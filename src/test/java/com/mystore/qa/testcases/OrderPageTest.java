package com.mystore.qa.testcases;

import com.github.javafaker.Faker;
import com.mystore.qa.basetest.BaseTest;
import com.mystore.qa.pages.*;
import com.mystore.qa.pages.deprecated.FadedShortSleeveTShirtsPage_Deprecated;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderPageTest extends BaseTest {

    Faker faker;
    MyStorePage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    SearchPage searchPage;
    FadedShortSleeveTShirtsPage_Deprecated fadedShortSleeveTShirtsPage;
    OrderPage orderPage;

    @Test
    public void validateYourShoppingCartBreadcrumbTest() {
        String productType = prop.getProperty("productType");
        String quantity = prop.getProperty("quantity");
        String size = prop.getProperty("size");

        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        searchPage = myAccountPage.doSearch(productType);
//        fadedShortSleeveTShirtsPage = searchPage.clickOnMore();
        fadedShortSleeveTShirtsPage.doAddToCart(quantity, size);
        orderPage = fadedShortSleeveTShirtsPage.proceedToOrderPage();
        Assert.assertTrue(orderPage.getYourShoppingCartBreadCrumb());
    }

    @Test
    public void validateOrderTitlePage() {
        String productType = prop.getProperty("productType");
        String quantity = prop.getProperty("quantity");
        String size = prop.getProperty("size");

        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        searchPage = myAccountPage.doSearch(productType);
//        fadedShortSleeveTShirtsPage = searchPage.clickOnMore();
        fadedShortSleeveTShirtsPage.doAddToCart(quantity, size);
        orderPage = fadedShortSleeveTShirtsPage.proceedToOrderPage();

        String actOrderPageTitle = orderPage.getOrderPageTitle();
        String expOrderPageTitle = prop.getProperty("orderPageTitle");
        Assert.assertEquals(expOrderPageTitle, actOrderPageTitle);
    }

    @Test
    public void validatePriceTest() {
        String productType = prop.getProperty("productType");
        String quantity = prop.getProperty("quantity");
        String size = prop.getProperty("size");

        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        searchPage = myAccountPage.doSearch(productType);
//        fadedShortSleeveTShirtsPage = searchPage.clickOnMore();
        fadedShortSleeveTShirtsPage.doAddToCart(quantity, size);
        orderPage = fadedShortSleeveTShirtsPage.proceedToOrderPage();
        Assert.assertEquals(orderPage.price(), orderPage.getTotal());
    }

    @Test
    public void doProceedTest() {
        faker = new Faker();
        String productType = prop.getProperty("productType");
        String quantity = prop.getProperty("quantity");
        String size = prop.getProperty("size");
        String deliveryInstruction = faker.currency().name();
        int index = Math.max(1, 3);

        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        searchPage = myAccountPage.doSearch(productType);
//        fadedShortSleeveTShirtsPage = searchPage.clickOnMore();
        fadedShortSleeveTShirtsPage.doAddToCart(quantity, size);
        orderPage = fadedShortSleeveTShirtsPage.proceedToOrderPage();
        orderPage.proceedFinally(deliveryInstruction, index);
    }

}
