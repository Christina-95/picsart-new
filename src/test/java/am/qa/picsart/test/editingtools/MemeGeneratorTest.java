package am.qa.picsart.test.editingtools;

import am.qa.picsart.pages.editingtools.EditingToolsPage;
import am.qa.picsart.pages.editingtools.MemeGeneratorPage;
import am.qa.picsart.pages.editingtools.MemeGeneratorSelectTemplatePage;
import am.qa.picsart.pages.user.PicsArtUserPage;
import am.qa.picsart.test.base.PicsArtBaseTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MemeGeneratorTest extends PicsArtBaseTest {

    @Test
    public void testMemeGenerator() throws InterruptedException {
        //Test Case ID:38
        //Given that the user is on the "Editing Tools" page,
        //when the user clicks on the "Meme Generator" and Chooses one of the random templates,
        //then the "Photo", "Text", "Shape" and "Adjust" options are available


        //Login with correct credentials -- Done in PicsArtBaseTest
        //click on the "Start Editing" button
        PicsArtUserPage userPage = new PicsArtUserPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(userPage.startEditingButton));
        userPage.startEditingButton.click();

        //38.1.Click on the "Meme Generator"
        EditingToolsPage editingToolsPage = new EditingToolsPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(editingToolsPage.memeGenerator));
        editingToolsPage.memeGenerator.click();

        //38.2.Choose one of the templates
        MemeGeneratorSelectTemplatePage templatePage = new MemeGeneratorSelectTemplatePage(driver);
        templatePage.clickOnRandomTemplate();

        //validate that when the "Photo" category is enabled the "Use your image" and suggested photos are displayed
        MemeGeneratorPage memePage = new MemeGeneratorPage(driver);
        wait.until(ExpectedConditions.visibilityOf(memePage.photoCategory));
        Assert.assertTrue(memePage.photoCategory.isDisplayed());
        Thread.sleep(1000);
        Assert.assertEquals(memePage.uploadYourImage(), "Use your image");
        Assert.assertTrue(memePage.suggestedImages.size()<=48);

        //validate that the "Text" category is displayed and the "Click to add text" option is available
        Assert.assertTrue(memePage.textCategory.isDisplayed());
        memePage.textCategory.click();
        wait.until(ExpectedConditions.elementToBeClickable(memePage.clickToAddText));
        memePage.clickToAddText.click();
        Assert.assertTrue(memePage.AddTextDropDownList.size() <= 3);
        System.out.println(memePage.AddTextDropDownList.size());

        for (int i = 1; i <= memePage.AddTextDropDownList.size(); i++) {
            if (i <2) {
                String first = memePage.addTextDropDownList(i);
                Assert.assertEquals(first, "Add a heading");

            } else if (i<3) {
                String second = memePage.addTextDropDownList(i+1);
                Assert.assertEquals(second, "Add a subheading");

            }
            else {
                String third = memePage.addTextDropDownList(i+2);
                Assert.assertEquals(third, "Add a body text");
            }
        }

        //validate that when the "Adjust" option is clicked
        //then the "Saturation", "Brightness", "Contrast", "Zoom" and "Rotate" options are available
        wait.until(ExpectedConditions.elementToBeClickable(memePage.adjustOption));
        memePage.adjustOption.click();
        Assert.assertTrue(memePage.adjustOptionsList.size()<=5);
        for (int i = 1; i < memePage.adjustOptionsList.size(); i++) {
            if (i<2) {
                Assert.assertEquals(memePage.adjustOptions(i),"Saturation\n" + "0");
            }
            else if (i<3) {
                Assert.assertEquals(memePage.adjustOptions(i+1),"Brightness\n" + "0");
            }
            else if (i<4) {
                Assert.assertEquals(memePage.adjustOptions(i+2),"Contrast\n" + "0");
            }
            else if (i<5) {
                Assert.assertEquals(memePage.adjustOptions(i+3),"Zoom\n" + "0");
            }
            else {
                Assert.assertEquals(memePage.adjustOptions(i+4),"Rotate\n" + "0");
            }
        }
    }
}
