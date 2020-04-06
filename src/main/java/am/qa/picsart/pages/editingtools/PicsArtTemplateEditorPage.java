package am.qa.picsart.pages.editingtools;

import am.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PicsArtTemplateEditorPage extends PicsArtBasePage {

    public PicsArtTemplateEditorPage(WebDriver driver) {
        super(driver);
    }

    protected final String TEMPLATES_CATEGORY = "//div[@id='templates-category']";
    protected final String PHOTOS_CATEGORY = "//div[@id='photos-category']";
    protected final String STICKERS_CATEGORY = "//div[@id='stickers-category']";
    protected final String TEXT_CATEGORY = "//i[@class='icon-text-icon']";
    protected final String SHAPE_CATEGORY = "//div[@id='elements-category']";
    protected final String OVERLAYS_CATEGORY = "//i[@class='icon-overlay']";

    @FindBy (xpath = TEMPLATES_CATEGORY)
    public WebElement templateCategory;

    @FindBy (xpath = PHOTOS_CATEGORY)
    public WebElement photosCategory;

    @FindBy (xpath = STICKERS_CATEGORY)
    public WebElement stickersCategory;

    @FindBy (xpath = TEXT_CATEGORY)
    public WebElement textCategory;

    @FindBy (xpath = SHAPE_CATEGORY)
    public WebElement shapeCategory;

    @FindBy (xpath = OVERLAYS_CATEGORY)
    public WebElement overlaysCategory;
}
