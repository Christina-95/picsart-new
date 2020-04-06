package am.qa.picsart.pages.editingtools;

import am.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PicsArtPixelStretchEffectsPage extends PicsArtBasePage {

    public PicsArtPixelStretchEffectsPage(WebDriver driver) {
        super(driver);
    }

    protected final String STRETCH_CATEGORY = "//div[@id='runout-category']";
    protected final String SHARE_OPTION = "//span[contains(.,'Share')]";
    protected final String DOWNLOAD_OPTION = "//i[@class='icon-download']";

    @FindBy (xpath = STRETCH_CATEGORY)
    public WebElement stretchCategory;

    @FindBy (xpath = SHARE_OPTION)
    public WebElement shareOption;

    @FindBy (xpath = DOWNLOAD_OPTION)
    public WebElement downloadOption;
}
