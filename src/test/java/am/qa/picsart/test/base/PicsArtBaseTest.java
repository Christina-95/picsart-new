package am.qa.picsart.test.base;



import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import am.qa.picsart.pages.base.PicsArtBasePage;
import am.qa.picsart.pages.login.PicsArtLoginPage;
import am.qa.picsart.pages.user.PicsArtUserPage;


public class PicsArtBaseTest {
	
		protected static final String HOME_PAGE_URL = "https://picsart.com";
		protected Properties properties;
		protected WebDriver driver; 
	
		
		@BeforeTest()
		public void prepareEnv() throws IOException, InterruptedException {
			properties = new Properties();
			properties.load(getClass().getClassLoader().getResourceAsStream("readProperty.properties"));
			System.setProperty("webdriver.chrome.driver", properties.getProperty("chromeDriver"));
			driver = new ChromeDriver();
			driver.get(HOME_PAGE_URL);
			//driver.manage().window().maximize();
			PicsArtBasePage page = new PicsArtBasePage(driver);
			page.clicOnPopUp();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(page.loginButton));
	        page.clickOnLoginButton();
	        PicsArtLoginPage loginPage = new PicsArtLoginPage(driver);
	        loginPage.signIn();
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


	   