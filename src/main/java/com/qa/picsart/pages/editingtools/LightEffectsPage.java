package com.qa.picsart.pages.editingtools;

import com.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LightEffectsPage extends PicsArtBasePage {
    public LightEffectsPage(WebDriver driver) {
        super(driver);
    }

    protected final String EFFECTS_CATEGORY = "//i[@class='icon-fxeffects']";
    //protected final String LIGHT_FILTER1 = "//div[@class='lutCategoryItemsScroll-0-2-175']//*[text()='LightFilter1']";
    protected final String LIGHT_FILTER1 ="//*[text()='LightFilter1']/..";
    protected final String ADJUST_CATEGORY = "//p[contains(text(),'Adjust')]";
    protected final String BLEND_CATEGORY = "//p[contains(text(),'Blend')]";

    @FindBy (xpath = EFFECTS_CATEGORY)
    public WebElement effectsCategory;

    @FindBy (xpath = LIGHT_FILTER1)
    public WebElement lightFilter1;

    @FindBy (xpath = ADJUST_CATEGORY)
    public WebElement adjustCategory;

    @FindBy (xpath = BLEND_CATEGORY)
    public WebElement blendCategory;
}
