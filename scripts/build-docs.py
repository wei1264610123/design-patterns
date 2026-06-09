#!/usr/bin/env python3
"""Scan Java source and readme files, generate docs/js/patterns-data.js."""

import json
import os
import re
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
SRC = ROOT / "src" / "main" / "java" / "com"
OUT = ROOT / "docs" / "js" / "patterns-data.js"

PATTERN_CATALOG = [
    {
        "id": "prototype",
        "name": "原型模式",
        "nameEn": "Prototype",
        "category": "creational",
        "categoryName": "创建型",
        "summary": "通过克隆已有对象来创建新对象，避免重复的高代价初始化。",
        "path": "prototype",
    },
    {
        "id": "builder-demo",
        "name": "建造者模式",
        "nameEn": "Builder",
        "category": "creational",
        "categoryName": "创建型",
        "summary": "将复杂对象的构建过程与表示分离，逐步组装出不同表示。",
        "path": "builder/demo",
        "variant": "共享单车示例",
    },
    {
        "id": "builder-demo2",
        "name": "建造者模式",
        "nameEn": "Builder",
        "category": "creational",
        "categoryName": "创建型",
        "summary": "链式调用构建复杂对象，适合属性较多的实体。",
        "path": "builder/demo2",
        "variant": "Phone 链式构建",
    },
    {
        "id": "builder-service",
        "name": "建造者模式",
        "nameEn": "Builder",
        "category": "creational",
        "categoryName": "创建型",
        "summary": "快餐套餐组装示例，Director 负责组合 Builder 产物。",
        "path": "builder/service",
        "variant": "快餐套餐",
    },
    {
        "id": "adapter-class",
        "name": "适配器模式",
        "nameEn": "Adapter",
        "category": "structural",
        "categoryName": "结构型",
        "summary": "通过继承实现类适配器，让 TF 卡可被 SD 卡接口读取。",
        "path": "adapter/class_adapter",
        "variant": "类适配器",
    },
    {
        "id": "adapter-object",
        "name": "适配器模式",
        "nameEn": "Adapter",
        "category": "structural",
        "categoryName": "结构型",
        "summary": "通过组合实现对象适配器，解耦适配逻辑与目标接口。",
        "path": "adapter/object_adapter",
        "variant": "对象适配器",
    },
    {
        "id": "bridge",
        "name": "桥接模式",
        "nameEn": "Bridge",
        "category": "structural",
        "categoryName": "结构型",
        "summary": "将抽象与实现分离，使两个维度可以独立变化。",
        "path": "bridge",
    },
    {
        "id": "combination",
        "name": "组合模式",
        "nameEn": "Composite",
        "category": "structural",
        "categoryName": "结构型",
        "summary": "以树形结构组合对象，统一处理部分与整体。",
        "path": "combination",
    },
    {
        "id": "decorator",
        "name": "装饰器模式",
        "nameEn": "Decorator",
        "category": "structural",
        "categoryName": "结构型",
        "summary": "动态给对象添加职责，比继承更灵活地扩展功能。",
        "path": "decorator",
    },
    {
        "id": "facade",
        "name": "外观模式",
        "nameEn": "Facade",
        "category": "structural",
        "categoryName": "结构型",
        "summary": "为复杂子系统提供统一高层接口，简化客户端调用。",
        "path": "facade",
    },
    {
        "id": "flyweight",
        "name": "享元模式",
        "nameEn": "Flyweight",
        "category": "structural",
        "categoryName": "结构型",
        "summary": "共享细粒度对象，减少内存占用，提高性能。",
        "path": "flyweight",
    },
    {
        "id": "proxy-static",
        "name": "代理模式",
        "nameEn": "Proxy",
        "category": "structural",
        "categoryName": "结构型",
        "summary": "静态代理在编译期确定代理类，控制对真实对象的访问。",
        "path": "proxy/static_proxy",
        "variant": "静态代理",
    },
    {
        "id": "proxy-jdk",
        "name": "代理模式",
        "nameEn": "Proxy",
        "category": "structural",
        "categoryName": "结构型",
        "summary": "JDK 动态代理在运行时生成代理，基于接口实现。",
        "path": "proxy/jdk_proxy",
        "variant": "JDK 动态代理",
    },
    {
        "id": "command",
        "name": "命令模式",
        "nameEn": "Command",
        "category": "behavioral",
        "categoryName": "行为型",
        "summary": "将请求封装为对象，解耦调用者与接收者。",
        "path": "command",
    },
    {
        "id": "iterator",
        "name": "迭代器模式",
        "nameEn": "Iterator",
        "category": "behavioral",
        "categoryName": "行为型",
        "summary": "提供顺序访问聚合元素的方法，而不暴露内部表示。",
        "path": "iterator",
    },
    {
        "id": "mediator",
        "name": "中介者模式",
        "nameEn": "Mediator",
        "category": "behavioral",
        "categoryName": "行为型",
        "summary": "用中介对象封装同事对象间的交互，降低耦合。",
        "path": "mediator",
    },
    {
        "id": "responsibility",
        "name": "责任链模式",
        "nameEn": "Chain of Responsibility",
        "category": "behavioral",
        "categoryName": "行为型",
        "summary": "将请求沿处理者链传递，直到有对象处理它。",
        "path": "responsibility",
    },
    {
        "id": "strategy",
        "name": "策略模式",
        "nameEn": "Strategy",
        "category": "behavioral",
        "categoryName": "行为型",
        "summary": "定义算法族并封装，使它们可以互相替换。",
        "path": "strategy",
    },
    {
        "id": "template",
        "name": "模板方法模式",
        "nameEn": "Template Method",
        "category": "behavioral",
        "categoryName": "行为型",
        "summary": "在父类定义算法骨架，子类重写特定步骤。",
        "path": "template",
    },
    {
        "id": "state",
        "name": "状态模式",
        "nameEn": "State",
        "category": "behavioral",
        "categoryName": "行为型",
        "summary": "电梯状态示例（重构前），展示状态驱动行为的思路。",
        "path": "state/before",
        "variant": "重构前示例",
    },
]


