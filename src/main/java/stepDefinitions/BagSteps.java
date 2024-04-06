package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BagSteps {

    public WebDriver driver = new ChromeDriver();

    CommonFunctions commonFunctions = new CommonFunctions();

    @Given("I am on home page {string}")
    public void openHomePage(String url) {
        driver.get(url);
        Assert.assertTrue(driver.findElement(By.className("login_logo")).isDisplayed());
    }

    @When("I do Login with username {string} and password {string}")
    public void doLogin(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());
    }

    @When("I choose a product {string}")
    public void chooseProduct(String productName) {
        driver.findElement(By.xpath("//div[@data-test = 'inventory-item-name' and text() = '" + productName + "']")).click();
        Assert.assertTrue(driver.findElement(By.name("back-to-products")).isDisplayed());
    }

    @When("I click Add to cart button with badge {string}")
    public void addToCart(String badgeValue) {
        driver.findElement(By.id("add-to-cart")).click();
        Assert.assertEquals(badgeValue, driver.findElement(By.className("shopping_cart_badge")).getText());
    }

    @When("I click bag icon")
    public void clickBagIcon() {
        driver.findElement(By.className("shopping_cart_link")).click();
        Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());
    }

    @Then("I should see product {string} in the bag")
    public void verifyProductInBag(String expectedProductInBag) {
        Assert.assertEquals(expectedProductInBag, driver.findElement(By.className("inventory_item_name")).getText());
    }

    @When("I click remove button in the bag")
    public void clickRemoveButton() {
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

    }

    @Then("the product {string} should be removed")
    public void verifyProductRemovedFromBag() {
        commonFunctions.assertNoSuchElement(driver, By.className("inventory_item_name"));
    }

    @When("I click back button")
    public void clickBackButton() {
driver.findElement(By.id("back-to-products")).click();
Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());
    }

    @Then("I should see products {string} and {string} in the bag")
    public void verifyMultipleProductsInBag(String expectedProduct1InBag, String expectedProduct2InBag) {
String expectedProducts[] = {expectedProduct1InBag, expectedProduct2InBag};

for (String expectedProduct: expectedProducts)
{
    List<WebElement> actualProductsInBag = driver.findElements(By.xpath("//div[@data-test = 'inventory-item-name']"));
}
    }
}
