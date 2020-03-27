package am.qa.picsart.test.apps;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import am.qa.picsart.pages.user.PicsArtUserPage;
import am.qa.picsart.test.base.PicsArtBaseTest;

public class PicsArtGetTheAppTest extends PicsArtBaseTest{
	
	@Test 
	public void testGetTheAppButton() {
		//Test Case ID:13
		//Given that the user is authenticated
		//when the user selects the "Get the app" button
		//then the "Get the App for free" pop-up is displayed 
		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//13.1.Click on the "Get the app" button
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(userPage.getTheAppButton));
		userPage.getTheAppButton.click();
		
		//validate that the "Get the App for free" pop-up is displayed
		wait.until(ExpectedConditions.elementToBeClickable(userPage.getTheAppPopUpTitle));
		Assert.assertTrue(userPage.getTheAppPopUpTitle.isDisplayed());
	}

}
