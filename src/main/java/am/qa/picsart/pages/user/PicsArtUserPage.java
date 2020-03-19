package am.qa.picsart.pages.user;

import java.util.Random;

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
	Random random = new Random();
	int a = random.nextInt(99) + 10;
	public String collectionName = "Collection" + a;
	
	
	protected final String USER_AVATAR = "//img[@class='c-image-check js-user-avatar']";
	protected final String CAREERS_LINK = "//a[contains(text(),'Careers')]";
	protected final String START_EDITING_Button ="//span[contains(text(),'Start Editing')]";
	protected final String USER_LINK = "//a[@data-js-ga-click='top-menu open profile']";
	protected final String POSTS_LINK = "//a[@class='c-active active']";
	protected final String LAST_POSTED_IMAGE = "//div[@class=\"img-wrapper pa-ratio-1-1\"]";
	protected final String EDIT_OPTION= "//li[@class='c-photo-description-edit'][contains(text(),'Edit')]";
	protected final String DELETE_OPTION = "//li[@class='js-remove-image'][contains(text(),'Delete')]";
	protected final String SAVE_TO_COLLECTION = "//li[contains(text(),'Save to Collection')]";
	protected final String DROP_DOWN_DOTS = "//div[@class='c-dropdown diagonal dropdown dropdown-toggle']";
	protected final String CREATE_COLLECTION_OPTION = "//div[@class='gradient-border magenta-gradient-border']";
	protected final String CREATE_BUTTON = "//button[@type='submit']";
	protected final String COLLECTION_NAME_FIELD = "//input[@type='text']";
	protected final String X_BUTTON = "//span[@class='c-close-trigger js-close-preview svg-close close-modal']";
	protected final String COLLECTIONS_LINK = "//a[contains(.,'0Collections')]";
	public String LAST_CREATED_COLLECTION = "//a[@class=\"content clearfix\"]//*[text()='"+collectionName+"']";		
	
	
	
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
	
	@FindBy (xpath = LAST_POSTED_IMAGE)
	public WebElement lastPostedImage;
	
	@FindBy (xpath = EDIT_OPTION)
	public WebElement editOption;
	
	@FindBy (xpath = DELETE_OPTION)
	public WebElement deleteOption;
	
	@FindBy (xpath = SAVE_TO_COLLECTION)
	public WebElement saveToCollectionOption;
	
	@FindBy (xpath = DROP_DOWN_DOTS)
	public WebElement dropDown;
	
	@FindBy (xpath = CREATE_COLLECTION_OPTION)
	public WebElement createCollectionOption;
	
	@FindBy (xpath = CREATE_BUTTON)
	public WebElement createButton;
	
	@FindBy (xpath = COLLECTION_NAME_FIELD)
	public WebElement collectionNameField;
	
	@FindBy (xpath = X_BUTTON)
	public WebElement xButton;
	
	@FindBy (xpath = COLLECTIONS_LINK)
	public WebElement collectionsLink;
	
	
	
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
	
	public PicsArtUserPage clickOnLastPostedImage() {
		wait.waitForElementToBeClickable(lastPostedImage);
		lastPostedImage.click();
		return new PicsArtUserPage(driver);
	}
	
	public PicsArtUserPage clickOnSaveToCollectionOption() {
		wait.waitForElementToBeClickable(saveToCollectionOption);
		saveToCollectionOption.click();
		return new PicsArtUserPage(driver);
	}
	
	public PicsArtUserPage clickOnCreateButton() {
		wait.waitForElementToBeClickable(createButton);
		createButton.click();
		return new PicsArtUserPage(driver);
	}
	
	public PicsArtUserPage fillInTheCollectionNameField() {
		wait.waitForElementToBeClickable(createButton);
		collectionNameField.click();
		collectionNameField.sendKeys("Collection" + a);
		return new PicsArtUserPage(driver);
	}
	
	public PicsArtUserPage selectCreateCollectionOption() {
		wait.waitForElementToBeClickable(createCollectionOption);
		createCollectionOption.click();
		return new PicsArtUserPage(driver);
	}
	
	public PicsArtUserPage clickTheXButton() {
		xButton.click();
		return new PicsArtUserPage(driver);
	}
	
	public PicsArtUserPage clickTheCollectionsLink() {
		collectionsLink.click();
		return new PicsArtUserPage(driver);
	}
}
