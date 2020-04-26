package com.qa.picsart.test.upwardsbutton;

import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.BaseLoginTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpwardsButtonTest extends BaseLoginTest {

    @Test
    public void testUpwardsArrowFunctionality() {
        //Test Case ID:23
        //Given that the user is authenticated
        // when the user scroll down the page and clicks the "↑"  upwards arrow
        //then the  "Check out the new PicsArt Web Tools!" title is displayed

        //Login with correct credentials -- Done in PicsArtBaseTest
        //23.1.Scroll down the page
        PicsArtUserPage userPage = new PicsArtUserPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");

        //23.2.Click on the "↑" upwards arrow
        wait.until(ExpectedConditions.elementToBeClickable(userPage.upwardsArrow));
        userPage.upwardsArrow.click();

        //validate that the "Check out the new PicsArt Web Tools!" title is displayed
        wait.until(ExpectedConditions.visibilityOf(userPage.picsartWebToolsTitle));
        Assert.assertTrue(userPage.picsartWebToolsTitle.isDisplayed());
    }
}
