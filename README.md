# VoiceTeach (言传声教) - 教学辅助语音Agent

> 🎙️ 基于TTS大模型微调的教学辅助Agent移动端应用，支持语音交互、教学答疑、有声PPT课件生成

[![Android](https://img.shields.io/badge/Android-6.0+-green.svg?style=flat-square&logo=android)](https://developer.android.com/about/versions/marshmallow)
[![Java](https://img.shields.io/badge/Java-11+-orange.svg?style=flat-square&logo=openjdk)](https://www.oracle.com/java/technologies/downloads/)
[![MVVM](https://img.shields.io/badge/Architecture-MVVM-blue.svg?style=flat-square&logo=android-studio)](https://developer.android.com/topic/libraries/architecture)
[![MIT License](https://img.shields.io/github/license/your-username/aivoice.svg?style=flat-square&logo=github)](LICENSE)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square&logo=github)](CONTRIBUTING.md)

---

## 📋 目录

- [📱 项目简介](#-项目简介)
- [✨ 核心功能特性](#-核心功能特性)
- [🔧 技术栈选型](#-技术栈选型)
- [📂 项目结构](#-项目结构)
- [🔑 权限说明](#-权限说明)
- [📥 安装指南](#-安装指南)
- [📋 运行要求](#-运行要求)
- [📖 使用说明](#-使用说明)
- [🛠️ 开发规范](#-开发规范)
- [🤝 贡献方式](#-贡献方式)
- [📄 许可证](#-许可证)
- [🌟 致谢](#-致谢)

---

## 📱 项目简介

VoiceTeach（言传声教）是一款面向教育场景的**智能教学辅助Agent移动端应用**，基于GPT-SoVITS TTS大模型微调构建。应用整合了智能语音交互、教学答疑、有声PPT课件生成、蓝牙设备控制及文件管理等核心能力，为教师和学生提供个性化的教学语音服务。

### 🌟 设计理念
- **教学导向**：专注教育场景，贴合真实教学需求
- **语音优先**：基于TTS大模型，提供优质语音合成与交互体验
- **模块化架构**：功能模块独立封装，支持按需扩展与二次开发
- **性能优先**：优化资源占用与响应速度，适配中低端Android设备

### 🎯 核心价值
- 一站式教学语音服务：教学答疑、有声课件生成、语音播报
- 支持自定义音色模型、情感、语速，满足个性化教学需求
- 本地语音处理与云端TTS大模型结合，兼顾效率与质量
- 严格遵循Android设计规范，提供统一流畅的教学交互体验

---

## ✨ 核心功能特性

### 1. 智能语音交互 · 高效沟通
- 🎤 **双输入模式**：语音实时输入（即时转文字）+ 文字手动输入，无缝切换
- 🧠 **多模型支持**：内置多种主流AI对话模型，可灵活切换，兼顾速度与质量
- 🎨 **个性化配置**：支持语音情感（温和/活泼/专业）、语速、音量自定义调节
- 📄 **文件驱动交互**：上传音频（MP3/WAV）、文本（TXT）文件，基于内容进行AI对话与分析（转写、摘要、翻译等）

### 2. 蓝牙设备管理 · 便捷连接
- 🔍 **快速扫描**：一键触发附近蓝牙设备扫描，实时显示设备名称、信号强度与连接状态
- 📱 **设备管理**：清晰展示已配对设备列表，支持快速连接/断开，历史设备自动记忆
- 📢 **状态反馈**：连接成功/失败/断开时提供视觉+文字双重提示，操作更安心
- 🧩 **广泛兼容**：支持蓝牙4.0及以上设备，适配耳机、音箱、智能硬件等多种外设

### 3. 本地音乐播放 · 沉浸式体验
- ▶️ **全功能控制**：播放/暂停、上一曲/下一曲、精准快进/快退，操作无死角
- 🔊 **灵活调节**：实时音量调节+播放进度拖动，适配不同环境听觉需求
- 🔄 **多播放模式**：顺序播放、单曲循环、列表循环，自由切换
- 📝 **信息展示**：歌曲标题、歌手、专辑封面、播放时长一目了然，支持歌词同步显示（需文件包含歌词信息）

### 4. 多类型文件上传 · 智能处理
- 📁 **文件兼容**：支持本地音频（MP3/WAV）、文本（TXT）文件上传，适配主流格式
- 🎙️ **实时录音**：内置录音功能，录制完成后可直接上传至AI服务处理
- ⚙️ **参数精细化**：支持AI模型类型、处理精度、输出格式自定义，优化处理结果
- 📤 **结果导出**：处理结果（转写文本、分析报告）可导出为TXT文件，便于后续使用

### 5. 本地文件管理 · 便捷操作
- 📂 **分类浏览**：按文件类型（音频/文本）、存储目录分类展示，快速定位目标文件
- ⚡ **多功能操作**：文件播放、分享、重命名、删除，一站式完成
- 🎵 **沉浸式播放**：音频文件支持全屏播放模式，聚焦核心听觉体验
- 🧹 **缓存管理**：自动识别重复文件，支持手动清理缓存，释放设备存储空间

---

## 🔧 技术栈选型

| 类别         | 技术/工具                    | 说明                                     |
| :----------- | :--------------------------- | :--------------------------------------- |
| **开发语言** | Java                         | Android平台主流开发语言，兼容性强        |
| **开发框架** | Android SDK                  | 基于官方SDK构建，确保跨版本适配性        |
| **架构模式** | MVVM                         | 数据与视图分离，提升代码可维护性与测试性 |
| **导航组件** | Android Navigation Component | 统一页面导航管理，简化页面跳转逻辑       |
| **媒体播放** | ExoPlayer                    | Google官方播放器，支持多格式、低延迟     |
| **UI组件**   | Material Design Components   | 符合Material Design规范，视觉体验统一    |
| **蓝牙技术** | Android Bluetooth API        | 实现蓝牙设备扫描、连接与数据通信         |
| **网络请求** | Retrofit + OkHttp            | 高效处理HTTP请求，支持拦截器、缓存       |
| **数据存储** | Room Database                | 本地数据库管理，优化文件元数据存储       |
| **异步处理** | Kotlin Coroutines            | 简化异步任务逻辑，提升性能               |
| **依赖注入** | Dagger Hilt                  | 简化组件依赖管理，提升代码可测试性       |
| **图片加载** | Glide                        | 高效图片加载与缓存，支持多种格式         |
| **构建工具** | Gradle                       | 自动化构建与依赖管理                     |
| **代码规范** | Checkstyle + Spotless        | 统一代码风格，提升代码质量               |

---

## 📂 项目结构

```bash
├── app/src/main/                  # 应用核心目录
│   ├── java/com/yuanchuanshengjiao/voiceteach/  # 业务代码目录
│   │   ├── bluetooth/             # 蓝牙功能模块（扫描、连接、状态管理）
│   │   │   ├── Bluetooth.java              # 蓝牙核心管理类
│   │   │   ├── BluetoothDeviceInfo.java    # 蓝牙设备信息类
│   │   │   ├── BluetoothGattCustom.java    # BLE GATT连接类
│   │   │   ├── CustomBluetoothDeviceAdapter.java # 设备列表适配器
│   │   │   └── BluetoothConnectionListener.java # 状态监听接口
│   │   ├── files/                 # 文件管理模块（浏览、播放、分享）
│   │   │   └── UriManager.java    # URI持久化管理
│   │   ├── message/               # 消息处理模块（AI对话、数据解析）
│   │   │   ├── MessageInfo.java   # 消息实体类
│   │   │   ├── CustomMessageAdapter.java   # 消息列表适配器
│   │   │   └── CustomBindingAdapter.java   # 数据绑定适配器
│   │   ├── ui/                    # 界面组件模块
│   │   │   ├── bluetooth/         # 蓝牙相关界面（设备列表、连接页）
│   │   │   ├── files/             # 文件管理界面（文件列表、详情页）
│   │   │   ├── home/              # 应用主界面（教学对话、语音交互）
│   │   │   ├── music/             # 音乐播放界面（播放器、歌单）
│   │   │   └── upload/            # 文件上传界面（文件选择、参数配置）
│   │   └── MainActivity.java      # 应用入口主活动
│   └── res/                       # 资源文件目录
│       ├── layout/                # 界面布局文件
│       ├── drawable/              # 图片资源（图标、背景）
       ├── values/                # 字符串、颜色、尺寸配置
│       └── menu/                  # 菜单配置文件
├── gradle/                        # Gradle构建配置目录
├── docs/                          # 项目文档（开发指南、FAQ、截图）
├── LICENSE                        # 开源许可证
└── README.md                      # 项目说明文档（本文件）
```

---

## 🔑 权限说明

为保障应用核心功能正常运行，需申请以下系统权限（均为功能必需，无冗余权限）：

| 权限名称                                           | 用途说明                         | 是否必需         | 权限等级 |
| :------------------------------------------------- | :------------------------------- | :--------------- | :------- |
| `RECORD_AUDIO`                                     | 语音输入、实时录音功能           | 是               | 危险权限 |
| `BLUETOOTH` / `BLUETOOTH_ADMIN`                    | 蓝牙设备扫描、连接与管理         | 是               | 普通权限 |
| `BLUETOOTH_SCAN` / `BLUETOOTH_CONNECT`             | Android 12+ 蓝牙操作必需权限     | 是               | 危险权限 |
| `ACCESS_FINE_LOCATION`                             | Android 6.0-11 蓝牙扫描必需权限  | 是（适配旧版本） | 危险权限 |
| `READ_EXTERNAL_STORAGE` / `WRITE_EXTERNAL_STORAGE` | 读取/写入本地文件（音乐、文本）  | 是               | 危险权限 |
| `INTERNET`                                         | 与AI服务交互、获取模型配置       | 是               | 普通权限 |
| `ACCESS_WIFI_STATE`                                | 检测网络状态，优化AI服务请求策略 | 否               | 普通权限 |
| `WAKE_LOCK`                                        | 音乐播放时保持屏幕常亮（可选）   | 否               | 普通权限 |

> 📌 说明：
> - 应用会在首次使用对应功能时**动态申请权限**，并明确说明权限用途
> - 用户可随时在系统设置中关闭权限（关闭后对应功能将不可用）
> - 严格遵循Android权限最佳实践，不滥用权限，保护用户隐私

---

## 📥 安装指南

### 前置条件
- 已安装 Android Studio（建议 Arctic Fox 2020.3.1 及以上版本）
- 配置好 Android 开发环境（JDK 11+、SDK API Level 23+）
- 拥有 Android 设备（API Level 23+，支持蓝牙4.0+）或模拟器

### 安装步骤

#### 1. 获取代码
```bash
# 克隆项目
git clone https://github.com/HanphoneJan/voice-teach.git

# 进入项目目录
cd voice-teach
```

#### 2. 导入项目
- 打开 Android Studio → 选择 "Open an existing project"
- 选中下载的项目根目录 → 等待项目同步完成（自动下载依赖库）
- 若同步失败，可尝试：
  - 检查网络连接，配置 Maven 镜像（阿里云、Google 镜像）
  - 点击 "File → Sync Project with Gradle Files" 手动同步

#### 3. 配置设备
- **实体设备**：开启 USB 调试模式（设置 → 关于手机 → 连续点击版本号激活开发者选项），通过 USB 连接电脑
- **模拟器**：创建 API Level 23+ 的 Android 模拟器（建议配置蓝牙支持）

#### 4. 构建运行
- 选择目标设备（实体机/模拟器）
- 点击 Android Studio 工具栏 "Run" 按钮（绿色三角图标）
- 首次构建可能耗时较长（需下载依赖与编译资源），耐心等待即可
- 构建成功后，应用将自动安装至设备并启动

### 常见问题排查
| 问题现象                     | 解决方案                                                     |
| :--------------------------- | :----------------------------------------------------------- |
| 依赖下载失败                 | 检查网络连接，配置国内 Maven 镜像，或手动下载依赖包放入本地仓库 |
| 构建报错 "Could not find..." | 确保 Gradle 版本与 Android Gradle Plugin 版本匹配（参考 `build.gradle`） |
| 设备无法识别                 | 安装对应设备的 USB 驱动，重新启用 USB 调试模式，或更换 USB 线缆 |
| 权限申请后功能仍不可用       | 检查设备系统设置 → 应用 → VoiceTeach → 权限，确保所需权限已开启 |

---

## 📋 运行要求

| 类别     | 要求说明                                         |
| :------- | :----------------------------------------------- |
| 系统版本 | Android 6.0 (API Level 23) 及以上                |
| 硬件要求 | 支持蓝牙 4.0+，设备内存 2GB+，存储空间 100MB+    |
| 网络要求 | 需连接互联网（Wi-Fi/移动网络）以使用 AI 交互功能 |
| 其他要求 | 开启设备麦克风、蓝牙权限（功能必需）             |
| 推荐配置 | Android 10.0+，设备内存 4GB+，存储空间 500MB+    |

---

## 📖 使用说明

### 1. 语音交互使用流程

1. 启动应用后，默认进入**主界面**，顶部显示功能导航栏
2. 选择输入方式：
   - 语音输入：点击底部「麦克风图标」，按住说话（松开后自动提交）
   - 文字输入：点击「输入框」，手动编辑文字内容
3. 配置参数（可选）：点击输入框下方「模型设置」，选择 AI 模型、语音情感、语速等
4. 点击「发送」按钮，等待 AI 处理（显示加载动画）
5. 处理完成后展示回复结果（文字+语音朗读可选），支持复制、导出、重新生成

### 2. 蓝牙设备连接流程

1. 在主界面点击「蓝牙」图标，进入**蓝牙管理界面**
2. 开启设备蓝牙（应用引导开启，或手动在系统设置中开启）
3. 点击「扫描设备」按钮，搜索附近可用蓝牙设备（实时更新结果）
4. 点击目标设备名称，按提示完成配对（部分设备需输入配对码）
5. 连接成功后显示「已连接」状态，可通过蓝牙设备播放语音回复、音乐
6. 断开连接：点击「断开」按钮，或在系统蓝牙设置中关闭连接

### 3. 音乐播放操作流程

1. 在主界面点击「音乐」图标，进入**音乐播放界面**，应用自动扫描本地音频文件
2. 播放控制：
   - 点击歌曲名称开始播放，底部控制栏支持播放/暂停、上一曲/下一曲
   - 拖动进度条快进/快退，点击「音量图标」调节音量
3. 模式切换：点击控制栏「模式」按钮，切换顺序播放/单曲循环/列表循环
4. 沉浸式播放：点击「全屏图标」，进入全屏模式，支持歌词同步显示（需 .lrc 歌词文件）

### 4. 文件上传处理流程

1. 在主界面点击「上传」图标，进入**文件上传界面**
2. 选择上传方式：
   - 本地文件：点击「选择音频文件」或「选择文本文件」，从本地目录选择
   - 实时录音：点击「录音」按钮，录制完成后自动上传
3. 配置参数：选择 AI 模型类型、处理精度、输出格式等

## Star History

<a href="https://www.star-history.com/?repos=HanphoneJan%2FVoiceTeach&type=date&legend=top-left">
 <picture>
   <source media="(prefers-color-scheme: dark)" srcset="https://api.star-history.com/image?repos=HanphoneJan/VoiceTeach&type=date&theme=dark&legend=top-left" />
   <source media="(prefers-color-scheme: light)" srcset="https://api.star-history.com/image?repos=HanphoneJan/VoiceTeach&type=date&legend=top-left" />
   <img alt="Star History Chart" src="https://api.star-history.com/image?repos=HanphoneJan/VoiceTeach&type=date&legend=top-left" />
 </picture>
</a>
