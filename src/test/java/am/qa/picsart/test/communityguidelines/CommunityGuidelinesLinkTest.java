package am.qa.picsart.test.communityguidelines;

import am.qa.picsart.pages.communityguidelines.PicsArtCommunityGuidelinesPage;
import am.qa.picsart.pages.disputepolicy.PicsArtCopyrightDisputePolicyPage;
import am.qa.picsart.pages.user.PicsArtUserPage;
import am.qa.picsart.test.base.PicsArtBaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CommunityGuidelinesLinkTest extends PicsArtBaseTest {

    @Test
   public void testCommunityGuidelinesLink () {
        //Test Case ID:22
        // Given that the user is authenticated
        // when the user clicks on the "Community Guidelines" link and clicks on the "here" link
        // then the "COPYRIGHT DISPUTE POLICY" page is displayed

        //Login with correct credentials -- Done in PicsArtBaseTest
        //22.1.Click in the "Community Guidelines" link
        PicsArtUserPage userPage = new PicsArtUserPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(userPage.communityGuidelinesLink));
        userPage.communityGuidelinesLink.click();

        //validate that the Community Guidelines" page is displayed
        PicsArtCommunityGuidelinesPage communityGuidelinesPage = new PicsArtCommunityGuidelinesPage(driver);
        wait.until(ExpectedConditions.visibilityOf(communityGuidelinesPage.communityGuidelinesTitle));
        Assert.assertTrue(communityGuidelinesPage.communityGuidelinesTitle.isDisplayed());

        //22.2.Click on the "here" link
        wait.until(ExpectedConditions.elementToBeClickable(communityGuidelinesPage.hereLink));
        communityGuidelinesPage.hereLink.click();

        //validate that the "COPYRIGHT DISPUTE POLICY" page is displayed
        driver.get("https://picsart.com/copyright-dispute-policy");
        PicsArtCopyrightDisputePolicyPage copyrightDisputePolicyPage = new PicsArtCopyrightDisputePolicyPage(driver);
        wait.until(ExpectedConditions.visibilityOf(copyrightDisputePolicyPage.copirightDisputePolicyTitle));
        Assert.assertTrue(copyrightDisputePolicyPage.copirightDisputePolicyTitle.isDisplayed());
    }
}
