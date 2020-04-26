package com.qa.picsart.test.images;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.BaseLoginTest;

public class PicksImagesOptionsTest extends BaseLoginTest {
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
	public void testPicksImagesOptions() {
		//Test Case ID:15
		//"Given that the user is authenticated
		//when the user selects ""Explore"" link, selects one of the random images in the "PICKS" section
		//then the user can do the following actions:
		//Report Abuse
		//Repost
		//Save to Collection

		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//15.1.Click on the "Explore" link
		wait.until(ExpectedConditions.elementToBeClickable(userPage.exploreLink));
		userPage.exploreLink.click();
		
		//15.2.Click the "Picks" link
		wait.until(ExpectedConditions.elementToBeClickable(userPage.picksLink));
		userPage.picksLink.click();
		
		//15.3.Select one of the images
		wait.until(ExpectedConditions.elementToBeClickable(userPage.picksImage));
		userPage.picksImage.click();
		
		//15.4.Move the mouse to the drop-down
		wait.until(ExpectedConditions.elementToBeClickable(userPage.dropDown));
		actions.moveToElement(userPage.dropDown).build().perform();
		
		//validate that the "Report Abuse", "Repost" and "Save to Collection" options are displayed
		wait.until(ExpectedConditions.elementToBeClickable(userPage.reportAbuseOption));
		Assert.assertTrue(userPage.reportAbuseOption.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(userPage.repostOption));
		Assert.assertTrue(userPage.repostOption.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(userPage.saveToCollectionOption));
		Assert.assertTrue(userPage.saveToCollectionOption.isDisplayed());

	}


}
