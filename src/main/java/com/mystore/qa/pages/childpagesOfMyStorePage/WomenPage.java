package com.mystore.qa.pages.childpagesOfMyStorePage;

import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WomenPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public WomenPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_DurationOfSeconds));
    }

    private WebElement womenBreadcrumb() {
        By womenBreadcrumbLocator = By.cssSelector(".navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(womenBreadcrumbLocator));
        return driver.findElement(womenBreadcrumbLocator);
    }

    public boolean getWomenBreadcrumb() {
        try {
            System.out.println(" ===> Header women breadcrumb is displayed. <=== ");
            System.out.println(womenBreadcrumb().getText());
            return womenBreadcrumb().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

    //    FILTERING:

    private WebElement getDressesCategoryCheckbox() {
        By dressCategoryCheckboxLocator = By.cssSelector("#uniform-layered_category_8");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dressCategoryCheckboxLocator));
        return driver.findElement(dressCategoryCheckboxLocator);
    }

    private WebElement getSizeCheckbox() {
        By sizeCheckboxLocator = By.cssSelector("#uniform-layered_id_attribute_group_3");
        wait.until(ExpectedConditions.visibilityOfElementLocated(sizeCheckboxLocator));
        return driver.findElement(sizeCheckboxLocator);
    }

    private WebElement getColorCheckbox() {
        By colorCheckboxLocator = By.cssSelector("#layered_id_attribute_group_13");
        wait.until(ExpectedConditions.visibilityOfElementLocated(colorCheckboxLocator));
        System.out.println("Color has been selected");
        return driver.findElement(colorCheckboxLocator);
    }

    //    METHOD:

    public void doSorting() throws InterruptedException {
        getDressesCategoryCheckbox().click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#uniform-layered_id_attribute_group_3")));
        getSizeCheckbox().click();
        getColorCheckbox().click();
        Thread.sleep(15000);
    }

//    Validate Text:

    public String validateFilteringText() {
        By validateTextLocator = By.cssSelector("span.cat-name");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.cat-name")));
        String validateSortingText = driver.findElement(validateTextLocator).getText();
        System.out.println(validateSortingText);
        return validateSortingText;
    }

    public String extractResultString() {
        List<WebElement> list = driver.findElements(By.cssSelector(".product-container"));
        for (int i = 0; i < list.size(); i++) {
            String extTemp = list.get(i).getText().replaceAll("\n", " ");
            System.out.println("Initial: " + extTemp);
            return extTemp;
        }
        return null;
    }

//  SLIDER:

    private void navigateToSlider() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 950)", "");
        System.out.println("Page has bee scrolled down");
    }

    private WebElement leftSlider() {
        By leftSliderLocator = By.xpath("(//*[@id = 'layered_price_slider']/a)[1]");
        wait.until(ExpectedConditions.presenceOfElementLocated(leftSliderLocator));
        return driver.findElement(leftSliderLocator);
    }

    private WebElement rightSlider() {
        By rightSliderLocator = By.xpath("(//*[@id = 'layered_price_slider']/a)[2]");
        wait.until(ExpectedConditions.presenceOfElementLocated(rightSliderLocator));
        return driver.findElement(rightSliderLocator);
    }

    public void moveLeftSlider() {

//        Position of slider:
        Point point = leftSlider().getLocation();
        int x_axis = point.getX();
        int y_axis = point.getY();
        System.out.println("X-axis: " + x_axis + ", Y-axis: " + y_axis);

        Actions act = new Actions(driver);
        act.dragAndDropBy(leftSlider(), 33, 0).perform();
    }

    public void moveRightSlider() {

//        Position of slider:
        Point point = rightSlider().getLocation();
        int x_axis = point.getX();
        int y_axis = point.getY();
        System.out.println("X-axis: " + x_axis + ", Y-axis: " + y_axis);

        Actions act = new Actions(driver);
        act.dragAndDropBy(rightSlider(), -175, 0).perform();
    }

    public void moveSlider() throws InterruptedException {
        navigateToSlider();
        moveLeftSlider();
        moveRightSlider();
        Thread.sleep(2000);
    }

    public String getShowingOut() {
        By showingOutLocator = By.xpath("(//*[@class='product-count'])[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(showingOutLocator));
        String showingOutResult = driver.findElement(showingOutLocator).getText();
        System.out.println("Out of: " + showingOutResult);
        return showingOutResult;
    }

    private WebElement getSortBy() {
        By sortByLocator = By.cssSelector("#selectProductSort");
        wait.until(ExpectedConditions.presenceOfElementLocated(sortByLocator));
        return driver.findElement(sortByLocator);
    }

    public void selectSort() throws InterruptedException {
        Select select = new Select(getSortBy());
        select.selectByIndex(2);
        Thread.sleep(3500);
    }

    public String extractSortString() {

        List<WebElement> list = driver.findElements(By.cssSelector(".product-container"));
        for (int i = 0; i < list.size(); i++) {
            String extTemp = list.get(i).getText().replaceAll("\n", " ");
            System.out.println("Initial: " + extTemp);
            return extTemp;
        }
        return null;
    }


//    INFORMATION:

//    #informations_block_left_1>div>ul>li
}