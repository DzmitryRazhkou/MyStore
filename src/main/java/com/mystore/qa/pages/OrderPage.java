package com.mystore.qa.pages;

import com.mystore.qa.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class OrderPage extends BasePage {
    public OrderPage(WebDriver driver) {
        super(driver);
    }

//    VALIDATE BREADCRUMB:

    private WebElement getYourShoppingCart() {
        By yourShoppingCartLocator = By.xpath("//div[@class='breadcrumb clearfix']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(yourShoppingCartLocator));
        return driver.findElement(yourShoppingCartLocator);
    }

    public boolean getYourShoppingCartBreadCrumb() {
        try {
            System.out.println(" ===> Your shopping cart breadcrumb is displayed. <=== ");
            System.out.println(getYourShoppingCart().getText());
            return getYourShoppingCart().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getOrderPageTitle() {
        System.out.println(" =====> Order page title is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

//    VALIDATE PRICES:

    private double getTotalPrice() {
        By totalPriceLocator = By.cssSelector("tr td#total_product");
        wait.until(ExpectedConditions.presenceOfElementLocated(totalPriceLocator));
        String totalPriceTr = driver.findElement(totalPriceLocator).getText().replaceAll("[^a-zA-Z\\d]", "");
        return (Double.parseDouble(totalPriceTr))/100;
    }

    private double getTotalShipping() {
        By totalShippingLocator = By.cssSelector("tr td#total_shipping");
        wait.until(ExpectedConditions.presenceOfElementLocated(totalShippingLocator));
        String totalShippingText = driver.findElement(totalShippingLocator).getText();
        String totalShippingTr = totalShippingText.replaceAll("[^a-zA-Z\\d]", "");
        return (Double.parseDouble(totalShippingTr))/100;
    }

    public double getTotal() {
        By totalLocator = By.cssSelector("span#total_price");
        wait.until(ExpectedConditions.presenceOfElementLocated(totalLocator));
        String totalText = driver.findElement(totalLocator).getText();
        String totalTr = totalText.replaceAll("[^a-zA-Z\\d]", "");
        double total = (Double.parseDouble(totalTr))/100;
        System.out.println(" =====> Expected total price: " + total + "$ <=====");
        return total;
    }

    public double price() {
        double actTotal = getTotalPrice() + getTotalShipping();
        System.out.println(" =====> Actual total price: " + actTotal + "$ <=====");
        return actTotal;
    }

//    CLICK PROCEED TO CHECKOUT SUMMARY:

    private WebElement getProceedToCheckOutSummary() {
        By proceedToCheckOutSummaryLocator = By.xpath("(//a[@title='Proceed to checkout'])[2]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckOutSummaryLocator));
        return driver.findElement(proceedToCheckOutSummaryLocator);
    }

//    CLICK PROCEED TO CHECKOUT SUMMARY:

    private void selectDeliveryAddress(int index){
        By deliveryAddressLocator = By.cssSelector("select#id_address_delivery");
        wait.until(ExpectedConditions.presenceOfElementLocated(deliveryAddressLocator));

        WebElement deliveryAddress = driver.findElement(deliveryAddressLocator);
        Select select = new Select(deliveryAddress);
        select.selectByIndex(index);
    }

    private WebElement getTextArea() {
        By textAreaLocator = By.cssSelector("textarea[name='message']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(textAreaLocator));
        return driver.findElement(textAreaLocator);
    }

    private WebElement getProceedToCheckOutAddress() {
        By proceedToCheckOutAddressLocator = By.xpath("(//button[@type='submit'])[2]");
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckOutAddressLocator));
        return driver.findElement(proceedToCheckOutAddressLocator);
    }

//    SHIPPING:

    private WebElement getCheckBox() {
        By checkBoxLocator = By.cssSelector("div.checker");
        wait.until(ExpectedConditions.elementToBeClickable(checkBoxLocator));
        return driver.findElement(checkBoxLocator);
    }

    private WebElement getProceedToCheckOutShipping() {
        By proceedToCheckOutShippingLocator = By.xpath("(//button[@type='submit'])[2]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckOutShippingLocator));
        return driver.findElement(proceedToCheckOutShippingLocator);
    }

    private WebElement getPaymentMethod() {
        By getPaymentMethodLocator = By.cssSelector("a.cheque");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getPaymentMethodLocator));
        return driver.findElement(getPaymentMethodLocator);
    }


    public void proceedThruOrderPage(String deliveryInstruction, int index) {
        getProceedToCheckOutSummary().click();
        selectDeliveryAddress(index);
        getTextArea().clear();
        getTextArea().sendKeys(deliveryInstruction);
        getProceedToCheckOutAddress().click();
        getCheckBox().click();
        getProceedToCheckOutShipping().click();
    }

    public MyStorePaymentPage selectPaymentMethod(){
        getPaymentMethod().click();
        return new MyStorePaymentPage(driver);
    }
}
