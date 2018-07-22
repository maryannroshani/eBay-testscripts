package com.ebay.cucumber.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class LoginSteps extends AbstractSteps {

    @Before
    public void setUp() throws MalformedURLException {
        setupAndroid();
    }

    @Given("I should be at the sign in page")
    public void shouldLaunchApp() throws Throwable {
        Assert.assertTrue(driver.findElement(By.id("com.ebay.mobile:id/logo")).isDisplayed());
        driver.findElement(By.id("com.ebay.mobile:id/button_sign_in")).click();
        System.out.println("Executed launch app method");
    }

    @And("I enter valid username and passsword")
    public void shouldEnterSignInData() throws Throwable {
        driver.findElement(By.id("com.ebay.mobile:id/edit_text_username")).sendKeys(" nexttriptester1@gmail.com");
        driver.findElement(By.id("com.ebay.mobile:id/et_temp")).sendKeys("Babi1234");
        System.out.println("Executed Enter sign in data method");
    }

    @When("I click the Sign in button")
    public void clickSignIn() throws Throwable {
        driver.findElement(By.id("com.ebay.mobile:id/button_sign_in")).click();
        System.out.println("Executed click sign in method");
    }

    @Then("I Successfully Logged into eBay home page")
    public void loggedIn() throws Throwable {
        Assert.assertTrue(driver.findElement(By.id("com.ebay.mobile:id/home")).isDisplayed());
        System.out.println("Checked if the login was successful or not");
    }

    @And("I enter Invalid username and passsword")
    public void iProvideInvalidUsernameAndPasssword() throws Throwable{
        driver.findElement(By.id("com.ebay.mobile:id/edit_text_username")).sendKeys(" nexttriptester1@gmail.co");
        driver.findElement(By.id("com.ebay.mobile:id/et_temp")).sendKeys("Babi1234");
    }

    @Then("I should get the error message")
    public void iGetTheErrorMessage()throws Throwable {
       Assert.assertTrue(driver.findElement(By.id("com.ebay.mobile:id/tv_sign_in_alert")).isDisplayed());
    }

}
