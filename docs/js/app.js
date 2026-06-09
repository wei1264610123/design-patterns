(function () {
  "use strict";

  const data = window.PATTERNS_DATA;
  if (!data) {
    document.body.innerHTML = "<p style='padding:40px;color:#fff'>文档数据未加载，请先运行 scripts/build-docs.py</p>";
    return;
  }

  const { patterns, stats } = data;
  const CATEGORY_ORDER = ["creational", "structural", "behavioral"];
  const CATEGORY_NAMES = {
    creational: "创建型模式",
    structural: "结构型模式",
    behavioral: "行为型模式",
  };

  const sidebar = document.getElementById("sidebar");
  const main = document.getElementById("main");
  const searchInput = document.getElementById("search");
  const menuToggle = document.getElementById("menu-toggle");

  let currentId = null;

  function escapeHtml(text) {
    return text
      .replace(/&/g, "&amp;")
      .replace(/</g, "&lt;")
      .replace(/>/g, "&gt;")
      .replace(/"/g, "&quot;");
  }

  function highlightJava(code) {
    const tokens = [];
    const mark = (html) => {
      const id = tokens.length;
      tokens.push(html);
      return `\x00${id}\x00`;
    };

    let result = escapeHtml(code);

    // 先保护注释、字符串，避免后续关键字匹配到 HTML 属性（如 class="cmt" 中的 class）
    result = result.replace(/(\/\/.*$)/gm, (m) => mark(`<span class="cmt">${m}</span>`));
    result = result.replace(/(\/\*[\s\S]*?\*\/)/g, (m) => mark(`<span class="cmt">${m}</span>`));
    result = result.replace(/"([^"\\]|\\.)*"/g, (m) => mark(`<span class="str">${m}</span>`));
    result = result.replace(/(@\w+)/g, (m) => mark(`<span class="ann">${m}</span>`));
    result = result.replace(
      /\b(package|import|public|private|protected|static|final|class|interface|extends|implements|new|return|void|int|long|if|else|for|while|this|super|null|true|false|enum)\b/g,
      (m) => mark(`<span class="kw">${m}</span>`)
    );

    return result.replace(/\x00(\d+)\x00/g, (_, id) => tokens[Number(id)]);
  }

  function withLineNumbers(code) {
    return code
      .split("\n")
      .map((line, i) => `<span class="line-num">${i + 1}</span>${line}`)
      .join("\n");
  }

  function groupByCategory() {
    const groups = {};
    CATEGORY_ORDER.forEach((c) => (groups[c] = []));
    patterns.forEach((p) => groups[p.category].push(p));
    return groups;
  }

  function renderSidebar(filter = "") {
    const groups = groupByCategory();
    const q = filter.toLowerCase().trim();
    let html = "";

    CATEGORY_ORDER.forEach((cat) => {
      const items = groups[cat].filter((p) => {
        if (!q) return true;
        const hay = [p.name, p.nameEn, p.summary, p.variant, p.id, p.sourcePath].filter(Boolean).join(" ").toLowerCase();
        return hay.includes(q);
      });
      if (!items.length) return;

      html += `<div class="sidebar-section">
        <div class="sidebar-title">
          <span class="category-dot ${cat}"></span>
          ${CATEGORY_NAMES[cat]}
        </div>`;

      items.forEach((p) => {
        const label = p.variant ? `${p.name}` : p.name;
        html += `<a class="nav-item${currentId === p.id ? " active" : ""}" data-id="${p.id}">
          ${escapeHtml(label)}
          ${p.variant ? `<span class="variant">${escapeHtml(p.variant)}</span>` : ""}
        </a>`;
      });

      html += "</div>";
    });

    sidebar.innerHTML = html || '<div class="empty-state" style="padding:20px">无匹配结果</div>';

    sidebar.querySelectorAll(".nav-item").forEach((el) => {
      el.addEventListener("click", () => {
        showPattern(el.dataset.id);
        sidebar.classList.remove("open");
      });
    });
  }

  function renderHome() {
    currentId = null;
    renderSidebar(searchInput.value);

    const groups = groupByCategory();
    const categoryDesc = {
      creational: "关注对象的创建过程，将对象的创建与使用分离。",
      structural: "关注类和对象的组合，形成更大的结构。",
      behavioral: "关注对象之间的通信及职责分配。",
    };

    let cardsHtml = "";
    CATEGORY_ORDER.forEach((cat) => {
      const items = groups[cat];
      cardsHtml += `<div class="category-card" data-category="${cat}">
        <h3><span class="category-dot ${cat}"></span>${CATEGORY_NAMES[cat]}</h3>
        <p>${categoryDesc[cat]}</p>
        <div class="pattern-chips">
          ${items.map((p) => `<span class="chip" data-id="${p.id}">${escapeHtml(p.variant ? `${p.name} · ${p.variant}` : p.name)}</span>`).join("")}
        </div>
      </div>`;
    });

    main.innerHTML = `
      <section class="hero">
        <h1>Java 设计模式学习手册</h1>
        <p>本项目收录了 GoF 23 种设计模式中的经典 Java 实现示例，包含模式说明、源码结构与可运行的 Client 入口类，适合系统学习与快速查阅。</p>
      </section>
      <div class="stats-grid">
        <div class="stat-card"><div class="number">${stats.totalPatterns}</div><div class="label">模式示例</div></div>
        <div class="stat-card"><div class="number">${stats.totalFiles}</div><div class="label">Java 源文件</div></div>
        <div class="stat-card creational"><div class="number">${stats.creational}</div><div class="label">创建型</div></div>
        <div class="stat-card structural"><div class="number">${stats.structural}</div><div class="label">结构型</div></div>
        <div class="stat-card behavioral"><div class="number">${stats.behavioral}</div><div class="label">行为型</div></div>
      </div>
      <div class="category-cards">${cardsHtml}</div>
    `;

    main.querySelectorAll(".chip, .category-card").forEach((el) => {
      el.addEventListener("click", (e) => {
        const chip = e.target.closest(".chip");
        if (chip) {
          showPattern(chip.dataset.id);
          return;
        }
        const card = e.target.closest(".category-card");
        if (card) {
          const first = patterns.find((p) => p.category === card.dataset.category);
          if (first) showPattern(first.id);
        }
      });
    });
  }

  function renderDocSections(readme) {
    if (!readme.sections.length) {
      return '<div class="content-section"><h2>📖 模式说明</h2><p class="doc-text">暂无 readme 文档，请查看右侧源码了解实现细节。</p></div>';
    }

    let html = '<div class="content-section"><h2>📖 模式说明</h2>';
    readme.sections.forEach((sec) => {
      if (sec.title === "概述" || sec.title.includes("模式")) {
        html += `<p class="doc-text">${escapeHtml(sec.content)}</p>`;
      } else {
        html += `<div class="doc-subsection"><h3>${escapeHtml(sec.title)}</h3><p class="doc-text">${escapeHtml(sec.content)}</p></div>`;
      }
    });
    html += "</div>";
    return html;
  }

  function showPattern(id) {
    const pattern = patterns.find((p) => p.id === id);
    if (!pattern) return;

    currentId = id;
    renderSidebar(searchInput.value);

    const entryFile = pattern.files.find((f) => f.name === pattern.entryFile) || pattern.files[0];
    const otherFiles = pattern.files.filter((f) => f !== entryFile);

    main.innerHTML = `
      <div class="pattern-header">
        <div class="breadcrumb">
          <span id="go-home">首页</span> / <span>${escapeHtml(pattern.categoryName)}</span> / <span>${escapeHtml(pattern.name)}</span>
        </div>
        <div class="pattern-title-row">
          <h1>${escapeHtml(pattern.name)}${pattern.variant ? ` <small style="font-size:0.6em;color:var(--text-muted)">(${escapeHtml(pattern.variant)})</small>` : ""}</h1>
          <span class="badge ${pattern.category}">${escapeHtml(pattern.categoryName)}</span>
        </div>
        <p class="pattern-summary">${escapeHtml(pattern.summary)}</p>
        <div class="meta-row">
          <span>英文名：<strong>${escapeHtml(pattern.nameEn)}</strong></span>
          <span>源码路径：<code>${escapeHtml(pattern.sourcePath)}</code></span>
          <span>入口类：<code>${escapeHtml(pattern.entryPackage || "")}.${escapeHtml(pattern.entryFile || "")}</code></span>
          <span>文件数：${pattern.fileCount}</span>
        </div>
      </div>

      ${renderDocSections(pattern.readme)}

      <div class="code-panel" id="code-panel">
        <div class="code-panel-header">
          <div class="file-tabs" id="file-tabs">
            ${pattern.files.map((f, i) => `<button class="file-tab${f.name === pattern.entryFile ? " entry active" : i === 0 ? " active" : ""}" data-file="${escapeHtml(f.name)}">${escapeHtml(f.name)}</button>`).join("")}
          </div>
          <button class="copy-btn" id="copy-btn">复制代码</button>
        </div>
        <pre class="code-block" id="code-block"></pre>
      </div>

      <div class="content-section">
        <h2>📁 项目文件 (${pattern.fileCount})</h2>
        <div class="file-list" id="file-list">
          ${pattern.files.map((f) => `
            <div class="file-card" data-file="${escapeHtml(f.name)}">
              <div class="fname">${escapeHtml(f.name)}</div>
              <div class="fpath">${escapeHtml(f.path)}</div>
            </div>
          `).join("")}
        </div>
      </div>
    `;

    const codeBlock = document.getElementById("code-block");
    const fileMap = Object.fromEntries(pattern.files.map((f) => [f.name, f]));

    function showFile(name) {
      const file = fileMap[name];
      if (!file) return;
      codeBlock.innerHTML = withLineNumbers(highlightJava(file.content));
      document.querySelectorAll(".file-tab").forEach((t) => t.classList.toggle("active", t.dataset.file === name));
    }

    const initial = pattern.entryFile || (pattern.files[0] && pattern.files[0].name);
    showFile(initial);

    document.getElementById("file-tabs").addEventListener("click", (e) => {
      const tab = e.target.closest(".file-tab");
      if (tab) showFile(tab.dataset.file);
    });

    document.getElementById("file-list").addEventListener("click", (e) => {
      const card = e.target.closest(".file-card");
      if (card) {
        showFile(card.dataset.file);
        document.getElementById("code-panel").scrollIntoView({ behavior: "smooth" });
      }
    });

    document.getElementById("copy-btn").addEventListener("click", () => {
      const active = document.querySelector(".file-tab.active");
      const file = fileMap[active.dataset.file];
      navigator.clipboard.writeText(file.content).then(() => {
        const btn = document.getElementById("copy-btn");
        btn.textContent = "已复制 ✓";
        setTimeout(() => (btn.textContent = "复制代码"), 1500);
      });
    });

    document.getElementById("go-home").addEventListener("click", renderHome);
    window.scrollTo({ top: 0, behavior: "smooth" });
  }

  searchInput.addEventListener("input", () => renderSidebar(searchInput.value));

  menuToggle.addEventListener("click", () => sidebar.classList.toggle("open"));

  document.getElementById("logo").addEventListener("click", (e) => {
    e.preventDefault();
    renderHome();
  });

  document.getElementById("stat-patterns").textContent = stats.totalPatterns;
  document.getElementById("stat-files").textContent = stats.totalFiles;

  renderHome();
})();
