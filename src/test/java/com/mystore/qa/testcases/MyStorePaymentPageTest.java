package com.mystore.qa.testcases;

import com.github.javafaker.Faker;
import com.mystore.qa.basetest.BaseTest;
import com.mystore.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyStorePaymentPageTest extends BaseTest {

    Faker faker;
    MyStorePage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    SearchPage searchPage;
    OrderPage orderPage;
    MyStorePaymentPage myStorePaymentPage;
    OrderHistoryPage orderHistoryPage;

    @Test
    public void validateCheckPaymentBreadcrumbTest() {
            faker = new Faker();
            String deliveryInstruction = faker.currency().name();
            int index = Math.max(1, 3);

            String productType = prop.getProperty("productType");

            String quantity = prop.getProperty("quantity");
            String size = prop.getProperty("size");

            myStorePage = new MyStorePage(driver);
            loginPage = myStorePage.clickSignIn();
            myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
            searchPage = myAccountPage.doSearch(productType);
            searchPage.doClickOnProduct();
            searchPage.doAddToCart(quantity, size);
            orderPage = searchPage.proceedToOrderPage();
            orderPage.proceedThruOrderPage(deliveryInstruction, index);
            myStorePaymentPage = orderPage.selectPaymentMethod();
            Assert.assertTrue(myStorePaymentPage.getMyStorePaymentPageBreadCrumb());
        }

    @Test
    public void validateMyStorePaymentPageTitlePage() {
        faker = new Faker();
        String deliveryInstruction = faker.currency().name();
        int index = Math.max(1, 3);

        String productType = prop.getProperty("productType");

        String quantity = prop.getProperty("quantity");
        String size = prop.getProperty("size");

        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        searchPage = myAccountPage.doSearch(productType);
        searchPage.doClickOnProduct();
        searchPage.doAddToCart(quantity, size);
        orderPage = searchPage.proceedToOrderPage();
        orderPage.proceedThruOrderPage(deliveryInstruction, index);
        myStorePaymentPage = orderPage.selectPaymentMethod();

        String actMyStorePaymentPageTitle = myStorePaymentPage.getMyStorePaymentPageTitle();
        String expMyStorePaymentPageTitle = prop.getProperty("getMyStorePaymentPageTitle");
        Assert.assertEquals(expMyStorePaymentPageTitle, actMyStorePaymentPageTitle);
    }

    @Test
    public void validateConfirmOrderCompleteTest() {
        faker = new Faker();
        String deliveryInstruction = faker.currency().name();
        int index = Math.max(1, 3);

        String productType = prop.getProperty("productType");

        String quantity = prop.getProperty("quantity");
        String size = prop.getProperty("size");

        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        searchPage = myAccountPage.doSearch(productType);
        searchPage.doClickOnProduct();
        searchPage.doAddToCart(quantity, size);
        orderPage = searchPage.proceedToOrderPage();
        orderPage.proceedThruOrderPage(deliveryInstruction, index);
        myStorePaymentPage = orderPage.selectPaymentMethod();
        myStorePaymentPage.validatePaymentInformation();
        Assert.assertTrue(myStorePaymentPage.validateConfirmOrderComplete());
    }

    @Test
    public void validateBackToOrdersTest() {
        faker = new Faker();
        String deliveryInstruction = faker.currency().name();
        int index = Math.max(1, 3);

        String productType = prop.getProperty("productType");

        String quantity = prop.getProperty("quantity");
        String size = prop.getProperty("size");

        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        searchPage = myAccountPage.doSearch(productType);
        searchPage.doClickOnProduct();
        searchPage.doAddToCart(quantity, size);
        orderPage = searchPage.proceedToOrderPage();
        orderPage.proceedThruOrderPage(deliveryInstruction, index);
        myStorePaymentPage = orderPage.selectPaymentMethod();
        myStorePaymentPage.validatePaymentInformation();
        orderHistoryPage = myStorePaymentPage.validateBackToOrders();
        Assert.assertTrue(orderHistoryPage.getOrderHistoryBreadCrumb());
    }
}
