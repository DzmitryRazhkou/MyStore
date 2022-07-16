package com.mystore.qa.testcases;

import com.mystore.qa.basetest.BaseTest;
import com.mystore.qa.pages.LoginCreateAccountPage;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.MyAccountPage;
import com.mystore.qa.pages.MyStorePage;
import com.mystore.qa.utils.TestUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Iterator;

public class LoginPageTest extends BaseTest {
    MyStorePage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    LoginCreateAccountPage loginCreateAccountPage;

    @Test
    public void validateMyLoginPageTitle(){
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        String actMyLoginPageTitle = loginPage.getMyLoginPageTitle();
        String expMyLoginPageTitle = prop.getProperty("myLoginPageTitle");
        Assert.assertEquals(expMyLoginPageTitle, actMyLoginPageTitle);
    }

    @Test
    public void doClickSignInTest(){
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        Assert.assertTrue(loginPage.getAuthenticationBreadCrumb());
    }

    @Test
    public void validateForgotPasswordLinkTest(){
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        Assert.assertTrue(loginPage.validateForgotPasswordLink());
    }

    @Test
    public void doLoginCorrectCredentialsTest(){
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        Assert.assertTrue(myAccountPage.getMyAccountBreadCrumb());
    }

    @Test
    public void doLoginIncorrectCredentialsTest(){
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        loginPage.doLogin(prop.getProperty("wrong_email"), prop.getProperty("wrong_password"));
        Assert.assertTrue(loginPage.getErrorForm());
    }

    @DataProvider
    public Iterator<Object[]> getCreateAccountEmails() {
        ArrayList<Object[]> testData = TestUtil.getCreateAccountEmails();
        return testData.iterator();
    }

    @Test(dataProvider = "getCreateAccountEmails")
    public void doCreateAccountTest(String emailCreateAccount){
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        loginCreateAccountPage = loginPage.doCreateAccount(emailCreateAccount);
        Assert.assertTrue(loginCreateAccountPage.getAuthenticationBreadcrumb());
    }
}
