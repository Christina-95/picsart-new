package com.qa.picsart.pages.communityguidelines;

import com.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommunityGuidelinesPage extends PicsArtBasePage {
    public CommunityGuidelinesPage(WebDriver driver) {
        super(driver);
    }

    protected final String HERE_LINK = "//a[@href='//picsart.com/copyright-dispute-policy']";
    protected final String COMMUNITY_GUIDELINES_TITLE = "//h1[contains(text(),'OUR COMMUNITY GUIDELINES.')]";

    @FindBy (xpath = HERE_LINK)
    public WebElement hereLink;

    @FindBy (xpath = COMMUNITY_GUIDELINES_TITLE)
    public WebElement communityGuidelinesTitle;
}
