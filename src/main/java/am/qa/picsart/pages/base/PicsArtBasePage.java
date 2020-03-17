package am.qa.picsart.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import am.qa.picsart.pages.login.PicsArtLoginPage;

public class PicsArtBasePage {
	
	protected static final String CLOSE_POP_UP = "//div[@id='modal-body']/div[2]";
			//"//div[@class='modal-close js-close-button']";
	protected final String LOGIN_BUTTON_XPATH = "//a[@data-js-ga-click='sign-in']";
	
	@FindBy (xpath = LOGIN_BUTTON_XPATH)
	WebElement loginButton;
	
	@FindBy (xpath = CLOSE_POP_UP)
	WebElement closePopUp;
	
	public WebDriver driver;
	
	public PicsArtBasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void waitForElementPresent(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void moveToElement(WebElement element) {
		Actions actions= new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public void clicOnPopUp() throws InterruptedException {
		Thread.sleep(2000);
		moveToElement(closePopUp);
		closePopUp.click();
	}
	
	
	public PicsArtLoginPage clickOnLoginButton() throws InterruptedException {
		waitForElementPresent(loginButton);
		Thread.sleep(3000);
		loginButton.click();
		return new PicsArtLoginPage(driver);
	}
}
