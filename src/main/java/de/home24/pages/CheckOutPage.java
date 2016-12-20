package de.home24.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.util.StringUtils;

import static org.apache.commons.lang3.StringUtils.replaceOnce;

/**
 * Created by Ayzat on 20.12.2016.
 */
public class CheckOutPage extends BasePage {
    private WebDriver driver;

    @FindBy(xpath = "//strong[@class=\"cart-total-price acte-checkout-grandTotal-lbl\"]")
    WebElement totalPrice;

    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public double getTotalPrice() {
        String price = totalPrice.getText().substring(0, (totalPrice.getText().length()-2)).replace(",",".");
        int occurance = StringUtils.countOccurrencesOf(price, ".");
        if(occurance>1){
            price = replaceOnce(price, ".", "").trim();
        }
        return Double.parseDouble(price);
    }
}
