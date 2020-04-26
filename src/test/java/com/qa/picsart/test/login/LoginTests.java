package com.qa.picsart.test.login;

import com.qa.picsart.pages.base.PicsArtBasePage;
import com.qa.picsart.pages.login.LoginPage;
import com.qa.picsart.test.base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class LoginTests extends BaseTest {
    private PicsArtBasePage basePage;
    private WebDriverWait wait;
    private LoginPage loginPage;
    Random random = new Random();
    int a = random.nextInt(999999999) + 10;

    @BeforeClass
    public void start() {
        basePage = new PicsArtBasePage(driver);
        wait = new WebDriverWait(driver, 30);
        loginPage = new LoginPage(driver);
    }
    @Test
    public void testPasswordError() {
        //Test Case ID:42
        //Given that the user is on the PicsArt.com page,
        //when the user attempts to log in with too many characters in the password field,
        //then the error message is displayed

        //Navigate to picsart.com -- Done in BaseTest
        //42.1.Click on "Log In" button
        wait.until(ExpectedConditions.elementToBeClickable(basePage.loginButton));
        basePage.loginButton.click();

        //42.2.Enter valid email address in the "Username" field
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.usernameOrEmailField));
        loginPage.enterEmailInUsernameField("smth1234@gmail.com");

        //42.3.Enter password with too many characters in the "Password" field
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.passwordField));
        loginPage.enterPasswordPasswordField(a + "something.......");


        //42.4.Click on "Sign In" button
        wait.until(ExpectedConditions.visibilityOf(loginPage.signInButton));
        loginPage.signInButton.click();

        //validate that the error message is displayed
        Assert.assertEquals(loginPage.incorrectPasswordFormatErr.getText(), "Incorrect password format");
    }
}
