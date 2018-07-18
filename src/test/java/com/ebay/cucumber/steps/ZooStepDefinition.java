

package com.ebay.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZooStepDefinition {

 WebDriver driver = null;

    @Given("I am on the zoo site")
    public void i_am_on_the_zoo_site()throws Throwable {
        driver = new ChromeDriver();
        driver.navigate().to("http://www.thetestroom.com/webapp");
        System.out.println("ok");
    }

@When("I click on {string}")
public void i_click_on_Contact_link(String link)throws Throwable {
    driver.findElement(By.id(link)).click();
    System.out.println("ok");
}


    @And("I enter {string} into the name field")
    public void i_enter_Name_test_into_the_name_field(String value)throws Throwable {
        driver.findElement(By.name("name_field")).sendKeys(value);
        System.out.println("ok");
    }

    @And("I enter {string} into the address field")
    public void i_enter_Address_test_into_the_address_field(String value)throws Throwable {
        driver.findElement(By.name("address_field")).sendKeys(value);
        System.out.println("ok");
    }

    @And("I enter {string} into the postcode field")
    public void i_enter_Postcode_test_into_the_postcode_field(String value) throws Throwable{
        driver.findElement(By.name("postcode_field")).sendKeys(value);
        System.out.println("ok");
    }

    @And("I enter {string} into the email field")
    public void i_enter_Email_test_into_the_email_field(String value)throws Throwable {
        driver.findElement(By.name("email_field")).sendKeys(value);
        System.out.println("ok");
    }

    @And("I submit the contact form")
    public void i_submit_the_contact_form() throws Throwable{
        driver.findElement(By.id("submit message")).click();
        System.out.println("ok");
    }

    @Then("I check I am on the confirmation page")
    public void i_check_I_am_on_the_confirmation_page() throws Throwable{
        System.out.println("ok");
    }

    @And("I close the browser")
    public void i_close_the_browser() throws Throwable{
        driver.close();
    }
}
