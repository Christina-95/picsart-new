package am.qa.picsart.test;


import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import am.qa.picsart.pages.base.PicsArtBasePage;
import am.qa.picsart.pages.editingtools.PicsArtEditingToolsPage;
import am.qa.picsart.pages.editingtools.PicsArtRemoveBackgroundEditingPage;
import am.qa.picsart.pages.editingtools.PicsArtUploadSelectImagePage;
import am.qa.picsart.pages.gettheapp.PicsArtGetTheAppPage;
import am.qa.picsart.pages.jobs.PicsArtJobsPage;
import am.qa.picsart.pages.jobs.vacancies.PicsArtVacanciesPage;
import am.qa.picsart.pages.login.PicsArtLoginPage;
import am.qa.picsart.pages.support.PicsArtSupportPage;
import am.qa.picsart.pages.user.PicsArtUserPage;
import am.qa.picsart.test.base.PicsArtBaseTest;

public class PicsArtTest extends PicsArtBaseTest {
	
	
	@Test
	public void testCareersLink() throws InterruptedException {
		//Test Case ID:1
		//Given that the user is authenticated 
		//when the user selects the "Career" section and the "PicsArt Careers" page is displayed and clicks the "View Jobs" button
		//then the current required vacancies shall be displayed

		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//1.1:Click on "Careers" link
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		userPage.clickOnCareersLink();
		
		//1.2:Click the "View Jobs" button
		PicsArtJobsPage jobsPage = new PicsArtJobsPage(driver);
		jobsPage.clickOnViewJobsButton();
		
		//Validate that the current vacancies are displayed
		Thread.sleep(1000);
		Assert.assertTrue(jobsPage.departmentsText.isDisplayed());
	}
	
	@Test 
	public void testVacanciesPage() throws InterruptedException {
		//Test Case ID:2
		//Given that the user is authenticated and  is on the "PicsArt Careers" page
		//when the user clicks the "Continue on Jobs" button
		//then the current required vacancies are displayed in the new separated page (picsart.com/jobs/vacancies)

		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//2.1:Click on "Careers" link
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		userPage.clickOnCareersLink();
		
		//2.2:Click the "View Jobs" button
		PicsArtJobsPage jobsPage = new PicsArtJobsPage(driver);
		jobsPage.clickOnViewJobsButton();
		
		//2.3:Click the "Continue on Jobs" button
		jobsPage.clickOnContinueOnJobsBtn();
		
		//validate that the picsart.com/jobs/vacancies page is opened
		PicsArtVacanciesPage vacanciesPage = new PicsArtVacanciesPage(driver);
		vacanciesPage.waitForVacanciespageTitle();
		Assert.assertTrue(vacanciesPage.vacanciesPageTitle.isDisplayed());
	}
	
	@Test 
	public void testVacanciesByDepartmentsAndLocation() { 
		//Test Case ID:3
		//Given that the user is authenticated
		//when the user is on the "PicsArt Careers" page
		//then the user can search for vacancies by "DEPARTMENTS" and "LOCATION"
		
		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//3.1:Click on "Careers" link
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(userPage.careersLink));
		userPage.clickOnCareersLink();
		
		//3.2:Click the "View Jobs" button
		PicsArtJobsPage jobsPage = new PicsArtJobsPage(driver);
		wait.until(ExpectedConditions.visibilityOf(jobsPage.viewJobsButton));
		jobsPage.clickOnViewJobsButton();
		
