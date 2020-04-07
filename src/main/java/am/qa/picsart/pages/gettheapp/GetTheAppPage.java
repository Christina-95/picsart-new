package am.qa.picsart.pages.gettheapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import am.qa.picsart.pages.base.PicsArtBasePage;

public class GetTheAppPage extends PicsArtBasePage{

	public GetTheAppPage(WebDriver driver) {
		super(driver);
	}
	
	protected final String GET_IT_NOW_BUTTON = "//a[@data-app-name='PicsArt Photo Studio']";
	protected final String GET_THE_APP_POP_UP_TITLE = "//h3[contains(text(),'Get the App for free')]";
	
	
	
	@FindBy (xpath = GET_IT_NOW_BUTTON)
	public WebElement getItNowButton;
	
	@FindBy (xpath = GET_THE_APP_POP_UP_TITLE)
	public WebElement getTheAppPopUpTitle;

}
