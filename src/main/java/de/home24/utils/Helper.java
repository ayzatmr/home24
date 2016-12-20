package de.home24.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import static java.util.concurrent.TimeUnit.MICROSECONDS;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by Ayzat on 20.12.2016.
 */
public abstract class Helper {
    public static WebElement waitFor(WebDriver driver, WebElement webElement) {
        Wait wait = new FluentWait(driver)
                .withTimeout(15, SECONDS)
                .pollingEvery(500, MICROSECONDS);
        WebElement element = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return element;
    }

    public static void selectElement(WebElement element, int index){
        Select dropdown = new Select(element);
        dropdown.selectByIndex(index);
    }
}
