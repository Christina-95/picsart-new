package am.qa.picsart.pages.editingtools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import am.qa.picsart.pages.base.PicsArtBasePage;

public class EditingToolsPage extends PicsArtBasePage {

	public EditingToolsPage(WebDriver driver) {
		super(driver);
	}
	
	
	protected final String EDITING_TOOLS_PAGE_TITLE = "//h1[@class='editing-tools-title']";
	protected final String REMOVE_BACKGROUND = "//h4[contains(text(),'Remove Background')]";
	protected final String TEMPLATE_EDITOR = "//*[text()='Template Editor']";
	protected final String PIXEL_STRETCH_EFFECTS = "//*[text()='Pixel Stretch Effect']";
	protected final String CHANGE_BACKGROUND = "//*[text()='Change Background']";
	protected final String ADD_STICKER = "//*[text()='Add Sticker']";
	protected final String SKETCH_EFFECTS = "//*[text()='Sketch Effects']";
	protected final String LIGHT_EFFECTS = "//*[text()='Light Effects']";
	protected final String DOUBLE_EXPOSURE = "//div[@class='bottom']//*[text()='Double Exposure']";
	
	
	@FindBy (xpath = EDITING_TOOLS_PAGE_TITLE)
	public WebElement editingToolsPageTitle;
	
	@FindBy (xpath = REMOVE_BACKGROUND)
	public WebElement removeBackgroundFilter;

	@FindBy (xpath = TEMPLATE_EDITOR)
	public WebElement templateEditor;

	@FindBy (xpath = PIXEL_STRETCH_EFFECTS)
	public WebElement pixelStretchEffects;

	@FindBy (xpath = CHANGE_BACKGROUND)
	public WebElement changeBackground;

	@FindBy (xpath = ADD_STICKER)
	public WebElement addSticker;

	@FindBy (xpath = SKETCH_EFFECTS)
	public WebElement sketchEffects;

	@FindBy (xpath = LIGHT_EFFECTS)
	public WebElement lightEffects;

	@FindBy (xpath = DOUBLE_EXPOSURE)
	public WebElement doubleExposure;

}
