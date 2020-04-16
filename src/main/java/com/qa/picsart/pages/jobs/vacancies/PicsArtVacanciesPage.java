package com.qa.picsart.pages.jobs.vacancies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.picsart.pages.base.PicsArtBasePage;

public class PicsArtVacanciesPage extends PicsArtBasePage {

	public PicsArtVacanciesPage(WebDriver driver) {
		super(driver);
	}
	
	PicsArtBasePage wait = new PicsArtBasePage(driver);
	
	protected final String PAGE_TITLE = "//h1[contains(text(),'Join Our Team')]";
	
	@FindBy (xpath = PAGE_TITLE)
	public WebElement vacanciesPageTitle;

	
	public void waitForVacanciespageTitle() {
		driver.get("https://picsart.com/jobs/vacancies");
		wait.waitForElementPresent(vacanciesPageTitle);
		System.out.println("Picsart vacancies page is dipslayed");
	}
}
