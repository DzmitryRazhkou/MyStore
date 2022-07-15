package com.mystore.qa.testcases.deprecated;

import com.github.javafaker.Faker;
import com.mystore.qa.driverfactory.DriverFactory;
import com.mystore.qa.pages.*;
import com.mystore.qa.pages.deprecated.FadedShortSleeveTShirtsPage_Deprecated;
import com.mystore.qa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class FadedShortSleeveTShirtsPageTest_Deprecated {

    ConfigReader cp;
    DriverFactory df;
    Properties prop;

    private static WebDriver driver;
    private static WebDriverWait wait;

    Faker faker;
    MyStorePage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    SearchPage searchPage;
    FadedShortSleeveTShirtsPage_Deprecated fadedShortSleeveTShirtsPage;
    OrderPage orderPage;

    @BeforeMethod
    public void startUp() {
        cp = new ConfigReader();
        df = new DriverFactory();
        prop = cp.initProp();
        driver = df.initDriver("chrome", prop);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void validateFadedShortSleeveTShirtBreadcrumbTest() {
        String productType = prop.getProperty("productType");

        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        searchPage = myAccountPage.doSearch(productType);
//        fadedShortSleeveTShirtsPage = searchPage.clickOnMore();
        Assert.assertTrue(fadedShortSleeveTShirtsPage.getFadedShortSleeveTShirtBreadCrumb());
    }

    @Test
    public void validateFadedShortSleeveTShirtTitlePage() throws InterruptedException {
        String productType = prop.getProperty("productType");

        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        searchPage = myAccountPage.doSearch(productType);
//        fadedShortSleeveTShirtsPage = searchPage.clickOnMore();

        String actFadedShortSleeveTShirtPageTitle = fadedShortSleeveTShirtsPage.getFadedShortSleeveTShirtPageTitle();
        String expFadedShortSleeveTShirtPageTitle = prop.getProperty("fadedShortSleeveTShirtsTitlePage");
        Assert.assertEquals(actFadedShortSleeveTShirtPageTitle, expFadedShortSleeveTShirtPageTitle);
    }

    @Test
    public void doWriteReviewTest() {
        faker = new Faker();
        String productType = prop.getProperty("productType");
        String title = faker.artist().name();
        String comment = faker.medical().symptoms();

        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        searchPage = myAccountPage.doSearch(productType);
//        fadedShortSleeveTShirtsPage = searchPage.clickOnMore();
        fadedShortSleeveTShirtsPage.doWriteReview(title, comment);
        Assert.assertTrue(fadedShortSleeveTShirtsPage.newReviewComment());
    }

    @Test
    public void doSendEmailFriendTest() {
        faker = new Faker();
        String productType = prop.getProperty("productType");
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();

        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        searchPage = myAccountPage.doSearch(productType);
//        fadedShortSleeveTShirtsPage = searchPage.clickOnMore();
        fadedShortSleeveTShirtsPage.doSendEmailFriend(name, email);
        Assert.assertTrue(fadedShortSleeveTShirtsPage.newEmailComment());
    }

    @Test
    public void doAddToWishTest() {
        String productType = prop.getProperty("productType");

        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        searchPage = myAccountPage.doSearch(productType);
//        fadedShortSleeveTShirtsPage = searchPage.clickOnMore();
        fadedShortSleeveTShirtsPage.getAddToWishBtn();
        Assert.assertTrue(fadedShortSleeveTShirtsPage.newAddToWish());
    }

    @Test
    public void doAddToCartTest() {
        String productType = prop.getProperty("productType");
        String quantity = prop.getProperty("quantity");
        String size = prop.getProperty("size");

        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        searchPage = myAccountPage.doSearch(productType);
//        fadedShortSleeveTShirtsPage = searchPage.clickOnMore();
        fadedShortSleeveTShirtsPage.doAddToCart(quantity, size);
        Assert.assertTrue(fadedShortSleeveTShirtsPage.getSuccessMessage());

    }
}
