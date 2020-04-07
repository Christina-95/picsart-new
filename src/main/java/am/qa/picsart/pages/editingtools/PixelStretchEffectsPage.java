package am.qa.picsart.pages.editingtools;

import am.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PixelStretchEffectsPage extends PicsArtBasePage {

    public PixelStretchEffectsPage(WebDriver driver) {
        super(driver);
    }

    protected final String STRETCH_CATEGORY = "//div[@id='runout-category']";
    protected final String SHARE_OPTION = "//span[contains(.,'Share')]";
    protected final String DOWNLOAD_OPTION = "//i[@class='icon-download']";
    protected final String STRETCH_FILTER1 = "//div[@class='itemOverlay-0-2-171']";
    protected final String POST_BUTTON = "//button[contains(.,'Post')]";
    protected final String PUBLIC_BUTTON = "//button[@type='button']";
    protected final String GO_TO_TOOLS_BUTTON = "//p[@class='anotherToolText-0-2-24'][contains(text(),'Go to Tools')]";

    @FindBy (xpath = STRETCH_CATEGORY)
    public WebElement stretchCategory;

    @FindBy (xpath = SHARE_OPTION)
    public WebElement shareOption;

    @FindBy (xpath = DOWNLOAD_OPTION)
    public WebElement downloadOption;

    @FindBy (xpath = STRETCH_FILTER1)
    public WebElement stretchFilter1;

    @FindBy (xpath = POST_BUTTON)
    public WebElement postButton;

    @FindBy (xpath = PUBLIC_BUTTON)
    public WebElement publicButton;

    @FindBy (xpath = GO_TO_TOOLS_BUTTON)
    public WebElement goToToolsButton;



}
