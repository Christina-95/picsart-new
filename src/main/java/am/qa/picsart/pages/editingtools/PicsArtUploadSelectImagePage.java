package am.qa.picsart.pages.editingtools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import am.qa.picsart.pages.base.PicsArtBasePage;

public class PicsArtUploadSelectImagePage  extends PicsArtBasePage {

	public PicsArtUploadSelectImagePage(WebDriver driver) {
		super(driver);
	}
	
	PicsArtBasePage wait = new PicsArtBasePage(driver);
	
	public static final String RANDOM_IMAGE = "(//img[@alt='img'])[21]";
	
	
	@FindBy (xpath = RANDOM_IMAGE)
	public WebElement randomImage;
	

	
}