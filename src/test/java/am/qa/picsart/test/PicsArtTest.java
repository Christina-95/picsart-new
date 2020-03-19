package am.qa.picsart.test;


import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import am.qa.picsart.pages.editingtools.PicsArtEditingToolsPage;
import am.qa.picsart.pages.editingtools.PicsArtRemoveBackgroundEditingPage;
import am.qa.picsart.pages.editingtools.PicsArtUploadSelectImagePage;
import am.qa.picsart.pages.jobs.PicsArtJobsPage;
import am.qa.picsart.pages.jobs.vacancies.PicsArtVacanciesPage;
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
	public void testVacanciesByDepartmentsAndLocation() throws InterruptedException {
		//Test Case ID:3
		//Given that the user is authenticated
		//when the user is on the "PicsArt Careers" page
		//then the user can search for vacancies by "DEPARTMENTS" and "LOCATION"
		
		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//3.1:Click on "Careers" link
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		userPage.clickOnCareersLink();
		//3.2:Click the "View Jobs" button
		PicsArtJobsPage jobsPage = new PicsArtJobsPage(driver);
		jobsPage.clickOnViewJobsButton();
		//3.3:Click the "Engineering" in the Departments section
		jobsPage.clickOnEngineeringLink();
		//validate that vacancies for "Engineering" are displayed
		//3.4:Click the Yerevan in the "Location" section
		jobsPage.clickOnYerevanLink();
		//validate that the vacancies in Yerevan are displayed
	}

	
	@Test 
	public void testApplyForVacancy() {
		//Test Case ID:4
		//Given that the user is authenticated and is on the "PicsArt Careers" page 
		//when the user selects the specific required vacancy
		//then the user can apply for it by filling out the required fields in the "Application" section

	}
	
	public void testEditingTools() throws InterruptedException {
		//Test Case ID:5
		//Given that the user is authenticated
		//when the user clicks the "Start Editing" button
		//then the "Editing Tools" page are displayed
		
		
		//Login with correct credentials -- Done in PicsArtBaseTest
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		//5.1.Click the "Start Editing" button
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
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		//6.1.Click the "Start Editing" button
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
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		//7.1.Click the "Start Editing" button
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
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		//8.1.Click on the user avatar beside "Get the app" button
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
	public void testSaveToCollectionoption() {
		//Test Case ID:10
		//Given that the user is on her/his profile page 
		//when the user selects any of her/his posted images and Click on the"Save to Collection"
		//then the user can save the image/sticker in the existing or in the newly created collection
		
		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//10.1.Click on the user avatar beside "Get the app" button
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		userPage.clickOnUserAvatar();
		//Login with correct credentials -- Done in PicsArtBaseTest
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
		userPage.clickOnSaveToCollectionOption();
		//10.6.Select the "Create Collection" option
		userPage.selectCreateCollectionOption();
		//10.7.Fill in the "Collection Name" field
		wait.until(ExpectedConditions.visibilityOf(userPage.collectionNameField));
		userPage.fillInTheCollectionNameField();
		//10.8.Click on the "Create" button
		wait.until(ExpectedConditions.visibilityOf(userPage.createButton));
		userPage.clickOnCreateButton();
		//go back to collections
//		wait.until(ExpectedConditions.visibilityOf(userPage.xButton));
//		userPage.clickTheXButton();
//		//click on the "Collections" link
//		wait.until(ExpectedConditions.visibilityOf(userPage.collectionsLink));
//		userPage.clickTheCollectionsLink();
		driver.get("https://picsart.com/u/tinat6043/collections");
		//validate that the collection was saved
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
}
