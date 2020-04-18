package com.qa.picsart.test.base;



import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.picsart.pages.base.PicsArtBasePage;
import com.qa.picsart.pages.login.LoginPage;
import com.qa.picsart.pages.user.PicsArtUserPage;


public class PicsArtBaseTest {
	
	protected static final String HOME_PAGE_URL = "https://picsart.com";
	protected Properties properties;
	protected WebDriver driver; 
	
		
	@BeforeTest()
	public void prepareEnv() throws IOException {
	properties = new Properties();
	properties.load(getClass().getClassLoader().getResourceAsStream("readProperty.properties"));
	System.setProperty("webdriver.chrome.driver", properties.getProperty("chromeDriver"));
	driver = new ChromeDriver();
	driver.get(HOME_PAGE_URL);
	driver.manage().window().maximize();
	
	
	PicsArtBasePage page = new PicsArtBasePage(driver);
	WebDriverWait wait = new WebDriverWait(driver, 30);
//	wait.until(ExpectedConditions.visibilityOf(page.closePopUp));
//	page.moveToClosePopUp();
//	//close the Pop-up
//	page.closePopUp.click();
	
	//click on the "Log In" button
	wait.until(ExpectedConditions.visibilityOf(page.loginButton));
	page.loginButton.click();
	
	//Fill in the username and password fields
	LoginPage loginPage = new LoginPage(driver);
	wait.until(ExpectedConditions.visibilityOf(loginPage.usernameOrEmailField));
	loginPage.usernameOrEmailField.click();
	loginPage.usernameOrEmailField.sendKeys("XXX@gmail.com");
	wait.until(ExpectedConditions.visibilityOf(loginPage.passwordField));
	loginPage.passwordField.click();
	loginPage.passwordField.sendKeys("12345678");
	
	//click on the "Sign In " button
	wait.until(ExpectedConditions.visibilityOf(loginPage.signInButton));
	loginPage.signInButton.click();
	
	//validate that the user is logged in
	PicsArtUserPage userPage = new PicsArtUserPage(driver);
	userPage.validateLoggedInUser();
			
	}
		
		
//		@AfterTest
//		public void quit() {
//			PicsArtUserPage userPage = new PicsArtUserPage(driver);
//			WebDriverWait wait = new WebDriverWait(driver, 30);
//			wait.until(ExpectedConditions.visibilityOf(userPage.userAvatar));
//			userPage.userAvatar.click();
//			wait.until(ExpectedConditions.visibilityOf(userPage.logOutLink));
//			userPage.logOutLink.click();
//			driver.quit();
//		}
		
		@AfterTest
		public void quitChrome() {
			driver.quit();
		}
		
}


	   