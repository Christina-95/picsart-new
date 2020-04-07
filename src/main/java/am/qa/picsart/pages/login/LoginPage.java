package am.qa.picsart.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import am.qa.picsart.pages.base.PicsArtBasePage;

public class LoginPage extends PicsArtBasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	protected final String USERNAME_OR_EMAIL_FIELD = "//input[@id='username']";
	protected final String PASSWORD_FIELD = "//input[@id='password']";
	protected final String SIGN_IN_BUTTON = "//div[@type='submit']";
	protected final String ERROR_MESSAGE = "//span[contains(text(),'Connection error')]";
	
	
	@FindBy (xpath = USERNAME_OR_EMAIL_FIELD)
	public WebElement usernameOrEmailField;
	
	@FindBy (xpath = PASSWORD_FIELD)
	public WebElement passwordField;
	
	@FindBy (xpath = SIGN_IN_BUTTON)
	public WebElement signInButton;
	
	@FindBy (xpath = ERROR_MESSAGE)
	public WebElement errorMessage;
	
	

}
