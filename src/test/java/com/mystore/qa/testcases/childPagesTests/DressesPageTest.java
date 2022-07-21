package com.mystore.qa.testcases.childPagesTests;

import com.mystore.qa.basetest.BaseTest;
import com.mystore.qa.pages.MyStorePage;
import com.mystore.qa.pages.childpagesOfMyStorePage.DressesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DressesPageTest extends BaseTest {
    MyStorePage myStorePage;
    DressesPage dressesPage;

    @Test
    public void validateDressesBreadcrumbTest() {
        dressesPage = new DressesPage(driver);
        myStorePage = new MyStorePage(driver);
        dressesPage = myStorePage.clickOnDresses();
        Assert.assertTrue(dressesPage.getDressesBreadcrumb());
    }

    @Test
    public void doSortingTest() throws InterruptedException {
        dressesPage = new DressesPage(driver);
        myStorePage = new MyStorePage(driver);

        dressesPage = myStorePage.clickOnDresses();
        dressesPage.doSorting();

        String actSortingResult = dressesPage.validateFilteringText();
        String expSortingResult = "DRESSES > CATEGORIES SUMMER DRESSES > SIZE L > COLOR ORANGE";

        String actList = dressesPage.extractResultString().trim();
        String expList = "Printed Summer Dress $28.98 $30.51 -5% In stock";
        Assert.assertEquals(actSortingResult, expSortingResult);
        Assert.assertEquals(actList, expList);
    }

    @Test
    public void moveSlidersTest() throws InterruptedException {
        dressesPage = new DressesPage(driver);
        myStorePage = new MyStorePage(driver);

        dressesPage = myStorePage.clickOnDresses();
        dressesPage.moveSlider();

        String actResult = dressesPage.extractResultString();
        String expResult = "Printed Dress $26.00 In stock";
        Assert.assertEquals(actResult, expResult);

        String actOutOf = dressesPage.getShowingOut();
        String expOutOf = "Showing 1 - 1 of 1 items";
        Assert.assertEquals(actOutOf, expOutOf);
    }

    @Test
    public void doSelectSortTest() throws InterruptedException {
        dressesPage = new DressesPage(driver);
        myStorePage = new MyStorePage(driver);

        dressesPage = myStorePage.clickOnDresses();
        dressesPage.selectSort();

        String actResult = dressesPage.extractSortString();
        String expResult = "Printed Chiffon Dress $16.40 $20.50 -20% In stock";
        Assert.assertEquals(actResult, expResult);
    }

}
