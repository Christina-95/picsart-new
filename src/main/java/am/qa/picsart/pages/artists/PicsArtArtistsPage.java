package am.qa.picsart.pages.artists;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import am.qa.picsart.pages.base.PicsArtBasePage;

public class PicsArtArtistsPage extends PicsArtBasePage {

	public PicsArtArtistsPage(WebDriver driver) {
		super(driver);
	}
	
	protected final String ANIME_USER_LINK = "//a[@content='shina__']";
	protected final String FOLLOW_BUTTON = "//span[@class='off'][contains(text(),'Follow')]";
	protected final String FOLLOWING_BUTTON = "//span[@class='on'][contains(text(),'Following')]";
	
	
	@FindBy (xpath = ANIME_USER_LINK)
	public WebElement animeUserLink;
	
	@FindBy (xpath = FOLLOW_BUTTON)
	public WebElement followButton;
	
	@FindBy (xpath = FOLLOWING_BUTTON)
	public WebElement followingButton;

}
