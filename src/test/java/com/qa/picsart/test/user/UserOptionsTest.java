package com.qa.picsart.test.user;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.BaseLoginTest;

public class UserOptionsTest extends BaseLoginTest {
	
	@Test
	public void testUserOptions() {
		//Test Case ID:16
		//Given that the user is authenticated
		//when the user clicks on the user's avatar
		//then the username, "Find Friends", "Settings" and "Log Out" links are displayed
		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//14.1.Click on the user avatar
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(userPage.userAvatar));
		userPage.clickOnUserAvatar();
		
		//validate that the username link, "Find Friends", "Settings" and "Log Out" links are displayed
		wait.until(ExpectedConditions.elementToBeClickable(userPage.userNameLink));
		Assert.assertTrue(userPage.userNameLink.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(userPage.findFriendsLink));
		Assert.assertTrue(userPage.findFriendsLink.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(userPage.settingsLink));
		Assert.assertTrue(userPage.settingsLink.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(userPage.logOutLink));
		Assert.assertTrue(userPage.logOutLink.isDisplayed());
		
	}


}
