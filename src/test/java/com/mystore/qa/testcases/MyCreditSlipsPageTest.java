package com.mystore.qa.testcases;

import com.mystore.qa.basetest.BaseTest;
import com.mystore.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyCreditSlipsPageTest extends BaseTest {
    MyStorePage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    MyCreditSlipsPage myCreditSlipsPage;

    @Test
    public void validateMyCreditSlipsBreadcrumbTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myCreditSlipsPage = myAccountPage.clickOnMyCreditSlips();
        Assert.assertTrue(myCreditSlipsPage.getMyCreditSlipsBreadCrumb());
    }

    @Test
    public void validateMyCreditSlipsTitlePage() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myCreditSlipsPage = myAccountPage.clickOnMyCreditSlips();
        String actMyCreditSlipsPageTitle = myCreditSlipsPage.getMyCreditSlipsPageTitle();
        String expMyCreditSlipsPageTitle = prop.getProperty("myCreditSlipsPageTitle");
        Assert.assertEquals(expMyCreditSlipsPageTitle, actMyCreditSlipsPageTitle);
    }

    @Test
    public void validateMyCreditSlipsMessage() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myCreditSlipsPage = myAccountPage.clickOnMyCreditSlips();
        String actMyCreditSlipsMessage = myCreditSlipsPage.getMessage();
        String expMMyCreditSlipsMessage = prop.getProperty("messageText");
        Assert.assertEquals(expMMyCreditSlipsMessage, actMyCreditSlipsMessage);
    }

    @Test
    public void doClickOnBackToYourAccountTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myCreditSlipsPage = myAccountPage.clickOnMyCreditSlips();
        myAccountPage = myCreditSlipsPage.doClickBackToToYourAccount();
        String actMyAccountPageTitle = myAccountPage.getMyAccountPageTitle();
        String expMyAccountPageTitle = prop.getProperty("myAccountPageTitle");
        Assert.assertEquals(expMyAccountPageTitle, actMyAccountPageTitle);
    }

    @Test
    public void doClickOnHomeTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myCreditSlipsPage = myAccountPage.clickOnMyCreditSlips();
        myStorePage = myCreditSlipsPage.doClickHome();
        String actMyStorePageTitle = myStorePage.getMyStorePageTitle();
        String expMyStorePageTitle = prop.getProperty("myStorePageTitle");
        Assert.assertEquals(expMyStorePageTitle, actMyStorePageTitle);
    }
}
