package am.qa.picsart.pages.editingtools;

import am.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PicsArtPixelStretchEffectsPage extends PicsArtBasePage {

    public PicsArtPixelStretchEffectsPage(WebDriver driver) {
        super(driver);
    }

    protected final String STRETCH_CATEGORY = "";
    protected final String SHARE_OPTION = "";
    protected final String DOWNLOAD_OPTION = "";

    @FindBy (xpath = STRETCH_CATEGORY)
    public WebElement stretchCategory;

    @FindBy (xpath = SHARE_OPTION)
    public WebElement shareOption;

    @FindBy (xpath = DOWNLOAD_OPTION)
    public WebElement downloadOption;
}
