package am.qa.picsart.pages.blog;

import am.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PicsArtBlogPage extends PicsArtBasePage {
    public PicsArtBlogPage(WebDriver driver) {
        super(driver);
    }

    protected final String PICSART_JAPAN_LINK = "//a[contains(text(),'PicsArt Japan')]";
    protected final String PICSART_JAPAN_LINK = "";


    @FindBy (xpath = PICSART_JAPAN_LINK)
    public WebElement picsartJapanLink;
}
