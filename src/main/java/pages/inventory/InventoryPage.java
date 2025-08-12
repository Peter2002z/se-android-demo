package pages.inventory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage {
    private final AndroidDriver driver;

    public InventoryPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private WebElement getProductsTitle() {
        return driver.findElement(AppiumBy.xpath("//*[@text='PRODUCTS']"));
    }

    public boolean isProductsPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(getProductsTitle())).isDisplayed();
    }
}
