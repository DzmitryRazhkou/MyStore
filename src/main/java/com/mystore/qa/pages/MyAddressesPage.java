package com.mystore.qa.pages;

import com.mystore.qa.basepage.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.List;

public class MyAddressesPage extends BasePage {

    public MyAddressesPage(WebDriver driver) {
        super(driver);
    }

//    VALIDATE BREADCRUMB:

    private WebElement getMyAddresses() {
        By myAddressesLocator = By.xpath("//strong[contains(text(),'Your addresses are listed below.')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(myAddressesLocator));
        return driver.findElement(myAddressesLocator);
    }

    public boolean getMyAddressesParagraphMessage() {
        try {
            System.out.println(" =====> " + getMyAddresses().getText() + " <===== ");
            return getMyAddresses().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getMyAddressesPageTitle() {
        System.out.println(" =====> My addresses page title is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

//    EXTRACT EXISTING DATA:

    public List<String> getExistingData() {
        By myAddressLocator = By.xpath("//ul[@class='last_item item box']/li");
        wait.until(ExpectedConditions.presenceOfElementLocated(myAddressLocator));

        List<WebElement> myAddressList = driver.findElements(myAddressLocator);
        List<String> myAddressesTextList = new ArrayList<>();

        for (WebElement existDataRow : myAddressList) {
            if (existDataRow.isDisplayed()) {
                myAddressesTextList.add(existDataRow.getText());
            } else {
                return null;
            }
        }
        return myAddressesTextList;
    }

//    UPDATE:

    private WebElement getUpdateButton() {
        By getUpdateBtnLocator = By.cssSelector("[title^='Update']");
        wait.until(ExpectedConditions.presenceOfElementLocated(getUpdateBtnLocator));
        return driver.findElement(getUpdateBtnLocator);
    }

    private WebElement getAddressFl() {
        By getAddressFlLocator = By.id("address1");
        wait.until(ExpectedConditions.presenceOfElementLocated(getAddressFlLocator));
        return driver.findElement(getAddressFlLocator);
    }

    private WebElement getAddressSl() {
        By getAddressSlLocator = By.id("address2");
        wait.until(ExpectedConditions.presenceOfElementLocated(getAddressSlLocator));
        return driver.findElement(getAddressSlLocator);
    }

    private WebElement getPhone() {
        By getPhoneLocator = By.id("phone");
        wait.until(ExpectedConditions.presenceOfElementLocated(getPhoneLocator));
        return driver.findElement(getPhoneLocator);
    }

    private WebElement getAdditionalInfo() {
        By getAdditionalInfoLocator = By.id("other");
        wait.until(ExpectedConditions.presenceOfElementLocated(getAdditionalInfoLocator));
        return driver.findElement(getAdditionalInfoLocator);
    }

    private WebElement getSaveBtn() {
        By getSaveBtnLocator = By.id("submitAddress");
        wait.until(ExpectedConditions.presenceOfElementLocated(getSaveBtnLocator));
        return driver.findElement(getSaveBtnLocator);
    }

    public void doUpdate(String addressFl, String addressSl, String phone, String addInfo, String alias) {
        getUpdateButton().click();
        getAddressFl().clear();
        getAddressFl().sendKeys(addressFl);
        getAddressSl().clear();
        getAddressSl().sendKeys(addressSl);
        getPhone().clear();
        getPhone().sendKeys(phone);
        getAdditionalInfo().clear();
        getAdditionalInfo().sendKeys(addInfo);
        getAlias().clear();
        getAlias().sendKeys(alias);
        getSaveBtn().click();
    }

//    ADD A NEW ADDRESS:

    private WebElement getAddANewAddressButton() {
        By getAddANewAddressLocator = By.cssSelector("[title^='Add an address']");
        wait.until(ExpectedConditions.presenceOfElementLocated(getAddANewAddressLocator));
        return driver.findElement(getAddANewAddressLocator);
    }

    private WebElement getCity() {
        By getCityLocator = By.id("city");
        wait.until(ExpectedConditions.presenceOfElementLocated(getCityLocator));
        return driver.findElement(getCityLocator);
    }

    private void selectStates(String stateValue) {
        By getStatesValuesLocator = By.xpath("(//*[@class='form-control'])[1]/option");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getStatesValuesLocator));
        List<WebElement> list = driver.findElements(getStatesValuesLocator);

        for (WebElement webElement : list) {
            System.out.println(webElement.getText());
            if (webElement.getText().contains(stateValue)) {
                webElement.click();
                break;
            }
        }
    }

    private WebElement getZipCode() {
        By getAddressSlLocator = By.id("postcode");
        wait.until(ExpectedConditions.presenceOfElementLocated(getAddressSlLocator));
        return driver.findElement(getAddressSlLocator);
    }

    private WebElement getAlias() {
        By getAliasLocator = By.id("alias");
        wait.until(ExpectedConditions.presenceOfElementLocated(getAliasLocator));
        return driver.findElement(getAliasLocator);
    }

    public void doAddNewAddress(String addAddressFl, String addAddressSl, String addCity, String addState, String addZip,
                                String addPhone, String addAddInfo, String alias) {

        getAddANewAddressButton().click();
        getAddressFl().sendKeys(addAddressFl);
        getAddressSl().sendKeys(addAddressSl);
        getCity().sendKeys(addCity);
        selectStates(addState);
        getZipCode().sendKeys(addZip);
        getPhone().sendKeys(addPhone);
        getAdditionalInfo().sendKeys(addAddInfo);
        getAlias().clear();
        getAlias().sendKeys(alias);
        getSaveBtn().click();
    }

//    DELETE:

    private WebElement getDeleteBtn() {
        By deleteBtnLocator = By.xpath("(//*[@title='Delete'])[2]");
        wait.until(ExpectedConditions.presenceOfElementLocated(deleteBtnLocator));
        return driver.findElement(deleteBtnLocator);
    }

    public void getAlert() {
        getDeleteBtn().click();
        Alert okDelete = driver.switchTo().alert();
        String textAlert = okDelete.getText();
        System.out.println("JS Pop up: " + textAlert);
        okDelete.accept();
    }

//    Back to your account:

    private WebElement getBackToYourAccount() {
        By getBackToYourAccountLocator = By.xpath("//*[contains(text(),' Back to your account')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(getBackToYourAccountLocator));
        return driver.findElement(getBackToYourAccountLocator);
    }

    public MyAccountPage doClickBackToToYourAccount() {
        getBackToYourAccount().click();
        return new MyAccountPage(driver);
    }

//    Home:

    private WebElement getHome() {
        By getHomeLocator = By.xpath("//*[contains(text(),' Home')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(getHomeLocator));
        return driver.findElement(getHomeLocator);
    }

    public MyStorePage doClickHome() {
        getHome().click();
        return new MyStorePage(driver);
    }
}

