package am.qa.picsart.test.editingtools;

import am.qa.picsart.pages.editingtools.EditingToolsPage;
import am.qa.picsart.pages.editingtools.PhotoOverlaysPage;
import am.qa.picsart.pages.editingtools.UploadSelectImagePage;
import am.qa.picsart.pages.user.PicsArtUserPage;
import am.qa.picsart.test.base.PicsArtBaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PhotoOverlaysTest extends PicsArtBaseTest {

    @Test
    public void testPhotoOverlays() throws InterruptedException {
        //Test Case ID:36
        //Given that the user is on the "Editing Tools" page,
        //when the user clicks on the "Photo Overlays" and Chooses one of the random images,
        //then the "More" and "Back" options are available for each category


        //Login with correct credentials -- Done in PicsArtBaseTest
        //click on the "Start Editing" button
        PicsArtUserPage userPage = new PicsArtUserPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.elementToBeClickable(userPage.startEditingButton));
        userPage.startEditingButton.click();

        //36.1.Click on the "Photo Overlays"
        EditingToolsPage editingToolsPage = new EditingToolsPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(editingToolsPage.photoOverlays));
        editingToolsPage.photoOverlays.click();

        //36.2.Choose one of the images
        UploadSelectImagePage uploadImage = new UploadSelectImagePage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(uploadImage.randomImage));
        uploadImage.randomImage.click();

        //validate that the "More" option is displayed for each category
        Thread.sleep(2000);
        PhotoOverlaysPage photoOverlaysPage = new PhotoOverlaysPage(driver);
        Assert.assertTrue(photoOverlaysPage.moreOptions.size()<=8);

        //36.3.Click on the "More" option
        for (int i = 0; i < photoOverlaysPage.moreOptions.size(); i++) {
            if(i < 4) {
                photoOverlaysPage.clickOnTheMoreOption(i+1);
            }
            else {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("javascript:window.scrollBy(250,350)");
                photoOverlaysPage.clickOnTheMoreOption(i+1);
            }
            //validate that when the More option is clicked then the "Back" option is displayed
            wait.until(ExpectedConditions.visibilityOf(photoOverlaysPage.backOption));
            Assert.assertTrue(photoOverlaysPage.backOption.isDisplayed());
        }
    }
}