package com.qa.picsart.pages.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.picsart.pages.base.PicsArtBasePage;

public class PicsArtSupportPage extends PicsArtBasePage {

	public PicsArtSupportPage(WebDriver driver) {
		super(driver);
	}
	
	protected final String ENGLISH_LINK = "//span[@id='language-name']";
	protected final String RUSSIAN_LINK = "//span[@id='ru']";
	public final String PAGE_TITLE_RUSSIAN = "//h1[contains(text(),'Чем мы можем помочь?')]";
	
	
	@FindBy (xpath = ENGLISH_LINK)
	public WebElement englishLink;
	
	@FindBy (xpath = RUSSIAN_LINK)
	public WebElement russianLink;
	
	
	public PicsArtSupportPage clickOnEnglishLink() {
		englishLink.click();
		return new PicsArtSupportPage(driver);
	}
	
	public PicsArtSupportPage clickOnRussianLink() {
		russianLink.click();
		return new PicsArtSupportPage(driver);
	}

}
