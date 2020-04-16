package com.qa.picsart.test.careers;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.qa.picsart.pages.jobs.PicsArtJobsPage;
import com.qa.picsart.pages.jobs.vacancies.PicsArtVacanciesPage;
import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.PicsArtBaseTest;

public class PicsArtCareerTests extends PicsArtBaseTest {
	private WebDriverWait wait;
	private PicsArtUserPage userPage;
	private PicsArtJobsPage jobsPage;
	private PicsArtVacanciesPage vacanciesPage;


	@BeforeClass
	public void start() {
		wait = new WebDriverWait(driver, 30);
		userPage = new PicsArtUserPage(driver);
		jobsPage = new PicsArtJobsPage(driver);
		vacanciesPage = new PicsArtVacanciesPage(driver);
	}
	
	
	@Test
	public void testCareersLink() {
		//Test Case ID:1
		//Given that the user is authenticated 
		//when the user selects the "Career" section and the "PicsArt Careers" page is displayed and clicks the "View Jobs" button
		//then the current required vacancies shall be displayed

		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//1.1:Click on "Careers" link
		wait.until(ExpectedConditions.visibilityOf(userPage.careersLink));
		userPage.careersLink.click();
		
		//1.2:Click the "View Jobs" button
		wait.until(ExpectedConditions.visibilityOf(jobsPage.viewJobsButton));
		jobsPage.clickOnViewJobsButton();
		
		//Validate that the current vacancies are displayed
		wait.until(ExpectedConditions.visibilityOf(jobsPage.departmentsText));
		Assert.assertTrue(jobsPage.departmentsText.isDisplayed());
	}
	
	@Test 
	public void testVacanciesPage() {
		//Test Case ID:2
		//Given that the user is authenticated and  is on the "PicsArt Careers" page
		//when the user clicks the "Continue on Jobs" button
		//then the current required vacancies are displayed in the new separated page (picsart.com/jobs/vacancies)

		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//2.1:Click on "Careers" link
		wait.until(ExpectedConditions.visibilityOf(userPage.careersLink));
		userPage.careersLink.click();
		
		//2.2:Click the "View Jobs" button
		wait.until(ExpectedConditions.visibilityOf(jobsPage.viewJobsButton));
		jobsPage.clickOnViewJobsButton();
		
		//2.3:Click the "Continue on Jobs" button
		wait.until(ExpectedConditions.visibilityOf(jobsPage.continueOnJobsButton));
		jobsPage.continueOnJobsButton.click();
		
		//validate that the picsart.com/jobs/vacancies page is opened
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
		wait.until(ExpectedConditions.visibilityOf(userPage.careersLink));
		userPage.careersLink.click();
		
		//3.2:Click the "View Jobs" button
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

}
