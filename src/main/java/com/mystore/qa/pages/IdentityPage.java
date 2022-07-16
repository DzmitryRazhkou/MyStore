package com.mystore.qa.pages;

import com.mystore.qa.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IdentityPage extends BasePage {
    public IdentityPage(WebDriver driver) {
        super(driver);
    }

//    VALIDATE BREADCRUMB:

    private WebElement getIdentity() {
        By identityLocator = By.cssSelector("span.navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(identityLocator));
        return driver.findElement(identityLocator);
    }

    public boolean getIdentityBreadCrumb() {
        try {
            System.out.println(" ===> Identity breadcrumb is displayed. <=== ");
            System.out.println(getIdentity().getText());
            return getIdentity().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getIdentityPageTitle() {
        System.out.println(" =====> Identity page title is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

//    REQUIRED FIELDS:

//    First Name:

    private String getFirstNameText() {
        By getFirstNameLocator = By.id("firstname");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getFirstNameLocator));
        System.out.println("First name is: " +driver.findElement(getFirstNameLocator).getAttribute("value"));
        return driver.findElement(getFirstNameLocator).getAttribute("value");
    }

//    Last Name:

    private String getLastNameText() {
        By getLastNameLocator = By.id("lastname");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLastNameLocator));
        System.out.println("Last name is: " +driver.findElement(getLastNameLocator).getAttribute("value"));
        return driver.findElement(getLastNameLocator).getAttribute("value");
    }

//    Email:
    private String getEmailText() {
        By getEmailLocator = By.id("email");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getEmailLocator));
        System.out.println("Email is: " +driver.findElement(getEmailLocator).getAttribute("value"));
        return driver.findElement(getEmailLocator).getAttribute("value");
    }

//    Error: org.openqa.selenium.support.ui.UnexpectedTagNameException: Element should have been "select" but was "div"
//    Select can be only used on <select> tag.

    private String getDayDOB() {
        By getDaysLocator = By.cssSelector("div.form-group:nth-of-type(5)>div>div:first-of-type");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getDaysLocator));

        Select daysSelect = new Select(driver.findElement(By.id("days")));
        WebElement daysOption = daysSelect.getFirstSelectedOption();
        String days = daysOption.getText().trim();
        return days;
    }

    private String getMonthDOB() {
        By getMonthsLocator = By.cssSelector("div.form-group:nth-of-type(5)>div>div:nth-of-type(2)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getMonthsLocator));

        Select monthSelect = new Select(driver.findElement(By.id("months")));
        WebElement monthOption = monthSelect.getFirstSelectedOption();
        String months = monthOption.getText().trim();
        return months;
    }

    private String getYearDOB() {
        By getYearsLocator = By.cssSelector("div.form-group:nth-of-type(5)>div>div:last-of-type");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getYearsLocator));

        Select yearsSelect = new Select(driver.findElement(By.id("years")));
        WebElement yearOption = yearsSelect.getFirstSelectedOption();
        String years = yearOption.getText().trim();
        return years;
    }

//    Whole DOB:

    private String getDOB() {
        String dob = getDayDOB() + "/" + getMonthDOB() + "/" + getYearDOB();
        System.out.println(" =====> Date of birth is: " + dob + " <===== ");
        return dob;
    }

    public List<String> getPersonalInfo() {
        List<String> personalData = new ArrayList<>(Arrays.asList(getFirstNameText(), getLastNameText(), getEmailText(), getDOB()));
        for (String s: personalData) {
            System.out.println(s);
        }
        return personalData;
    }

//    Back to your account:

    private WebElement getBackToYourAccount(){
        By getBackToYourAccountLocator = By.xpath("(//*[@class='btn btn-default button button-small'])[2]");
        wait.until(ExpectedConditions.presenceOfElementLocated(getBackToYourAccountLocator));
        return driver.findElement(getBackToYourAccountLocator);
    }

    public MyAccountPage doClickBackToToYourAccount(){
        getBackToYourAccount().click();
        return new MyAccountPage(driver);
    }

//    Home:

    private WebElement getHome(){
        By getHomeLocator = By.xpath("(//*[@class='btn btn-default button button-small'])[3]");
        wait.until(ExpectedConditions.presenceOfElementLocated(getHomeLocator));
        return driver.findElement(getHomeLocator);
    }

    public MyStorePage doClickHome(){
        getHome().click();
        return new MyStorePage(driver);
    }
}
