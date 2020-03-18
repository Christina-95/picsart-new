package am.qa.picsart.test.jobs;


import org.testng.Assert;
import org.testng.annotations.Test;

import am.qa.picsart.pages.base.PicsArtBasePage;
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

}
