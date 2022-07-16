package com.mystore.qa.pages;

import com.mystore.qa.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class LoginCreateAccountPage extends BasePage {
    public LoginCreateAccountPage(WebDriver driver) {
        super(driver);
    }

//    VALIDATE BREADCRUMB:

    private WebElement authenticationBreadcrumb() {
        By womenBreadcrumbLocator = By.cssSelector("span.navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(womenBreadcrumbLocator));
        return driver.findElement(womenBreadcrumbLocator);
    }

    public boolean getAuthenticationBreadcrumb() {
        try {
            System.out.println(" ===> Header authentication breadcrumb is displayed. <=== ");
            System.out.println(authenticationBreadcrumb().getText());
            return authenticationBreadcrumb().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getMyLoginCreateAccountPageTitle(){
        System.out.println(" =====> My login create account page title is: " +driver.getTitle()+ " <===== ");
        return driver.getTitle();
    }

//    YOUR PERSONAL INFORMATION:

//    1. Title:

    private WebElement getMrMrsRadioBtn() {
        By getMrRadioBtnLocator = By.cssSelector("#id_gender1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getMrRadioBtnLocator));
        return driver.findElement(getMrRadioBtnLocator);
    }

    //    First Name:

    private WebElement getFirstName() {
        By getFirstNameLocator = By.cssSelector("#customer_firstname");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getFirstNameLocator));
        return driver.findElement(getFirstNameLocator);
    }

//    Last Name:

    private WebElement getLastName() {
        By getLastNameLocator = By.cssSelector("#customer_lastname");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLastNameLocator));
        return driver.findElement(getLastNameLocator);
    }

//    Password:

    private WebElement getPassword() {
        By getPasswordLocator = By.cssSelector("#passwd");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getPasswordLocator));
        return driver.findElement(getPasswordLocator);
    }

//    Date Of Birth:

//    1. Days

    private void selectDays(String dayValue) {
        By getDaysValuesLocator = By.xpath("(//*[@class='form-control'])[1]//option");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getDaysValuesLocator));

        List<WebElement> list = driver.findElements(getDaysValuesLocator);

        for (WebElement webElement : list) {
            System.out.println(webElement.getText());
            if (webElement.getText().equals(dayValue)) {
                webElement.click();
                break;
            }
        }
    }

//    2. Months

    private void selectMonths(String monthValue) {

        By getMonthsValuesLocator = By.xpath("(//*[@class='form-control'])[2]//option");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getMonthsValuesLocator));

            List<WebElement> list = driver.findElements(getMonthsValuesLocator);

        for (WebElement webElement : list) {
            System.out.println(webElement.getText());
            if (webElement.getText().contains(monthValue)) {
                webElement.click();
                break;
            }
        }
        }


//    3. Years

    public void selectYears(String yearsValue) {
        By getYearsValuesLocator = By.xpath("(//*[@class='form-control'])[3]//option");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getYearsValuesLocator));
            List<WebElement> list = driver.findElements(getYearsValuesLocator);

        for (WebElement webElement : list) {
            System.out.println(webElement.getText());
            if (webElement.getText().equals(yearsValue)) {
                webElement.click();
                break;
            }
        }
        }

//    YOUR ADDRESS:

//    1. First Name:

    private WebElement getFirstNameAddress() {
        By getFirstNameAddressLocator = By.cssSelector("#firstname:nth-of-type(1)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getFirstNameAddressLocator));
        return driver.findElement(getFirstNameAddressLocator);
    }

//    2. Last Name:

    private WebElement getLastNameAddress() {
        By getLastNameAddressLocator = By.cssSelector("#lastname:nth-of-type(1)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLastNameAddressLocator));
        return driver.findElement(getLastNameAddressLocator);
    }

//    3. Company:

    private WebElement getCompany() {
        By getCompanyLocator = By.cssSelector("#company");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getCompanyLocator));
        return driver.findElement(getCompanyLocator);
    }

//    4. Address:

    //    First Line
    private WebElement getAddressFirstLine() {
        By getAddressFirstLineLocator = By.cssSelector("#address1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getAddressFirstLineLocator));
        return driver.findElement(getAddressFirstLineLocator);
    }

    //    Second Line
    private WebElement getAddressSecondLine() {
        By getAddressSecondLineLocator = By.cssSelector("#address2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getAddressSecondLineLocator));
        return driver.findElement(getAddressSecondLineLocator);
    }

//    5. City:

    private WebElement getCity() {
        By getCityLocator = By.cssSelector("#city");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getCityLocator));
        return driver.findElement(getCityLocator);
    }

//    6. State:

    private void selectStates(String stateValue) {
        By getStatesValuesLocator = By.xpath("(//*[@class='form-control'])[10]//option");
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

//    7. ZIP/POSTAL CODE

    private WebElement getZipCode() {
        By getZipCodeLocator = By.cssSelector("#postcode");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getZipCodeLocator));
        return driver.findElement(getZipCodeLocator);
    }

//    8. Additional Info

    private WebElement getAddInfo() {
        By getAddInfoLocator = By.cssSelector("#other");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getAddInfoLocator));
        return driver.findElement(getAddInfoLocator);
    }

//    9. Mobile phone:

    private WebElement getMobilePhone() {
        By getMobilePhoneLocator = By.cssSelector("#phone_mobile");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getMobilePhoneLocator));
        return driver.findElement(getMobilePhoneLocator);
    }

//    11. REGISTER BUTTON

    private WebElement getRegisterBtn() {
        By getRegisterBtnLocator = By.cssSelector("#submitAccount");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getRegisterBtnLocator));
        return driver.findElement(getRegisterBtnLocator);
    }


//    FINAL METHOD


    public MyAccountPage fillUpPersonalInfo(String firstName, String lastName, String password,
    String dayDOB, String monthDOB, String yearDOB, String company, String addressFL, String addressSL,
                                   String city, String state, long zipCode, String addInfo, long phone) {

        getMrMrsRadioBtn().click();
        getFirstName().sendKeys(firstName);
        getLastName().sendKeys(lastName);
        getPassword().sendKeys(password);

        selectDays(dayDOB);
        selectMonths(monthDOB);
        selectYears(yearDOB);

        getFirstNameAddress().sendKeys(firstName);
        getLastNameAddress().sendKeys(lastName);
        getCompany().sendKeys(company);
        getAddressFirstLine().sendKeys(addressFL);
        getAddressSecondLine().sendKeys(addressSL);
        getCity().sendKeys(city);
        selectStates(state);
        getZipCode().sendKeys(String.valueOf(zipCode));
        getAddInfo().sendKeys(addInfo);
        getMobilePhone().sendKeys(String.valueOf(phone));
        getRegisterBtn().click();
        return new MyAccountPage(driver);
    }

}
