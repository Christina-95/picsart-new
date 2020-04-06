package am.qa.picsart.pages.blog;

import am.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PicsArtJapanPage extends PicsArtBasePage {
    public PicsArtJapanPage(WebDriver driver) {
        super(driver);
    }

    protected final String PICSART_JAPAN_PAGE_TITLE = "//h2[@class='title'][contains(text(),'PicsArt Japan')]";


    @FindBy (xpath = PICSART_JAPAN_PAGE_TITLE)
    public WebElement picsartJapanPageTitle;
}
