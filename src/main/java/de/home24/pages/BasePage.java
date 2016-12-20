package de.home24.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by Ayzat on 20.12.2016.
 */
public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        //make sure that all described elements is presented on the screen
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }
}
