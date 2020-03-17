package am.qa.picsart.test.jobs;


import org.testng.Assert;
import org.testng.annotations.Test;

import am.qa.picsart.pages.jobs.PicsArtJobsPage;
import am.qa.picsart.pages.user.PicsArtUserPage;
import am.qa.picsart.test.base.PicsArtBaseTest;

public class PicsArtJobsTest extends PicsArtBaseTest {
	
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
		Thread.sleep(2000);
		Assert.assertTrue(jobsPage.departmentsText.isDisplayed());
	}

}
