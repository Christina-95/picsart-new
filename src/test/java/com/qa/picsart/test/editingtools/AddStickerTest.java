package com.qa.picsart.test.editingtools;

import com.qa.picsart.pages.editingtools.AddStickerPage;
import com.qa.picsart.pages.editingtools.EditingToolsPage;
import com.qa.picsart.pages.editingtools.UploadSelectImagePage;
import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.PicsArtBaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddStickerTest extends PicsArtBaseTest {

    @Test
    public void testAddSticker() {
        //Test Case ID:32
        //Given that the user is on the "Editing Tools" page,
        //when the user clicks on the "Add Sticker" and Chooses one of the random images,
        //then the "Search stickers" option is available

        //Login with correct credentials -- Done in PicsArtBaseTest
        //click on the "Start Editing" button
        PicsArtUserPage userPage = new PicsArtUserPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(userPage.startEditingButton));
        userPage.startEditingButton.click();

        //32.1.Click on the "Add Sticker"
        EditingToolsPage editingToolsPage = new EditingToolsPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(editingToolsPage.addSticker));
        editingToolsPage.addSticker.click();

        //32.2.Choose one of the images
        UploadSelectImagePage uploadImage = new UploadSelectImagePage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(uploadImage.randomImage));
        uploadImage.randomImage.click();

        //32.3.Click on the "Sticker" option
        AddStickerPage addStickerPage = new AddStickerPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(addStickerPage.stickersCategory));
        addStickerPage.stickersCategory.click();

        //validate that the "Search stickers" option is displayed
        wait.until(ExpectedConditions.elementToBeClickable(addStickerPage.searchStickersOption));
        Assert.assertTrue(addStickerPage.searchStickersOption.isDisplayed());

    }
}
