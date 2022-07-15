package com.mystore.qa.pages;

import com.mystore.qa.basepage.BasePage;
import com.mystore.qa.pages.childpagesOfMyStorePage.DressesPage;
import com.mystore.qa.pages.childpagesOfMyStorePage.TShirtsPage;
import com.mystore.qa.pages.childpagesOfMyStorePage.WomenPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyStorePage extends BasePage {
    public MyStorePage(WebDriver driver) {
        super(driver);
    }

//  Header Section:

//    VALIDATE LOGO:

    private WebElement logo() {
        By logoLocator = By.xpath("//*[@title='My Store']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoLocator));
        return driver.findElement(logoLocator);
    }

    public boolean getLogo() {
        try {
            System.out.println(" ===> Header logo is displayed. <=== ");
            return logo().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getMyStorePageTitle(){
        System.out.println(" =====> My store page title is: " +driver.getTitle()+ " <===== ");
        return driver.getTitle();
    }

//    CONTACT US | SIGN OUT | USER:

    private WebElement getContactUsButton() {
        By contactUsButtonLocator = By.cssSelector("[title^='Contact Us']");
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsButtonLocator));
        return driver.findElement(contactUsButtonLocator);
    }

    private WebElement getSignInButton() {
        By signInButtonLocator = By.cssSelector("[title^='Log in to your customer account']");
        wait.until(ExpectedConditions.presenceOfElementLocated(signInButtonLocator));
        return driver.findElement(signInButtonLocator);
    }

//    private WebElement getSignOutButton() {
//        By signOutButtonLocator = By.cssSelector("[title^='Log me out']");
//        wait.until(ExpectedConditions.presenceOfElementLocated(signOutButtonLocator));
//        return driver.findElement(signOutButtonLocator);
//    }
//
//    private WebElement getUserButton() {
//        By userButtonLocator = By.cssSelector("[title^='View my customer account']");
//        wait.until(ExpectedConditions.presenceOfElementLocated(userButtonLocator));
//        return driver.findElement(userButtonLocator);
//    }

//    CLICK ON THE BUTTON:

    public ContactUsPage clickContactUs() {
        getContactUsButton().click();
        return new ContactUsPage(driver);
    }

    public LoginPage clickSignIn() {
        getSignInButton().click();
        return new LoginPage(driver);
    }

//    SECTIONS:

    private String getWomenSection() {
        By womenSectionLocator = By.xpath("//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(womenSectionLocator));
        return driver.findElement(womenSectionLocator).getText();
    }

    private String getDressesSection() {
        By dressesSectionLocator = By.xpath("(//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a)[2]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dressesSectionLocator));
        return driver.findElement(dressesSectionLocator).getText();
    }

    private String getTShirtsSection() {
        By t_shirtSectionLocator = By.xpath("(//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a)[3]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(t_shirtSectionLocator));
        return driver.findElement(t_shirtSectionLocator).getText();
    }

//    Final Method:

    public List<String> getNamesOfSection() {
        List<String> listOfSection = new ArrayList<>(Arrays.asList(getWomenSection(), getDressesSection(), getTShirtsSection()));
        System.out.println("Section is included: " + listOfSection);
        return listOfSection;
    }

//    WOMEN:

    private WebElement womenButton(){
        By womenSectionLocator = By.xpath("//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(womenSectionLocator));
        return driver.findElement(womenSectionLocator);
    }

    public WomenPage clickOnWomen(){
        womenButton().click();
        return new WomenPage(driver);
    }

//    DRESSES:

    private WebElement dressesButton(){
        By dressesSectionLocator = By.xpath("(//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a)[2]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dressesSectionLocator));
        return driver.findElement(dressesSectionLocator);
    }

    public DressesPage clickOnDresses(){
        dressesButton().click();
        return new DressesPage(driver);
    }

//    T-SHIRTS:

    private WebElement t_shirtsButton(){
        By t_shirtsSectionLocator = By.xpath("(//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a)[3]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(t_shirtsSectionLocator));
        return driver.findElement(t_shirtsSectionLocator);
    }

    public TShirtsPage clickOnTShirts(){
        t_shirtsButton().click();
        return new TShirtsPage(driver);
    }

//    Header Pictures:

    public int headerPictures() {
        By headerPicsLocator = By.xpath("//*[@id='slider_row']/div/div");
        List<WebElement> list = driver.findElements(headerPicsLocator);
        int amountOfHeaderPics = list.size();
        System.out.println("Amount of header pictures are: " + list.size());
        return amountOfHeaderPics;
    }

//    Footer Pictures:

    public int footerPictures() {
        By headerPicsLocator = By.xpath("//*[@id='center_column']/div/div");
        List<WebElement> list = driver.findElements(headerPicsLocator);
        int amountOfFooterPics = list.size();
        System.out.println("Amount of footer pictures are: " + list.size());
        return amountOfFooterPics;
    }

//    Middle Box:

    public String faceBookFieldText() {
        By facebookLinkTextLocator = By.id("facebook_block");
        String facebookLinkText = driver.findElement(facebookLinkTextLocator).getText().trim();
        System.out.println("Facebook text link is: " + facebookLinkText);
        return facebookLinkText;
    }

    public List<String> middleBox() {
        By middleBoxLocator = By.cssSelector(".col-xs-6:nth-of-type(1)");
        List<WebElement> list = driver.findElements(middleBoxLocator);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("===> Amount of section in middle box: " + list.size() + " <===");
            String middleBoxSection = list.get(i).getText();
            String removeRow = middleBoxSection.replaceAll("\n", " ");
            String removeComma = removeRow.replaceAll(",", "");
            String dividedString = removeComma.replaceAll("[.]", "");

//        First Section:

            String firstCome = dividedString.split(" ")[0];
            String firstVisit = dividedString.split(" ")[1];
            String firstUs = dividedString.split(" ")[2];

            String firstWordSection = firstCome + " ";
            String firstVisitSection = firstVisit + " ";

            String resultFirst = firstWordSection + firstVisitSection + firstUs;
            System.out.println(resultFirst);

//        Second Section:

            String secondCall = dividedString.split(" ")[13];
            String secondUs = dividedString.split(" ")[14];

            String secondWordSection = secondCall + " ";
            String resultSecond = secondWordSection + secondUs;
            System.out.println(resultSecond);

//        Third Section:

            String thirdHow = dividedString.split(" ")[24];
            String thirdTo = dividedString.split(" ")[25];
            String thirdPay = dividedString.split(" ")[26];
            String thirdDues = dividedString.split(" ")[27];

            String thirdWordHow = thirdHow + " ";
            String thirdWordTo = thirdTo + " ";
            String thirdWordPay = thirdPay + " ";

            String resultThird = thirdWordHow + thirdWordTo + thirdWordPay + thirdDues;
            System.out.println(resultThird);

            List<String> stringList = new ArrayList<>(Arrays.asList(resultFirst, resultSecond, resultThird));
            return stringList;
        }
        return null;
    }

    public String rightBox() {
        By rightBoxLocator = By.cssSelector(".col-xs-6:nth-of-type(2)");
        String rightBox = driver.findElement(rightBoxLocator).getText();

        String removeRow = rightBox.replaceAll("\n", " ");
        String removeComma = removeRow.replaceAll(",", "");
        String dividedString = removeComma.replaceAll("[.]", "");

        String firstCustom = dividedString.split(" ")[0];
        String firstBlock = dividedString.split(" ")[1];

        String firstWordCustom = firstCustom + " ";
        String result = firstWordCustom + firstBlock;
        System.out.println(result);
        return result;
    }

//        LINKS:

    public String getMiddleDescription() {
        By middleSelenium = By.cssSelector("#editorial_image_legend+h1");
        String middleSeleniumText = driver.findElement(middleSelenium).getText();
        System.out.println("Text in the middle description is: " + middleSeleniumText);
        return middleSeleniumText;
    }

    public String getSeleniumArticleDescription() {
        By seleniumArticleLocator = By.cssSelector("#editorial_image_legend+h1+h2+div");
        String seleniumArticleText = driver.findElement(seleniumArticleLocator).getText();
        System.out.println("Description of website: " + "\n" + seleniumArticleText);
        return seleniumArticleText;
    }

    public List<String> getFollowUsSeleniumLinks() {
        String facebookURL = getFacebookSeleniumLink().getAttribute("href");
        String twitterURL = getTwitterSeleniumLink().getAttribute("href");
        String youTubeURL = getYouTubeSeleniumLink().getAttribute("href");
        String googleURL = getGoogleSeleniumLink().getAttribute("href");

        List<String> links = new ArrayList<>(Arrays.asList(facebookURL, twitterURL, youTubeURL, googleURL));
        for (String s : links) {
            System.out.println(s);
        }
        return links;
    }

//    FacebookLink:

    private WebElement getFacebookSeleniumLink() {
        By facebookSeleniumLinkLocator = By.cssSelector("#social_block>ul>li>a");
        return driver.findElement(facebookSeleniumLinkLocator);
    }

//    TwitterLink:

    private WebElement getTwitterSeleniumLink() {
        By twitterSeleniumLinkLocator = By.xpath(".twitter");
        return driver.findElement(twitterSeleniumLinkLocator);
    }

//    YouTubeLink:

    private WebElement getYouTubeSeleniumLink() {
        By youTubeSeleniumLinkLocator = By.cssSelector(".youtube");
        return driver.findElement(youTubeSeleniumLinkLocator);
    }

//    GoogleLink:

    private WebElement getGoogleSeleniumLink() {
        By googleSeleniumLinkLocator = By.cssSelector(".google-plus");
        return driver.findElement(googleSeleniumLinkLocator);
    }

//    FOOTER:

//    My Account:

    private WebElement getMyOrders() {
        By getMyOrdersLocator = By.cssSelector("[title^='My orders']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getMyOrdersLocator));
        return driver.findElement(getMyOrdersLocator);
    }

    private WebElement getMyCreditSlips() {
        By getMyCreditSlipsLocator = By.cssSelector("[title^='My credit slips']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getMyCreditSlipsLocator));
        return driver.findElement(getMyCreditSlipsLocator);
    }

    private WebElement getMyAddresses() {
        By getMyAddressesLocator = By.cssSelector("[title^='My addresses']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getMyAddressesLocator));
        return driver.findElement(getMyAddressesLocator);
    }

    private WebElement getMyPersonalInfo() {
        By getMyPersonalInfoLocator = By.cssSelector("[title^='Manage my personal information']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getMyPersonalInfoLocator));
        return driver.findElement(getMyPersonalInfoLocator);
    }

    public List<String> getFooterMyAccount() {

        WebElement element = driver.findElement(By.cssSelector("[title^='Manage my customer account']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);

        String getMyOrdersText = getMyOrders().getText().trim();
        String getMyCreditSlipsText = getMyCreditSlips().getText().trim();
        String getMyAddressesText = getMyAddresses().getText().trim();
        String getMyPersonalInfoText = getMyPersonalInfo().getText().trim();

        List<String> list = new ArrayList<>(Arrays.asList(getMyOrdersText, getMyCreditSlipsText, getMyAddressesText, getMyPersonalInfoText));
        list.forEach(s -> System.out.println(s));
        return list;
    }

//    Information:

    private WebElement getSpecials() {
        By getSpecialsLocator = By.cssSelector("[title^='Specials']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getSpecialsLocator));
        return driver.findElement(getSpecialsLocator);
    }

    private WebElement getNewProducts() {
        By getNewProductsLocator = By.cssSelector("[title^='New products']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getNewProductsLocator));
        return driver.findElement(getNewProductsLocator);
    }

    private WebElement getBestSellers() {
        By getBestSellersLocator = By.cssSelector("[title^='Best sellers']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getBestSellersLocator));
        return driver.findElement(getBestSellersLocator);
    }

    private WebElement getOurStores() {
        By getOurStoresLocator = By.cssSelector("[title^='Our stores']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getOurStoresLocator));
        return driver.findElement(getOurStoresLocator);
    }

    private WebElement getContactUs() {
        By getContactUsLocator = By.cssSelector("[title^='Contact us']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getContactUsLocator));
        return driver.findElement(getContactUsLocator);
    }

    private WebElement getTermsAndConditionsOfUse() {
        By getTermsAndConditionsOfUseLocator = By.cssSelector("[title^='Terms and conditions of use']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getTermsAndConditionsOfUseLocator));
        return driver.findElement(getTermsAndConditionsOfUseLocator);
    }

    private WebElement getAboutUs() {
        By getAboutUsLocator = By.cssSelector("[title^='About us']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getAboutUsLocator));
        return driver.findElement(getAboutUsLocator);
    }

    private WebElement getSitemap() {
        By getSitemapLocator = By.cssSelector("[title^='Sitemap']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getSitemapLocator));
        return driver.findElement(getSitemapLocator);
    }

    public List<String> getFooterInformation() {

        WebElement element = driver.findElement(By.cssSelector("#block_various_links_footer"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);

        String getSpecialsText = getSpecials().getText().trim();
        String getNewProductsText = getNewProducts().getText().trim();
        String getBestSellersText = getBestSellers().getText().trim();
        String getOurStoresText = getOurStores().getText().trim();
        String getContactUsText = getContactUs().getText().trim();
        String getTermsAndConditionsText = getTermsAndConditionsOfUse().getText().trim();
        String getAboutUsText = getAboutUs().getText().trim();
        String getSideMapText = getSitemap().getText().trim();

        List<String> list = new ArrayList<>(Arrays.asList(getSpecialsText, getNewProductsText, getBestSellersText, getOurStoresText,
                getContactUsText, getTermsAndConditionsText, getAboutUsText, getSideMapText));
        list.forEach(s -> System.out.println(s));
        return list;
    }

//    Store Information:

    private WebElement getGeoLocation() {
        By getGeoLocationLocator = By.cssSelector("#block_contact_infos>div>ul>li");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getGeoLocationLocator));
        return driver.findElement(getGeoLocationLocator);
    }

    private WebElement getPhone() {
        By getPhoneLocator = By.cssSelector(".icon-phone+span");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getPhoneLocator));
        return driver.findElement(getPhoneLocator);
    }

    private WebElement getEmail() {
        By getIEmailLocator = By.cssSelector(".icon-envelope-alt+span>a");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getIEmailLocator));
        return driver.findElement(getIEmailLocator);
    }

    public List<String> getStoreInfo() {

        WebElement element = driver.findElement(By.cssSelector("#block_contact_infos"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);

        String getGeoLocationTrimmedText = getGeoLocation().getText().replaceAll("\n", " ").trim();
        String getPhoneText = getPhone().getText().trim();
        String getEmailText = getEmail().getText().trim();

        List<String> listStoreInformation = new ArrayList<>(Arrays.asList(getGeoLocationTrimmedText, getPhoneText, getEmailText));
        for (String s : listStoreInformation) {
            System.out.println(s);
        }
        return listStoreInformation;
    }
}


