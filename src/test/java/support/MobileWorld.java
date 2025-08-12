package support;

import configs.AndroidCapabilities;
import io.appium.java_client.android.AndroidDriver;
import pages.authentication.LoginPage;
import pages.inventory.InventoryPage;

public class MobileWorld {
    public AndroidDriver driver;
    public LoginPage loginPage;
    public InventoryPage inventoryPage;

    public void launchApp() throws Exception {
        // Dùng AndroidCapabilities để tạo driver
        AndroidCapabilities.initDriver();
        driver = AndroidCapabilities.getDriver();

        // Khởi tạo các page object
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    public void closeApp() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.err.println("Lỗi khi đóng app: " + e.getMessage());
            }
        }
    }
}
