package com.qa.picsart.test.apps;

import com.qa.picsart.test.base.BaseLoginTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.picsart.pages.user.PicsArtUserPage;

public class GetTheAppTest extends BaseLoginTest {

	private PicsArtUserPage userPage;
	private WebDriverWait wait;

	@BeforeClass
	public void start() {
		userPage = new PicsArtUserPage(driver);
		wait = new WebDriverWait(driver, 30);
	}

	
	@Test 
	public void testGetTheAppButton() {
		//Test Case ID:13
		//Given that the user is authenticated
		//when the user selects the "Get the app" button
		//then the "Get the App for free" pop-up is displayed 
		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//13.1.Click on the "Get the app" button
		wait.until(ExpectedConditions.elementToBeClickable(userPage.getTheAppButton));
		userPage.getTheAppButton.click();
		
		//validate that the "Get the App for free" pop-up is displayed
		wait.until(ExpectedConditions.elementToBeClickable(userPage.getTheAppPopUpTitle));
		Assert.assertTrue(userPage.getTheAppPopUpTitle.isDisplayed());
	}

}
