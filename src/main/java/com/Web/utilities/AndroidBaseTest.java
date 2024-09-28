package com.Web.utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import config.ConfigParser;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AndroidBaseTest {

    private AndroidDriver<AndroidElement> driver;
    private AppiumServer server;
    private final ConfigParser config = new ConfigParser();

    public AndroidDriver<AndroidElement> getDriver() {
        return this.driver;
    }

    @BeforeMethod
    public void setUpBeforeMethod() throws MalformedURLException {
        server = new AppiumServer();
        server.start();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", config.get("deviceName"));
        desiredCapabilities.setCapability("udid", config.get("udid"));
        desiredCapabilities.setCapability("platformName", config.get("platformName"));
        desiredCapabilities.setCapability("platformVersion", config.get("platformVersion"));
        desiredCapabilities.setCapability("appPackage", config.get("appPackage"));
        desiredCapabilities.setCapability("appActivity", config.get("appActivity"));
//        desiredCapabilities.setCapability("noReset", config.get("noReset"));
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
        URL remoteUrl = new URL(config.get("remoteUrl"));
        driver = new AndroidDriver<AndroidElement>(remoteUrl, desiredCapabilities);
        
    }

    @AfterMethod
    public void tearDownAfterMethod() {
        driver.quit();
        server.stop();
    }
}
