package com.mystore.qa.driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;


import java.util.Properties;

public class DriverFactory {

    public WebDriver driver;

    public WebDriver initDriver(String browserName, Properties prop) {
        System.out.println("Browser name is " + browserName);

        switch (browserName.toLowerCase()) {
            case "chrome":
                driver = WebDriverManager.chromedriver().create();
                break;

            case "firefox":
                driver = WebDriverManager.firefoxdriver().create();
                break;

            case "safari":
                driver = WebDriverManager.safaridriver().create();
                break;

            default:
                System.out.println("Pass the right browser name ..... ");
                break;
        }

        driver.get(prop.getProperty("url"));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        return driver;
    }
}


