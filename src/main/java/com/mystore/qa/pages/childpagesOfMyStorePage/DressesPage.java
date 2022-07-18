package com.mystore.qa.pages.childpagesOfMyStorePage;

import com.mystore.qa.basepage.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class DressesPage extends BasePage {
    public DressesPage(WebDriver driver) {
        super(driver);
    }

    private WebElement dressesBreadcrumb() {
        By dressesBreadcrumbLocator = By.xpath("//*[@class='breadcrumb clearfix']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dressesBreadcrumbLocator));
        return driver.findElement(dressesBreadcrumbLocator);
    }

    public boolean getDressesBreadcrumb() {
        try {
            System.out.println(" ===> Header dresses breadcrumb is displayed. <=== ");
            System.out.println(dressesBreadcrumb().getText());
            return dressesBreadcrumb().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    FILTERING:

    private WebElement getCategoryCheckbox() {
        By dressCategoryCheckboxLocator = By.cssSelector("#uniform-layered_category_11");
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
        log.info("User clicks at the category check box");
        getCategoryCheckbox().click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#uniform-layered_id_attribute_group_3")));
        log.info("User clicks at the size check box");
        getSizeCheckbox().click();
        log.info("User clicks at the color check box");
        getColorCheckbox().click();
        log.warn("Waiting for");
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
        List<WebElement> list = driver.findElements(By.cssSelector("div.product-container"));
        for (WebElement webElement : list) {
            String extTemp = webElement.getText().replaceAll("\n", " ");
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

        log.info("User gets location of the web elements");
        Point point = leftSlider().getLocation();
        int x_axis = point.getX();
        int y_axis = point.getY();
        System.out.println("X-axis: " + x_axis + ", Y-axis: " + y_axis);

        Actions act = new Actions(driver);
        act.dragAndDropBy(leftSlider(), 33, 0).perform();
    }

    public void moveRightSlider() {

//        Position of slider:
        log.info("User gets location of the web elements");
        Point point = rightSlider().getLocation();
        int x_axis = point.getX();
        int y_axis = point.getY();
        System.out.println("X-axis: " + x_axis + ", Y-axis: " + y_axis);

        Actions act = new Actions(driver);
        act.dragAndDropBy(rightSlider(), -175, 0).perform();
    }

    public void moveSlider() throws InterruptedException {
        log.warn("User navigates to an element");
        navigateToSlider();
        log.warn("User moves a slider to the left");
        moveLeftSlider();
        log.warn("User moves a slider to the right");
        moveRightSlider();
        log.warn("Waiting for...");
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
        log.warn("User selects a sorting button");
        Thread.sleep(3500);
    }

    public String extractSortString() {

        List<WebElement> list = driver.findElements(By.cssSelector(".product-container"));
        for (WebElement webElement : list) {
            String extTemp = webElement.getText().replaceAll("\n", " ");
            System.out.println("Initial: " + extTemp);
            return extTemp;
        }
        return null;
    }
}
