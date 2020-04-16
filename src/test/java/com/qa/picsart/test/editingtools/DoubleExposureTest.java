package com.qa.picsart.test.editingtools;

import com.qa.picsart.pages.editingtools.DoubleExposurePage;
import com.qa.picsart.pages.editingtools.DoubleExposureUploadImagePage;
import com.qa.picsart.pages.editingtools.EditingToolsPage;
import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.PicsArtBaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleExposureTest extends PicsArtBaseTest {

    @Test
    public void testDoubleExposure() throws InterruptedException {
        //Test Case ID:35
        //Given that the user is on the "Editing Tools" page,
        //when the user clicks on the "Double Exposure",
        //Chooses two random images and clicks on the "Next" button,
        //then the "None","DXP1" ..... "DXP19" options are available


        //Login with correct credentials -- Done in PicsArtBaseTest
        //click on the "Start Editing" button
        PicsArtUserPage userPage = new PicsArtUserPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(userPage.startEditingButton));
        userPage.startEditingButton.click();

        //35.1.Click on the "Double Exposure"
        EditingToolsPage editingToolsPage = new EditingToolsPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(editingToolsPage.doubleExposure));
        editingToolsPage.doubleExposure.click();

        //35.2.Choose two images and click on the "Next" button
        DoubleExposureUploadImagePage doubleExposureUploadImage = new DoubleExposureUploadImagePage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(doubleExposureUploadImage.randomImage1));
        doubleExposureUploadImage.randomImage1.click();
        wait.until(ExpectedConditions.elementToBeClickable(doubleExposureUploadImage.randomImage2));
        doubleExposureUploadImage.randomImage2.click();
        wait.until(ExpectedConditions.elementToBeClickable(doubleExposureUploadImage.nextButton));
        doubleExposureUploadImage.nextButton.click();

        //validate that the "None", "DXP1", ......."DXP19" options are displayed
        DoubleExposurePage doubleExposurePage = new DoubleExposurePage(driver);
        Thread.sleep(2000);
        Assert.assertTrue(doubleExposurePage.filtersCount());
    }
}

