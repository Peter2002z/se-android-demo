package configs;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidCapabilities {

    private static AndroidDriver driver;
    private static final String SERVER_URL = "http://127.0.0.1:4723";

    public static void initDriver() throws MalformedURLException {
        if (driver == null) {
            UiAutomator2Options options = getDefaultOptions();
            driver = new AndroidDriver(new URL(SERVER_URL), options);
        }
    }

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static UiAutomator2Options getDefaultOptions() {
        return new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("emulator-5554")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.swaglabsmobileapp")
                .setAppActivity("com.swaglabsmobileapp.MainActivity")
                .setNewCommandTimeout(Duration.ofSeconds(300));
        // Nếu muốn test file APK thay vì app cài sẵn:
        // .setApp(System.getProperty("user.dir") + "/apps/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk")
    }
}
