package com.mystore.qa.testcases.childPagesTests;

import com.mystore.qa.basetest.BaseTest;
import com.mystore.qa.pages.MyStorePage;
import com.mystore.qa.pages.childpagesOfMyStorePage.WomenPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Locale;

public class WomenPageTest extends BaseTest{

    MyStorePage myStorePage;
    WomenPage womenPage;

    @Test
    public void validateWomenBreadcrumbTest() {
        womenPage = new WomenPage(driver);
        myStorePage = new MyStorePage(driver);

        womenPage = myStorePage.clickOnWomen();
        Assert.assertTrue(womenPage.getWomenBreadcrumb());
    }

    @Test
    public void doSortingTest() throws InterruptedException {
        womenPage = new WomenPage(driver);
        myStorePage = new MyStorePage(driver);

        womenPage = myStorePage.clickOnWomen();
        womenPage.doSorting();

        String actSortingResult = womenPage.validateFilteringText().toUpperCase(Locale.ROOT);
        String expSortingResult = "WOMEN > CATEGORIES DRESSES > SIZE L > COLOR ORANGE";

        String actList = womenPage.extractResultString();
        String expList = "Printed Dress $26.00 In stock";
        Assert.assertEquals(actSortingResult, expSortingResult);
        Assert.assertEquals(actList, expList);
    }

    @Test
    public void moveSlidersTest() throws InterruptedException {
        womenPage = new WomenPage(driver);
        myStorePage = new MyStorePage(driver);

        womenPage = myStorePage.clickOnWomen();
        womenPage.moveSlider();

        String actResult = womenPage.extractResultString();
        String expResult = "Printed Dress $26.00 In stock";
        Assert.assertEquals(actResult, expResult);

        String actOutOf = womenPage.getShowingOut();
        String expOutOf = "Showing 1 - 1 of 1 items";
        Assert.assertEquals(actOutOf, expOutOf);
    }

    @Test
    public void doSelectSortTest() throws InterruptedException {
        womenPage = new WomenPage(driver);
        myStorePage = new MyStorePage(driver);

        womenPage = myStorePage.clickOnWomen();
        womenPage.selectSort();

        String actResult = womenPage.extractSortString();
        String expResult = "Printed Chiffon Dress $16.40 $20.50 -20% In stock";
        Assert.assertEquals(actResult, expResult);
    }
}
