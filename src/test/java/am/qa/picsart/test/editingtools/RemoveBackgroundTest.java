package am.qa.picsart.test.editingtools;

import am.qa.picsart.pages.editingtools.PicsArtEditingToolsPage;
import am.qa.picsart.pages.editingtools.PicsArtRemoveBackgroundEditingPage;
import am.qa.picsart.pages.editingtools.PicsArtUploadSelectImagePage;
import am.qa.picsart.pages.user.PicsArtUserPage;
import am.qa.picsart.test.base.PicsArtBaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveBackgroundTest extends PicsArtBaseTest {

    @Test
    public void testRemoveBackground() {
        //Test Case ID:6
        //Given that the user is on the "Editing Tools" page
        //when the user selects the "Remove Background" filter, selects one of the images,edits it,clicks on the "Share" button and clicks on the "Post" button
        //then the "Successfully Posted" message is displayed


        //Login with correct credentials -- Done in PicsArtBaseTest
        //6.1.Click on the "Start Editing" button
        PicsArtUserPage userPage = new PicsArtUserPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(userPage.startEditingButton));
        userPage.startEditingButton.click();

        //6.2.Select the "Remove Background" filter
        PicsArtEditingToolsPage toolsPage = new PicsArtEditingToolsPage(driver);
        wait.until(ExpectedConditions.visibilityOf(toolsPage.removeBackgroundFilter));
        toolsPage.removeBackgroundFilter.click();

        //6.3.Select one of the suggested images
        PicsArtUploadSelectImagePage uploadImage = new PicsArtUploadSelectImagePage(driver);
        wait.until(ExpectedConditions.visibilityOf(uploadImage.randomImage));
        uploadImage.randomImage.click();

        //6.4.Click the "Share" button
        PicsArtRemoveBackgroundEditingPage removeBackgroundPage = new PicsArtRemoveBackgroundEditingPage(driver);
        wait.until(ExpectedConditions.visibilityOf(removeBackgroundPage.shareButton));
        removeBackgroundPage.shareButton.click();

        //validate that the Pop-up is displayed
        wait.until(ExpectedConditions.visibilityOf(removeBackgroundPage.postButton));
        wait.until(ExpectedConditions.visibilityOf(removeBackgroundPage.popUpTitle));
        Assert.assertTrue(removeBackgroundPage.postButton.isDisplayed() && removeBackgroundPage.popUpTitle.isDisplayed());

        //6.5.Click the "Post" button
        wait.until(ExpectedConditions.visibilityOf(removeBackgroundPage.postButton));
        removeBackgroundPage.postButton.click();

        //validate that the success message is diplayed
        wait.until(ExpectedConditions.visibilityOf(removeBackgroundPage.successfullypostedMessage));
        Assert.assertTrue(removeBackgroundPage.successfullypostedMessage.isDisplayed());

    }

    @Test
    public void testGoToToolsBtn() {
        //Test Case ID:7
        //Given that the user is on the "Editing Tools" page
        //when the user selects the "Remove Background" filter, selects one of the images, edits it, clicks on the "Share" button, clicks on the "Post" button, gets the "Successfully Posted" message and clicks the "Go to Tools" button
        //then the user redirects to the "Editing Tools" page


        //Login with correct credentials -- Done in PicsArtBaseTest
        //7.1.Click the "Start Editing" button
        PicsArtUserPage userPage = new PicsArtUserPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(userPage.startEditingButton));
        userPage.startEditingButton.click();

        //7.2.Select the "Remove Background" filter
        PicsArtEditingToolsPage toolsPage = new PicsArtEditingToolsPage(driver);
        wait.until(ExpectedConditions.visibilityOf(toolsPage.removeBackgroundFilter));
        toolsPage.removeBackgroundFilter.click();

        //7.3.Select one of the suggested images
        PicsArtUploadSelectImagePage uploadImage = new PicsArtUploadSelectImagePage(driver);
        wait.until(ExpectedConditions.visibilityOf(uploadImage.randomImage));
        uploadImage.randomImage.click();

        //7.4.Click the "Share" button
        PicsArtRemoveBackgroundEditingPage removeBackgroundPage = new PicsArtRemoveBackgroundEditingPage(driver);
        wait.until(ExpectedConditions.visibilityOf(removeBackgroundPage.shareButton));
        removeBackgroundPage.shareButton.click();

        //7.5.Click the "Post" button
        wait.until(ExpectedConditions.visibilityOf(removeBackgroundPage.postButton));
        removeBackgroundPage.postButton.click();

        //validate that the success message is diplayed
        wait.until(ExpectedConditions.visibilityOf(removeBackgroundPage.successfullypostedMessage));
        Assert.assertTrue(removeBackgroundPage.successfullypostedMessage.isDisplayed());

        //7.6.Click the "Go to Tools" button
        wait.until(ExpectedConditions.visibilityOf(removeBackgroundPage.goToToolsBtn));
        removeBackgroundPage.goToToolsBtn.click();

        //validate that the Editing Tools page is displayed
        wait.until(ExpectedConditions.visibilityOf(toolsPage.editingToolsPageTitle));
        Assert.assertTrue(toolsPage.editingToolsPageTitle.isDisplayed());

    }
}
