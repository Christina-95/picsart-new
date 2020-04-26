package com.qa.picsart.test.support;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.picsart.pages.support.PicsArtSupportPage;
import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.BaseLoginTest;

public class PicsArtSupportTest extends BaseLoginTest {
	private PicsArtUserPage userPage;
	private WebDriverWait wait;
	private PicsArtSupportPage supportPage;


	@BeforeClass
	public void start() {
		userPage = new PicsArtUserPage(driver);
		wait = new WebDriverWait(driver, 30);
		supportPage = new PicsArtSupportPage(driver);
	}
	
	@Test
	public void testSupportPageLanguage() throws InterruptedException {
		//Test Case ID:12
		//Given that the user is authenticated
		//when the user selects the "Support" and redirects to "PicsArt Support" page
		//then the user can change the language of the page
		
		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//12.1.Click on the "Support" link
		wait.until(ExpectedConditions.elementToBeClickable(userPage.supportLink));
		userPage.clickOnSupportLink();
		
		//12.2.Click on "English" link
		wait.until(ExpectedConditions.elementToBeClickable(supportPage.englishLink));
		supportPage.clickOnEnglishLink();
		
		//12.3.Select other language
		Thread.sleep(1000);
		supportPage.clickOnRussianLink();

		//validate that the page's language has changed
		Thread.sleep(1000);
		Assert.assertTrue(!supportPage.PAGE_TITLE_RUSSIAN.isEmpty());

	}

}
