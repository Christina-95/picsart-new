package am.qa.picsart.pages.search;

import am.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PicsArtSearchPage extends PicsArtBasePage {

    public PicsArtSearchPage(WebDriver driver) {
        super(driver);
    }

    protected final String ALL_LINK = "//a[@data-js-ga-click='search select-category all']";
    protected final String STICKERS_LINK = "//a[@data-js-ga-click='search select-category stickers']";
    protected final String IMAGES_LINK = "//a[@data-js-ga-click='search select-category images']";
    protected final String HASHTAGS_LINK = "//a[@data-js-ga-click='search select-category tags']";
    protected final String ARTISTS_LINK = "//a[@data-js-ga-click='search select-category artists']";
    protected final String NATURE_HASHTAG = "(//span[contains(text(),'nature')])[1]";



    @FindBy (xpath = ALL_LINK)
    public  WebElement allLink;

    @FindBy (xpath = STICKERS_LINK)
    public WebElement stickersLink;

    @FindBy (xpath = IMAGES_LINK)
    public WebElement imagesLink;

    @FindBy (xpath = HASHTAGS_LINK)
    public WebElement hashtagLink;
    
    @FindBy (xpath = ARTISTS_LINK)
    public WebElement artistsLink;

    @FindBy (xpath = NATURE_HASHTAG)
    public WebElement natureHashtag;
}