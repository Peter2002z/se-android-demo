package pages.authentication;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait tối đa 10s
    }

    // Getter cho username input
    private WebElement getUsernameInput() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("test-Username")
        ));
    }

    // Getter cho password input
    private WebElement getPasswordInput() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("test-Password")
        ));
    }

    // Getter cho login button
    private WebElement getLoginButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("test-LOGIN")
        ));
    }

    public void enterUsername(String username) {
        getUsernameInput().clear();
        getUsernameInput().sendKeys(username);
    }

    public void enterPassword(String password) {
        getPasswordInput().clear();
        getPasswordInput().sendKeys(password);
    }

    public void clickLogin() {
        getLoginButton().click();
    }

    // Hàm login nhanh
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
