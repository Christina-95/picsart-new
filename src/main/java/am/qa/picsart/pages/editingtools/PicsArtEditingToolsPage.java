package am.qa.picsart.pages.editingtools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import am.qa.picsart.pages.base.PicsArtBasePage;

public class PicsArtEditingToolsPage extends PicsArtBasePage {

	public PicsArtEditingToolsPage(WebDriver driver) {
		super(driver);
	}
	
	
	protected final String EDITING_TOOLS_PAGE_TITLE = "//h1[@class='editing-tools-title']";
	public static final String REMOVE_BACKGROUN_FILTER = "//h4[contains(text(),'Remove Background')]";
	
	
	
	@FindBy (xpath = EDITING_TOOLS_PAGE_TITLE)
	public WebElement editingToolsPageTitle;
	
	@FindBy (xpath = REMOVE_BACKGROUN_FILTER)
	public WebElement removeBackgroundFilter;
	
	

}
