package com.qa.picsart.test.images;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.PicsArtBaseTest;

public class PicsArtImageOptionsTest extends PicsArtBaseTest{
	private PicsArtUserPage userPage;
	private WebDriverWait wait;
	private Actions actions;

	@BeforeClass
	public void start() {
		userPage = new PicsArtUserPage(driver);
		wait = new WebDriverWait(driver, 30);
		actions= new Actions(driver);
	}
	
	
	@Test 
	public void testImageOptions() {
		//Test Case ID:14
		//"Given that the user is authenticated
		//when the user move mouse to one of the uploaded images
		//then the user can do the following options:
		//Share
		//Like and comment
		//Save to Collection"
		
		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//14.1.Click on the user avatar
		wait.until(ExpectedConditions.elementToBeClickable(userPage.userAvatar));
		userPage.clickOnUserAvatar();
		
		//14.2.Click on the username link
		wait.until(ExpectedConditions.elementToBeClickable(userPage.userNameLink));
		userPage.clickOnUserNameLink();
		
		//14.3.Move the mouse to one of the posted images
		wait.until(ExpectedConditions.elementToBeClickable(userPage.lastPostedImage));
		actions.moveToElement(userPage.lastPostedImage).build().perform();
		
		//validate that the  "Share", "Like and comment" and "Save to Collection" options are displayed
		wait.until(ExpectedConditions.elementToBeClickable(userPage.share));
		Assert.assertTrue(userPage.share.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(userPage.likeAndComment));
		Assert.assertTrue(userPage.likeAndComment.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(userPage.saveToCollection));
		Assert.assertTrue(userPage.saveToCollection.isDisplayed());
	
	}

}
