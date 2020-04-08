package am.qa.picsart.pages.editingtools;

import am.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SketchEffectsPage extends PicsArtBasePage {
    public SketchEffectsPage(WebDriver driver) {
        super(driver);
    }


    protected final String NONE_OPTION = "//*[text()='NONE']";
    protected final String SKETCH1_OPTION = "//*[text()='Sketch1']";
    protected final String SKETCH2_OPTION = "//*[text()='Sketch2']";
    protected final String SKETCH3_OPTION = "//*[text()='Sketch3']";
    protected final String SKETCH4_OPTION = "//*[text()='Sketch4']";


    @FindBy (xpath = NONE_OPTION)
    public WebElement noneOption;

    @FindBy (xpath = SKETCH1_OPTION)
    public WebElement sketch1Option;

    @FindBy (xpath = SKETCH2_OPTION)
    public WebElement sketch2Option;

    @FindBy (xpath = SKETCH3_OPTION)
    public WebElement sketch3Option;

    @FindBy (xpath = SKETCH4_OPTION)
    public WebElement sketch4Option;
}
