package com.mystore.qa.testcases;

import com.mystore.qa.basetest.BaseTest;
import com.mystore.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderHistoryPageTest extends BaseTest {
    MyStorePage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    OrderHistoryPage orderHistoryPage;

    @Test
    public void validateOrderHistoryBreadcrumbTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        orderHistoryPage = myAccountPage.clickOnOrderHistory();
        Assert.assertTrue(orderHistoryPage.getOrderHistoryBreadCrumb());
    }

    @Test
    public void validateOrderHistoryTitlePage() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        orderHistoryPage = myAccountPage.clickOnOrderHistory();
        String actOrderHistoryPageTitle = orderHistoryPage.getOrderHistoryPageTitle();
        String expOrderHistoryPageTitle = prop.getProperty("orderHistoryPageTitle");
        Assert.assertEquals(expOrderHistoryPageTitle, actOrderHistoryPageTitle);
    }

    @Test
    public void getOrderReferenceTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        orderHistoryPage = myAccountPage.clickOnOrderHistory();
        String orderReference = prop.getProperty("orderReference");
        Assert.assertTrue(orderHistoryPage.getOrderReference(orderReference));
    }

    @Test
    public void getDateTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        orderHistoryPage = myAccountPage.clickOnOrderHistory();
        String date = prop.getProperty("date");
        Assert.assertTrue(orderHistoryPage.getDate(date));
    }

    @Test
    public void getTotalPriceTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        orderHistoryPage = myAccountPage.clickOnOrderHistory();
        String totalPrice = prop.getProperty("totalPrice");
        Assert.assertTrue(orderHistoryPage.getTotalPrice(totalPrice));
    }

    @Test
    public void doClickOnBackToYourAccountTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        orderHistoryPage = myAccountPage.clickOnOrderHistory();
        myAccountPage = orderHistoryPage.doClickBackToToYourAccount();
        String actMyAccountPageTitle = myAccountPage.getMyAccountPageTitle();
        String expMyAccountPageTitle = prop.getProperty("myAccountPageTitle");
        Assert.assertEquals(expMyAccountPageTitle, actMyAccountPageTitle);
    }

    @Test
    public void doClickOnHomeTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        orderHistoryPage = myAccountPage.clickOnOrderHistory();
        myStorePage = orderHistoryPage.doClickHome();
        String actMyStorePageTitle = myStorePage.getMyStorePageTitle();
        String expMyStorePageTitle = prop.getProperty("myStorePageTitle");
        Assert.assertEquals(expMyStorePageTitle, actMyStorePageTitle);
    }
}
