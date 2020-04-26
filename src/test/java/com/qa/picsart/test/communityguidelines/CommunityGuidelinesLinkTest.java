package com.qa.picsart.test.communityguidelines;

import com.qa.picsart.pages.communityguidelines.CommunityGuidelinesPage;
import com.qa.picsart.pages.disputepolicy.CopyrightDisputePolicyPage;
import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.BaseLoginTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CommunityGuidelinesLinkTest extends BaseLoginTest {

     private PicsArtUserPage userPage;
     private WebDriverWait wait;
     private CommunityGuidelinesPage communityGuidelinesPage;
     private CopyrightDisputePolicyPage copyrightDisputePolicyPage;


     @BeforeClass
     public void start() {
          userPage = new PicsArtUserPage(driver);
          wait = new WebDriverWait(driver, 30);
          communityGuidelinesPage = new CommunityGuidelinesPage(driver);
          copyrightDisputePolicyPage = new CopyrightDisputePolicyPage(driver);
     }

    @Test
   public void testCommunityGuidelinesLink () {
        //Test Case ID:22
        // Given that the user is authenticated
        // when the user clicks on the "Community Guidelines" link and clicks on the "here" link
        // then the "COPYRIGHT DISPUTE POLICY" page is displayed

        //Login with correct credentials -- Done in PicsArtBaseTest
        //22.1.Click in the "Community Guidelines" link
        wait.until(ExpectedConditions.elementToBeClickable(userPage.communityGuidelinesLink));
        userPage.communityGuidelinesLink.click();

        //validate that the Community Guidelines" page is displayed
        wait.until(ExpectedConditions.visibilityOf(communityGuidelinesPage.communityGuidelinesTitle));
        Assert.assertTrue(communityGuidelinesPage.communityGuidelinesTitle.isDisplayed());

        //22.2.Click on the "here" link
        wait.until(ExpectedConditions.elementToBeClickable(communityGuidelinesPage.hereLink));
        communityGuidelinesPage.hereLink.click();

        //validate that the "COPYRIGHT DISPUTE POLICY" page is displayed
        driver.get("https://picsart.com/copyright-dispute-policy");
        wait.until(ExpectedConditions.visibilityOf(copyrightDisputePolicyPage.copirightDisputePolicyTitle));
        Assert.assertTrue(copyrightDisputePolicyPage.copirightDisputePolicyTitle.isDisplayed());
    }
}
