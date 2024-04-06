package functionLibrary;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonFunctions {

    public void assertNoSuchElement(WebDriver driver, By by) {
        try {
            WebElement element = driver.findElement(by);
            Assert.fail();
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }
}
