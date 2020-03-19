package am.qa.picsart.pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import am.qa.picsart.pages.base.PicsArtBasePage;
import am.qa.picsart.pages.editingtools.PicsArtEditingToolsPage;
import am.qa.picsart.pages.jobs.PicsArtJobsPage;

public class PicsArtUserPage extends PicsArtBasePage{

	public PicsArtUserPage(WebDriver driver) {
		super(driver);
	}
	
	PicsArtBasePage wait = new PicsArtBasePage(driver);
	
	
	protected final String USER_AVATAR = "//img[@class='c-image-check js-user-avatar']";
	protected final String CAREERS_LINK = "//a[contains(text(),'Careers')]";
	protected final String START_EDITING_Button ="//span[contains(text(),'Start Editing')]";
	protected final String USER_LINK = "//a[@data-js-ga-click='top-menu open profile']";
	protected final String POSTS_LINK = "//a[@class='c-active active']";
			
			
	@FindBy (xpath = USER_AVATAR)
	WebElement userAvatar;
	
	@FindBy (xpath = CAREERS_LINK)
	WebElement careersLink;
	
	@FindBy (xpath = START_EDITING_Button)
	WebElement startEditingButton;
	
	@FindBy (xpath = USER_LINK)
	WebElement userLink;
	
	@FindBy (xpath = POSTS_LINK)
	public WebElement postsLink;
	
	
	public boolean validateLoggedInUser() {
		wait.waitForElementPresent(userAvatar);
		if (userAvatar.isDisplayed())
			return true;
		else return false;
	}
	
	public PicsArtJobsPage clickOnCareersLink() {
		wait.waitForElementToBeClickable(careersLink);
		careersLink.click();
		return new PicsArtJobsPage(driver);
	}

	public PicsArtEditingToolsPage clickOnStartEditingButton() throws InterruptedException {
		Thread.sleep(1000);
		startEditingButton.click();
		return new PicsArtEditingToolsPage(driver);
	}

	public PicsArtUserPage clickOnUserAvatar() {
		wait.waitForElementToBeClickable(userAvatar);
		userAvatar.click();
		return new PicsArtUserPage(driver);
	}
	
	public PicsArtUserPage clickOnUserNameLink() {
		wait.waitForElementToBeClickable(userLink);
		userLink.click();
		return new PicsArtUserPage(driver);
	}
}
