package com.qa.picsart.test.editingtools;

import com.qa.picsart.pages.editingtools.EditingToolsPage;
import com.qa.picsart.pages.editingtools.PixelStretchEffectsPage;
import com.qa.picsart.pages.editingtools.UploadSelectImagePage;
import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.PicsArtBaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PixelStretchEffectsTest extends PicsArtBaseTest {

    @Test
    public void testPixelStretchEffects() {
        //Test Case ID:29
        // Given that the user is on the "Editing Tools" page,
        //when the user clicks on the "Pixel Stretch Effect" and Chooses one of the random images ,
        //then the "Stretch" category, and "Share" , "Download"  options are  displayed

        //Login with correct credentials -- Done in PicsArtBaseTest
        //click on the "Start Editing" button
        PicsArtUserPage userPage = new PicsArtUserPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(userPage.startEditingButton));
        userPage.startEditingButton.click();

        //29.1.Click on the "Pixel Stretch Effect"
        EditingToolsPage editingToolsPage = new EditingToolsPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(editingToolsPage.pixelStretchEffects));
        editingToolsPage.pixelStretchEffects.click();

        //29.2.Choose on of the random images
        UploadSelectImagePage uploadImage = new UploadSelectImagePage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(uploadImage.randomImage));
        uploadImage.randomImage.click();

        //validate that the "Stretch" category, and "Share" , "Download"  options are  displayed
        PixelStretchEffectsPage pixelStretchEffectsPage = new PixelStretchEffectsPage(driver);
        wait.until(ExpectedConditions.visibilityOf(pixelStretchEffectsPage.stretchCategory));
        Assert.assertTrue(pixelStretchEffectsPage.stretchCategory.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(pixelStretchEffectsPage.shareOption));
        Assert.assertTrue(pixelStretchEffectsPage.shareOption.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(pixelStretchEffectsPage.downloadOption));
        Assert.assertTrue(pixelStretchEffectsPage.downloadOption.isDisplayed());

    }

    @Test
    public void testPixelStretchEffectsShareButton() {
        //Test Case ID:30
        //Given that the user is on the "Editing Tools" page,
        //when the user clicks on the "Pixel Stretch Effect" and Chooses one of the random images,
        //edits it and clicks the "Share" and the "Post" button,
        //then the image is displayed in the "Posts" section of the user's profile


        //Login with correct credentials -- Done in PicsArtBaseTest
        //click on the "Start Editing" button
        PicsArtUserPage userPage = new PicsArtUserPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(userPage.startEditingButton));
        userPage.startEditingButton.click();

        //30.1.Click on the "Pixel Stretch Effect"
        EditingToolsPage editingToolsPage = new EditingToolsPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(editingToolsPage.pixelStretchEffects));
        editingToolsPage.pixelStretchEffects.click();

        //30.2.Choose on of the random images
        UploadSelectImagePage uploadImage = new UploadSelectImagePage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(uploadImage.randomImage));
        uploadImage.randomImage.click();

        //30.3.Choose one of the image edits
        PixelStretchEffectsPage pixelStretchEffectsPage = new PixelStretchEffectsPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(pixelStretchEffectsPage.stretchFilter1));
        pixelStretchEffectsPage.stretchFilter1.click();

        //30.4.Click the "Share" button
        wait.until(ExpectedConditions.elementToBeClickable(pixelStretchEffectsPage.shareOption));
        pixelStretchEffectsPage.shareOption.click();

        //switch the post to "public"
        wait.until(ExpectedConditions.elementToBeClickable(pixelStretchEffectsPage.publicButton));
        pixelStretchEffectsPage.publicButton.click();

        //30.5.Click on the "Post" button
        wait.until(ExpectedConditions.elementToBeClickable(pixelStretchEffectsPage.postButton));
        pixelStretchEffectsPage.postButton.click();

        //click on the "Go to Tools" button
        wait.until(ExpectedConditions.visibilityOf(pixelStretchEffectsPage.goToToolsButton));
        pixelStretchEffectsPage.goToToolsButton.click();

        //30.6.Click on the username link and go to the "Posts" section
        wait.until(ExpectedConditions.elementToBeClickable(userPage.userAvatar));
        userPage.userAvatar.click();
        wait.until(ExpectedConditions.elementToBeClickable(userPage.userNameLink));
        userPage.userNameLink.click();
        wait.until(ExpectedConditions.elementToBeClickable(userPage.postsLink));
        userPage.postsLink.click();

        //validate that the image is displayed in the "Posts" section of the user's profile
        Assert.assertTrue(!userPage.POST_LINK.isEmpty());
    }
}
