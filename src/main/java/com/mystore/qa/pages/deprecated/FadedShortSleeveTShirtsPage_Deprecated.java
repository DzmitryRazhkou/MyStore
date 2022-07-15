package com.mystore.qa.pages.deprecated;

import com.mystore.qa.pages.OrderPage;
import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FadedShortSleeveTShirtsPage_Deprecated {

    private WebDriver driver;
    private WebDriverWait wait;

    public FadedShortSleeveTShirtsPage_Deprecated(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_DurationOfSeconds));
    }

//    VALIDATE BREADCRUMB:

    private WebElement getFadedShortSleeveTShirt() {
        By fadedShortSleeveTShirtLocator = By.xpath("//div[@class='breadcrumb clearfix']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(fadedShortSleeveTShirtLocator));
        return driver.findElement(fadedShortSleeveTShirtLocator);
    }

    public boolean getFadedShortSleeveTShirtBreadCrumb() {
        try {
            System.out.println(" ===> Faded short sleeve t-shirts breadcrumb is displayed. <=== ");
            System.out.println(getFadedShortSleeveTShirt().getText());
            return getFadedShortSleeveTShirt().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getFadedShortSleeveTShirtPageTitle() {
        System.out.println(" =====> Faded short sleeve t-shirts page title is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

//    WRITE A REVIEW:

    private WebElement getWriteReview() {
        By writeReviewLocator = By.cssSelector("a[class='open-comment-form']");
        wait.until(ExpectedConditions.presenceOfElementLocated(writeReviewLocator));
        return driver.findElement(writeReviewLocator);
    }

    private WebElement getStarContent() {
        By starContentLocator = By.cssSelector("div.star_content>div:last-of-type");
        wait.until(ExpectedConditions.presenceOfElementLocated(starContentLocator));
        return driver.findElement(starContentLocator);
    }

    private WebElement getTitle() {
        By titleLocator = By.cssSelector("input#comment_title");
        wait.until(ExpectedConditions.presenceOfElementLocated(titleLocator));
        return driver.findElement(titleLocator);
    }

    private WebElement getContent() {
        By contentLocator = By.cssSelector("#content");
        wait.until(ExpectedConditions.presenceOfElementLocated(contentLocator));
        return driver.findElement(contentLocator);
    }

    private WebElement getSendReviewBtn() {
        By sendReviewBtnLocator = By.cssSelector("button#submitNewMessage");
        wait.until(ExpectedConditions.presenceOfElementLocated(sendReviewBtnLocator));
        return driver.findElement(sendReviewBtnLocator);
    }

    public boolean newReviewComment() {
        By newCommentLocator = By.cssSelector("div.fancybox-inner > p:nth-of-type(1)");
        wait.until(ExpectedConditions.presenceOfElementLocated(newCommentLocator));
        try {
            WebElement newComment = driver.findElement(newCommentLocator);
            newComment.isDisplayed();
            System.out.println("New comment text is: " + newComment.getText());
            return true;
        } catch (TimeoutException y) {
            System.out.println("Provide another locator");
            return false;
        }
    }

    public void doWriteReview(String title, String comment) {
        getWriteReview().click();
        getStarContent().click();
        getTitle().clear();
        getTitle().sendKeys(title);
        getContent().clear();
        getContent().sendKeys(comment);
        getSendReviewBtn().click();
    }

//    SEND TO FRIEND:

    private WebElement getSendToFriendBtn() {
        By sendToFriendBtnLocator = By.cssSelector("a#send_friend_button");
        wait.until(ExpectedConditions.presenceOfElementLocated(sendToFriendBtnLocator));
        return driver.findElement(sendToFriendBtnLocator);
    }

    private WebElement getFriendNameField() {
        By friendNameFieldLocator = By.cssSelector("input#friend_name");
        wait.until(ExpectedConditions.presenceOfElementLocated(friendNameFieldLocator));
        return driver.findElement(friendNameFieldLocator);
    }

    private WebElement getFriendEmailField() {
        By friendEmailFieldLocator = By.cssSelector("input#friend_email");
        wait.until(ExpectedConditions.presenceOfElementLocated(friendEmailFieldLocator));
        return driver.findElement(friendEmailFieldLocator);
    }

    private WebElement getSendEmailBtn() {
        By sendEmailBtnLocator = By.cssSelector("button#sendEmail");
        wait.until(ExpectedConditions.presenceOfElementLocated(sendEmailBtnLocator));
        return driver.findElement(sendEmailBtnLocator);
    }

    public boolean newEmailComment() {
        By newCommentLocator = By.cssSelector("div.fancybox-inner > p:nth-of-type(1)");
        wait.until(ExpectedConditions.presenceOfElementLocated(newCommentLocator));
        try {
            WebElement newComment = driver.findElement(newCommentLocator);
            newComment.isDisplayed();
            System.out.println("New comment text is: " + newComment.getText());
            return true;
        } catch (TimeoutException y) {
            System.out.println("Provide another locator");
            return false;
        }
    }

    public void doSendEmailFriend(String friendName, String friendEmail) {
        getSendToFriendBtn().click();
        getFriendNameField().clear();
        getFriendNameField().sendKeys(friendName);
        getFriendEmailField().clear();
        getFriendEmailField().sendKeys(friendEmail);
        getSendEmailBtn().click();
    }

//    ADD TO WISH LIST:

    public void getAddToWishBtn() {
        By addToWishBtnLocator = By.cssSelector("a#wishlist_button");
        wait.until(ExpectedConditions.presenceOfElementLocated(addToWishBtnLocator));
        driver.findElement(addToWishBtnLocator).click();
    }

    public boolean newAddToWish() {
        By newAddWishLocator = By.cssSelector("p.fancybox-error");
        wait.until(ExpectedConditions.presenceOfElementLocated(newAddWishLocator));
        try {
            WebElement newComment = driver.findElement(newAddWishLocator);
            newComment.isDisplayed();
            System.out.println("New comment text is: " + newComment.getText());
            return true;
        } catch (TimeoutException y) {
            System.out.println("Provide another locator");
            return false;
        }
    }

//    ADD TO CART:

    private WebElement getQuantity() {
        By quantityLocator = By.cssSelector("input#quantity_wanted");
        wait.until(ExpectedConditions.presenceOfElementLocated(quantityLocator));
        return driver.findElement(quantityLocator);
    }

    private WebElement getPlusBtn() {
        By plusLocator = By.cssSelector("i.icon-plus");
        wait.until(ExpectedConditions.presenceOfElementLocated(plusLocator));
        return driver.findElement(plusLocator);
    }

    private WebElement getMinusBtn() {
        By minusLocator = By.cssSelector("i.icon-minus");
        wait.until(ExpectedConditions.presenceOfElementLocated(minusLocator));
        return driver.findElement(minusLocator);
    }

    private void getSize(String index) {
        By sizeLocator = By.cssSelector("select#group_1");
        wait.until(ExpectedConditions.presenceOfElementLocated(sizeLocator));
        WebElement size = driver.findElement(sizeLocator);

        Select sel = new Select(size);
        sel.selectByIndex(Integer.parseInt(index));
    }

    private WebElement getColor() {
        By colorLocator = By.cssSelector("ul#color_to_pick_list>li:nth-of-type(1)");
        wait.until(ExpectedConditions.presenceOfElementLocated(colorLocator));
        return driver.findElement(colorLocator);
    }

    private void getAddToCartBtn() {
        By addToCartBtnLocator = By.cssSelector("p#add_to_cart");
        WebElement addToCart = driver.findElement(addToCartBtnLocator);
        Actions act = new Actions(driver);
        act.moveToElement(addToCart).click().build().perform();

        By cartLayerLocator = By.cssSelector("div#layer_cart");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartLayerLocator));
    }

    public boolean getSuccessMessage() {
        By successMessageLocator = By.cssSelector("div[class='layer_cart_product col-xs-12 col-md-6'] h2");
        wait.until(ExpectedConditions.presenceOfElementLocated(successMessageLocator));
        WebElement successMessage = driver.findElement(successMessageLocator);
        System.out.println("Success message: " + successMessage.getText());
        return successMessage.isDisplayed();
    }

//    public boolean shoppingCart(String value) {
//        By shoppingCartLocator = By.cssSelector("div.shopping_cart a>span");
//        wait.until(ExpectedConditions.presenceOfElementLocated(shoppingCartLocator));
//
//        By deleteLocator = By.cssSelector("a[title='Delete']");
//
//        List<WebElement> shoppingCartList = driver.findElements(shoppingCartLocator);
//        for (WebElement s : shoppingCartList) {
//            if (s.getText().contains("(empty)")){
//                System.out.println(s.getText());
//                return true;
//            }
//        }
//        return false;
//    }

    public WebElement getProceedToCheckOutBtn() {
        By proceedToCheckOutBtnLocator = By.cssSelector("a[title='Proceed to checkout']");
        wait.until(ExpectedConditions.presenceOfElementLocated(proceedToCheckOutBtnLocator));
        return driver.findElement(proceedToCheckOutBtnLocator);
    }

    public OrderPage proceedToOrderPage(){
        getProceedToCheckOutBtn().click();
        return new OrderPage(driver);
    }


    public void doAddToCart(String quantity, String index) {
        getQuantity().clear();
        getQuantity().sendKeys(quantity);
        getPlusBtn().click();
        getMinusBtn().click();
        getSize(index);
        getColor().click();
        getAddToCartBtn();
    }
}

