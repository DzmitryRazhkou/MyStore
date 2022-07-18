package com.mystore.qa.pages;

import com.mystore.qa.basepage.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class StoresPage extends BasePage {
    public StoresPage(WebDriver driver) {
        super(driver);
    }

//    VALIDATE BREADCRUMB:

    private WebElement getMyWishes() {
        By myWishesLocator = By.cssSelector("span.navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(myWishesLocator));
        return driver.findElement(myWishesLocator);
    }

    public boolean getStoresBreadCrumb() {
        try {
            System.out.println(" ===> Stores breadcrumb is displayed. <=== ");
            System.out.println(getMyWishes().getText());
            return getMyWishes().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getStorePageTitle() {
        System.out.println(" =====> My stores page title is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

//    GOOGLE MAP:

    private WebElement doAcceptOk() {
        By googleMapLocator = By.cssSelector(".dismissButton:first-of-type");
        wait.until(ExpectedConditions.presenceOfElementLocated(googleMapLocator));
        return driver.findElement(googleMapLocator);
    }

    private WebElement getStore() {
        By locationLocator = By.xpath("(//div[@role='button'])[2]");
        wait.until(ExpectedConditions.elementToBeClickable(locationLocator));
        return driver.findElement(locationLocator);
    }

    private WebElement getStoreBusinessHours() {
        By scheduleLocator = By.cssSelector("div.gm-style-iw-d");
        wait.until(ExpectedConditions.presenceOfElementLocated(scheduleLocator));
        return driver.findElement(scheduleLocator);
    }

    private WebElement getClose() {
        By locationLocator = By.cssSelector("[title='Close']");
        wait.until(ExpectedConditions.presenceOfElementLocated(locationLocator));
        return driver.findElement(locationLocator);
    }

    public boolean doGetStoreGoogleMaps(String storeName) throws InterruptedException {
        navigate();
        doAcceptOk().click();
        getStore().click();
        Thread.sleep(1000);
        if (getStoreBusinessHours().getText().contains(storeName)) {
            System.out.println("Our store: \n" + getStoreBusinessHours().getText());
            getClose().click();
        }
        return false;
    }

//    Zoom In/ Zoom Out Map:

    private void navigate() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300)", "");
        System.out.println(" =====> Page has bee scrolled down <===== ");
    }

    private WebElement getZoomIn(){
        By zoomInLocator = By.cssSelector("[title='Zoom in']");
        wait.until(ExpectedConditions.presenceOfElementLocated(zoomInLocator));
        return driver.findElement(zoomInLocator);
    }

    private WebElement getZoomOut(){
        By zoomOutLocator = By.cssSelector("[title='Zoom out']");
        wait.until(ExpectedConditions.presenceOfElementLocated(zoomOutLocator));
        return driver.findElement(zoomOutLocator);
    }

    public void zoomInZoomOutTest() {
        navigate();
        doAcceptOk().click();
        getZoomIn().click();
        getZoomIn().click();
        getZoomIn().click();

        getZoomOut().click();
        getZoomOut().click();
        getZoomOut().click();
        System.out.println(" =====> Test passed <===== ");
    }


    private WebElement locationInput(){
        By locationInputLocator = By.xpath("//input[@class='form-control grey']");
        wait.until(ExpectedConditions.presenceOfElementLocated(locationInputLocator));
        return driver.findElement(locationInputLocator);
    }

    private void selectMiles(String value){
        By selectMilesLocator = By.xpath("(//select[@class='form-control'])[1]");
        wait.until(ExpectedConditions.presenceOfElementLocated(selectMilesLocator));
        WebElement selectRadius = driver.findElement(selectMilesLocator);

        Select select = new Select(selectRadius);
        select.selectByValue(value);
    }

    private WebElement getSearchBtn(){
        By getSearchBtnLocator = By.name("search_locations");
        wait.until(ExpectedConditions.presenceOfElementLocated(getSearchBtnLocator));
        return driver.findElement(getSearchBtnLocator);
    }

    private WebElement getFancyErrorMessage(){
        By getFancyErrorLocator = By.xpath("//*[@class='fancybox-error']");
        wait.until(ExpectedConditions.presenceOfElementLocated(getFancyErrorLocator));
        return driver.findElement(getFancyErrorLocator);
    }

    public boolean fancyError(){
        try {
            System.out.println("Error box message is: " +getFancyErrorMessage().getText());
            return getFancyErrorMessage().isDisplayed();
        } catch (TimeoutException y){
            System.out.println(" ===> Please provide the correct locator. <===");
        }
        return false;
    }


    public void doSelectLocation(String cityName, String value) {
        log.info("User clicks on the navigate button");
        navigate();
        log.info("User enters a city name");
        locationInput().clear();
        locationInput().sendKeys(cityName);
        log.info("User enters range of the miles");
        selectMiles(value);
        log.info("User clicks a search button");
        getSearchBtn().click();
    }
}
