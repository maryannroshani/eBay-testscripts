package com.ebay.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//public class StepsDefinitions1 {
//    WebDriver driver = null;

//    @Given("I am on the zoo website")
//    public void shouldNavigateToTheZooSite() throws Throwable {
//        driver = new ChromeDriver();
//        driver.navigate().to("http://www.thetestroom.com/webapp/");
//    }
//
//    @And("I close the browser")
//    public void shouldCloseTheBrowser() throws Throwable {
//        driver.close();
//    }
//
//    @When("^I click (.*?)$")
//    public void shouldClickLink(String link) throws Throwable {
//        driver.findElement(By.id(link)).click();
//    }
//
//    @Then("^I check page title is (.*?)$")
//    public void CheckPageTitle(String title) throws Throwable {
//        Assert.assertTrue(driver.getTitle().contains(title));
//    }
//
//    }
//





   /* @Given("I am on the zoo website")
    public void shouldNavigateToTheZooSite() throws Throwable {
        driver = new ChromeDriver();
        driver.navigate().to("http://www.thetestroom.com/webapp/");
    }

    @When("I click Adoption link")
    public void shouldClickAdoptionLink() throws Throwable {
        driver.findElement(By.id("adoption_link")).click();

    }

    @Then("I check page title is Adoption")
    public void shouldCheckPageTitleAdoption() throws Throwable {
         Assert.assertTrue(driver.getTitle().contains("Adoption"));
    }

    @Then("I close the browser")
    public void shouldCloseTheBrowser() throws Throwable {
        driver.close();

    }

    @When("I click About link")
    public void shouldClickAboutLink() throws Throwable {
        driver.findElement(By.id("about_link")).click();
    }

    @Then("I check page title is About")
    public void shouldCheckPageTitleAbout() throws Throwable {
        Assert.assertTrue(driver.getTitle().contains("About"));
    }

    @When("I click Contact link")
    public void shouldClickContactLink() throws Throwable {
        driver.findElement(By.id("contact_link")).click();
    }

    @Then("I check page title is Contact")
    public void shouldCheckPageTitleContact() throws Throwable {
        Assert.assertTrue(driver.getTitle().contains("Contact"));
    }*/

