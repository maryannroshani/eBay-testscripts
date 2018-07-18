package com.ebay;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;


import static org.junit.Assert.assertTrue;

public class EbayMain {
    private static AndroidDriver driver;
    private static String sessionId;


    @BeforeClass
    public static void setUp() throws MalformedURLException {
        setupAndroid();
    }

    private static void setupAndroid() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy Note 3");
        cap.setCapability("appPackage", "com.ebay.mobile");
        cap.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        sessionId = driver.getSessionId().toString();

    }

    @Test
    public void welcomeTextPresent() {
        assertTrue(driver.findElement(By.id("com.ebay.mobile:id/logo")).isDisplayed());
    }

    @BeforeClass
    public static void signIn() {
        driver.findElement(By.id("com.ebay.mobile:id/button_sign_in")).click();
        driver.findElement(By.id("com.ebay.mobile:id/edit_text_username")).sendKeys(" nexttriptester1@gmail.com");
        driver.findElement(By.id("com.ebay.mobile:id/edit_text_password")).sendKeys("Babi1234");
        driver.findElement(By.id("com.ebay.mobile:id/button_sign_in")).click();
        driver.findElement(By.id("com.ebay.mobile:id/button_google_deny")).click();
    }

    @Test
    public void browseCategories() {

        driver.findElement(By.id("com.ebay.mobile:id/home")).click();

        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\"com.ebay.mobile:id/design_navigation_view\")";
        String neededElement_finder = "new UiSelector().resourceId(\"com.ebay.mobile:id/menuitem_settings\")";


        driver.findElementByAndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")");
        driver.findElement(By.id("com.ebay.mobile:id/menuitem_categories")).click();


        List<WebElement> allElements = driver.findElements(By.id("com.ebay.mobile:id/imageview_category"));
        driver.findElements(By.id("com.ebay.mobile:id/imageview_category"));
        int s = allElements.size();
        for (int i = 0; i < s; i++)

        {
            allElements = driver.findElements(By.id("com.ebay.mobile:id/imageview_category"));
            System.out.println(allElements.get(i));

        }

    }

    @Test
    public void countCategories() {
        Set<String> allElementsText = new HashSet<String>();

        driver.findElement(By.id("com.ebay.mobile:id/home")).click();
        driver.findElement(By.id("com.ebay.mobile:id/menuitem_categories")).click();

        List<WebElement> categoeryList = driver.findElements(By.id("com.ebay.mobile:id/textview_category"));
        categoeryList.get(0);


        List<WebElement> ChildElements = driver.findElements(By.id("com.ebay.mobile:id/textview_category"));
        for (WebElement element : ChildElements) {
            String text = element.getText();
            allElementsText.add(text);
        }

        scrollAndCollectCat(allElementsText, "Collectibles");
        scrollAndCollectCat(allElementsText, "Dolls & Bears");
        scrollAndCollectCat(allElementsText, "Gift Cards & Coupons");
        scrollAndCollectCat(allElementsText, "Real Estate");
        scrollAndCollectCat(allElementsText, "Sporting Goods");
        scrollAndCollectCat(allElementsText, "Stamps");
        scrollAndCollectCat(allElementsText, "Video Games & Consoles");
        scrollAndCollectCat(allElementsText, "Everything Else");

        //allElementsText.forEach(System.out::println); another way to do following

        for (String s : allElementsText) {
            System.out.println(s);
        }

        int childElementsCount = allElementsText.size();

        int size = allElementsText.size();
        int item = new Random().nextInt(size);

        String random = new ArrayList<>(allElementsText).get(item);

        scrollToElement(random);
        driver.findElement(By.xpath("//android.widget.TextView[@text='" + random + "']")).click();

        if (childElementsCount == 35) {
            System.out.println("There are 35 Categories! ");

        }

    }

    private void scrollAndCollectCat(Set<String> allElementsText, final String catName) {
        scrollToElement(catName);


        List<WebElement> ChildElements1 = driver.findElements(By.id("com.ebay.mobile:id/textview_category"));
        for (WebElement element : ChildElements1) {
            String text = element.getText();
            allElementsText.add(text);
        }
    }

    private void scrollToElement(String catName) {
        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\"com.ebay.mobile:id/channel_content\")";
        String neededElement_finder = "new UiSelector().text(\"" + catName + "\")";

        driver.findElementByAndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")");
    }

    @Test
    public void searchItem(){
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.View/android.widget.LinearLayout/android.view.View/android.widget.LinearLayout/android.widget.TextView")).sendKeys("Peter Rabbit Book");
        driver.findElement(By.id("com.ebay.mobile:id/text")).click();
        driver.findElement(By.id("com.ebay.mobile:id/text_slot_1")).click();

        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Main navigation, open\"]")).click();
        driver.findElement(By.id("com.ebay.mobile:id/menuitem_home")).click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.View/android.widget.LinearLayout/android.view.View/android.widget.LinearLayout/android.widget.TextView")).click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[1]")).click();
        driver.findElement(By.id("com.ebay.mobile:id/text_recent_entry")).click();

    }
}


