package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Do;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortSteps extends CommonFunctions {

    @When("I click sort dropdown")
    public void clickSortDropdown() {
        clickElement(driver, By.className("product_sort_container"));
    }

    @Then("I should see options {string}, {string}, {string}, {string}")
    public void verifySortDropdownOptionsExist(String expOpt1, String expOpt2, String expOpt3, String expOpt4) {
        String expDropdownOptions[] = {expOpt1, expOpt2, expOpt3, expOpt4};

        List<WebElement> options = new Select(findElement(driver, By.className("product_sort_container"))).getOptions();

        List<String> optionsText = new ArrayList<>();

        for (WebElement option : options) {
            optionsText.add(option.getText());
        }

        //if statement below confirms same number of items - array uses length and list uses size
        if (expDropdownOptions.length == optionsText.size()) {
            for (String expOpt : expDropdownOptions) {
                Assert.assertTrue(optionsText.contains(expOpt));
            }

//Another way to confirm number of items is to assert between the two for loops without adding the if statement
// Assert.assertEquals(expDropdownOptions.length, optionsText.size());
// This will make sure it does not get to the second for loop unless this assert statement passes
        }
    }

    @When("I choose option {string}")
    public void chooseSortOption(String option) {
        new Select(driver.findElement(By.className("product_sort_container"))).selectByVisibleText(option);
        //use Select to wrap because this is a dropdown menu
        //If using common function, do following
        //selectDropdownOption(driver, By.className("product_sort_container"), option)
    }

    @Then("I expect products to be sorted in ascending order")
    public void verifyProductNameAtoZ() {
        List<WebElement> actualProducts = findElements(driver, By.xpath("//div[@data-test='inventory-item-name']"));

        List<String> productNames = new ArrayList<>();

        for (WebElement actualProduct : actualProducts) {

            productNames.add(actualProduct.getText());
        }

        List<String> sortedProductNames = new ArrayList<>(productNames);
        Collections.sort(sortedProductNames);

        Assert.assertTrue(productNames.equals(sortedProductNames));

    }

    @Then("I expect products to be sorted in descending order")
    public void verifyProductNameZtoA() {
        List<WebElement> actualProducts = findElements(driver, By.xpath("//div[@data-test='inventory-item-name']"));

        List<String> productNames = new ArrayList<>();

        for (WebElement actualProduct : actualProducts) {

            productNames.add(actualProduct.getText());
        }

        List<String> sortedProductNames = new ArrayList<>(productNames);
        Collections.sort(sortedProductNames, Collections.reverseOrder());

        Assert.assertTrue(productNames.equals(sortedProductNames));
    }

    @Then("I expect products to be sorted in price ascending order")
    public void verifyProductPriceLowToHigh() {

        List<WebElement> actualPricesElements = findElements(driver, By.xpath("//div[@data-test='inventory-item-price']"));

        List<Double> actualPrices = new ArrayList<>();

        for (WebElement actualPricesElement : actualPricesElements) {
            String priceAsText = actualPricesElement.getText();

            try {
                Double priceAsDigits = Double.parseDouble(priceAsText);
                actualPrices.add(priceAsDigits);
            } catch (NumberFormatException e) {
            }

        }
        List<Double> sortedActualPrices = new ArrayList<>(actualPrices);
        Collections.sort(sortedActualPrices);

        Assert.assertTrue(actualPrices.equals(sortedActualPrices));

    }

    @Then("I expect products to be sorted in price descending order")
    public void verifyProductPriceHighToLow() {

        List<WebElement> actualPricesElements = findElements(driver, By.xpath("//div[@data-test='inventory-item-price']"));

        List<Double> actualPrices = new ArrayList<>();

        for (WebElement actualPricesElement : actualPricesElements) {
            String priceAsText = actualPricesElement.getText();

            try {
                Double priceAsDigits = Double.parseDouble(priceAsText);
                actualPrices.add(priceAsDigits);
            } catch (NumberFormatException e) {
            }

        }
        List<Double> sortedActualPrices = new ArrayList<>(actualPrices);
        Collections.sort(sortedActualPrices, Collections.reverseOrder());

        Assert.assertTrue(actualPrices.equals(sortedActualPrices));

    }
}