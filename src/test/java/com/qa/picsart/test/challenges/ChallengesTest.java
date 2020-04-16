package com.qa.picsart.test.challenges;

import com.qa.picsart.pages.challenges.ChallengesPage;
import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.PicsArtBaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChallengesTest extends PicsArtBaseTest {

    @Test
    public void testChallengesLink() {
        //Test Case ID:26
        //Given that the user is authenticated
        //when the user clicks on the "Challenges"
        //then the "Active Challenges", "Voting Challenges", "Freestyle Challenges",
        //"Collage Challenges", "Image Remix Challenges", "Editing Challenges",
        //"Sticker Challenges", "Photography Challenges",
        //"Sticker Remix Challenges" and  "Drawing Challenges" are displayed


        //Login with correct credentials -- Done in PicsArtBaseTest
        //26.1.Click on the "Challenges" link
        PicsArtUserPage userPage = new PicsArtUserPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(userPage.challengesLink));
        userPage.challengesLink.click();

        //validate that the "Freestyle Challenges", "Collage Challenges", "Image Remix Challenges",
        //"Editing Challenges", "Sticker Challenges", "Photography Challenges",
        //"Sticker Remix Challenges" and "Drawing Challenges" and "See more" button are displayed
        ChallengesPage challengesPage = new ChallengesPage(driver);
        wait.until(ExpectedConditions.visibilityOf(challengesPage.freeStyleChallengesLink));
        Assert.assertTrue(challengesPage.freeStyleChallengesLink.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(challengesPage.collageChallengesLink));
        Assert.assertTrue(challengesPage.collageChallengesLink.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(challengesPage.imageRemixChallengesLink));
        Assert.assertTrue(challengesPage.imageRemixChallengesLink.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(challengesPage.editingChallengesLink));
        Assert.assertTrue(challengesPage.editingChallengesLink.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(challengesPage.stickerChallengesLink));
        Assert.assertTrue(challengesPage.stickerChallengesLink.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(challengesPage.photographyChallengesLink));
        Assert.assertTrue(challengesPage.photographyChallengesLink.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(challengesPage.stickerRemixChallengesLink));
        Assert.assertTrue(challengesPage.stickerRemixChallengesLink.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(challengesPage.drawingChallengesLink));
        Assert.assertTrue(challengesPage.drawingChallengesLink.isDisplayed());

    }
}
