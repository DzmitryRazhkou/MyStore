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

public class LoginCreateAccountPageTest extends BaseTest {
    MyStorePage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    LoginCreateAccountPage loginCreateAccountPage;

    @Test
    public void validateMyLoginCreateAccountPageTitle(){
        String emailCreate = prop.getProperty("loginCreateAccountPage");
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        loginCreateAccountPage = loginPage.doCreateAccount(emailCreate);
        String actMyLoginPageTitle = loginPage.getMyLoginPageTitle();
        String expMyLoginPageTitle = prop.getProperty("myLoginCreateAccountPageTitle");
        Assert.assertEquals(expMyLoginPageTitle, actMyLoginPageTitle);
    }

    @DataProvider
    public Iterator<Object[]> getFillUpPersonalData() {
        ArrayList<Object[]> testData = TestUtil.fillUpPersonalData();
        return testData.iterator();
    }

    @Test(dataProvider = "getFillUpPersonalData")
    public void fillUpPersonalInfoTest(String emailCreateAccount, String firstName, String lastName, String password,
        String days, String months, String years, String company, String addressFl, String addressSl, String city,
        String state, long zip, String addInfo, long phone){

        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        loginCreateAccountPage = loginPage.doCreateAccount(emailCreateAccount);
        myAccountPage = loginCreateAccountPage.fillUpPersonalInfo(firstName, lastName, password, days, months, years,
                company, addressFl, addressSl, city, state, zip, addInfo, phone);
        Assert.assertTrue(myAccountPage.getMyAccountBreadCrumb());
    }
}
