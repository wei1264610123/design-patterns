# Java 设计模式学习项目

收录 GoF 经典设计模式的 Java 实现示例，每个模式包含可运行的源码与说明文档。

## 快速开始

### 浏览文档（推荐）

```bash
# 1. 生成文档数据
python scripts/build-docs.py

# 2. 在浏览器中打开
# 直接双击 docs/index.html，或使用本地服务器：
cd docs && python -m http.server 8080
# 访问 http://localhost:8080
```

### 运行 Java 示例

在 IDE（IntelliJ IDEA 等）中打开项目，找到各模式目录下的 `Client.java` 并运行 `main` 方法。

## 项目结构

```
design-patterns/
├── docs/                    # HTML 文档站点
│   ├── index.html           # 文档首页
│   ├── css/style.css
│   └── js/
│       ├── app.js           # 前端交互逻辑
│       └── patterns-data.js # 自动生成的模式数据
├── scripts/
│   └── build-docs.py        # 文档构建脚本
└── src/main/java/com/       # 各设计模式源码
    ├── adapter/             # 适配器（类适配器 / 对象适配器）
    ├── bridge/              # 桥接
    ├── builder/             # 建造者
    ├── combination/         # 组合
    ├── command/             # 命令
    ├── decorator/           # 装饰器
    ├── facade/              # 外观
    ├── flyweight/           # 享元
    ├── iterator/            # 迭代器
    ├── mediator/            # 中介者
    ├── prototype/           # 原型
    ├── proxy/               # 代理（静态 / JDK 动态）
    ├── responsibility/      # 责任链
    ├── state/               # 状态
    ├── strategy/            # 策略
    └── template/            # 模板方法
```

## 模式分类

| 类型 | 模式 |
|------|------|
| **创建型** | 原型、建造者 |
| **结构型** | 适配器、桥接、组合、装饰器、外观、享元、代理 |
| **行为型** | 命令、迭代器、中介者、责任链、策略、模板方法、状态 |

## 更新文档

修改源码或 `readme.md` 后，重新运行：

```bash
python scripts/build-docs.py
```

然后刷新浏览器即可看到最新内容。
