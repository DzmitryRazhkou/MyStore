package com.mystore.qa.testcases;
import com.mystore.qa.basetest.BaseTest;
import com.mystore.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
public class SearchPageTest extends BaseTest {
    MyStorePage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    SearchPage searchPage;
    OrderPage orderPage;

    @Test
    public void validateSearchBreadcrumbTest() {
        String productType = prop.getProperty("productType");

        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        searchPage = myAccountPage.doSearch(productType);
        Assert.assertTrue(searchPage.getSearchBreadCrumb());
    }

    @Test
    public void validateSearchTitlePage() {
        String productType = prop.getProperty("productType");

        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        searchPage = myAccountPage.doSearch(productType);

        String actSearchPageTitle = searchPage.getSearchPageTitle();
        String expSearchPageTitle = prop.getProperty("searchPageTitle");
        Assert.assertEquals(expSearchPageTitle, actSearchPageTitle);
    }

    @Test
    public void validateSearchProduct() {
        String productType = prop.getProperty("productType");
        String product = prop.getProperty("searchedProduct");

        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        searchPage = myAccountPage.doSearch(productType);
        Assert.assertTrue(searchPage.getProductCount());
        Assert.assertTrue(searchPage.getProduct(product));
    }

    @Test
    public void doAddToCart() {
        String productType = prop.getProperty("productType");

        String quantity = prop.getProperty("quantity");
        String size = prop.getProperty("size");

        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        searchPage = myAccountPage.doSearch(productType);
        searchPage.doClickOnProduct();
        searchPage.doAddToCart(quantity, size);
        Assert.assertTrue(searchPage.getSuccessMessageSearchPage());
        orderPage = searchPage.proceedToOrderPage();
        Assert.assertTrue(orderPage.getYourShoppingCartBreadCrumb());
    }
}
