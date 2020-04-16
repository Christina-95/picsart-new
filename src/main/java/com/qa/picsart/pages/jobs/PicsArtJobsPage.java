package com.qa.picsart.pages.jobs;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.picsart.pages.base.PicsArtBasePage;

public class PicsArtJobsPage extends PicsArtBasePage{

	public PicsArtJobsPage(WebDriver driver) {
		super(driver);
	}
	
	PicsArtBasePage wait = new PicsArtBasePage(driver);
	
	protected final String PICSART_JOBS_URL = "https://picsart.com/jobs";
	protected final String VIEW_JOBS_BUTTON = "/html/body/div[3]/div/div[1]/div/div/a";
	protected final String DEPARTMENTS_TXT = "//label[@class='title'][contains(text(),'Departments')]";
	protected final String LOCATION_TEXT = "//label[contains(text(),'Location')]";
	protected final String CONTINUE_ON_JOBS_BUTTON = "//a[contains(text(),'Continue on Jobs')]";
	protected final String ENGINEERING_LINK ="//label[contains(text(),'Engineering')]";
	protected final String YEREVAN_LINK = "//li[@class='opt location_yerevan']";

	
	@FindBy (xpath = VIEW_JOBS_BUTTON)
	public WebElement viewJobsButton;
	
	@FindBy (xpath = DEPARTMENTS_TXT)
	public WebElement departmentsText;
	
	@FindBy (xpath = LOCATION_TEXT)
	public WebElement locationText;
	
	@FindBy (xpath = CONTINUE_ON_JOBS_BUTTON)
	public WebElement continueOnJobsButton;
	
	@FindBy (xpath = ENGINEERING_LINK)
	public WebElement engineeringLink;
	
	@FindBy (xpath = YEREVAN_LINK)
	public WebElement yerevanLink;
	
	
	public PicsArtJobsPage clickOnViewJobsButton() {
		driver.get(PICSART_JOBS_URL);
		viewJobsButton.click();
		return new PicsArtJobsPage(driver);
	}
	
	public boolean verifyVacanciesAreDisplayed() {
		wait.waitForElementPresent(departmentsText);
		if (departmentsText.isDisplayed())
		return true;
		else return false;	
	}
	
	
}
