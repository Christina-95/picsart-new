package com.qa.picsart.pages.editingtools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.picsart.pages.base.PicsArtBasePage;

public class UploadSelectImagePage extends PicsArtBasePage {

	public UploadSelectImagePage(WebDriver driver) {
		super(driver);
	}
	
	PicsArtBasePage wait = new PicsArtBasePage(driver);
	
	public final String RANDOM_IMAGE = "(//img[@alt='img'])[1]";
	public final String UPLOAD_YOUR_IMAGE_OPTION = "//i[@class='icon-upload addPhotoIcon-0-2-39']";
	
	
	@FindBy (xpath = RANDOM_IMAGE)
	public WebElement randomImage;

	@FindBy (xpath = UPLOAD_YOUR_IMAGE_OPTION)
	public WebElement uploadYourImageOption;
	
}
