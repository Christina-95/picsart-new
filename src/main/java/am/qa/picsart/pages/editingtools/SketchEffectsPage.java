package am.qa.picsart.pages.editingtools;

import am.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SketchEffectsPage extends PicsArtBasePage {
    public SketchEffectsPage(WebDriver driver) {
        super(driver);
    }

    protected final String EFFECTS_CATEGORY = "//div[@id='effects-category']";
    protected final String NONE_OPTION = "//div[@class='itemActive-0-2-179']";
    protected final String SKETCH1_OPTION = "(//img[@alt='img'])[2]";
    protected final String SKETCH2_OPTION = "(//img[@alt='img'])[3]";
    protected final String SKETCH3_OPTION = "(//img[@alt='img'])[4]";
    protected final String SKETCH4_OPTION = "(//img[@alt='img'])[5]";


    @FindBy (xpath = EFFECTS_CATEGORY)
    public WebElement effectsCategory;

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
