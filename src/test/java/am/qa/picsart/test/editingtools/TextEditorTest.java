package am.qa.picsart.test.editingtools;

import am.qa.picsart.pages.editingtools.EditingToolsPage;
import am.qa.picsart.pages.editingtools.TextEditorPage;
import am.qa.picsart.pages.editingtools.UploadSelectImagePage;
import am.qa.picsart.pages.user.PicsArtUserPage;
import am.qa.picsart.test.base.PicsArtBaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;

public class TextEditorTest extends PicsArtBaseTest {

    @Test
    public void testTextEditor() throws InterruptedException {
        //Test Case ID:37
        //Given that the user is on the "Editing Tools" page,
        //when the user clicks on the "Text Editor" and Chooses one of the random images,
        //then the "Text" and "Click to add text" options are available

        //Login with correct credentials -- Done in PicsArtBaseTest
        //click on the "Start Editing" button
        PicsArtUserPage userPage = new PicsArtUserPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(userPage.startEditingButton));
        userPage.startEditingButton.click();

        //37.1.Click on the "Text Editor"
        EditingToolsPage editingToolsPage = new EditingToolsPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(editingToolsPage.textEditor));
        editingToolsPage.textEditor.click();

        //validate that the "Upload your image" option is displayed
        UploadSelectImagePage uploadImage = new UploadSelectImagePage(driver);
        wait.until(ExpectedConditions.visibilityOf(uploadImage.uploadYourImageOption));
        Assert.assertTrue(uploadImage.uploadYourImageOption.isDisplayed());

        //37.2.Choose one of the images
        wait.until(ExpectedConditions.elementToBeClickable(uploadImage.randomImage));
        uploadImage.randomImage.click();

        //validate that the "Text" category is displayed
        TextEditorPage textEditorPage = new TextEditorPage(driver);
        wait.until(ExpectedConditions.visibilityOf(textEditorPage.textCategory));
        Assert.assertTrue(textEditorPage.textCategory.isDisplayed());

        //click on the "Click to add text" option
        wait.until(ExpectedConditions.elementToBeClickable(textEditorPage.clickToAddText));
        textEditorPage.clickToAddText.click();

        //validate that the "Click to add text" option is available and the "Add a heading",
        //"Add  a subheading" and "Add a body text" options are displayed
        Assert.assertTrue(textEditorPage.AddTextDropDownList.size() <= 3);
        System.out.println(textEditorPage.AddTextDropDownList.size());

        for (int i = 1; i <= textEditorPage.AddTextDropDownList.size(); i++) {
            if (i < 2) {
                String first = textEditorPage.addTextDropDownList(i);
                Assert.assertEquals(first, "Add a heading");

            } else if (i < 3) {
                String second = textEditorPage.addTextDropDownList(i+1);
                Assert.assertEquals(second, "Add a subheading");

            }
            else {
              String third = textEditorPage.addTextDropDownList(i+2);
                Assert.assertEquals(third, "Add a body text");

            }
        }
    }
}
