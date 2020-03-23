package am.qa.picsart.pages.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import am.qa.picsart.pages.base.PicsArtBasePage;
import am.qa.picsart.pages.support.PicsArtSupportPage;

public class PicsArtUserPage extends PicsArtBasePage{

	public PicsArtUserPage(WebDriver driver) {
		super(driver);
	}
	
	PicsArtBasePage wait = new PicsArtBasePage(driver);
	Random random = new Random();
	int a = random.nextInt(99) + 10;
	public String collectionName = "Collection" + a;
	public String changeUserName = "tina" + a;
	
	
	protected final String USER_AVATAR = "//img[@class='c-image-check js-user-avatar']";
	protected final String CAREERS_LINK = "//a[contains(text(),'Careers')]";
	protected final String START_EDITING_Button ="//span[contains(text(),'Start Editing')]";
	protected final String USERNAME_LINK = "//a[@data-js-ga-click='top-menu open profile']";
	protected final String POSTS_LINK = "//a[@class='c-active active']";
	protected final String LAST_POSTED_IMAGE = "//div[@class='img-wrapper pa-ratio-1-1']";
	protected final String EDIT_OPTION= "//li[@class='c-photo-description-edit'][contains(text(),'Edit')]";
	protected final String DELETE_OPTION = "//li[@class='js-remove-image'][contains(text(),'Delete')]";
	protected final String SAVE_TO_COLLECTION = "//li[contains(text(),'Save to Collection')]";
	protected final String DROP_DOWN_DOTS = "//div[@class='c-dropdown diagonal dropdown dropdown-toggle']";
	protected final String CREATE_COLLECTION_OPTION = "//div[@class='gradient-border magenta-gradient-border']";
	protected final String CREATE_BUTTON = "//button[@type='submit']";
	protected final String COLLECTION_NAME_FIELD = "//input[@type='text']";
	protected final String X_BUTTON = "//span[@class='c-close-trigger js-close-preview svg-close close-modal']";
	protected final String COLLECTIONS_LINK = "//a[contains(.,'0Collections')]";
	public String LAST_CREATED_COLLECTION = "//a[@class='content clearfix']//*[text()='"+collectionName+"']";	
	protected final String PICSART_STORE_LINK = "//a[contains(text(),'PicsArt Store')]";
	protected final String SUPPORT_LINK = "//a[contains(text(),'Support')]";
	protected final String PLUS_BUTTON = "//i[@class='svg-upload-photo-plus']";
	protected final String SHARE_BUTTON = "//*[@class='icon-share-grid']";
	protected final String LIKE_AND_COMMENT_BUTTON = "//div[@class='c-like-button notifier-hover-toggle like-button ']";
	protected final String SAVE_TO_COLLECTION_BUTTON = "//div[contains(@data-js-ga-click,'photo add-to-collection')]";
	protected final String EXPLORE_LINK = "//a[@data-js-ga-click='top-menu open explore']";
	protected final String PICKS_LINK = "//span[contains(text(),'PICKS')]";
	protected final String PICKS_IMAGE = "//img[@src='https://cdn131.picsart.com/322412926352201.jpg?type=webp&to=crop&r=256']";
	protected final String REPORT_ABUSE_OPTION = "//li[contains(text(),'Report Abuse')]";		
	protected final String REPOST_OPTION = "//li[contains(text(),'Repost')]";
	protected final String SETTINGS_LINK = "//a[contains(text(),'Settings')]";
	protected final String CHANGE_PASSWORD_BUTTON = "//button[@class='border-btn js-the-accordion-toggle accordion-toggle grid-col m7'][contains(text(),'Change')]";
	protected final String CURRENT_PASSWORD_FIELD = "//input[@name='password_confirm']";
	protected final String NEW_PASSWORD_FIELD = "//input[@name='password']";
	protected final String RETYPE_NEW_PASSWORD = "//input[@name='password_retype']";
	protected final String SAVE_CHANGES_BUTTON = "//button[@type='submit']";
	protected final String LOG_OUT_LINK = "//a[contains(text(),'Log Out')]";
	protected final String GET_THE_APP_BUTTON = "//div[@data-js-ga-click='get-app get-app top-nav']";
	protected final String GET_THE_APP_POP_UP_TITLE = "//span[@class='welcome-on-board'][contains(text(),'Get the App for free')]";
	protected final String FIND_FRIENDS_LINK = "//a[contains(text(),'Find Friends')]";
	protected final String ABOUT_LINK = "//label[contains(text(),'About')]";
	protected final String APPS_LINK = "//a[contains(text(),'Apps')]";
	protected final String NAME_FIELD = "//input[@placeholder='Name']";
	protected final String SAVE_BUTTON = "//button[@class='primary-btn js-save'][contains(text(),'Save')]";
	public String  USER_NAME = "//span[@class='text-ellipsis'][contains(text(),'"+changeUserName+"')]";
	protected final String PICSART_GOLD_LINK = "//a[@data-js-active='gold']";
	protected final String SEARCH_FIELD = "//input[@type='search']";
	protected final String ARTISTS_LINK = "//a[@data-js-ga-click='search select-category artists']";
	protected final String FOLLOWING_LINK = "//a[@href='/u/tinat6043/following']";
	protected final String NEW_PASSWORD_DOES_NOT_MATCH_ERROR = "//div[@class='err-message']";
	
	
	
	@FindBy (xpath = ARTISTS_LINK)
	public WebElement artistsLink;
	
