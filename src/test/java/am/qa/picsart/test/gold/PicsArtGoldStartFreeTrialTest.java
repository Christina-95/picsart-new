package am.qa.picsart.test.gold;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import am.qa.picsart.pages.gold.PicsArtGoldPage;
import am.qa.picsart.pages.user.PicsArtUserPage;
import am.qa.picsart.test.base.PicsArtBaseTest;

public class PicsArtGoldStartFreeTrialTest extends PicsArtBaseTest{
	
	@Test
	public void testPicsArtGoldStartFreeTrialButton() {
		//Test Case ID:18
		//Given that the user is authenticated
		//when the user selects the "PicsArt Gold", clicks the "Start Free Trial" button
		//then the "Your card won't be charged during trial period" message is displayed in the "Claim 14-Day Free Trial" page
		
		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//18.1.Click on the "Picsart Gold" link on the sidebar
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(userPage.picsartGoldLink));
		userPage.picsartGoldLink.click();
		
		//18.2.Click on the "Start Free Trial" button
		PicsArtGoldPage goldPage = new PicsArtGoldPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(goldPage.startFreeTrialButton));
		goldPage.startFreeTrialButton.click();
		
		//validate that the "Your card won't be charged during trial period" message is displayed in the "Claim 14-Day Free Trial" page
		wait.until(ExpectedConditions.elementToBeClickable(goldPage.picsartGoldTitle));
		Assert.assertTrue(goldPage.picsartGoldTitle.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(goldPage.cardInfoMessage));
		Assert.assertTrue(goldPage.cardInfoMessage.isDisplayed());
		
	}

}
