package com.mystore.qa.pages;

import com.mystore.qa.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyStorePaymentPage extends BasePage {

    public MyStorePaymentPage(WebDriver driver) {
        super(driver);
    }

//    VALIDATE BREADCRUMB:

    private WebElement getCheckPayment() {
        By checkPaymentLocator = By.cssSelector("span.navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkPaymentLocator));
        return driver.findElement(checkPaymentLocator);
    }

    public boolean getMyStorePaymentPageBreadCrumb() {
        try {
            System.out.println(" ===> Check payment breadcrumb is displayed. <=== ");
            System.out.println(getCheckPayment().getText());
            return getCheckPayment().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getMyStorePaymentPageTitle() {
        System.out.println(" =====> My order page title is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

    private WebElement getIConfirmPayment() {
        By getIConfirmPaymentLocator = By.cssSelector("button[class='button btn btn-default button-medium']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getIConfirmPaymentLocator));
        return driver.findElement(getIConfirmPaymentLocator);
    }

    public void validatePaymentInformation() {
        log.info("User confirms the order details.");
        getIConfirmPayment().click();
    }

    private WebElement getConfirmOrderComplete() {
        By getConfirmOrderCompleteLocator = By.cssSelector("p[class='alert alert-success']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getConfirmOrderCompleteLocator));
        return driver.findElement(getConfirmOrderCompleteLocator);
    }

    public boolean validateConfirmOrderComplete() {
        try {
            System.out.println(" =====> " + getConfirmOrderComplete().getText() + " <===== ");
            return getConfirmOrderComplete().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

    private WebElement getBackToOrders() {
        By getBackToOrdersLocator = By.cssSelector("a[class='button-exclusive btn btn-default']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getBackToOrdersLocator));
        return driver.findElement(getBackToOrdersLocator);
    }

    public OrderHistoryPage validateBackToOrders() {
        log.info("User clicks on the back to order.");
        getBackToOrders().click();
        log.info("User navigates on the order history page.");
        return new OrderHistoryPage(driver);
    }
}

