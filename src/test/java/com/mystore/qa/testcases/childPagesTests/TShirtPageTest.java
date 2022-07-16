package com.mystore.qa.testcases.childPagesTests;

import com.mystore.qa.basetest.BaseTest;
import com.mystore.qa.pages.MyStorePage;
import com.mystore.qa.pages.childpagesOfMyStorePage.TShirtsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TShirtPageTest extends BaseTest {
    MyStorePage myStorePage;
    TShirtsPage tShirtsPage;

    @Test
    public void validateTShirtsBreadcrumbTest() {
        tShirtsPage = new TShirtsPage(driver);
        myStorePage = new MyStorePage(driver);

        tShirtsPage = myStorePage.clickOnTShirts();
        Assert.assertTrue(tShirtsPage.getT_shirtBreadcrumb());
    }

    @Test
    public void doSortingTest() throws InterruptedException {
        tShirtsPage = new TShirtsPage(driver);
        myStorePage = new MyStorePage(driver);

        tShirtsPage = myStorePage.clickOnTShirts();
        tShirtsPage.doSorting();

        String actSortingResult = tShirtsPage.validateFilteringText();
        String expSortingResult = "T-SHIRTS > SIZE L > COLOR ORANGE";

        String actList = tShirtsPage.extractResultString().trim();
        String expList = "Faded Short Sleeve T-shirts $16.51 In stock";
        Assert.assertEquals(actSortingResult, expSortingResult);
        Assert.assertEquals(actList, expList);
    }

    @Test
    public void moveSlidersTest() throws InterruptedException {
        tShirtsPage = new TShirtsPage(driver);
        myStorePage = new MyStorePage(driver);

        tShirtsPage = myStorePage.clickOnTShirts();
        tShirtsPage.moveSlider();

        String actResult = tShirtsPage.extractResultString();
        String expResult = "Faded Short Sleeve T-shirts $16.51 In stock";
        Assert.assertEquals(actResult, expResult);

        String actOutOf = tShirtsPage.getShowingOut();
        String expOutOf = "Showing 1 - 1 of 1 item";
        Assert.assertEquals(actOutOf, expOutOf);
    }

    @Test
    public void doSelectSortTest() throws InterruptedException {
        tShirtsPage = new TShirtsPage(driver);
        myStorePage = new MyStorePage(driver);

        tShirtsPage = myStorePage.clickOnTShirts();
        tShirtsPage.selectSort();

        String actResult = tShirtsPage.extractSortString();
        String expResult = "Faded Short Sleeve T-shirts $16.51 In stock";
        Assert.assertEquals(actResult, expResult);
    }
}
