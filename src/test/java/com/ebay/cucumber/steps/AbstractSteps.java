package com.ebay.cucumber.steps;

import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public abstract class AbstractSteps {
     AndroidDriver driver;
     String sessionId;

    void setupAndroid() throws MalformedURLException {
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
}