	@FindBy (xpath = USER_AVATAR)
	public WebElement userAvatar;
	
	@FindBy (xpath = CAREERS_LINK)
	public WebElement careersLink;
	
	@FindBy (xpath = START_EDITING_Button)
	public WebElement startEditingButton;
	
	@FindBy (xpath = USERNAME_LINK)
	public WebElement userNameLink;
	
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
	
	@FindBy (xpath = PICSART_STORE_LINK)
	public WebElement picsArtStoreLink;
	
	@FindBy (xpath = SUPPORT_LINK)
	public WebElement supportLink;
	
	@FindBy (xpath = PLUS_BUTTON)
	public WebElement plusButton;
	
	@FindBy (xpath = SHARE_BUTTON)
	public WebElement share;
	
	@FindBy (xpath = LIKE_AND_COMMENT_BUTTON)
	public WebElement likeAndComment;
	
	@FindBy (xpath = SAVE_TO_COLLECTION_BUTTON)
	public WebElement saveToCollection;
	
	@FindBy (xpath = EXPLORE_LINK)
	public WebElement exploreLink;
	
	@FindBy (xpath = PICKS_LINK)
	public WebElement picksLink;
	
	@FindBy (xpath = PICKS_IMAGE)
	public WebElement picksImage;
	
	@FindBy (xpath = REPORT_ABUSE_OPTION)
	public WebElement reportAbuseOption;
	
	@FindBy (xpath = REPOST_OPTION)
	public WebElement repostOption;
	
	@FindBy (xpath = SETTINGS_LINK)
	public WebElement settingsLink;
	
	@FindBy (xpath = CHANGE_PASSWORD_BUTTON)
	public WebElement changePasswordButton;
	
	@FindBy (xpath = CURRENT_PASSWORD_FIELD)
	public WebElement currentPasswordField;
	
	@FindBy (xpath = NEW_PASSWORD_FIELD)
	public WebElement newPasswordField;
	
	@FindBy (xpath = RETYPE_NEW_PASSWORD)
	public WebElement retypeNewPassword;
	
	@FindBy (xpath = SAVE_CHANGES_BUTTON)
	public WebElement saveChangesButton;
	
	@FindBy (xpath = LOG_OUT_LINK)
	public WebElement logOutLink;

	@FindBy (xpath = GET_THE_APP_BUTTON)
	public WebElement getTheAppButton;
	
	@FindBy (xpath = GET_THE_APP_POP_UP_TITLE)
	public WebElement getTheAppPopUpTitle;
	
	@FindBy (xpath = FIND_FRIENDS_LINK)
	public WebElement findFriendsLink;
	
	@FindBy (xpath = ABOUT_LINK)
	public WebElement aboutLink;
	
	@FindBy (xpath = APPS_LINK)
	public WebElement appsLink;
	
	@FindBy (xpath = NAME_FIELD)
	public WebElement nameField;
	
	@FindBy (xpath = SAVE_BUTTON)
	public WebElement saveButton;
	
	@FindBy (xpath = PICSART_GOLD_LINK)
	public WebElement picsartGoldLink;
	
	@FindBy (xpath = SEARCH_FIELD)
	public WebElement searchField;
	
	@FindBy (xpath = FOLLOWING_LINK)
	public WebElement followingLink;
	
	@FindBy (xpath = NEW_PASSWORD_DOES_NOT_MATCH_ERROR)
	public WebElement newPasswordDoesntMatchErrorMessage;
	
	
	
	public boolean validateLoggedInUser() {
		wait.waitForElementPresent(userAvatar);
		if (userAvatar.isDisplayed())
			return true;
		else return false;
	}

	public PicsArtUserPage clickOnUserAvatar() {
		userAvatar.click();
		return new PicsArtUserPage(driver);
	}
	
	public PicsArtUserPage clickOnUserNameLink() {
		wait.waitForElementToBeClickable(userNameLink);
		userNameLink.click();
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
	
	
	public PicsArtUserPage clickOnPicsArtStoreLink() {
		picsArtStoreLink.click();
		return new PicsArtUserPage(driver);
	}
	
	public PicsArtSupportPage clickOnSupportLink() {
		String supportPage = "https://support.picsart.com/hc/ru";
		driver.get(supportPage);
		supportLink.click();
		return new PicsArtSupportPage(driver);
	}
	
	public PicsArtUserPage clickOnOlusButton() {
		plusButton.click();
		return new PicsArtUserPage(driver);
	}
	
	public PicsArtUserPage fillInTheCurrentPasswordField() {
		currentPasswordField.click();
		currentPasswordField.sendKeys("123456789");
		return new PicsArtUserPage(driver);
	}
	
	public PicsArtUserPage fillInTheNewPasswordField() {
		newPasswordField.click();
		newPasswordField.sendKeys("12345678");
		return new PicsArtUserPage(driver);
	}
	
	public PicsArtUserPage fillInTheRetypePasswordField() {
		retypeNewPassword.click();
		retypeNewPassword.sendKeys("12345678");
		return new PicsArtUserPage(driver);
	}
	
	public PicsArtUserPage fillInTheNameField() {
		nameField.click();
		nameField.clear();
		nameField.sendKeys(changeUserName);
		return new PicsArtUserPage(driver);
	}
	
	public PicsArtUserPage fillInTheSearchField() {
		searchField.click();
		searchField.sendKeys("anime");
		return new PicsArtUserPage(driver);
	}
	
}
