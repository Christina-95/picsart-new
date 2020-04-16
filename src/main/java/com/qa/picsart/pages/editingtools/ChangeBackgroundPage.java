package com.qa.picsart.pages.editingtools;

import com.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangeBackgroundPage extends PicsArtBasePage {
    public ChangeBackgroundPage(WebDriver driver) {
        super(driver);
    }

    protected final String CANVAS_CATEGORY = "//div[@class='js-handle-sidebar-trigger sidebarCategory-0-2-109']";
    protected final String WIDTH_OPTION = "//p[contains(text(),'W:')]";
    protected final String HEIGHT_OPTION = "//p[contains(text(),'H:')]";
    protected final String COLOR_CATEGORY = "//p[contains(text(),'Color')]";
    protected final String COLOR_GRADIENT = "//div[@class='colorPickerMain-0-2-221']";
    protected final String GRADIENT_CATEGORY = "//p[contains(text(),'Gradient')]";
    protected final String GRADIENT_PICKER = "(//p[contains(text(),'Gradient')])[1]";
    protected final String TEXTURE_CATEGORY = "//p[contains(text(),'Texture')]";
    protected final String USE_YOUR_IMAGE_OPTION = "//p[contains(text(),'Use your image')]";


    @FindBy (xpath = CANVAS_CATEGORY)
    public WebElement canvasCategory;

    @FindBy (xpath = WIDTH_OPTION)
    public WebElement widthOption;

    @FindBy (xpath = HEIGHT_OPTION)
    public WebElement heightOption;

    @FindBy (xpath = COLOR_CATEGORY)
    public WebElement colorCategory;

    @FindBy (xpath = COLOR_GRADIENT)
    public WebElement colorGradient;

    @FindBy (xpath = GRADIENT_CATEGORY)
    public WebElement gradientCategory;

    @FindBy (xpath = GRADIENT_PICKER)
    public WebElement gradientPicker;

    @FindBy (xpath = TEXTURE_CATEGORY)
    public WebElement textureCategory;

    @FindBy (xpath = USE_YOUR_IMAGE_OPTION)
    public WebElement userYourImageOption;

}
