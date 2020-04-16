package com.qa.picsart.pages.editingtools;

import com.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



import java.util.List;

public class PhotoOverlaysPage extends PicsArtBasePage {
    public PhotoOverlaysPage(WebDriver driver) {
        super(driver);
    }
    PicsArtBasePage wait = new PicsArtBasePage(driver);
    int index;

    protected final String OVERLAYS_CATEGORY = "//*[text()='Overlays']";
    protected final String MORE_OPTIONS = "//div[@class='overlays-0-2-176']//*[text()='More']";
    protected final String BACK_OPTION = "//*[text()='Back']";

    @FindBy (xpath = OVERLAYS_CATEGORY)
    public WebElement overlaysCategory;

    @FindBy (xpath = MORE_OPTIONS)
    public List<WebElement> moreOptions;

    @FindBy (xpath = BACK_OPTION)
    public WebElement backOption;


    public void clickOnTheMoreOption(int index) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class='moreOverlays-0-2-178'][contains(.,'More')])["+index+"]")).click();
        System.out.println("More option");
        Thread.sleep(1000);
        backOption.click();
    }

}
