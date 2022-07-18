package com.mystore.qa.pages;

import com.mystore.qa.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactUsPage extends BasePage {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

//    RETURN HOME:

//    private WebElement getReturnHomeButton(){
//        By returnHomeButtonLocator = By.cssSelector(".home");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(returnHomeButtonLocator));
//        return driver.findElement(returnHomeButtonLocator);
//    }

//    CONTACT

    private WebElement getContact(){
        By contactLocator = By.cssSelector(".navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactLocator));
        return driver.findElement(contactLocator);
    }

    public boolean getContactBreadCrumb() {
        try {
            System.out.println(" ===> Contact breadcrumb is displayed. <=== ");
            return getContact().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }
}