def read_text(path: Path) -> str:
    if not path.exists():
        return ""
    return path.read_text(encoding="utf-8", errors="replace")


def parse_readme(content: str) -> dict:
    if not content.strip():
        return {"sections": [], "raw": ""}

    sections = []
    current_title = "概述"
    current_lines = []

    for line in content.splitlines():
        if line.startswith("# "):
            if current_lines:
                sections.append({"title": current_title, "content": "\n".join(current_lines).strip()})
            current_title = line[2:].strip()
            current_lines = []
        elif line.startswith("## "):
            if current_lines:
                sections.append({"title": current_title, "content": "\n".join(current_lines).strip()})
            current_title = line[3:].strip()
            current_lines = []
        elif line.startswith("### "):
            if current_lines:
                sections.append({"title": current_title, "content": "\n".join(current_lines).strip()})
            current_title = line[4:].strip()
            current_lines = []
        else:
            current_lines.append(line)

    if current_lines:
        sections.append({"title": current_title, "content": "\n".join(current_lines).strip()})

    cleaned = []
    for section in sections:
        text = re.sub(r"```+", "", section["content"])
        text = re.sub(r"!\[.*?\]\(.*?\)", "", text)
        text = text.strip()
        if text:
            cleaned.append({"title": section["title"], "content": text})

    return {"sections": cleaned, "raw": content}


def collect_java_files(pattern_dir: Path) -> list:
    files = []
    if not pattern_dir.exists():
        return files

    for java_file in sorted(pattern_dir.rglob("*.java")):
        rel = java_file.relative_to(ROOT).as_posix()
        files.append(
            {
                "name": java_file.name,
                "path": rel,
                "package": extract_package(read_text(java_file)),
                "content": read_text(java_file),
                "isClient": java_file.name == "Client.java",
            }
        )
    return files


def extract_package(content: str) -> str:
    match = re.search(r"^package\s+([\w.]+);", content, re.MULTILINE)
    return match.group(1) if match else ""


def find_readme(pattern_dir: Path) -> Path | None:
    for name in ("readme.md", "README.md"):
        candidate = pattern_dir / name
        if candidate.exists():
            return candidate
    parent = pattern_dir.parent
    for name in ("readme.md", "README.md"):
        candidate = parent / name
        if candidate.exists() and parent != SRC:
            return candidate
    return None


def build_pattern(entry: dict) -> dict:
    pattern_dir = SRC / entry["path"]
    readme_path = find_readme(pattern_dir)
    readme = parse_readme(read_text(readme_path)) if readme_path else {"sections": [], "raw": ""}
    java_files = collect_java_files(pattern_dir)

    client = next((f for f in java_files if f["isClient"]), None)
    if not client and java_files:
        for candidate in java_files:
            if "Demo" in candidate["name"] or "Pattern" in candidate["name"]:
                client = candidate
                break
        if not client:
            client = java_files[0]

    return {
        **entry,
        "sourcePath": f"src/main/java/com/{entry['path']}",
        "readme": readme,
        "files": java_files,
        "fileCount": len(java_files),
        "entryFile": client["name"] if client else None,
        "entryPackage": client["package"] if client else None,
    }


def main() -> None:
    patterns = [build_pattern(entry) for entry in PATTERN_CATALOG]
    stats = {
        "totalPatterns": len(patterns),
        "totalFiles": sum(p["fileCount"] for p in patterns),
        "creational": sum(1 for p in patterns if p["category"] == "creational"),
        "structural": sum(1 for p in patterns if p["category"] == "structural"),
        "behavioral": sum(1 for p in patterns if p["category"] == "behavioral"),
    }

    payload = {"generatedAt": __import__("datetime").datetime.now().isoformat(timespec="seconds"), "stats": stats, "patterns": patterns}

    OUT.parent.mkdir(parents=True, exist_ok=True)
    OUT.write_text(
        "// Auto-generated by scripts/build-docs.py — do not edit manually\n"
        f"window.PATTERNS_DATA = {json.dumps(payload, ensure_ascii=False, indent=2)};\n",
        encoding="utf-8",
    )
    print(f"Generated {OUT} ({len(patterns)} patterns, {stats['totalFiles']} Java files)")


if __name__ == "__main__":
    main()
