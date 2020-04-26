package com.qa.picsart.test.user;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.BaseLoginTest;

public class UserPostsTests extends BaseLoginTest {
	
	@Test
	public void testUserPosts() {
		//Test Case ID:8
		//Given that the user is authenticated
		//when the user goes to her/his profile page
		//then the posted images are displayed

		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//8.1.Click on the user avatar beside "Get the app" button
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		userPage.clickOnUserAvatar();
		
		//8.2.Click on the username link
		userPage.clickOnUserNameLink();
		
		//validate that the "Posts" are displayed
		Assert.assertTrue(userPage.postsLink.isDisplayed());
	}
	

	@Test
	public void testPostedImageOptions() {
		//Test Case ID:9
		//"Given that the user is on her/his profile page 
		//when the user selects any of her/his posted images
		//then the user allowed to do the following actions:
		//Edit
		//Delete
		//Save to Collection

		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//9.1.Click on the user avatar beside "Get the app" button
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		userPage.clickOnUserAvatar();
		
		//9.2.Click on the username link
		userPage.clickOnUserNameLink();
		
		//9.3.Click on the last posted image
		userPage.clickOnLastPostedImage();
		
		//9.4.Move to Drop-down
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(userPage.dropDown));
		Actions actions= new Actions(driver);
		actions.moveToElement(userPage.dropDown).build().perform();
		
		//validate that the "Edit" option is displayed
		Assert.assertTrue(userPage.editOption.isDisplayed());
		
		//validate that the "Delete" option is displayed
		Assert.assertTrue(userPage.deleteOption.isDisplayed());
		
		//validate that the "save to Collection" option is displayed
		Assert.assertTrue(userPage.saveToCollectionOption.isDisplayed());
	}

}
