package am.qa.picsart.test.editingtools;

import am.qa.picsart.pages.editingtools.EditingToolsPage;
import am.qa.picsart.pages.editingtools.SketchEffectsPage;
import am.qa.picsart.pages.editingtools.UploadSelectImagePage;
import am.qa.picsart.pages.user.PicsArtUserPage;
import am.qa.picsart.test.base.PicsArtBaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SketchEffectsTest extends PicsArtBaseTest {

    @Test
    public void testSketchEffects() {
        //Test Case ID:33
        //Given that the user is on the "Editing Tools" page,
        //when the user clicks on the "Sketch Effects" and Chooses one of the random images,
        //then the "Effects" option is available

        //Login with correct credentials -- Done in PicsArtBaseTest
        //click on the "Start Editing" button
        PicsArtUserPage userPage = new PicsArtUserPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(userPage.startEditingButton));
        userPage.startEditingButton.click();

        //33.1.Click on the "Sketch Effects"
        EditingToolsPage editingToolsPage = new EditingToolsPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(editingToolsPage.sketchEffects));
        editingToolsPage.sketchEffects.click();

        //33.2.Choose one of the images
        UploadSelectImagePage uploadImage = new UploadSelectImagePage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(uploadImage.randomImage));
        uploadImage.randomImage.click();

        //validate that the "None", "Sketch1", "Sketch2", "Sketch3" and "Sketch4" options are displayed
        SketchEffectsPage sketchEffectsPage = new SketchEffectsPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(sketchEffectsPage.noneOption));
        Assert.assertTrue(sketchEffectsPage.noneOption.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(sketchEffectsPage.sketch1Option));
        Assert.assertTrue(sketchEffectsPage.sketch1Option.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(sketchEffectsPage.sketch2Option));
        Assert.assertTrue(sketchEffectsPage.sketch2Option.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(sketchEffectsPage.sketch3Option));
        Assert.assertTrue(sketchEffectsPage.sketch3Option.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(sketchEffectsPage.sketch4Option));
        Assert.assertTrue(sketchEffectsPage.sketch4Option.isDisplayed());
    }
}
