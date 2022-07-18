package com.mystore.qa.pages;

import com.mystore.qa.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

//    RETURN HOME:

    private WebElement getReturnHomeButton() {
        By returnHomeButtonLocator = By.cssSelector(".icon-home");
        wait.until(ExpectedConditions.visibilityOfElementLocated(returnHomeButtonLocator));
        return driver.findElement(returnHomeButtonLocator);
    }

//    VALIDATE AUTHENTICATION:

    private WebElement getAuthentication() {
        By authenticationLocator = By.cssSelector(".navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(authenticationLocator));
        return driver.findElement(authenticationLocator);
    }

    public boolean getAuthenticationBreadCrumb() {
        try {
            System.out.println(" ===> Authentication breadcrumb is displayed. <=== ");
            return getAuthentication().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getMyLoginPageTitle(){
        System.out.println(" =====> My login page title is: " +driver.getTitle()+ " <===== ");
        return driver.getTitle();
    }

//    ALREADY REGISTERED?

//    FORGOT YOUR PASSWORD

    private WebElement getForgotPasswordLink() {
        By getForgotPasswordLinkLocator = By.cssSelector("[title^='Recover your forgotten password']");
        wait.until(ExpectedConditions.presenceOfElementLocated(getForgotPasswordLinkLocator));
        return driver.findElement(getForgotPasswordLinkLocator);
    }

    public boolean validateForgotPasswordLink() {
        try {
            System.out.println(" ===> Forgot your password is displayed. <=== ");
            System.out.println(getForgotPasswordLink().getText());
            return getForgotPasswordLink().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    Correct Credentials:

    private WebElement getEmail() {
        By emailLocator = By.cssSelector("#email");
        wait.until(ExpectedConditions.presenceOfElementLocated(emailLocator));
        return driver.findElement(emailLocator);
    }

    private WebElement getPassword() {
        By passwordLocator = By.cssSelector("#passwd");
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordLocator));
        return driver.findElement(passwordLocator);
    }

    private WebElement getSignIn() {
        By signInBtnLocator = By.cssSelector("#SubmitLogin");
        wait.until(ExpectedConditions.presenceOfElementLocated(signInBtnLocator));
        return driver.findElement(signInBtnLocator);
    }

    public MyAccountPage doLogin(String email, String password) {
        log.info("User enters email address");
        getEmail().clear();
        getEmail().sendKeys(email);
        log.info("User enters password");
        getPassword().clear();
        getPassword().sendKeys(password);
        log.info("User clicks on the sign in button");
        getSignIn().click();
        log.info("User navigates at the my account page");
        return new MyAccountPage(driver);
    }

//    Incorrect Credentials:

    public boolean getErrorForm() {
        By errorFromLocator = By.cssSelector("#SubmitLogin");
        wait.until(ExpectedConditions.presenceOfElementLocated(errorFromLocator));
        try {
            System.out.println("=====> Error form is displayed <===== .");
            return driver.findElement(errorFromLocator).isDisplayed();
        } catch (TimeoutException y) {
            System.out.println("Provide another locator.");
            return false;
        }
    }

//    CREATE AN ACCOUNT:

    private WebElement getEmailCreateAccount() {
        By emailCreateAccountLocator = By.cssSelector("#email_create");
        wait.until(ExpectedConditions.presenceOfElementLocated(emailCreateAccountLocator));
        return driver.findElement(emailCreateAccountLocator);
    }

    private WebElement getCreateAccountBtn() {
        By signInBtnLocator = By.cssSelector("#SubmitCreate");
        wait.until(ExpectedConditions.presenceOfElementLocated(signInBtnLocator));
        return driver.findElement(signInBtnLocator);
    }

    public LoginCreateAccountPage doCreateAccount(String emailCreateAccount) {
        log.info("User enters new email address for creating a new account");
        getEmailCreateAccount().clear();
        getEmailCreateAccount().sendKeys(emailCreateAccount);
        log.info("User clicks on the create new account button");
        getCreateAccountBtn().click();
        log.info("User navigates at the my login create account page");
        return new LoginCreateAccountPage(driver);
    }
}

