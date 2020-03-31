package am.qa.picsart.pages.presscenter;

import am.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PicsArtPressCenterPage extends PicsArtBasePage {
    public PicsArtPressCenterPage(WebDriver driver) {
        super(driver);
    }

    protected final String PRESS_CENTER_TITLE = "//h1[contains(text(),'Press Center')]";
    protected final String PRESS_KIT_BUTTON = "//a[contains(text(),'Press Kit')]";


    @FindBy (xpath = PRESS_CENTER_TITLE)
    public WebElement pressCenterTitle;

    @FindBy (xpath = PRESS_KIT_BUTTON)
    public WebElement pressKitButton;
}
