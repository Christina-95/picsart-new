package am.qa.picsart.pages.editingtools;

import am.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DoubleExposureUploadImagePage extends PicsArtBasePage {

    public DoubleExposureUploadImagePage(WebDriver driver) {
        super(driver);
    }

    protected final String RANDOM_IMAGE1 = "(//img[@alt='img'])[2]";
    protected final String RANDOM_IMAGE2 = "(//img[@alt='img'])[3]";
    protected final String NEXT_BUTTON = "//button[contains(text(),'Next')]";



    @FindBy (xpath = RANDOM_IMAGE1)
    public WebElement randomImage1;

    @FindBy (xpath = RANDOM_IMAGE2)
    public WebElement randomImage2;

    @FindBy (xpath = NEXT_BUTTON)
    public WebElement nextButton;
}
