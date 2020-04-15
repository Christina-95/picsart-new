package am.qa.picsart.pages.editingtools;

import am.qa.picsart.pages.base.PicsArtBasePage;
import com.google.common.collect.Iterables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class TextEditorPage extends PicsArtBasePage {
    public TextEditorPage(WebDriver driver) {
        super(driver);
    }

    protected final String TEXT_CATEGORY = "//*[text()='Text']";
    protected final String CLICK_TO_ADD_TEXT_OPTION = "//*[text()='Click to add text']";
    protected final String ADD_TEXT_DROP_DOWN_LIST = "(//div[@class='addCustomText-0-2-175'])/*";


    @FindBy(xpath = TEXT_CATEGORY)
    public WebElement textCategory;

    @FindBy(xpath = CLICK_TO_ADD_TEXT_OPTION)
    public WebElement clickToAddText;

    @FindBy(xpath = ADD_TEXT_DROP_DOWN_LIST)
    public List<WebElement> AddTextDropDownList;

    public String addTextDropDownList(int index) {
       String text = driver.findElement(By.xpath("(//div[@class='addCustomText-0-2-175'])/*["+index+"]")).getText();
       return text;
    }

}
