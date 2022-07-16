package com.mystore.qa.testcases;

import com.mystore.qa.basetest.BaseTest;
import com.mystore.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IdentityPageTest extends BaseTest {
    MyStorePage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    IdentityPage identityPage;

    @Test
    public void validateIdentityBreadcrumbTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        identityPage = myAccountPage.clickOnIdentity();
        Assert.assertTrue(identityPage.getIdentityBreadCrumb());
    }

    @Test
    public void validateIdentityTitlePage() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        identityPage = myAccountPage.clickOnIdentity();
        String actIdentityPageTitle = identityPage.getIdentityPageTitle();
        String expIdentityPageTitle = prop.getProperty("myIdentityPageTitle");
        Assert.assertEquals(expIdentityPageTitle, actIdentityPageTitle);
    }

    @Test
    public void getPersonalInfoTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        identityPage = myAccountPage.clickOnIdentity();
        List<String> actPersonalInfoList = identityPage.getPersonalInfo();

        List<String> expPersonalInfoList = new ArrayList<>(Arrays.asList(prop.getProperty("firstname"),
                prop.getProperty("lastname"), prop.getProperty("email"), prop.getProperty("dob")));

        Assert.assertEquals(expPersonalInfoList, actPersonalInfoList);
    }

    @Test
    public void doClickOnBackToYourAccountTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        identityPage = myAccountPage.clickOnIdentity();
        myAccountPage = identityPage.doClickBackToToYourAccount();
        String actMyAccountPageTitle = myAccountPage.getMyAccountPageTitle();
        String expMyAccountPageTitle = prop.getProperty("myAccountPageTitle");
        Assert.assertEquals(expMyAccountPageTitle, actMyAccountPageTitle);
    }

    @Test
    public void doClickOnHomeTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        identityPage = myAccountPage.clickOnIdentity();
        myStorePage = identityPage.doClickHome();
        String actMyStorePageTitle = myStorePage.getMyStorePageTitle();
        String expMyStorePageTitle = prop.getProperty("myStorePageTitle");
        Assert.assertEquals(expMyStorePageTitle, actMyStorePageTitle);
    }

}
