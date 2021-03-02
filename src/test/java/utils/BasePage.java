package utils;

import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


import static utils.Driver.driver;

public class BasePage {

    public void click(WebElement element, int maxTimeOut){
        fluentWait(element, maxTimeOut);    element.click();
    }

    public void clickByText(String text, int timeOut) {
        implicitWait(timeOut);
        driver.findElement(By.xpath("//*[@text='" + text + "']")).click();
    }

    public static void implicitWait(int timeOut) {
        Driver.driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

    public void sendKeys(WebElement element, String stringValue, int maxTimeout) {
        fluentWait(element, maxTimeout);
        element.sendKeys(stringValue);
    }

    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public String getText(WebElement element, int maxTimeout) {
        fluentWait(element, maxTimeout);
        return element.getText();
    }

    public String getTextWithIndex(List<WebElement> elements, int index, int maxTimeout) {
        fluentWait(elements.get(index), maxTimeout);
        return elements.get(index).getText();
    }

    public void clickWithIndex(List<WebElement> elements, int index, int maxTimeout) {
        fluentWait(elements.get(index), maxTimeout);
        elements.get(index).click();
    }

    public void fluentWait(WebElement element, int maxTimeOut){
        Wait wait = new FluentWait(Driver.driver)
                .withTimeout(Duration.ofSeconds(maxTimeOut))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);

        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static void swipe(int startX, int startY, int endX, int endY, int duration){
        System.out.println("Swipe (" + startX + "," + startY + "," + endX + "," + endY + "," + duration + ")");

        new TouchAction(driver).press(new PointOption<>().withCoordinates(startX, startY))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(duration)))
                .moveTo(new PointOption<>().withCoordinates(endX, endY)).release().perform();

    }

    public static void waitABit(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
