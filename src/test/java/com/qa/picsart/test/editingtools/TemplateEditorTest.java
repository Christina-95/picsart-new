package com.qa.picsart.test.editingtools;

import com.qa.picsart.pages.editingtools.EditingToolsPage;
import com.qa.picsart.pages.editingtools.TemplateEditorPage;
import com.qa.picsart.pages.editingtools.UploadSelectImagePage;
import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.BaseLoginTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TemplateEditorTest extends BaseLoginTest {

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
        EditingToolsPage editingToolsPage = new EditingToolsPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(editingToolsPage.templateEditor));
        editingToolsPage.templateEditor.click();

        //28.2.Choose one of the images
        UploadSelectImagePage uploadImage = new UploadSelectImagePage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(uploadImage.randomImage));
        uploadImage.randomImage.click();

        //validate that the "Templates", "Photo", "Stickers", "Text", "Shape" and "Overlays" categories are displayed
        TemplateEditorPage templateEditorPage = new TemplateEditorPage(driver);
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
