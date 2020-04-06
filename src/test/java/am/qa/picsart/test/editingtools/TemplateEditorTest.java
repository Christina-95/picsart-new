package am.qa.picsart.test.editingtools;

import am.qa.picsart.pages.editingtools.PicsArtEditingToolsPage;
import am.qa.picsart.pages.editingtools.PicsArtTemplateEditorPage;
import am.qa.picsart.pages.editingtools.PicsArtUploadSelectImagePage;
import am.qa.picsart.pages.user.PicsArtUserPage;
import am.qa.picsart.test.base.PicsArtBaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TemplateEditorTest extends PicsArtBaseTest {

    @Test
    public void testTemplateEditor() {
        //Test Case ID:28
        //Given that the user is on the "Editing Tools" page,
        //when the user clicks on the "Template Editor" and Chooses one of the random images,
        //then the "Templates", "Photo", "Stickers", "Text", "Shape" and "Overlays" categories are displayed in the left side of the photo


        //Login with correct credentials -- Done in PicsArtBaseTest
        //click on the "Start Editing" button
        PicsArtUserPage userPage = new PicsArtUserPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(userPage.startEditingButton));
        userPage.startEditingButton.click();

        //28.1.Click on the "Template Editor"
        PicsArtEditingToolsPage editingToolsPage = new PicsArtEditingToolsPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(editingToolsPage.templateEditor));
        editingToolsPage.templateEditor.click();

        //28.2.Choose one of the images
        PicsArtUploadSelectImagePage uploadImage = new PicsArtUploadSelectImagePage(driver);
        wait.until(ExpectedConditions.visibilityOf(uploadImage.randomImage));
        uploadImage.randomImage.click();

        //validate that the "Templates", "Photo", "Stickers", "Text", "Shape" and "Overlays" categories are displayed
        PicsArtTemplateEditorPage templateEditorPage = new PicsArtTemplateEditorPage(driver);
        wait.until(ExpectedConditions.visibilityOf(templateEditorPage.templateCategory));
        Assert.assertTrue(templateEditorPage.templateCategory.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(templateEditorPage.photosCategory));
        Assert.assertTrue(templateEditorPage.photosCategory.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(templateEditorPage.stickersCategory));
        Assert.assertTrue(templateEditorPage.stickersCategory.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(templateEditorPage.textCategory));
        Assert.assertTrue(templateEditorPage.textCategory.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(templateEditorPage.shapeCategory));
        Assert.assertTrue(templateEditorPage.shapeCategory.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(templateEditorPage.overlaysCategory));
        Assert.assertTrue(templateEditorPage.overlaysCategory.isDisplayed());
    }
}
