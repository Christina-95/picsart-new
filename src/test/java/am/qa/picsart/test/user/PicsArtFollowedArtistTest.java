package am.qa.picsart.test.user;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import am.qa.picsart.pages.artists.PicsArtArtistsPage;
import am.qa.picsart.pages.user.PicsArtUserPage;
import am.qa.picsart.test.base.PicsArtBaseTest;

public class PicsArtFollowedArtistTest extends PicsArtBaseTest{
	
	@Test 
	public void testFollowedArtistIsDisplayed() throws InterruptedException {
		//Test Case ID:20
		//Given that the user is authenticated
		//when the user searches for an artist, clicks on the artist's username, clicks "Follow" button
		//then the followed artist is displayed in the user's "Following" section
		
		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//20.1.Enter any artist name in the "Search" field and click Enter
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(userPage.searchField));
		userPage.fillInTheSearchField();
		userPage.searchField.submit();
		
		//20.2.Click on the "Artists"
		wait.until(ExpectedConditions.elementToBeClickable(userPage.artistsLink));
		userPage.artistsLink.click();
		
		//20.3.Click on the prefered artist username
		PicsArtArtistsPage artistPage = new PicsArtArtistsPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(artistPage.animeUserLink));
		artistPage.animeUserLink.click();
		
		//20.4.Click on the "Follow" button
		wait.until(ExpectedConditions.elementToBeClickable(artistPage.followingButton));
		artistPage.followingButton.click();
		Thread.sleep(2000);
		artistPage.followButton.click();
		
		//20.5.Click on the user avatar and on the username link
		wait.until(ExpectedConditions.elementToBeClickable(userPage.userAvatar));
		userPage.userAvatar.click();
		wait.until(ExpectedConditions.elementToBeClickable(userPage.userNameLink));
		userPage.userNameLink.click();
		
		//20.6.Click on the "Following"  
		wait.until(ExpectedConditions.elementToBeClickable(userPage.followingLink));
		userPage.followingLink.click();
		
		//validate that the followed artist is displayed
		wait.until(ExpectedConditions.elementToBeClickable(artistPage.animeUserLink));
		Assert.assertTrue(artistPage.animeUserLink.isDisplayed());

	}


}
