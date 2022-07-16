package com.mystore.qa.testcases;

import com.github.javafaker.Faker;
import com.mystore.qa.basetest.BaseTest;
import com.mystore.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StoresPageTest extends BaseTest {
    Faker faker;
    MyStorePage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    MyWishesPage myWishesPage;
    StoresPage storesPage;

    @Test
    public void validateMyWishesBreadcrumbTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();
        storesPage = myWishesPage.doClickOurStores();
        Assert.assertTrue(storesPage.getStoresBreadCrumb());
    }

    @Test
    public void validateIdentityTitlePage() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();
        storesPage = myWishesPage.doClickOurStores();
        String actMyWishesPageTitle = storesPage.getStorePageTitle();
        String expMyWishesPageTitle = prop.getProperty("storesPageTitle");
        Assert.assertEquals(expMyWishesPageTitle, actMyWishesPageTitle);
    }

    @Test
    public void doGoogleClicksTest() throws InterruptedException {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();
        storesPage = myWishesPage.doClickOurStores();
        Assert.assertTrue(!storesPage.doGetStoreGoogleMaps(prop.getProperty("store")));
    }

    @Test
    public void doZoomInZoomOutTest() throws InterruptedException {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();
        storesPage = myWishesPage.doClickOurStores();
        storesPage.zoomInZoomOutTest();
    }

    @Test
    public void selectLocationStoreTest() throws InterruptedException {
        faker = new Faker();
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();
        storesPage = myWishesPage.doClickOurStores();

        String city = faker.address().city();
        String value = prop.getProperty("radius");
        storesPage.doSelectLocation(city, value);
        Assert.assertTrue(storesPage.fancyError());
    }

}
