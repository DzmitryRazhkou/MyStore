package com.mystore.qa.pages;

import com.mystore.qa.basepage.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
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
                System.out.println("Product list contains: " + s.getText().trim());
                return true;
            }
        }
        return false;
    }

//    MORE BUTTON:

    private WebElement getProduct() {
        By getProductLocator = By.cssSelector("div.product-container");
        wait.until(ExpectedConditions.presenceOfElementLocated(getProductLocator));
        return driver.findElement(getProductLocator);
    }

    public void doClickOnProduct() {
        log.info("User clicks on the product to proceed further");
        getProduct().click();
    }


//    ADD TO CART (FROM FADED SHORT SLEEVE SHIRT):

    private WebElement getIFrame() {
        By iframeLocator = By.cssSelector("iframe[class='fancybox-iframe']");
        wait.until(ExpectedConditions.presenceOfElementLocated(iframeLocator));
        return driver.findElement(iframeLocator);
    }

    private WebElement getQuantity() {
        By quantityLocator = By.cssSelector("input#quantity_wanted");
        wait.until(ExpectedConditions.presenceOfElementLocated(quantityLocator));
        return driver.findElement(quantityLocator);
    }

    private WebElement getPlusBtn() {
        By plusLocator = By.cssSelector("i.icon-plus");
        wait.until(ExpectedConditions.presenceOfElementLocated(plusLocator));
        return driver.findElement(plusLocator);
    }

    private WebElement getMinusBtn() {
        By minusLocator = By.cssSelector("i.icon-minus");
        wait.until(ExpectedConditions.presenceOfElementLocated(minusLocator));
        return driver.findElement(minusLocator);
    }

    private void getSize(String index) {
        By sizeLocator = By.cssSelector("select#group_1");
        wait.until(ExpectedConditions.presenceOfElementLocated(sizeLocator));
        WebElement size = driver.findElement(sizeLocator);

        Select sel = new Select(size);
        sel.selectByIndex(Integer.parseInt(index));
    }

    private WebElement getColor() {
        By colorLocator = By.cssSelector("ul#color_to_pick_list>li:nth-of-type(1)");
        wait.until(ExpectedConditions.presenceOfElementLocated(colorLocator));
        return driver.findElement(colorLocator);
    }

    private WebElement getAddToCartButton() {
        By addToCartLocator = By.cssSelector("button[name='Submit']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartLocator));
        return driver.findElement(addToCartLocator);
    }

    public boolean getSuccessMessageSearchPage() {
        By successMessageLocator = By.cssSelector("div[class='layer_cart_product col-xs-12 col-md-6'] h2");
        wait.until(ExpectedConditions.presenceOfElementLocated(successMessageLocator));
        WebElement successMessage = driver.findElement(successMessageLocator);
        System.out.println("Success message: " + successMessage.getText());
        return successMessage.isDisplayed();
    }

    private void tryCatchCustomWait(){
        try {
            wait.until(ExpectedConditions.attributeToBe((getAddToCartButton()), "class", "exclusive added"));
        } catch (TimeoutException y){
            System.out.println(" =====> CW <===== ");
        }
    }

    public void doAddToCart(String quantity, String index) {
        log.info("User switches to the frame");
        driver.switchTo().frame(getIFrame());
        log.info("User selects quantity of the product");
        getQuantity().clear();
        getQuantity().sendKeys(quantity);
        getPlusBtn().click();
        getMinusBtn().click();
        log.info("User selects size of the product from the drop down menu");
        getSize(index);
        log.info("User selects color of the product");
        getColor().click();
        log.info("User clicks on the add to cart button");
        getAddToCartButton().click();
        tryCatchCustomWait();
        log.warn("User goes backyard to the page");
        driver.switchTo().defaultContent();
    }

    private WebElement getProceedToCheckOutBtn() {
        By proceedToCheckOutBtnLocator = By.cssSelector("div[class='layer_cart_cart col-xs-12 col-md-6'] div a");
        wait.until(ExpectedConditions.presenceOfElementLocated(proceedToCheckOutBtnLocator));
        return driver.findElement(proceedToCheckOutBtnLocator);
    }

    public OrderPage proceedToOrderPage() {
        getProceedToCheckOutBtn();
        return new OrderPage(driver);
    }
}
