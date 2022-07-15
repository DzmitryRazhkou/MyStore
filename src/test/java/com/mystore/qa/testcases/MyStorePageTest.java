package com.mystore.qa.testcases;

import com.mystore.qa.basetest.BaseTest;
import com.mystore.qa.pages.ContactUsPage;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.MyAccountPage;
import com.mystore.qa.pages.MyStorePage;
import com.mystore.qa.pages.childpagesOfMyStorePage.WomenPage;
import com.mystore.qa.utils.ConfigReader;
import com.mystore.qa.utils.TestUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.*;

public class MyStorePageTest extends BaseTest {
    MyStorePage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    ContactUsPage contactUsPage;
    WomenPage womenPage;

    @Test
    public void validateLogoTest() {
        myStorePage = new MyStorePage(driver);
        Assert.assertTrue(myStorePage.getLogo());
    }

    @Test
    public void validateMyStorePageTitle(){
        myStorePage = new MyStorePage(driver);
        String actMyStorePageTitle = myStorePage.getMyStorePageTitle();
        String expMyStorePageTitle = prop.getProperty("myStorePageTitle");
        Assert.assertEquals(expMyStorePageTitle, actMyStorePageTitle);
    }

    @Test
    public void doClickContactUsTest(){
        myStorePage = new MyStorePage(driver);
        contactUsPage = myStorePage.clickContactUs();
        Assert.assertTrue(contactUsPage.getContactBreadCrumb());
    }

    @Test
    public void doClickSignInTest(){
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        Assert.assertTrue(loginPage.getAuthenticationBreadCrumb());
    }

    @Test
    public void doClickWomen(){
        myStorePage = new MyStorePage(driver);
        womenPage = myStorePage.clickOnWomen();
        Assert.assertTrue(womenPage.getWomenBreadcrumb());
    }

    @DataProvider
    public Iterator<Object[]> getDataSectionWomen() {
        ArrayList<Object[]> testData = TestUtil.getDataSectionWomen();
        return testData.iterator();
    }

    @Test(dataProvider = "getDataSectionWomen")
    public void validateSectionWomen(String women, String dresses, String t_shirts) {
        myStorePage = new MyStorePage(driver);
        List<String> expList = new ArrayList<>(Arrays.asList(women, dresses, t_shirts));
        List<String> actList = myStorePage.getNamesOfSection();
        Assert.assertEquals(expList, actList);
    }


    @Test
    public void validateAmountOfHeaderPicsTest() {
        myStorePage = new MyStorePage(driver);
        int expAmountOfHeader = Integer.parseInt(ConfigReader.initProp().getProperty("amountOfHeader"));
        int actAmountOfHeader = myStorePage.headerPictures();
        Assert.assertEquals(expAmountOfHeader, actAmountOfHeader);
    }

    @Test
    public void validateAmountOfFooterPicsTest() {
        myStorePage = new MyStorePage(driver);
        int expAmountOfFooter = Integer.parseInt(ConfigReader.initProp().getProperty("amountOfFooter"));
        int actAmountOfFooter = myStorePage.footerPictures();
        Assert.assertEquals(expAmountOfFooter, actAmountOfFooter);
    }

    @Test
    public void leftBoxTextTest() {
        myStorePage = new MyStorePage(driver);
        String actFacebookLinkText = myStorePage.faceBookFieldText();
        String expFacebookLinkText = ConfigReader.initProp().getProperty("facebookLinkText");
        Assert.assertEquals(expFacebookLinkText, actFacebookLinkText);
    }

    @DataProvider
    public Iterator<Object[]> getDataMiddleBoxTest() {
        ArrayList<Object[]> testData = TestUtil.getDataMiddleBoxText();
        return testData.iterator();
    }

