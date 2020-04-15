package am.qa.picsart.pages.editingtools;

import am.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class MemeGeneratorPage extends PicsArtBasePage {
    public MemeGeneratorPage(WebDriver driver) {
        super(driver);
    }

    protected final String PHOTO_CATEGORY = "//i[@class='icon-upload']";
    protected final String SUGGESTED_IAMGES = "//div[@class='memePhotosContainer-0-2-172']/*";
    protected final String TEXT_CATEGORY = "//p[contains(text(),'Text')]";
    protected final String CLICK_TO_ADD_TEXT_OPTION = "//*[text()='Click to add text']";
    protected final String ADD_TEXT_DROP_DOWN_LIST = "(//div[@class='addCustomText-0-2-175'])/*";
    protected final String SHAPE_CATEGORY = "//p[contains(text(),'Shape')]";
    protected final String ADJUST_OPTION = "//p[contains(text(),'Adjust')]";
    protected final String ADJUST_OPTIONS = "//div[@class='settingNameOutput-0-2-198']";


    @FindBy(xpath = PHOTO_CATEGORY)
    public WebElement photoCategory;

    @FindBy(xpath = SUGGESTED_IAMGES)
    public List<WebElement> suggestedImages;

    @FindBy(xpath = TEXT_CATEGORY)
    public WebElement textCategory;

    @FindBy(xpath = CLICK_TO_ADD_TEXT_OPTION)
    public WebElement clickToAddText;

    @FindBy(xpath = ADD_TEXT_DROP_DOWN_LIST)
    public List<WebElement> AddTextDropDownList;

    @FindBy(xpath = SHAPE_CATEGORY)
    public WebElement shapeCategory;

    @FindBy(xpath = ADJUST_OPTION)
    public WebElement adjustOption;

    @FindBy(xpath = ADJUST_OPTIONS)
    public List<WebElement> adjustOptionsList;

    public String uploadYourImage() {
        String text = driver.findElement(By.xpath("//p[contains(text(),'Use your image')]")).getText();
        return text;
    }

    public String addTextDropDownList(int index) {
        String text = driver.findElement(By.xpath("(//div[@class='addCustomText-0-2-175'])/*["+index+"]")).getText();
        return text;
    }

    public String adjustOptions(int index) {
        String text = driver.findElement(By.xpath("//div[@class='settingNameOutput-0-2-198']["+index+"]")).getText();
        return text;
    }

}
