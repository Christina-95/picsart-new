package am.qa.picsart.test.presscenter;

import am.qa.picsart.pages.presscenter.PicsArtPressCenterPage;
import am.qa.picsart.pages.user.PicsArtUserPage;
import am.qa.picsart.test.base.PicsArtBaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class PressCenterTest extends PicsArtBaseTest {

    @Test
    public void testPressKitButton() throws InterruptedException {
        //Test Case ID:25
        //Given that the user is authenticated
        //when the user clicks on the "About", clicks on the "Press Center" and clicks on the "Press Kit" button
        //then the "Dropbox-PicsArt Press Kit" page is displayed

        //Login with correct credentials -- Done in PicsArtBaseTest
        //25.1.Click on the "About" link and click on the "Press Center"
        PicsArtUserPage userPage = new PicsArtUserPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(userPage.aboutLink));
        userPage.aboutLink.click();
        wait.until(ExpectedConditions.elementToBeClickable(userPage.pressCenterLink));
        userPage.pressCenterLink.click();

        //validate that the "PRESS CENTER" page is displayed
        PicsArtPressCenterPage pressCenterPage = new PicsArtPressCenterPage(driver);
        wait.until(ExpectedConditions.visibilityOf(pressCenterPage.pressCenterTitle));
        Assert.assertTrue(pressCenterPage.pressCenterTitle.isDisplayed());

        //25.2.Click on the "Press Kit" button
        wait.until(ExpectedConditions.elementToBeClickable(pressCenterPage.pressKitButton));
        pressCenterPage.pressKitButton.click();

        //validate that the "Dropbox-PicsArt Press Kit" page is displayed
        String oldTab = driver.getWindowHandle();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));
        String URL = driver.getCurrentUrl();
        Thread.sleep(2000);
        Assert.assertEquals(URL, "https://www.dropbox.com/sh/u4cyf48ndwj4cjx/AACuF7SYjc9093XVCXl1VuOca?dl=0");

    }
}
