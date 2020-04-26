package com.qa.picsart.test.editingtools;

import com.qa.picsart.pages.editingtools.EditingToolsPage;
import com.qa.picsart.pages.editingtools.MemeGeneratorPage;
import com.qa.picsart.pages.editingtools.MemeGeneratorSelectTemplatePage;
import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.BaseLoginTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MemeGeneratorTest extends BaseLoginTest {

    private PicsArtUserPage userPage;
    private EditingToolsPage editingToolsPage;
    private MemeGeneratorSelectTemplatePage templatePage;
    private MemeGeneratorPage memePage;
    private WebDriverWait wait;


    @BeforeClass
    public void start() {
        userPage = new PicsArtUserPage(driver);
        editingToolsPage = new EditingToolsPage(driver);
        templatePage = new MemeGeneratorSelectTemplatePage(driver);
        memePage = new MemeGeneratorPage(driver);
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void testMemeGenerator() throws InterruptedException {
        //Test Case ID:38
        //Given that the user is on the "Editing Tools" page,
        //when the user clicks on the "Meme Generator" and Chooses one of the random templates,
        //then the "Photo", "Text", "Shape" and "Adjust" options are available


        //Login with correct credentials -- Done in PicsArtBaseTest
        //click on the "Start Editing" button
        wait.until(ExpectedConditions.elementToBeClickable(userPage.startEditingButton));
        userPage.startEditingButton.click();

        //38.1.Click on the "Meme Generator"
        wait.until(ExpectedConditions.elementToBeClickable(editingToolsPage.memeGenerator));
        editingToolsPage.memeGenerator.click();

        //38.2.Choose one of the templates
        templatePage.clickOnRandomTemplate();

        //validate that when the "Photo" category is enabled the "Use your image" and suggested photos are displayed
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

        for (int i = 0; i <= memePage.AddTextDropDownList.size(); i++) {
            if (i <2) {
                String first = memePage.addTextDropDownList(1);
                Assert.assertEquals(first, "Add a heading");

            } else if (i<3) {
                String second = memePage.addTextDropDownList(2);
                Assert.assertEquals(second, "Add a subheading");

            }
            else {
                String third = memePage.addTextDropDownList(3);
                Assert.assertEquals(third, "Add a body text");
            }
        }

        //validate that when the "Adjust" option is clicked
        //then the "Saturation", "Brightness", "Contrast", "Zoom" and "Rotate" options are available
        wait.until(ExpectedConditions.elementToBeClickable(memePage.adjustOption));
        memePage.adjustOption.click();
        Thread.sleep(2000);
        Assert.assertTrue(memePage.adjustOptionsList.size()<=5);
        for (int i = 0; i < memePage.adjustOptionsList.size(); i++) {
            if (i<2) {
                Assert.assertEquals(memePage.adjustOptions(1),"Saturation\n" + "0");
            }
            else if (i<3) {
                Assert.assertEquals(memePage.adjustOptions(2),"Brightness\n" + "0");
            }
            else if (i<4) {
                Assert.assertEquals(memePage.adjustOptions(3),"Contrast\n" + "0");
            }
            else if (i<5) {
                Assert.assertEquals(memePage.adjustOptions(4),"Zoom\n" + "0");
            }
            else {
                Assert.assertEquals(memePage.adjustOptions(5),"Rotate\n" + "0");
            }
        }
    }
}
