package com.qa.picsart.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.picsart.pages.base.PicsArtBasePage;

import java.util.Random;

public class LoginPage extends PicsArtBasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	protected final String USERNAME_OR_EMAIL_FIELD = "//input[@id='username']";
	protected final String PASSWORD_FIELD = "//input[@id='password']";
	protected final String SIGN_IN_BUTTON = "//div[@type='submit'][text()='Sign in']";
	protected final String ERROR_MESSAGE = "//span[contains(text(),'Connection error')]";
	protected final String INCORRECT_PASSWORD_FORMAT_ERROR = "//span[contains(text(),'Incorrect password format')]";
	
	
	@FindBy (xpath = USERNAME_OR_EMAIL_FIELD)
	public WebElement usernameOrEmailField;
	
	@FindBy (xpath = PASSWORD_FIELD)
	public WebElement passwordField;
	
	@FindBy (xpath = SIGN_IN_BUTTON)
	public WebElement signInButton;
	
	@FindBy (xpath = ERROR_MESSAGE)
	public WebElement errorMessage;

	@FindBy (xpath = INCORRECT_PASSWORD_FORMAT_ERROR)
	public WebElement incorrectPasswordFormatErr;
	
	public void enterEmailInUsernameField(String email) {
		usernameOrEmailField.click();
		usernameOrEmailField.sendKeys(email);
	}

	public void enterPasswordPasswordField(String password) {
		passwordField.click();
		passwordField.sendKeys(password);
	}

}
