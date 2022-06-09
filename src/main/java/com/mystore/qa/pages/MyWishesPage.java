package com.mystore.qa.pages;

import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MyWishesPage {

    private String textTrimmed;
    private WebDriver driver;
    private WebDriverWait wait;

    public MyWishesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_DurationOfSeconds));
    }

    //    VALIDATE BREADCRUMB:

    private WebElement getMyWishes() {
        By myWishesLocator = By.cssSelector("span.navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(myWishesLocator));
        return driver.findElement(myWishesLocator);
    }

    public boolean getMyWishesBreadCrumb() {
        try {
            System.out.println(" ===> My wishes breadcrumb is displayed. <=== ");
            System.out.println(getMyWishes().getText());
            return getMyWishes().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getMyWishesPageTitle() {
        System.out.println(" =====> My wishes page title is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

    public String getTopSellers() {
        By topSellersLocator = By.cssSelector("#best-sellers_block_right>div>ul>li");
        wait.until(ExpectedConditions.presenceOfElementLocated(topSellersLocator));

        List<WebElement> list = driver.findElements(topSellersLocator);
        for (WebElement s : list) {
            textTrimmed = s.getText().replaceAll("\\s+", " ");
            System.out.println(textTrimmed);
        }
        return textTrimmed;
    }
}