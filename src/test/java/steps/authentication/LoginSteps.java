package steps.authentication;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import support.MobileWorld;
import configs.AndroidCapabilities;

import org.openqa.selenium.By;

public class LoginSteps {
    MobileWorld mobileWorld;

    public LoginSteps(MobileWorld mobileWorld) {
        this.mobileWorld = mobileWorld;
    }

    @Given("I am on the login screen")
    public void iAmOnTheLoginScreen() {
        // Giả sử app mở là login screen
    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        mobileWorld.loginPage.enterUsername(username);
    }

    @When("I enter password {string}")
    public void iEnterPassword(String password) {
        mobileWorld.loginPage.enterPassword(password);
    }

    @When("I tap login")
    public void iTapLogin() {
        mobileWorld.loginPage.clickLogin();
    }

    @Then("I should see the products page")
    public void iShouldSeeTheProductsPage() {
        Assert.assertTrue(mobileWorld.inventoryPage.isProductsPageDisplayed());
    }
}
