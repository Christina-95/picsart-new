package am.qa.picsart.pages.editingtools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import am.qa.picsart.pages.base.PicsArtBasePage;

public class RemoveBackgroundEditingPage extends PicsArtBasePage {

	public RemoveBackgroundEditingPage(WebDriver driver) {
		super(driver);
	}

	PicsArtBasePage wait = new PicsArtBasePage(driver);

	
	public static final String SHARE_BUTTON = "//span[contains(text(),'Share')]";
	public static final String POST_BUTTON = "//button[@class='shareScreenButton-0-2-98']/*";
	public static final String POP_UP_TITLE = "//p[contains(text(),'Share to your PicsArt Profile')]";
	public static final String SUCCESSFULLY_POSTED_MESSAGE = "//p[contains(text(),'Successfully Posted')]";
	public static final String GO_TO_TOOLS_BUTTON = "//p[@class='anotherToolText-0-2-24'][contains(text(),'Go to Tools')]";
	
	
	
	
	@FindBy (xpath = SHARE_BUTTON)
	public WebElement shareButton;
	
	@FindBy (xpath = POST_BUTTON)
	public WebElement postButton;
	
	@FindBy (xpath = POP_UP_TITLE)
	public WebElement popUpTitle;
	
	@FindBy (xpath = SUCCESSFULLY_POSTED_MESSAGE)
	public WebElement successfullypostedMessage;
	
	@FindBy (xpath = GO_TO_TOOLS_BUTTON)
	public WebElement goToToolsBtn;
	

	
	public RemoveBackgroundEditingPage clickOnGoToToolsBtn() throws InterruptedException {
		wait.waitForElementToBeClickable(goToToolsBtn);
		Thread.sleep(1000);
		goToToolsBtn.click();
		return new RemoveBackgroundEditingPage(driver);
	}

}
