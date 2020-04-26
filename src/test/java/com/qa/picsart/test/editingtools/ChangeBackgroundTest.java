package com.qa.picsart.test.editingtools;

import com.qa.picsart.pages.editingtools.ChangeBackgroundPage;
import com.qa.picsart.pages.editingtools.EditingToolsPage;
import com.qa.picsart.pages.editingtools.UploadSelectImagePage;
import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.BaseLoginTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeBackgroundTest extends BaseLoginTest {

    @Test
    public void testChangeBackground() {
        //Test Case ID:31
        //Given that the user is on the "Editing Tools" page,
        //when the user clicks on the "Change Background" and Chooses one of the random images,
        //then the "Canvas", "Color", "Gradient" and "Texture" categories are  available

        //Login with correct credentials -- Done in PicsArtBaseTest
        //click on the "Start Editing" button
        PicsArtUserPage userPage = new PicsArtUserPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(userPage.startEditingButton));
        userPage.startEditingButton.click();

        //31.1.Click on the "Change Background"
        EditingToolsPage editingToolsPage = new EditingToolsPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(editingToolsPage.changeBackground));
        editingToolsPage.changeBackground.click();

        //31.2.Choose one of the images
        UploadSelectImagePage uploadImage = new UploadSelectImagePage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(uploadImage.randomImage));
        uploadImage.randomImage.click();

        //31.3.Click the "Canvas"
        ChangeBackgroundPage changeBackgroundPage = new ChangeBackgroundPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(changeBackgroundPage.canvasCategory));
        changeBackgroundPage.canvasCategory.click();

        //validate that the "Width" and "Height" are displayed
        wait.until(ExpectedConditions.visibilityOf(changeBackgroundPage.widthOption));
        Assert.assertTrue(changeBackgroundPage.widthOption.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(changeBackgroundPage.heightOption));
        Assert.assertTrue(changeBackgroundPage.heightOption.isDisplayed());

        //31.4.Click on the "Color"
        wait.until(ExpectedConditions.elementToBeClickable(changeBackgroundPage.colorCategory));
        changeBackgroundPage.colorCategory.click();

        //validate that the color gradient is displayed
        wait.until(ExpectedConditions.visibilityOf(changeBackgroundPage.colorGradient));
        Assert.assertTrue(changeBackgroundPage.colorGradient.isDisplayed());

        //31.5.Click on the "Gradient"
        wait.until(ExpectedConditions.elementToBeClickable(changeBackgroundPage.gradientCategory));
        changeBackgroundPage.gradientCategory.click();

        //validate that the gradient is displayed
        wait.until(ExpectedConditions.visibilityOf(changeBackgroundPage.gradientPicker));
        Assert.assertTrue(changeBackgroundPage.gradientPicker.isDisplayed());

        //31.6.Click on the "Texture"
        wait.until(ExpectedConditions.elementToBeClickable(changeBackgroundPage.textureCategory));
        changeBackgroundPage.textureCategory.click();

        //validate that the "Use your image" option is displayed
        wait.until(ExpectedConditions.visibilityOf(changeBackgroundPage.userYourImageOption));
        Assert.assertTrue(changeBackgroundPage.userYourImageOption.isDisplayed());
    }
}
