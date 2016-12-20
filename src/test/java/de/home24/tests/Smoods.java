package de.home24.tests;

import de.home24.config.AbstractSeleniumTest;
import de.home24.pages.CheckOutPage;
import de.home24.pages.HomePage;
import de.home24.pages.SmoodDetailPage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ayzat on 20.12.2016.
 */
public class Smoods extends AbstractSeleniumTest {

    private static int quantity = 2;

    @Test
    public void checkTotalOrderPrice() {
        HomePage homePage = new HomePage(driver);
        SmoodDetailPage smoodPage = homePage.search("smood");

        //check if basket is empty
        int itemsInBasket = smoodPage.getAmountOfItemsInBasket();
        Assert.assertTrue("Order have already been added to basket", itemsInBasket == 0);

        //select items
        smoodPage.selectBedSize(2);
        smoodPage.selectQuantity(quantity);
        double price = smoodPage.getPrice();

        CheckOutPage checkOutPage = smoodPage.addToBasket();

        //check if sum of order is correct
        double totalPrice = checkOutPage.getTotalPrice();
        Assert.assertTrue("Total sum is incorrect", totalPrice == price * (quantity+1));

    }

    @Test
    public void checkAmountOfItemsInBasket() {
        HomePage homePage = new HomePage(driver);
        SmoodDetailPage smoodPage = homePage.search("smood");

        //check if basket is empty
        int itemsInBasket = smoodPage.getAmountOfItemsInBasket();
        Assert.assertTrue("Order have already been added to basket", itemsInBasket == 0);

        //select items
        smoodPage.selectQuantity(quantity);

        smoodPage.addToBasketAndContinueShopping();
        int newAmountOfItemsInBasket = smoodPage.getAmountOfItemsInBasket();
        Assert.assertTrue("Total sum is incorrect", newAmountOfItemsInBasket == quantity+1);

    }

}
