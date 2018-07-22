package com.ebay.cucumber.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.List;

public class SearchItemSteps extends AbstractSteps {

    @Before
    public void setUp() throws MalformedURLException {
        setupAndroid();
    }

    @Before("@login")
    public void beforeLogin() {
        Assert.assertTrue(driver.findElement(By.id("com.ebay.mobile:id/logo")).isDisplayed());
        driver.findElement(By.id("com.ebay.mobile:id/button_sign_in")).click();
        driver.findElement(By.id("com.ebay.mobile:id/edit_text_username")).sendKeys(" nexttriptester1@gmail.com");
        driver.findElement(By.id("com.ebay.mobile:id/et_temp")).sendKeys("Babi1234");
        driver.findElement(By.id("com.ebay.mobile:id/button_sign_in")).click();
        System.out.println("Running login scenario");
    }

    @Given("I should be signed in eBay account Home")
    public void i_should_be_signed_in_eBay_account_Home() throws Throwable {
        Assert.assertTrue(driver.findElement(By.id("com.ebay.mobile:id/home")).isDisplayed());
    }

    @And("Navigate to me search bar")
    public void navigate_to_me_search_bar() throws Throwable {
        driver.findElement(By.id("com.ebay.mobile:id/search_box")).click();
        System.out.println("Running login scenario");
    }

    @When("I search an item with valid data")
    public void i_search_an_item_with_valid_data()throws Throwable {
        driver.findElement(By.id("com.ebay.mobile:id/search_src_text")).sendKeys("Peter Rabbit Book");
    }

    @Then("Display search results")
    public void display_search_results()throws Throwable {
        Assert.assertTrue(driver.findElement(By.id("com.ebay.mobile:id/suggestionList")).isDisplayed());
    }

    @And("I click the first search suggestion")
    public void i_click_the_first_search_suggestion()throws Throwable {
        List suggestions = driver.findElements(By.id("com.ebay.mobile:id/text"));
        ((WebElement)suggestions.get(0)).click();
    }

    @When("I click the recent in searches")
    public void i_click_the_recent_in_searches() throws Throwable {
        driver.findElement(By.xpath(" //android.widget.TextView[@text=\"Recent\"]")).click();
    }

    @Then("Display recent search list")
    public void display_recent_search_list() throws Throwable {
        Assert.assertTrue(driver.findElement(By.id("android:id/list")).isEnabled());
        System.out.println("Running login scenario");
    }

    @When("I click the saved in searches")
    public void i_click_the_saved_in_searches() throws Throwable {
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"Saved\"]")).click();
        System.out.println("Running login scenario");
    }

    @Then("Display saved search list")
    public void display_saved_search_list() throws Throwable {
        Assert.assertTrue(driver.findElement(By.id("android:id/list")).isEnabled());
        System.out.println("Running login scenario");
    }
}
