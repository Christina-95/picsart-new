package com.qa.picsart.pages.base;

import com.qa.picsart.pages.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PicsArtBasePage {
	
	protected static final String CLOSE_POP_UP = "//div[@class='modal-close js-close-button']";
	protected final String LOGIN_BUTTON = "//a[@data-js-ga-click='sign-in']";
	
	@FindBy (xpath = LOGIN_BUTTON)
	public WebElement loginButton;
	
	@FindBy (xpath = CLOSE_POP_UP)
	public WebElement closePopUp;
	
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
	
	public void waitForElementPresent(String xPath) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xPath)));
	}
	
	public void moveToElement(WebElement element) {
		Actions actions= new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	
	
	public void moveToClosePopUp() {

		moveToElement(closePopUp);
	}
	
	
	public LoginPage clickOnLoginButton() {
		loginButton.click();
		return new LoginPage(driver);
	}
}