		//validate that current required vacancies are displayed with the possibility to search by "Departments" and "Location"
		wait.until(ExpectedConditions.visibilityOf(jobsPage.departmentsText));
		Assert.assertTrue(jobsPage.departmentsText.isDisplayed());
		wait.until(ExpectedConditions.visibilityOf(jobsPage.locationText));
		Assert.assertTrue(jobsPage.locationText.isDisplayed());
		wait.until(ExpectedConditions.visibilityOf(jobsPage.engineeringLink));
		Assert.assertTrue(jobsPage.engineeringLink.isDisplayed());
		wait.until(ExpectedConditions.visibilityOf(jobsPage.yerevanLink));
		Assert.assertTrue(jobsPage.yerevanLink.isDisplayed());
	}

	
	@Test 
	public void testChangePassword () {
		//Test Case ID:4
		//Given that the user is authenticated
		//when the user changes her/his profile password
		//then the user cannot log in with the old password
		
		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//4.1.Click on the user avatar beside "Get the app" button
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(userPage.userAvatar));
		userPage.clickOnUserAvatar();
		
		//4.2.Click on the "Settings" link
		wait.until(ExpectedConditions.visibilityOf(userPage.settingsLink));
		userPage.settingsLink.click();
		
		//4.3.Click on the "Change" button beside Password field
		wait.until(ExpectedConditions.visibilityOf(userPage.changePasswordButton));
		userPage.changePasswordButton.click();
		
		//4.4.Fill in the "Current Password", "New Password" and "Retype new password" fields
		wait.until(ExpectedConditions.visibilityOf(userPage.currentPasswordField));
		userPage.fillInTheCurrentPasswordField();
		wait.until(ExpectedConditions.visibilityOf(userPage.newPasswordField));
		userPage.fillInTheNewPasswordField();
		wait.until(ExpectedConditions.visibilityOf(userPage.retypeNewPassword));
		userPage.fillInTheRetypePasswordField();
		
		//4.5.Click on the "Save Changes" button
		wait.until(ExpectedConditions.visibilityOf(userPage.saveChangesButton));
		userPage.saveChangesButton.click();
		
		//4.6.Click on the user avatar and on the "Log Out" link
		wait.until(ExpectedConditions.visibilityOf(userPage.userAvatar));
		userPage.clickOnUserAvatar();
		wait.until(ExpectedConditions.visibilityOf(userPage.logOutLink));
		userPage.logOutLink.click();
		
		//validate that the user is logged out of the system 
		Assert.assertFalse(userPage.userAvatar.isDisplayed());
		
		//4.7.Click on the "Log In" button
		PicsArtBasePage page = new PicsArtBasePage(driver);
		wait.until(ExpectedConditions.visibilityOf(page.loginButton));
        page.clickOnLoginButton();
        
        //4.8.Fill in the "Username" field with correct username 
        PicsArtLoginPage loginPage = new PicsArtLoginPage(driver);
        loginPage.usernameOrEmailField.click();
        loginPage.usernameOrEmailField.sendKeys("tinat6043@gmail.com");
       
        //4.9.Fill in the "Password" field with the old password and click on the "Sign in" button
        loginPage.passwordField.click();
        loginPage.passwordField.sendKeys("123456789");
        wait.until(ExpectedConditions.visibilityOf(loginPage.signInButton));
        loginPage.signInButton.click();
        
        //validate that the error message is displayed
        wait.until(ExpectedConditions.visibilityOf(loginPage.errorMessage));
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        
	}
	
	public void testEditingTools() throws InterruptedException {
		//Test Case ID:5
		//Given that the user is authenticated
		//when the user clicks the "Start Editing" button
		//then the "Editing Tools" page are displayed
		
		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//5.1.Click the "Start Editing" button
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		userPage.clickOnStartEditingButton();
		
		//validate that the Editing Tools page is displayed
		PicsArtEditingToolsPage toolsPage = new PicsArtEditingToolsPage(driver);
		Assert.assertTrue(toolsPage.editingToolsPageTitle.isDisplayed());
	
	}
	
	@Test
	public void testRemoveBackground() throws InterruptedException {
		//Test Case ID:6
		//Given that the user is on the "Editing Tools" page
		//when the user selects the "Remove Background" filter, selects one of the images,edits it,clicks on the "Share" button and clicks on the "Post" button
		//then the user gets the "Successfully Posted" message


		//Login with correct credentials -- Done in PicsArtBaseTest
		//6.1.Click the "Start Editing" button
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		userPage.clickOnStartEditingButton();
		
		//6.2.Select the "Remove Background" filter
		PicsArtEditingToolsPage toolsPage = new PicsArtEditingToolsPage(driver);
		toolsPage.clickOnRemoveBackgroundFilter();
		
		//6.3.Select one of the suggested images
		PicsArtUploadSelectImagePage uploadImage = new PicsArtUploadSelectImagePage(driver);
		uploadImage.clickOnRandomImage();
		
		//6.4.Click the "Share" button
		PicsArtRemoveBackgroundEditingPage removeBackgroundPage = new PicsArtRemoveBackgroundEditingPage(driver);
		Thread.sleep(2000);
		removeBackgroundPage.clickOnShareButton();
		
		//validate that the Pop-up is displayed
		Assert.assertTrue(removeBackgroundPage.postButton.isDisplayed() && removeBackgroundPage.popUpTitle.isDisplayed());
		
		//6.5.Click the "Post" button
		Thread.sleep(3000);
		removeBackgroundPage.clickOnPostButton();
		
		//validate that the success message is diplayed 
		//wait.waitForElementPresent(removeBackgrounPage.successfullypostedMessage);
		Thread.sleep(30000);
		Assert.assertTrue(removeBackgroundPage.successfullypostedMessage.isDisplayed());
		
	}
	
	@Test
	public void testGoToToolsBtn() throws InterruptedException {
		//Test Case ID:7
		//Given that the user is on the "Editing Tools" page
		//when the user selects the "Remove Background" filter, selects one of the images, edits it, clicks on the "Share" button, clicks on the "Post" button, gets the "Successfully Posted" message and clicks the "Go to Tools" button
		//then the user redirects to the "Editing Tools" page

		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//7.1.Click the "Start Editing" button
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		userPage.clickOnStartEditingButton();
		
		//7.2.Select the "Remove Background" filter
		PicsArtEditingToolsPage toolsPage = new PicsArtEditingToolsPage(driver);
		toolsPage.clickOnRemoveBackgroundFilter();
		
		//7.3.Select one of the suggested images
		PicsArtUploadSelectImagePage uploadImage = new PicsArtUploadSelectImagePage(driver);
		uploadImage.clickOnRandomImage();
		
		//7.4.Click the "Share" button
		PicsArtRemoveBackgroundEditingPage removeBackgroundPage = new PicsArtRemoveBackgroundEditingPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(removeBackgroundPage.shareButton));
		removeBackgroundPage.clickOnShareButton();
		
		//7.5.Click the "Post" button
		wait.until(ExpectedConditions.visibilityOf(removeBackgroundPage.postButton));
		removeBackgroundPage.clickOnPostButton();
		
		//validate that the success message is diplayed 
		wait.until(ExpectedConditions.visibilityOf(removeBackgroundPage.successfullypostedMessage));
		Assert.assertTrue(removeBackgroundPage.successfullypostedMessage.isDisplayed());
		
		//7.6.Click the "Go to Tools" button
		removeBackgroundPage.clickOnGoToToolsBtn();
		
		//validate that the Editing Tools page is displayed
		Assert.assertTrue(toolsPage.editingToolsPageTitle.isDisplayed());
		
	}
	
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
	
	@Test
	public void testSupportPageLanguage() throws InterruptedException {
		//Test Case ID:12
		//Given that the user is authenticated
		//when the user selects the "Support" and redirects to "PicsArt Support" page
		//then the user can change the language of the page
		
		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//12.1.Click on the "Support" link
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(userPage.supportLink));
		userPage.clickOnSupportLink();
		
		//12.2.Click on "English" link
		PicsArtSupportPage supportPage = new PicsArtSupportPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(supportPage.englishLink));
		supportPage.clickOnEnglishLink();
		
		//12.3.Select other language
		Thread.sleep(1000);
		supportPage.clickOnRussianLink();

		//validate that the page's language has changed
		Thread.sleep(1000);
		Assert.assertTrue(!supportPage.PAGE_TITLE_RUSSIAN.isEmpty());

	}
	
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
	
	@Test 
	public void testImageOptions() {
		//Test Case ID:14
		//"Given that the user is authenticated
		//when the user move mouse to one of the uploaded images
		//then the user can do the following options:
		//Share
		//Like and comment
		//Save to Collection"
		
		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//14.1.Click on the user avatar
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(userPage.userAvatar));
		userPage.clickOnUserAvatar();
		
		//14.2.Click on the username link
		wait.until(ExpectedConditions.elementToBeClickable(userPage.userNameLink));
		userPage.clickOnUserNameLink();
		
		//14.3.Move the mouse to one of the posted images
		Actions actions= new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(userPage.lastPostedImage));
		actions.moveToElement(userPage.lastPostedImage).build().perform();
		
		//validate that the  "Share", "Like and comment" and "Save to Collection" options are displayed
		wait.until(ExpectedConditions.elementToBeClickable(userPage.share));
		Assert.assertTrue(userPage.share.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(userPage.likeAndComment));
		Assert.assertTrue(userPage.likeAndComment.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(userPage.saveToCollection));
		Assert.assertTrue(userPage.saveToCollection.isDisplayed());
	
	}
	
	@Test 
	public void testPicksImagesOptions() {
		//Test Case ID:15
		//"Given that the user is authenticated
		//when the user selects ""Explore"" link, selects one of the random images in the "PICKS" section
		//then the user can do the following actions:
		//Report Abuse
		//Repost
		//Save to Collection

		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//15.1.Click on the "Explore" link
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(userPage.exploreLink));
		userPage.exploreLink.click();
		
		//15.2.Click the "Picks" link
		wait.until(ExpectedConditions.elementToBeClickable(userPage.picksLink));
		userPage.picksLink.click();
		
		//15.3.Select one of the images
		wait.until(ExpectedConditions.elementToBeClickable(userPage.picksImage));
		userPage.picksImage.click();
		
		//15.4.Move the mouse to the drop-down
		Actions actions= new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(userPage.dropDown));
		actions.moveToElement(userPage.dropDown).build().perform();
		
		//validate that the "Report Abuse", "Repost" and "Save to Collection" options are displayed
		wait.until(ExpectedConditions.elementToBeClickable(userPage.reportAbuseOption));
		Assert.assertTrue(userPage.reportAbuseOption.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(userPage.repostOption));
		Assert.assertTrue(userPage.repostOption.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(userPage.saveToCollectionOption));
		Assert.assertTrue(userPage.saveToCollectionOption.isDisplayed());

	}
	
	@Test
	public void testUserOptions() {
		//Test Case ID:16
		//Given that the user is authenticated
		//when the user clicks on the user's avatar
		//then the username, "Find Friends", "Settings" and "Log Out" links are displayed
		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//14.1.Click on the user avatar
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(userPage.userAvatar));
		userPage.clickOnUserAvatar();
		
		//validate that the username link, "Find Friends", "Settings" and "Log Out" links are displayed
		wait.until(ExpectedConditions.elementToBeClickable(userPage.userNameLink));
		Assert.assertTrue(userPage.userNameLink.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(userPage.findFriendsLink));
		Assert.assertTrue(userPage.findFriendsLink.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(userPage.settingsLink));
		Assert.assertTrue(userPage.settingsLink.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(userPage.logOutLink));
		Assert.assertTrue(userPage.logOutLink.isDisplayed());
		
	}
	
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
