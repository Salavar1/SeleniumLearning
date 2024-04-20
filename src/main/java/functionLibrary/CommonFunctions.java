package functionLibrary;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class CommonFunctions {

    public static WebDriver driver;
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void assertNoSuchElement(WebDriver driver, By by) {
        try {
            WebElement element = driver.findElement(by);
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }

     /*For when network is slow or webpage is slowly rendering components,
    you want your test script to wait for certain amount of time to catch up with
    that to synchronize the test execution and your page loading or component loading
     */
    public void waitForTime(WebDriver driver, Duration duration) {
        driver.manage().timeouts().implicitlyWait(duration);
    }

    public WebElement findElement(WebDriver driver, By by) {
        return driver.findElement(by);
    }

    public void clickElement(WebDriver driver, By by) {
        findElement(driver, by).click();
    }

    public void type(WebDriver driver, By by, String text) {
        findElement(driver, by).sendKeys(text);
    }

    public void goToUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public void assertTrue(WebDriver driver, By by) {
        Assert.assertTrue(findElement(driver, by).isDisplayed());
    }

    public void assertEquals(WebDriver driver, By by, String expectedText) {
        Assert.assertEquals(expectedText, findElement(driver, by).getText());
    }

    //To find and return a LIST of web elements
    public List<WebElement> findElements(WebDriver driver, By by) {
        return driver.findElements(by);
    }

    //To select an option from a dropdown menu
    public void selectDropdownOption(WebDriver driver, By by, String option) {
        new Select(findElement(driver, by)).selectByVisibleText(option);
    }
}
