package de.home24.pages;

import de.home24.utils.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Ayzat on 20.12.2016.
 */
public class SmoodDetailPage extends BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//span[@itemprop=\"price\"]")
    WebElement price;

    @FindBy(xpath = "//select[@name=\"bedSize\"]")
    WebElement bedSize;

    @FindBy(xpath = "//select[@name=\"qty\"]")
    WebElement quantity;

    @FindBy(xpath = "//button[text()=\"In den Warenkorb\"]")
    WebElement addToBasketButton;

    @FindBy(id = "js-close-cart-overlay-button")
    WebElement backButton;

    @FindBy(className = "article-rating__stars")
    WebElement rating;

    @FindBy(id = "js-to-cart-button")
    WebElement cartButton;

    @FindBy(xpath = "//li[@class=\"slider-list\"]")
    List<WebElement> pictures;

    @FindBy(className = "pdp-section")
    List<WebElement> additionalOffers;

    @FindBy(xpath = "//div[@class=\"header__count-badge js-header__cart-articles-count\"]")
    WebElement itemsInBasket;

    public SmoodDetailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public double getPrice() {
        return Double.parseDouble(price.getText().replace(",","."));
    }

    public WebElement getCartButton() {
        return Helper.waitFor(driver, cartButton);
    }

    public WebElement getBackButton() {
        return Helper.waitFor(driver, backButton);
    }

    public CheckOutPage addToBasket() {
        Helper.waitFor(driver, addToBasketButton).click();
        WebElement cartButton = getCartButton();
        cartButton.click();
        return new CheckOutPage(driver);
    }

    public void addToBasketAndContinueShopping() {
        Helper.waitFor(driver, addToBasketButton).click();
        WebElement backButton = getBackButton();
        backButton.click();
    }

    public int getAmountOfItemsInBasket() {
        WebElement element = Helper.waitFor(driver, itemsInBasket);
        int quantity = Integer.parseInt(element.getText());
        return quantity;
    }

    public void selectBedSize(int index) {
        Helper.selectElement(bedSize, index);
    }

    public void selectQuantity(int index) {
        Helper.selectElement(quantity, index);
    }
}