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

import java.util.ArrayList;
import java.util.List;

public class BagSteps extends CommonFunctions {


    @Given("I am on home page {string}")
    public void openHomePage(String url) {
        driver.get(url);
        //with common function do, goToUrl(driver, url);
        Assert.assertTrue(driver.findElement(By.className("login_logo")).isDisplayed());
        //with common function do, assertTrue(driver, By.className("login_logo"));
    }

    @When("I do Login with username {string} and password {string}")
    public void doLogin(String username, String password) {
        //if typing username using common functions do the following
        //type(driver, By.id("user-name"), username);
        //to click, you do, clickElement(driver, By.id("login-button"));
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
        //using common functions do, clickElement(driver, By.id("add-to-cart"));
        Assert.assertEquals(badgeValue, driver.findElement(By.className("shopping_cart_badge")).getText());
        //using common functions do, assertEquals(driver, By.className("shopping_cart_badge"), badgeValue);
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
    /*If you want to do above method using the common functions, do the following
clickElement(driver, By.xpath("//button[text()='Remove']"));
     */

    @Then("the product {string} should be removed")
    public void verifyProductRemovedFromBag(String expectedProductToBeRemoved) {
        assertNoSuchElement(driver, By.className("inventory_item_name"));
    }

    @When("I click back button")
    public void clickBackButton() {
        driver.findElement(By.id("back-to-products")).click();
        Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());
    }

    @Then("I should see products {string} and {string} in the bag")
    public void verifyMultipleProductsInBag(String expectedProduct1InBag, String expectedProduct2InBag) {

        //Create an array of expected products
        String expectedProducts[] = {expectedProduct1InBag, expectedProduct2InBag};

        //Create list of actual product elements
        List<WebElement> actualProductsInBag = driver.findElements(By.xpath("//div[@data-test = 'inventory-item-name']"));

        //Create an empty list to hold product names
        List<String> actualProductNames = new ArrayList<>();

        //Iterate through actual product elements and get name from each and add it to empty list
        for (WebElement actualProduct : actualProductsInBag) {
            actualProductNames.add(actualProduct.getText());
        }

        //Iterate through each expected products array and check that each exists within list of actualProductNames
        for (String expectedProduct : expectedProducts) {
            Assert.assertTrue(actualProductNames.contains(expectedProduct));
        }
    }
}

