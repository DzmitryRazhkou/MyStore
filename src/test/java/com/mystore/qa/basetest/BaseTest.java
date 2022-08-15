package com.mystore.qa.basetest;

import com.mystore.qa.driverfactory.DriverFactory;
import com.mystore.qa.utils.ConfigReader;
import com.mystore.qa.utils.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.Properties;

@Listeners(com.mystore.qa.listeners.Listeners.class)

public class BaseTest {

    protected ConfigReader cp;
    protected DriverFactory df;
    protected Properties prop;

    protected static WebDriver driver;

    @BeforeMethod
    public void startUp() {
        cp = new ConfigReader();
        df = new DriverFactory();
        prop = cp.initProp();
        driver = df.initDriver("chrome", prop);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.FAILURE == result.getStatus()) {
            Screenshot.takeScreenshot(driver, result.getName());
        }
        if (driver != null) {
            driver.quit();
        }
    }
}
