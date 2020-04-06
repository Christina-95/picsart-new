package am.qa.picsart.test.editingtools;

import am.qa.picsart.pages.editingtools.PicsArtEditingToolsPage;
import am.qa.picsart.pages.editingtools.PicsArtPixelStretchEffectsPage;
import am.qa.picsart.pages.editingtools.PicsArtUploadSelectImagePage;
import am.qa.picsart.pages.user.PicsArtUserPage;
import am.qa.picsart.test.base.PicsArtBaseTest;
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
        PicsArtEditingToolsPage editingToolsPage = new PicsArtEditingToolsPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(editingToolsPage.pixelStretchEffects));
        editingToolsPage.pixelStretchEffects.click();

        //29.2.Choose on of the random images
        PicsArtUploadSelectImagePage uploadImage = new PicsArtUploadSelectImagePage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(uploadImage.randomImage));
        uploadImage.randomImage.click();

        //validate that the "Stretch" category, and "Share" , "Download"  options are  displayed
        PicsArtPixelStretchEffectsPage pixelStretchEffectsPage = new PicsArtPixelStretchEffectsPage(driver);
        wait.until(ExpectedConditions.visibilityOf(pixelStretchEffectsPage.stretchCategory));
        Assert.assertTrue(pixelStretchEffectsPage.stretchCategory.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(pixelStretchEffectsPage.shareOption));
        Assert.assertTrue(pixelStretchEffectsPage.shareOption.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(pixelStretchEffectsPage.downloadOption));
        Assert.assertTrue(pixelStretchEffectsPage.downloadOption.isDisplayed());

    }
}
