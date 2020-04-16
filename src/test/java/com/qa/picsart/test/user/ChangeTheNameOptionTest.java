package com.qa.picsart.test.user;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.PicsArtBaseTest;

public class ChangeTheNameOptionTest extends PicsArtBaseTest{
	
	@Test
	public void testChangeNameOption() {
		//Test Case ID:19
		//Given that the user is on her/his profile page 
		//when the user selects the "Settings" option and changes her/his name in the "Name" field
		//then in the user's page the changed name is displayed

		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//19.1.Click on the user's avatar
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(userPage.userAvatar));
		userPage.clickOnUserAvatar();
		
		//19.2.Click the "Settings" option
		wait.until(ExpectedConditions.elementToBeClickable(userPage.settingsLink));
		userPage.settingsLink.click();
		
		//19.3.Change username's name in the "Name" field and click on the "Save" button
		wait.until(ExpectedConditions.elementToBeClickable(userPage.nameField));
		userPage.fillInTheNameField();
		wait.until(ExpectedConditions.elementToBeClickable(userPage.saveButton));
		userPage.saveButton.click();
		
		//19.4.Click on the username link
		wait.until(ExpectedConditions.elementToBeClickable(userPage.userAvatar));
		userPage.clickOnUserAvatar();
		wait.until(ExpectedConditions.elementToBeClickable(userPage.userNameLink));
		userPage.userNameLink.click();
		
		//validate that the changed name is displayed
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(userPage.USER_NAME)));
		Assert.assertFalse(userPage.USER_NAME.isEmpty());

	}

}
