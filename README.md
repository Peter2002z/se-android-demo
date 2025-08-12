# SE Android Demo Automation

Dự án này là ví dụ sử dụng **Appium + Cucumber + Java** để tự động hóa kiểm thử ứng dụng Android (ở đây là app **Swag Labs**).

## 1. Công nghệ sử dụng
- **Java 17**
- **Maven**
- **Appium Java Client 9.x**
- **Cucumber 7.x**
- **Selenium 4.x**
- **TestNG**
- **UIAutomator2** (Appium driver cho Android)

## 2. Cấu trúc thư mục chính
```plaintext
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   └── java
│   │       ├── configs
│   │       │   └── AndroidCapabilities.java   # Cấu hình Appium default
│   │       └── pages
│   │           ├── authentication
│   │           │   └── LoginPage.java         # Page Object màn Login
│   │           └── inventory
│   │               └── InventoryPage.java     # Page Object màn Inventory
│   └── test
│       └── java
│           ├── runners
│           │   └── TestRunner.java            # File chạy Cucumber TestNG
│           ├── steps
│           │   └── authentication
│           │       └── LoginSteps.java        # Step Definitions Login
│           └── support
│               ├── Hooks.java                 # @Before & @After hooks
│               └── MobileWorld.java           # Chứa driver & page objects
│       └── resources
│           └── features
│               └── authentication
│                   └── login.feature          # Feature file cho Login
└── target                                    # Thư mục build của Maven
```


## 3. Cài đặt môi trường

### Bước 1: Cài Java & Maven
- Java 17: https://adoptium.net/
- Maven: https://maven.apache.org/

### Bước 2: Cài Appium Server (v2.x)
```bash
npm install -g appium
```
- Kiểm tra:
```bash
appium --version
```

### Bước 3: Cài Appium UIAutomator2 driver
```bash
appium driver install uiautomator2
```

### Bước 4: Cài Android SDK
- Cài Android Studio
- Cài platform-tools và cấu hình biến môi trường:
```bash
export ANDROID_HOME=~/Library/Android/sdk
export PATH=$PATH:$ANDROID_HOME/platform-tools
```

### Bước 5: Khởi động emulator hoặc kết nối thiết bị thật
```bash
adb devices
```

---
## 4. Cấu hình App
Mặc định file `AndroidCapabilities.java` đang dùng **appPackage** và **appActivity** của ứng dụng Sauce Labs Mobile App:
```java
.setAppPackage("com.swaglabsmobileapp")
.setAppActivity("com.swaglabsmobileapp.MainActivity");
```
Nếu muốn chạy file APK thay vì app cài sẵn:
```java
.setApp(System.getProperty("user.dir") + "/apps/your-app.apk")
```

---
## 5. Chạy test

### 5.1. Khởi động Appium Server
```bash
appium
```

### 5.2. Chạy test với Maven
```bash
mvn clean test

