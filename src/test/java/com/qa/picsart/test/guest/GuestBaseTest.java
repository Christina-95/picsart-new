package com.qa.picsart.test.guest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Properties;

public class GuestBaseTest {
    protected static final String HOME_PAGE_URL = "https://picsart.com";
    protected Properties properties;
    protected WebDriver driver;


    @BeforeTest()
    public void prepare() throws IOException {
        properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream("readProperty.properties"));
        System.setProperty("webdriver.chrome.driver", properties.getProperty("chromeDriver"));
        driver = new ChromeDriver();
        driver.get(HOME_PAGE_URL);
        driver.manage().window().maximize();
    }


    @AfterTest
    public void quitChrome() {
        driver.quit();
    }

}
