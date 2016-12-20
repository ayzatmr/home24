package de.home24.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ayzat on 20.12.2016.
 */
public class HomePage extends BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@type=\"search\"]")
    WebElement searchField;

    @FindBy(xpath = "//button[text()=\"Suchen\"]")
    WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public SmoodDetailPage search(String text) {
        searchField.clear();
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.ENTER);
        return new SmoodDetailPage(driver);
    }
}

