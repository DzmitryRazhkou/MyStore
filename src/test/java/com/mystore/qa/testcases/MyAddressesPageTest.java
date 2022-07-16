package com.mystore.qa.testcases;

import com.github.javafaker.Faker;
import com.mystore.qa.basetest.BaseTest;
import com.mystore.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAddressesPageTest extends BaseTest {
    MyStorePage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    MyAddressesPage myAddressesPage;
    Faker faker;

    @Test
    public void validateMyAddressesMessageTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myAddressesPage = myAccountPage.clickOnMyAddresses();
        Assert.assertTrue(myAddressesPage.getMyAddressesParagraphMessage());
    }

    @Test
    public void validateMyAddressesTitlePage() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myAddressesPage = myAccountPage.clickOnMyAddresses();
        String actMyAddressesPageTitle = myAddressesPage.getMyAddressesPageTitle();
        String expMyAddressesPageTitle = prop.getProperty("myAddressesPageTitle");
        Assert.assertEquals(expMyAddressesPageTitle, actMyAddressesPageTitle);
    }


    @Test
    public void doUpdateTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myAddressesPage = myAccountPage.clickOnMyAddresses();

        faker = new Faker();
        String addressFl = faker.address().fullAddress();
        String addressSl = faker.address().secondaryAddress();
        String phone = faker.phoneNumber().cellPhone();
        String data = faker.beer().name();
        String alias = faker.name().title();

        myAddressesPage.doUpdate(addressFl, addressSl, phone, data, alias);
        Assert.assertTrue(myAddressesPage.getMyAddressesParagraphMessage());
    }

    @Test(priority = 1)
    public void doAddNewAddressTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myAddressesPage = myAccountPage.clickOnMyAddresses();

        faker = new Faker();
        String addressFl = faker.address().fullAddress();
        String addressSl = faker.address().secondaryAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String zip = faker.address().zipCode();
        String phone = faker.phoneNumber().cellPhone();
        String data = faker.beer().name();
        String alias = faker.name().title();

        myAddressesPage.doAddNewAddress(addressFl, addressSl, city, state, zip, phone, data, alias);
        Assert.assertTrue(myAddressesPage.getMyAddressesParagraphMessage());
    }

    @Test(priority = 2)
    public void doDelete() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myAddressesPage = myAccountPage.clickOnMyAddresses();
        myAddressesPage.getAlert();

        Assert.assertTrue(myAddressesPage.getMyAddressesParagraphMessage());
    }

    @Test
    public void doClickOnBackToYourAccountTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myAddressesPage = myAccountPage.clickOnMyAddresses();
        myAccountPage = myAddressesPage.doClickBackToToYourAccount();
        String actMyAccountPageTitle = myAccountPage.getMyAccountPageTitle();
        String expMyAccountPageTitle = prop.getProperty("myAccountPageTitle");
        Assert.assertEquals(expMyAccountPageTitle, actMyAccountPageTitle);
    }

    @Test
    public void doClickOnHomeTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myAddressesPage = myAccountPage.clickOnMyAddresses();
        myStorePage = myAddressesPage.doClickHome();
        String actMyStorePageTitle = myStorePage.getMyStorePageTitle();
        String expMyStorePageTitle = prop.getProperty("myStorePageTitle");
        Assert.assertEquals(expMyStorePageTitle, actMyStorePageTitle);
    }
}

