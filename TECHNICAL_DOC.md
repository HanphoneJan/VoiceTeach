# VoiceTeach (言传声教) 技术文档

## 1. 项目概述

VoiceTeach（言传声教）是一款基于Android平台的教学辅助Agent移动端应用，采用MVVM架构模式，集成了基于TTS大模型的智能语音交互、教学答疑、有声PPT课件生成、蓝牙连接控制、音乐播放及文件管理等多种功能。

项目后端基于FastAPI框架搭建GPT-SoVITS大模型服务，实现教学场景语音生成、智能答疑等功能。

## 2. 架构设计

### 2.1 整体架构

应用采用MVVM (Model-View-ViewModel) 架构模式，将业务逻辑与UI展示分离，提高代码的可维护性和可测试性。

```
┌─────────────────────────────────────────────────────────────────┐
│                          View Layer                             │
│  (Activities, Fragments, Layouts)                               │
└─────────────────────────────────────────────────────────────────┘
                                    │
                                    ▼
┌─────────────────────────────────────────────────────────────────┐
│                        ViewModel Layer                          │
│  (HomeViewModel, BluetoothViewModel, MusicViewModel, etc.)       │
└─────────────────────────────────────────────────────────────────┘
                                    │
                                    ▼
┌─────────────────────────────────────────────────────────────────┐
│                          Model Layer                            │
│  (Data Models, Repositories, Services)                          │
└─────────────────────────────────────────────────────────────────┘
```

### 2.2 模块划分

应用主要分为以下几个功能模块：

| 模块名称 | 主要职责 | 核心类 |
|---------|---------|--------|
| 语音交互 | 处理语音输入输出，AI对话 | HomeFragment, HomeViewModel |
| 蓝牙连接 | 蓝牙设备扫描、连接和管理 | BluetoothFragment, BluetoothViewModel, Bluetooth |
| 音乐播放 | 本地音乐文件播放控制 | MusicFragment, MusicViewModel |
| 文件上传 | 音频和文本文件上传，录音功能 | UploadFragment, UploadViewModel |
| 文件管理 | 本地文件浏览、播放和分享 | FilesFragment, FilesViewModel, UriManager |

## 3. 核心功能实现

### 3.1 语音交互功能

#### 3.1.1 实现流程

1. **输入方式切换**：用户可以通过按钮切换语音输入和文字输入模式
2. **语音录制**：使用Android MediaRecorder API进行语音录制
3. **文字输入**：通过EditText接收用户输入
4. **AI请求**：将用户输入发送到AI服务，获取回复
5. **结果展示**：将AI回复以文本和语音形式展示给用户

#### 3.1.2 核心代码

- **语音录制控制**：`HomeViewModel.startRecording()` 和 `HomeViewModel.stopRecording()`
- **消息管理**：`CustomMessageAdapter` 负责消息列表的展示
- **AI请求处理**：`HomeViewModel.uploadFiles()` 方法处理AI请求

### 3.2 蓝牙连接功能

#### 3.2.1 实现流程

1. **权限检查**：确保应用具有蓝牙相关权限
2. **设备扫描**：使用BluetoothAdapter.startDiscovery()扫描附近设备
3. **设备列表展示**：将扫描到的设备显示在列表中
4. **设备连接**：选择设备后建立蓝牙连接
5. **连接状态管理**：监听蓝牙连接状态变化

#### 3.2.2 核心代码

- **蓝牙扫描**：`BluetoothViewModel.startScanning()`
- **设备连接**：`BluetoothViewModel.connectToDevice()`
- **状态监听**：`BluetoothConnectionListener` 接口监听连接状态

### 3.3 音乐播放功能

#### 3.3.1 实现流程

1. **音频文件加载**：扫描本地音频文件
2. **播放控制**：提供播放/暂停、上一曲、下一曲等控制
3. **播放模式切换**：支持顺序播放、单曲循环、列表循环
4. **进度控制**：支持快进/快退操作
5. **音量调节**：提供音量增减功能

#### 3.3.2 核心代码

- **媒体播放**：使用ExoPlayer进行音频播放
- **播放控制**：`MusicViewModel.playAudio()`、`MusicViewModel.playNextTrack()` 等方法
- **播放模式**：`MusicViewModel.togglePlaybackMode()` 切换播放模式

### 3.4 文件上传功能

#### 3.4.1 实现流程

1. **文件选择**：支持从本地选择音频和文本文件
2. **录音功能**：支持录制音频文件
3. **参数设置**：设置模型类型、情感、语速等参数
4. **文件上传**：将文件和参数上传到服务器
5. **上传状态反馈**：向用户反馈上传进度和结果

#### 3.4.2 核心代码

- **文件选择**：`UploadViewModel.chooseAudio()` 和 `UploadViewModel.chooseFile()`
- **录音控制**：`UploadViewModel.startRecording()` 和 `UploadViewModel.stopRecording()`
- **文件上传**：`UploadViewModel.uploadFiles()` 方法处理文件上传

### 3.5 文件管理功能

#### 3.5.1 实现流程