    @Test(dataProvider = "getDataMiddleBoxTest")
    public void middleBoxTextTest(String comeVisitUs, String callUs, String howToPayDues) {
        myStorePage = new MyStorePage(driver);
        List<String> expList = new ArrayList<>(Arrays.asList(comeVisitUs, callUs, howToPayDues));
        List<String> actList = myStorePage.middleBox();
        Assert.assertNotEquals(expList, actList);
    }

    @Test
    public void rightBoxTextTest() {
        myStorePage = new MyStorePage(driver);
        String actRightBox = myStorePage.rightBox();
        String expRightBox = ConfigReader.initProp().getProperty("rightBox");
        Assert.assertEquals(actRightBox, expRightBox);
    }

    @Test
    public void middleDescriptionSeleniumTest() {
        myStorePage = new MyStorePage(driver);
        String actMiddleDescription = myStorePage.getMiddleDescription();
        String expMiddleDescription = ConfigReader.initProp().getProperty("middleDescription");
        Assert.assertEquals(actMiddleDescription, expMiddleDescription);
    }

    @Test
    public void validateDescriptionOfWebsiteTest() {
        myStorePage = new MyStorePage(driver);
        String actSeleniumArticleText = myStorePage.getSeleniumArticleDescription();
        String expSeleniumArticleText = ConfigReader.initProp().getProperty("seleniumArticleText");
        Assert.assertEquals(actSeleniumArticleText, expSeleniumArticleText);
    }

    @Test
    public void validateFollowUsSeleniumLinksTest() {
        myStorePage = new MyStorePage(driver);
        List<String> actLinksList = myStorePage.getFollowUsSeleniumLinks();
        List<String> expLinksList = new ArrayList<>(Arrays.asList("https://www.facebook.com/groups/525066904174158/", null, null, null));
        Assert.assertEquals(actLinksList, expLinksList);
    }

    @DataProvider
    public Iterator<Object[]> getFooterMyAccount() {
        ArrayList<Object[]> testData = TestUtil.getFooterMyAccount();
        return testData.iterator();
    }

    @Test(dataProvider = "getFooterMyAccount")
    public void validateFooterMyAccount(String myOrders, String myCreditSlips, String myAddresses, String myPersonalInfo){

        myStorePage = new MyStorePage(driver);
        List<String> actFooterMyAccountList = myStorePage.getFooterMyAccount();
        List<String> expFooterMyAccountList = new ArrayList<>(Arrays.asList(myOrders, myCreditSlips, myAddresses, myPersonalInfo));
        Assert.assertEquals(actFooterMyAccountList, expFooterMyAccountList);
    }

    @DataProvider
    public Iterator<Object[]> getFooterInformation() {
        ArrayList<Object[]> testData = TestUtil.getFooterInformation();
        return testData.iterator();
    }

    @Test(dataProvider = "getFooterInformation")
    public void validateFooterInformation(String specials, String newProducts, String bestSellers,
                                          String ourStores, String contactUs, String terms, String aboutUs, String siteMap){

        myStorePage = new MyStorePage(driver);
        List<String> actFooterInformationList = myStorePage.getFooterInformation();
        List<String> expFooterInformationList = new ArrayList<>(Arrays.asList(specials, newProducts, bestSellers, ourStores, contactUs, terms, aboutUs, siteMap));
        Assert.assertEquals(actFooterInformationList, expFooterInformationList);
    }

    @DataProvider
    public Iterator<Object[]> getFooterStoreInfo() {
        ArrayList<Object[]> testData = TestUtil.getFooterStoreInfo();
        return testData.iterator();
    }

    @Test(dataProvider = "getFooterStoreInfo")
    public void validateFooterStoreInfo(String geoLocation, String phone, String email){
        myStorePage = new MyStorePage(driver);
        List<String> actFooterStoreInformationList = myStorePage.getStoreInfo();
        List<String> expFooterStoreInformationList = new ArrayList<>(Arrays.asList(geoLocation, phone, email));
        Assert.assertEquals(actFooterStoreInformationList, expFooterStoreInformationList);
    }
}

