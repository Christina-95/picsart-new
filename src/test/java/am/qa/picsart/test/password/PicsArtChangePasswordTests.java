package am.qa.picsart.test.password;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import am.qa.picsart.pages.base.PicsArtBasePage;
import am.qa.picsart.pages.login.PicsArtLoginPage;
import am.qa.picsart.pages.user.PicsArtUserPage;
import am.qa.picsart.test.base.PicsArtBaseTest;

public class PicsArtChangePasswordTests extends PicsArtBaseTest {
	
	@Test 
	public void testChangePassword () {
		//Test Case ID:4
		//Given that the user is authenticated
		//when the user changes her/his profile password
		//then the user cannot log in with the old password
		
		
		//Login with correct credentials -- Done in PicsArtBaseTest
		//4.1.Click on the user avatar beside "Get the app" button
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(userPage.userAvatar));
		userPage.clickOnUserAvatar();
		
		//4.2.Click on the "Settings" link
		wait.until(ExpectedConditions.visibilityOf(userPage.settingsLink));
		userPage.settingsLink.click();
		
		//4.3.Click on the "Change" button beside Password field
		wait.until(ExpectedConditions.visibilityOf(userPage.changePasswordButton));
		userPage.changePasswordButton.click();
		
		//4.4.Fill in the "Current Password", "New Password" and "Retype new password" fields
		wait.until(ExpectedConditions.visibilityOf(userPage.currentPasswordField));
		userPage.fillInTheCurrentPasswordField();
		wait.until(ExpectedConditions.visibilityOf(userPage.newPasswordField));
		userPage.fillInTheNewPasswordField();
		wait.until(ExpectedConditions.visibilityOf(userPage.retypeNewPassword));
		userPage.fillInTheRetypePasswordField();
		
		//4.5.Click on the "Save Changes" button
		wait.until(ExpectedConditions.visibilityOf(userPage.saveChangesButton));
		userPage.saveChangesButton.click();
		
		//4.6.Click on the user avatar and on the "Log Out" link
		wait.until(ExpectedConditions.visibilityOf(userPage.userAvatar));
		userPage.clickOnUserAvatar();
		wait.until(ExpectedConditions.visibilityOf(userPage.logOutLink));
		userPage.logOutLink.click();
		
		//validate that the user is logged out of the system 
		Assert.assertFalse(userPage.userAvatar.isDisplayed());
		
		//4.7.Click on the "Log In" button
		PicsArtBasePage page = new PicsArtBasePage(driver);
		wait.until(ExpectedConditions.visibilityOf(page.loginButton));
        page.clickOnLoginButton();
        
        //4.8.Fill in the "Username" field with correct username 
        PicsArtLoginPage loginPage = new PicsArtLoginPage(driver);
        loginPage.usernameOrEmailField.click();
        loginPage.usernameOrEmailField.sendKeys("tinat6043@gmail.com");
       
        //4.9.Fill in the "Password" field with the old password and click on the "Sign in" button
        loginPage.passwordField.click();
        loginPage.passwordField.sendKeys("123456789");
        wait.until(ExpectedConditions.visibilityOf(loginPage.signInButton));
        loginPage.signInButton.click();
        
        //validate that the error message is displayed
        wait.until(ExpectedConditions.visibilityOf(loginPage.errorMessage));
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        
	}
	
	@Test 
	public void testRetypeNewPassword() {
		//Test Case ID:21
		//Given that the user is authenticated
		//when the user changes her/his profile password and types old password in the "Retype new password" field
		//then the error message is displayed


		//Login with correct credentials -- Done in PicsArtBaseTest
		//21.1.Click on the user avatar beside "Get the app" button
		PicsArtUserPage userPage = new PicsArtUserPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(userPage.userAvatar));
		userPage.clickOnUserAvatar();
				
		//21.2.Click on the "Settings" link
		wait.until(ExpectedConditions.visibilityOf(userPage.settingsLink));
		userPage.settingsLink.click();
				
		//21.3.Click on the "Change" button beside Password field
		wait.until(ExpectedConditions.visibilityOf(userPage.changePasswordButton));
		userPage.changePasswordButton.click();
				
		//21.4.Fill in the "Current Password" and  "New Password" 
		wait.until(ExpectedConditions.visibilityOf(userPage.currentPasswordField));
		userPage.currentPasswordField.click();
		userPage.currentPasswordField.sendKeys("12345678");
		wait.until(ExpectedConditions.visibilityOf(userPage.newPasswordField));
		userPage.newPasswordField.click();
		userPage.newPasswordField.sendKeys("123456789");
		
		//21.5.Fill in the "Retype new password" field with an old password
		wait.until(ExpectedConditions.visibilityOf(userPage.retypeNewPassword));
		userPage.retypeNewPassword.click();
		userPage.retypeNewPassword.sendKeys("12345678");
		
				
		//21.6.Click on the "Save Changes" button
		wait.until(ExpectedConditions.visibilityOf(userPage.saveChangesButton));
		userPage.saveChangesButton.click();
		
		//validate that the error message is displayed
		wait.until(ExpectedConditions.visibilityOf(userPage.newPasswordDoesntMatchErrorMessage));
		Assert.assertTrue(userPage.newPasswordDoesntMatchErrorMessage.isDisplayed());
		
	}

}
