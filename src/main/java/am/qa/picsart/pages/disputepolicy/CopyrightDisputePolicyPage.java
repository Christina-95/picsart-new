package am.qa.picsart.pages.disputepolicy;

import am.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CopyrightDisputePolicyPage extends PicsArtBasePage {
    public CopyrightDisputePolicyPage(WebDriver driver) {
        super(driver);
    }

    protected final String COPYRIGHT_DISPUTE_POLICY_TITLE = "//h1[contains(text(),'Copyright Dispute Policy')]";

    @FindBy (xpath = COPYRIGHT_DISPUTE_POLICY_TITLE)
    public WebElement copirightDisputePolicyTitle;
}
