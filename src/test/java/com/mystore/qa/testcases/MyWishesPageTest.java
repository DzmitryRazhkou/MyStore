package com.mystore.qa.testcases;

import com.github.javafaker.Faker;
import com.mystore.qa.basetest.BaseTest;
import com.mystore.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class MyWishesPageTest extends BaseTest {
    Faker faker;
    MyStorePage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    MyWishesPage myWishesPage;

    @Test
    public void validateMyWishesBreadcrumbTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();
        Assert.assertTrue(myWishesPage.getMyWishesBreadCrumb());
    }

    @Test
    public void validateIdentityTitlePage() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();
        String actMyWishesPageTitle = myWishesPage.getMyWishesPageTitle();
        String expMyWishesPageTitle = prop.getProperty("myWishesPageTitle");
        Assert.assertEquals(expMyWishesPageTitle, actMyWishesPageTitle);
    }

    @Test
    public void validateTopSellersCountTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();

        List<String> actTopSellersList = myWishesPage.getTopSellers();

        int actAmountOfTopSellers = actTopSellersList.size();
        System.out.println(" =====> The amount of top sellers: " + actAmountOfTopSellers + " products <=====. ");
        int expAmountOfTopSellers = Integer.parseInt(prop.getProperty("countOfTopSellers"));
        Assert.assertEquals(expAmountOfTopSellers, actAmountOfTopSellers);

        for (String s : actTopSellersList) {
            System.out.println(s);

            String result = prop.getProperty("product");
            Assert.assertTrue(myWishesPage.validateTopSellers(result));
        }
    }

    @Test
    public void createNewWishListTest(){
        faker = new Faker();

        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();
        String newWishListName = faker.app().name();
        String wishListID = myWishesPage.getId(newWishListName);
        Assert.assertTrue(myWishesPage.wishListExist(wishListID, newWishListName));
    }

    @Test
    public void deleteWishListTest(){
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();
        myWishesPage.getAlert();
    }

    @Test
    public void doClickOnBackToYourAccountTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();
        myAccountPage = myWishesPage.doClickBackToToYourAccount();
        String actMyAccountPageTitle = myAccountPage.getMyAccountPageTitle();
        String expMyAccountPageTitle = prop.getProperty("myAccountPageTitle");
        Assert.assertEquals(expMyAccountPageTitle, actMyAccountPageTitle);
    }

    @Test
    public void doClickOnHomeTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();
        myStorePage = myWishesPage.doClickHome();
        String actMyStorePageTitle = myStorePage.getMyStorePageTitle();
        String expMyStorePageTitle = prop.getProperty("myStorePageTitle");
        Assert.assertEquals(expMyStorePageTitle, actMyStorePageTitle);
    }
}
