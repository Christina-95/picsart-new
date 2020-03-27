package am.qa.picsart.test.apps;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import am.qa.picsart.pages.gettheapp.PicsArtGetTheAppPage;
import am.qa.picsart.pages.user.PicsArtUserPage;
import am.qa.picsart.test.base.PicsArtBaseTest;

public class PicsArtAppsLinkTest extends PicsArtBaseTest{
	
	@Test 
	public void testAppsLink() {
		//Test Case ID:17
		//Given that the user is authenticated
		//when the user clicks on the "About", clicks on the "Apps", clicks on the "Get It Now" button in the PicsArt Apps page
		//then the "Get the App for free" page is displayed
		
		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//17.1.Click on "About" link in the sidebar
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(userPage.aboutLink));
		userPage.aboutLink.click();
		
		//17.2.Click on the "Apps" link
		wait.until(ExpectedConditions.elementToBeClickable(userPage.appsLink));
		userPage.appsLink.click();
		
		//17.3.Click on the "Get It Now" button
		PicsArtGetTheAppPage getTheAppPage = new PicsArtGetTheAppPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(getTheAppPage.getItNowButton));
		getTheAppPage.getItNowButton.click();
		
		//validate that the "Get the App for free" pop-up is displayed
		wait.until(ExpectedConditions.elementToBeClickable(getTheAppPage.getTheAppPopUpTitle));
		Assert.assertTrue(getTheAppPage.getTheAppPopUpTitle.isDisplayed());
		
		//additional step
		driver.get(HOME_PAGE_URL);
		
	}


}
