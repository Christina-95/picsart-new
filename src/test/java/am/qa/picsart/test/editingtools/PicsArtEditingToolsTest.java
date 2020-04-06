package am.qa.picsart.test.editingtools;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import am.qa.picsart.pages.editingtools.PicsArtEditingToolsPage;
import am.qa.picsart.pages.editingtools.PicsArtRemoveBackgroundEditingPage;
import am.qa.picsart.pages.editingtools.PicsArtUploadSelectImagePage;
import am.qa.picsart.pages.user.PicsArtUserPage;
import am.qa.picsart.test.base.PicsArtBaseTest;

public class PicsArtEditingToolsTest extends PicsArtBaseTest{

	
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
		PicsArtEditingToolsPage toolsPage = new PicsArtEditingToolsPage(driver);
		wait.until(ExpectedConditions.visibilityOf(toolsPage.editingToolsPageTitle));
		Assert.assertTrue(toolsPage.editingToolsPageTitle.isDisplayed());
	
	}
	
}
