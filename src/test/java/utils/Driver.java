package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static utils.PropertyReader.prop;
import static utils.PropertyReader.testDataReader;

public class Driver {

    public static AppiumDriver<WebElement> driver;

    public static AppiumDriver<WebElement> setupDriver() throws MalformedURLException {
        testDataReader();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
        desiredCapabilities.setCapability("noReset", prop.getProperty("resetValue"));
        desiredCapabilities.setCapability("automationName", prop.getProperty("uiAutomator2"));
        desiredCapabilities.setCapability("appPackage", prop.getProperty("appPackage"));
        desiredCapabilities.setCapability("appActivity", prop.getProperty("appActivity"));
        desiredCapabilities.setCapability("newCommandTimeout", 0);


        driver = new AndroidDriver<WebElement>(new URL(prop.getProperty("url")), desiredCapabilities);

        return driver;


    }
}
