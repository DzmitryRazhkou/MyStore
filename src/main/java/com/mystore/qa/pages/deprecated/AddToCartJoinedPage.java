package com.mystore.qa.pages.deprecated;

import com.mystore.qa.pages.deprecated.FadedShortSleeveTShirtsPage_Deprecated;
import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddToCartJoinedPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AddToCartJoinedPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_DurationOfSeconds));
    }

//    VALIDATE BREADCRUMB:

    private WebElement getSearch() {
        By orderHistoryLocator = By.cssSelector("span.navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderHistoryLocator));
        return driver.findElement(orderHistoryLocator);
    }

    public boolean getSearchBreadCrumb() {
        try {
            System.out.println(" ===> Search breadcrumb is displayed. <=== ");
            System.out.println(getSearch().getText());
            return getSearch().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getSearchPageTitle() {
        System.out.println(" =====> Search page title is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

//    PRODUCT COUNT:

    public boolean getProductCount() {
        By productCountLocator = By.xpath("(//div[@class='product-count'])[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCountLocator));
        try {
            WebElement productCount = driver.findElement(productCountLocator);
            System.out.println("Text is: " + productCount.getText());
            return productCount.isDisplayed();
        } catch (TimeoutException y) {
            System.out.println("Provide an another locator");
        }
        return false;
    }

    public boolean getProduct(String productName) {
        By getProductLocator = By.cssSelector("div.product-container");
        wait.until(ExpectedConditions.presenceOfElementLocated(getProductLocator));
        List<WebElement> productList = driver.findElements(getProductLocator);
        for (WebElement s : productList) {
            if (s.getText().trim().contains(productName) && s.isDisplayed()) {
                System.out.println("Product list contains: " +s.getText().trim());
                return true;
            }
        }
        return false;
    }


//    MORE BUTTON:

    private WebElement getProduct(){
        By getProductLocator = By.cssSelector("div.product-container");
        wait.until(ExpectedConditions.presenceOfElementLocated(getProductLocator));
        return driver.findElement(getProductLocator);
    }

    public FadedShortSleeveTShirtsPage_Deprecated clickOnMore(){
        getProduct().click();
        return new FadedShortSleeveTShirtsPage_Deprecated(driver);
    }

}
