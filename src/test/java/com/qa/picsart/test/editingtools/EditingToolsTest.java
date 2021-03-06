package com.qa.picsart.test.editingtools;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.picsart.pages.editingtools.EditingToolsPage;
import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.BaseLoginTest;

public class EditingToolsTest extends BaseLoginTest {

	
	@Test
	public void testEditingTools() {
		//Test Case ID:5
		//Given that the user is authenticated
		//when the user clicks the "Start Editing" button
		//then the "Editing Tools" page are displayed
		
		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//5.1.Click the "Start Editing" button
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(userPage.startEditingButton));
		userPage.startEditingButton.click();
		
		//validate that the Editing Tools page is displayed
		EditingToolsPage toolsPage = new EditingToolsPage(driver);
		wait.until(ExpectedConditions.visibilityOf(toolsPage.editingToolsPageTitle));
		Assert.assertTrue(toolsPage.editingToolsPageTitle.isDisplayed());
	
	}
	
}
