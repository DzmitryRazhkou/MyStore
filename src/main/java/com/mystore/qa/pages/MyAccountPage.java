package com.mystore.qa.pages;

import com.mystore.qa.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BasePage {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

//    VALIDATE BREADCRUMB:

    private WebElement getMyAccount() {
        By myAccountLocator = By.cssSelector("span.navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountLocator));
        return driver.findElement(myAccountLocator);
    }

    public boolean getMyAccountBreadCrumb() {
        try {
            System.out.println(" ===> My account breadcrumb is displayed. <=== ");
            System.out.println(getMyAccount().getText());
            return getMyAccount().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getMyAccountPageTitle(){
        System.out.println(" =====> My account page title is: " +driver.getTitle()+ " <===== ");
        return driver.getTitle();
    }

//    SEARCH HEADER:

    private WebElement getSearchField(){
        By searchFieldLocator = By.id("search_query_top");
        wait.until(ExpectedConditions.presenceOfElementLocated(searchFieldLocator));
        return driver.findElement(searchFieldLocator);
    }

    private WebElement getSearchBtn(){
        By searchBtnLocator = By.name("submit_search");
        wait.until(ExpectedConditions.presenceOfElementLocated(searchBtnLocator));
        return driver.findElement(searchBtnLocator);
    }

    public SearchPage doSearch(String productType){
        log.info("User enters product type on the search field");
        getSearchField().sendKeys(productType);
        log.info("User clicks on the search button");
        getSearchBtn().click();
        log.info("User navigates at the my search page");
        return new SearchPage(driver);
    }

//    MY ACCOUNT:

//    1. Order History:

    private WebElement getOrderHistoryLink(){
        By orderHistoryLocator = By.cssSelector("[title^='Orders']");
        wait.until(ExpectedConditions.presenceOfElementLocated(orderHistoryLocator));
        return driver.findElement(orderHistoryLocator);
    }

    public OrderHistoryPage clickOnOrderHistory(){
        getOrderHistoryLink().click();
        return new OrderHistoryPage(driver);
    }

//    My Credit Slips:

    private WebElement getMyCreditSlipsLink(){
        By myCreditSlipsLocator = By.cssSelector("[title^='Credit slips']");
        wait.until(ExpectedConditions.presenceOfElementLocated(myCreditSlipsLocator));
        return driver.findElement(myCreditSlipsLocator);
    }

    public MyCreditSlipsPage clickOnMyCreditSlips(){
        log.info("User clicks on the my credit slips link");
        getMyCreditSlipsLink().click();
        log.info("User navigates at the my credit slips page");
        return new MyCreditSlipsPage(driver);
    }

//    My Addresses:

    private WebElement getMyAddressesLink(){
        By addressesLocator = By.cssSelector("[title^='Addresses']");
        wait.until(ExpectedConditions.presenceOfElementLocated(addressesLocator));
        return driver.findElement(addressesLocator);
    }

    public MyAddressesPage clickOnMyAddresses(){
        log.info("User clicks on the my address link");
        getMyAddressesLink().click();
        log.info("User navigates at the my address page");
        return new MyAddressesPage(driver);
    }

//    Identity:

    private WebElement getIdentityLink(){
        By identityLocator = By.cssSelector("[title^='Information']");
        wait.until(ExpectedConditions.presenceOfElementLocated(identityLocator));
        return driver.findElement(identityLocator);
    }

    public IdentityPage clickOnIdentity(){
        log.info("User clicks on the my identity link");
        getIdentityLink().click();
        log.info("User navigates at the my identity page");
        return new IdentityPage(driver);
    }

//    My Wishes:

    private WebElement getMyWishesLink(){
        By myWishesLocator = By.cssSelector("[title^='My wishlists']");
        wait.until(ExpectedConditions.presenceOfElementLocated(myWishesLocator));
        return driver.findElement(myWishesLocator);
    }

    public MyWishesPage clickOnMyWishes(){
        log.info("User clicks on the my wishes link");
        getMyWishesLink().click();
        log.info("User navigates at the my wishes page");
        return new MyWishesPage(driver);
    }

//    Home:

    private WebElement getHome(){
        By getHomeLocator = By.xpath("(//*[@class='btn btn-default button button-small'])[2]");
        wait.until(ExpectedConditions.presenceOfElementLocated(getHomeLocator));
        return driver.findElement(getHomeLocator);
    }

    public MyStorePage doClickHome(){
        log.info("User clicks on the my home");
        getHome().click();
        log.info("User navigates at the my store page");
        return new MyStorePage(driver);
    }
}
