package am.qa.picsart.test.editingtools;

import am.qa.picsart.pages.editingtools.EditingToolsPage;
import am.qa.picsart.pages.editingtools.LightEffectsPage;
import am.qa.picsart.pages.editingtools.UploadSelectImagePage;
import am.qa.picsart.pages.user.PicsArtUserPage;
import am.qa.picsart.test.base.PicsArtBaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LightEffectsTest extends PicsArtBaseTest {

    @Test
    public void testLightEffects() {
        //Test Case ID:34
        //Given that the user is on the "Editing Tools" page,
        //when the user clicks on the "Light Effects",
        //Chooses one of the random images and clicks on one of the "LighFilter",
        //then the "Adjust" and "Blend" options are available

        //Login with correct credentials -- Done in PicsArtBaseTest
        //click on the "Start Editing" button
        PicsArtUserPage userPage = new PicsArtUserPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(userPage.startEditingButton));
        userPage.startEditingButton.click();

        //34.1.Click on the "Light Effects"
        EditingToolsPage editingToolsPage = new EditingToolsPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(editingToolsPage.lightEffects));
        editingToolsPage.lightEffects.click();

        //34.2.Choose one of the images
        UploadSelectImagePage uploadImage = new UploadSelectImagePage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(uploadImage.randomImage));
        uploadImage.randomImage.click();

        //validate that the "Effects" category is displayed
        LightEffectsPage lightEffectsPage = new LightEffectsPage(driver);
        wait.until(ExpectedConditions.visibilityOf(lightEffectsPage.effectsCategory));
        Assert.assertTrue(lightEffectsPage.effectsCategory.isDisplayed());

        //34.3.Choose one of the "LighFilter" options
        wait.until(ExpectedConditions.elementToBeClickable(lightEffectsPage.lightFilter1));
        lightEffectsPage.lightFilter1.click();

        //validate that the "Adjust" and "Blend" categories are displayed
        wait.until(ExpectedConditions.visibilityOf(lightEffectsPage.adjustCategory));
        Assert.assertTrue(lightEffectsPage.adjustCategory.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(lightEffectsPage.blendCategory));
        Assert.assertTrue(lightEffectsPage.blendCategory.isDisplayed());
    }
}