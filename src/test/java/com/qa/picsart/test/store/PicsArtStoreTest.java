package com.qa.picsart.test.store;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.PicsArtBaseTest;

public class PicsArtStoreTest extends PicsArtBaseTest{


	@Test
	public void testPicsArtStoreLink() {
		//Tets Case ID:11
		//Given that the user is authenticated
		//when the user selects the "PicsArt Store"
		//then the user is redirected to zazzle.com/store/picsart page
		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//11.1.Click on the "PicsArt Store" link
		String zazzlePage = "https://www.zazzle.com/store/picsart";
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(userPage.picsArtStoreLink));
		userPage.clickOnPicsArtStoreLink();
		
		//validate that the zazzle.com/store/picsart page is displayed
		Assert.assertTrue(!zazzlePage.isEmpty());
	}

}
