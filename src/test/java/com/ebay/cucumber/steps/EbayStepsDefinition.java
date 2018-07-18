package com.ebay.cucumber.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class EbayStepsDefinition {
    private AndroidDriver driver;
    private String sessionId;


    @Before
    public void setUp() throws MalformedURLException {
        setupAndroid();
    }

    private void setupAndroid() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy Note 3");
        capabilities.setCapability("appPackage", "com.ebay.mobile");
        capabilities.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");
        System.out.println();
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        sessionId = driver.getSessionId().toString();
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
        driver.findElement(By.id("com.ebay.mobile:id/edit_text_password")).sendKeys("Babi1234");
        System.out.println("Executed Enter sign in data method");
    }

    @When("I click the Sign in button")
    public void clickSignIn() throws Throwable {
        driver.findElement(By.id("com.ebay.mobile:id/button_sign_in")).click();
        System.out.println("Executed click sign in method");
    }

    @And("I click deny link accounts")
    public void i_click_deny_link_accounts() {
        driver.findElement(By.id("com.ebay.mobile:id/button_google_deny")).click();
    }

    @Then("I Successfully Logged into eBay home page")
    public void loggedIn() throws Throwable {
        Assert.assertTrue(driver.findElement(By.id("com.ebay.mobile:id/home")).isDisplayed());
        System.out.println("Checked if the login was successful or not");
    }

    @And("I enter Invalid username and passsword")
    public void iProvideInvalidUsernameAndPasssword() throws Throwable{
        driver.findElement(By.id("com.ebay.mobile:id/edit_text_username")).sendKeys(" nexttriptester1@gmail.co");
        driver.findElement(By.id("com.ebay.mobile:id/edit_text_password")).sendKeys("Babi1234");
    }

    @Then("I should get the error message")
    public void iGetTheErrorMessage()throws Throwable {
       Assert.assertTrue(driver.findElement(By.id("com.ebay.mobile:id/tv_sign_in_alert")).isDisplayed());
    }

}
