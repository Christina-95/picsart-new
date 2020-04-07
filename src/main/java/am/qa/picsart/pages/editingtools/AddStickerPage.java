package am.qa.picsart.pages.editingtools;

import am.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddStickerPage extends PicsArtBasePage {
    public AddStickerPage(WebDriver driver) {
        super(driver);
    }

    protected final String STICKERS_CATEGORY = "//i[@class='icon-sticker']";
    protected final String SEARCH_STICKERS_OPTION = "//input[@type='text']";


    @FindBy (xpath = STICKERS_CATEGORY)
    public WebElement stickersCategory;

    @FindBy (xpath = SEARCH_STICKERS_OPTION)
    public WebElement searchStickersOption;
}
