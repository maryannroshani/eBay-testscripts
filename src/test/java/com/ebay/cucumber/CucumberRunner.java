package com.ebay.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/ZooTest.feature"}, plugin = {"pretty", "html:target/html"})
public class CucumberRunner {


}