1. **目录选择**：支持选择本地目录
2. **文件列表展示**：显示目录中的音频文件
3. **文件播放**：点击文件进行播放
4. **文件分享**：长按文件可选择其他应用打开
5. **全屏播放**：支持视频文件全屏播放

#### 3.5.2 核心代码

- **目录选择**：`FilesFragment.openDirectorySelector()`
- **文件加载**：`FilesFragment.loadAudioFiles()` 加载音频文件列表
- **文件播放**：`FilesViewModel.playFile()` 播放选中文件
- **全屏控制**：`FilesFragment.enterFullScreen()` 和 `FilesFragment.exitFullScreen()`

## 4. 关键API设计

### 4.1 后端API接口

应用与后端GPT-SoVITS服务通过HTTP API进行通信：

| 接口路径 | 方法 | 功能描述 |
|---------|------|---------|
| `/aivoice/chat` | POST | 教学对话接口，支持文本/语音输入，返回AI回复及语音 |
| `/aivoice/upload` | POST | 有声课件生成接口，支持文本/音频上传，生成教学语音 |

### 4.2 Bluetooth API

```java
// 蓝牙设备连接监听
public interface BluetoothConnectionListener {
    void onConnected(BluetoothDevice device);
    void onDisconnected(BluetoothDevice device);
    void onConnectionFailed(BluetoothDevice device, int errorCode);
}

// 蓝牙设备信息类
public class BluetoothDeviceInfo {
    private String deviceName;
    private String deviceAddress;
    private boolean isConnected;
    // getter and setter methods
}

// 蓝牙管理类
public class Bluetooth {
    public static void init(Context context);
    public static boolean isBluetoothEnabled();
    public static void enableBluetooth();
    public static void disableBluetooth();
    public static List<BluetoothDevice> getPairedDevices();
    public static void connectToDevice(BluetoothDevice device, BluetoothConnectionListener listener);
    public static void disconnectDevice();
    public static BluetoothDevice getConnectedDevice();
}
```

### 4.2 File Management API

```java
// URI管理类，用于保存和获取文件URI
public class UriManager {
    public static void setUri(Context context, Uri uri);
    public static Uri getUri(Context context);
    public static void clearUri(Context context);
}
```

### 4.3 Message API

```java
// 消息信息类
public class MessageInfo {
    private String messageContent;
    private int messageType; // 0: 用户消息, 1: AI消息
    private long timestamp;
    // getter and setter methods
}

// 消息适配器
public class CustomMessageAdapter extends RecyclerView.Adapter<CustomMessageAdapter.MessageViewHolder> {
    // 消息列表适配和展示
}
```

## 5. 项目配置

### 5.1 应用包名
- **包名**: `com.yuanchuanshengjiao.voiceteach`
- **应用ID**: `com.yuanchuanshengjiao.voiceteach`
- **应用名称**: 言传声教

### 5.2 后端服务配置
- **开发环境**: https://www.hanphone.top/aivoice/
- **接口版本**: v1

### 5.3 权限管理

应用需要以下权限：

| 权限名称 | 使用场景 | 权限级别 |
|---------|---------|--------|
| RECORD_AUDIO | 语音录制 | 危险权限 |
| BLUETOOTH_SCAN | 蓝牙设备扫描 | 正常权限(Android 12+) |
| BLUETOOTH_CONNECT | 蓝牙设备连接 | 正常权限(Android 12+) |
| ACCESS_FINE_LOCATION | 蓝牙设备扫描 | 危险权限 |
| ACCESS_COARSE_LOCATION | 蓝牙设备扫描 | 危险权限 |
| READ_EXTERNAL_STORAGE | 文件读取 | 危险权限 |
| WRITE_EXTERNAL_STORAGE | 文件写入 | 危险权限 |
| READ_MEDIA_AUDIO | 音频文件读取 | 危险权限(Android 13+) |
| INTERNET | 网络请求 | 正常权限 |

权限请求流程：
1. 在AndroidManifest.xml中声明所需权限
2. 在运行时检查并请求危险权限
3. 处理权限请求结果
4. 对于拒绝权限的情况，引导用户前往设置页面手动开启

## 6. 导航设计

应用使用Android Navigation Component进行页面导航，包含以下导航图：

```
mobile_navigation.xml
├── HomeFragment (主界面)
├── BluetoothFragment (蓝牙界面)
├── MusicFragment (音乐界面)
├── UploadFragment (上传界面)
└── FilesFragment (文件界面)
```

底部导航栏使用BottomNavigationView实现，用户可以通过点击导航项切换不同功能模块。

## 7. UI设计

### 7.1 主题与样式

- **主题**：使用Material Design主题，支持浅色和深色模式
- **颜色**：定义了统一的颜色资源，确保UI风格一致
- **布局**：采用响应式设计，适配不同屏幕尺寸

### 7.2 核心UI组件

- **RecyclerView**：用于展示消息列表、蓝牙设备列表、文件列表
- **BottomSheetDialog**：用于显示设置选项、音乐列表等
- **ExoPlayerView**：用于视频文件播放
- **Material Button**：提供统一的按钮样式
- **Spinner**：用于选择模型参数、情感、语速等

