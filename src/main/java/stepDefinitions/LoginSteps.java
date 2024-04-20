package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginSteps extends CommonFunctions {

    @Then("I should land on the Products page")
    public void verifyOnProductsPage() {
        Assert.assertTrue(findElement(driver, By.className("title")).isDisplayed());
    }

    @When("I do Login with an invalid username {string} and password {string}")
    public void doInvalidLogin(String username, String password) {
        type(driver, By.id("user-name"), username);
        type(driver, By.id("password"), password);
        clickElement(driver, By.id("login-button"));
    }

    @Then("I should see an error with message {string}")
    public void invalidLoginErrorMessage(String errorMessage) {
        assertEquals(driver, By.xpath("//h3[@data-test = 'error']"), errorMessage);
    }

    @When("I do Login without entering a username and password")
    public void doNoDataLogin() {
        clickElement(driver, By.id("login-button"));
    }

}
