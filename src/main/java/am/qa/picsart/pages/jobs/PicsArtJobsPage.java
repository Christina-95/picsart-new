package am.qa.picsart.pages.jobs;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import am.qa.picsart.pages.base.PicsArtBasePage;
import am.qa.picsart.pages.jobs.vacancies.PicsArtVacanciesPage;

public class PicsArtJobsPage extends PicsArtBasePage{

	public PicsArtJobsPage(WebDriver driver) {
		super(driver);
	}
	
	PicsArtBasePage wait = new PicsArtBasePage(driver);
	
	protected final String PICSART_JOBS_URL = "https://picsart.com/jobs";
	protected final String VIEW_JOBS_BUTTON = "/html/body/div[3]/div/div[1]/div/div/a";
	protected final String DEPARTMENTS_TXT = "//label[@class='title'][contains(text(),'Departments')]";
	protected final String CONTINUE_ON_JOBS_BUTTON = "//a[contains(text(),'Continue on Jobs')]";
	protected final String ENGINEERING_LINK ="//label[contains(text(),'Engineering')]";
	protected final String YEREVAN_LINK = "//li[@class='opt location_yerevan']";

	
	@FindBy (xpath = VIEW_JOBS_BUTTON)
	WebElement viewJobsButton;
	
	@FindBy (xpath = DEPARTMENTS_TXT)
	public WebElement departmentsText;
	
	@FindBy (xpath = CONTINUE_ON_JOBS_BUTTON)
	WebElement continueOnJobsButton;
	
	@FindBy (xpath = ENGINEERING_LINK)
	WebElement engineeringLink;
	
	@FindBy (xpath = YEREVAN_LINK)
	WebElement yerevanLink;
	
	
	public PicsArtJobsPage clickOnViewJobsButton() throws InterruptedException {
		driver.get(PICSART_JOBS_URL);
		Thread.sleep(1000);
		//wait.waitForElementToBeClickable(viewJobsButton);
		viewJobsButton.click();
		return new PicsArtJobsPage(driver);
	}
	
	public boolean verifyvacanciesAreDisplayed() {
		wait.waitForElementPresent(departmentsText);
		if (departmentsText.isDisplayed())
		return true;
		else return false;	
	}
	
	public PicsArtVacanciesPage clickOnContinueOnJobsBtn() throws InterruptedException {
		Thread.sleep(2000);
		continueOnJobsButton.click();
		System.out.println("Continue On Jobs Button was clicked");
		return new PicsArtVacanciesPage(driver);
	}
	
	public void clickOnEngineeringLink() throws InterruptedException {
		Thread.sleep(2000);
		engineeringLink.click();
	}

	public void clickOnYerevanLink() throws InterruptedException {
		Thread.sleep(2000);
		yerevanLink.click();
	}
}
