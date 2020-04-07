package am.qa.picsart.test.user;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import am.qa.picsart.pages.user.PicsArtUserPage;
import am.qa.picsart.test.base.PicsArtBaseTest;

public class SaveToCollectionTest extends PicsArtBaseTest{
	@Test
	public void testSaveToCollectionOption() {
		//Test Case ID:10
		//Given that the user is on her/his profile page 
		//when the user selects any of her/his posted images and Click on the"Save to Collection"
		//then the user can save the image in the newly created collection
		
		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//10.1.Click on the user avatar beside "Get the app" button
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		userPage.clickOnUserAvatar();
		
		//10.2.Click on the username link
		userPage.clickOnUserNameLink();
		
		//10.3.Click on the last posted image
		userPage.clickOnLastPostedImage();
		
		//10.4.Move to Drop-down
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(userPage.dropDown));
		Actions actions= new Actions(driver);
		actions.moveToElement(userPage.dropDown).build().perform();
		
		//10.5.Click on the"Save to Collection" option
		wait.until(ExpectedConditions.visibilityOf(userPage.saveToCollectionOption));
		userPage.clickOnSaveToCollectionOption();
		
		//10.6.Select the "Create Collection" option
		wait.until(ExpectedConditions.visibilityOf(userPage.createCollectionOption));
		userPage.selectCreateCollectionOption();
		
		//10.7.Fill in the "Collection Name" field
		wait.until(ExpectedConditions.visibilityOf(userPage.collectionNameField));
		userPage.fillInTheCollectionNameField();
		
		//10.8.Click on the "Create" button
		wait.until(ExpectedConditions.visibilityOf(userPage.createButton));
		userPage.clickOnCreateButton();
		
		//validate that the collection was saved
		driver.get("https://picsart.com/u/tinat6043/collections");
		Assert.assertFalse(userPage.LAST_CREATED_COLLECTION.isEmpty());
	
	}

}
