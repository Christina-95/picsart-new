package am.qa.picsart.pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import am.qa.picsart.pages.base.PicsArtBasePage;
import am.qa.picsart.pages.jobs.PicsArtJobsPage;

public class PicsArtUserPage extends PicsArtBasePage{

	public PicsArtUserPage(WebDriver driver) {
		super(driver);
	}
	
	PicsArtBasePage wait = new PicsArtBasePage(driver);
	
	
	protected final String USER_AVATAR = "//img[@class='c-image-check js-user-avatar']";
	protected final String CAREERS_LINK = "//a[contains(text(),'Careers')]";
	
	@FindBy (xpath = USER_AVATAR)
	WebElement userAvatar;
	
	@FindBy (xpath = CAREERS_LINK)
	WebElement careersLink;
	
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

}
