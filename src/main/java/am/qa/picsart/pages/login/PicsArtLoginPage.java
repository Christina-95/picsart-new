package am.qa.picsart.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import am.qa.picsart.pages.base.PicsArtBasePage;

public class PicsArtLoginPage extends PicsArtBasePage {

	public PicsArtLoginPage(WebDriver driver) {
		super(driver);
	}
	
	protected final String USERNAME_OR_EMAIL_FIELD = "//input[@id='username']";
	protected final String PASSWORD_FIELD = "//input[@id='password']";
	protected final String SIGN_IN_BUTTON = "//div[@type='submit']";
	
	@FindBy (xpath = USERNAME_OR_EMAIL_FIELD)
	WebElement usernameOrEmailField;
	
	@FindBy (xpath = PASSWORD_FIELD)
	WebElement passwordField;
	
	@FindBy (xpath = SIGN_IN_BUTTON)
	WebElement signInButton;
	
	
	public void signIn() throws InterruptedException{
		Thread.sleep(2000);
		usernameOrEmailField.sendKeys("tinat6043@gmail.com");
		passwordField.sendKeys("12345678");
		Thread.sleep(1000);
		signInButton.click();
	}

}
