package com.qa.picsart.pages.gold;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.picsart.pages.base.PicsArtBasePage;

public class PicsArtGoldPage extends PicsArtBasePage {

	public PicsArtGoldPage(WebDriver driver) {
		super(driver);
	}
	
	
	protected final String START_FREE_TRIAL_BUTTON = "//a[@class='link-button large undefined'][contains(.,'Start Free Trial')]";
	protected final String PICSART_GOLD_SUBSCRIBE_TTITLE = "//h2[@class='complete-your-purchase'][contains(text(),'Claim 14-Day Free Trial')]";
	protected final String CARD_INFO_MESSAGE = "//div[@class='trial-info']";
	
	@FindBy (xpath = START_FREE_TRIAL_BUTTON)
	public WebElement startFreeTrialButton;
	
	@FindBy (xpath = PICSART_GOLD_SUBSCRIBE_TTITLE)
	public WebElement picsartGoldTitle;
	
	@FindBy (xpath = CARD_INFO_MESSAGE)
	public WebElement cardInfoMessage;
	
	
	
}
