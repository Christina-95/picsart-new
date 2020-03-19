package am.qa.picsart.test.jobs;


import org.testng.Assert;
import org.testng.annotations.Test;

import am.qa.picsart.pages.base.PicsArtBasePage;
import am.qa.picsart.pages.editingtools.PicsArtEditingToolsPage;
import am.qa.picsart.pages.editingtools.PicsArtRemoveBackgroundEditingPage;
import am.qa.picsart.pages.editingtools.PicsArtUploadSelectImagePage;
import am.qa.picsart.pages.jobs.PicsArtJobsPage;
import am.qa.picsart.pages.jobs.vacancies.PicsArtVacanciesPage;
import am.qa.picsart.pages.user.PicsArtUserPage;
import am.qa.picsart.test.base.PicsArtBaseTest;

public class PicsArtJobsTest extends PicsArtBaseTest {
	
	PicsArtBasePage wait = new PicsArtBasePage(driver);
	
	@Test
	public void testCareersLink() throws InterruptedException {
		//Test Case ID:1
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
	}
	
	public void testEditingTools() throws InterruptedException {
		//Test Case ID:5
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
		Thread.sleep(2000);
		removeBackgroundPage.clickOnShareButton();
		//7.5.Click the "Post" button
		Thread.sleep(3000);
		removeBackgroundPage.clickOnPostButton();
		//validate that the success message is diplayed 
		Thread.sleep(30000);
		Assert.assertTrue(removeBackgroundPage.successfullypostedMessage.isDisplayed());
		//7.6.Click the "Go to Tools" button
		removeBackgroundPage.clickOnGoToToolsBtn();
		//validate that the Editing Tools page is displayed
		Assert.assertTrue(toolsPage.editingToolsPageTitle.isDisplayed());
		
	}
	
	@Test
	public void testUserPosts() {
		//Test Case ID:8
		//Login with correct credentials -- Done in PicsArtBaseTest
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		//8.1.Click on the user avatar beside "Get the app" button
		userPage.clickOnUserAvatar();
		//8.2.Click on the username link
		userPage.clickOnUserNameLink();
		//validate that the "Posts" are displayed
		Assert.assertTrue(userPage.postsLink.isDisplayed());
	}
}
