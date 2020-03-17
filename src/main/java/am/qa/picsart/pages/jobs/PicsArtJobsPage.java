package am.qa.picsart.pages.jobs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import am.qa.picsart.pages.base.PicsArtBasePage;

public class PicsArtJobsPage extends PicsArtBasePage{

	public PicsArtJobsPage(WebDriver driver) {
		super(driver);
	}
	
	PicsArtBasePage wait = new PicsArtBasePage(driver);
	
	protected final String PICSART_JOBS_URL = "https://picsart.com/jobs";
	protected final String VIEW_JOBS_BUTTON = "/html/body/div[3]/div/div[1]/div/div/a";
	protected final String DEPARTMENTS_TXT = "//label[@class='title'][contains(text(),'Departments')]";
	
	
	@FindBy (xpath = VIEW_JOBS_BUTTON)
	WebElement viewJobsButton;
	
	@FindBy (xpath = DEPARTMENTS_TXT)
	public WebElement departmentsText;
	
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

}
