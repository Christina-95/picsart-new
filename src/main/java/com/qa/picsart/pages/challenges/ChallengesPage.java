package com.qa.picsart.pages.challenges;

import com.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChallengesPage extends PicsArtBasePage {
    public ChallengesPage(WebDriver driver) {
        super(driver);
    }

    protected final String FREESTYLE_CHALLENGES_LINK = "//div[@class='name'][contains(text(),'Freestyle Challenges')]";
    protected final String COLLAGE_CHALLENGES_LINK = "//div[@class='name'][contains(text(),'Collage Challenges')]";
    protected final String IMAGE_REMIX_CHALLENGES_LINK = "//div[@class='name'][contains(text(),'Image Remix Challenges')]";
    protected final String EDITING_CHALLENGES_LINK = "//div[@class='name'][contains(text(),'Editing Challenges')]";
    protected final String STICKER_CHALLENGES_LINK = "//div[@class='name'][contains(text(),'Sticker Challenges')]";
    protected final String PHOTOGRAPHY_CHALLENGES_LINK = "//div[@class='name'][contains(text(),'Photography Challenges')]";
    protected final String STICKER_REMIX_CHALLENGES_LINK = "//div[@class='name'][contains(text(),'Sticker Remix Challenges')]";
    protected final String DRAWING_CHALLENGES_LINK = "//div[@class='name'][contains(text(),'Drawing Challenges')]";


    @FindBy (xpath = FREESTYLE_CHALLENGES_LINK)
    public WebElement freeStyleChallengesLink;

    @FindBy (xpath = COLLAGE_CHALLENGES_LINK)
    public WebElement collageChallengesLink;

    @FindBy (xpath = IMAGE_REMIX_CHALLENGES_LINK)
    public WebElement imageRemixChallengesLink;

    @FindBy (xpath = EDITING_CHALLENGES_LINK)
    public WebElement editingChallengesLink;

    @FindBy (xpath = STICKER_CHALLENGES_LINK)
    public WebElement stickerChallengesLink;

    @FindBy (xpath = PHOTOGRAPHY_CHALLENGES_LINK)
    public WebElement photographyChallengesLink;

    @FindBy (xpath = STICKER_REMIX_CHALLENGES_LINK)
    public WebElement stickerRemixChallengesLink;

    @FindBy (xpath = DRAWING_CHALLENGES_LINK)
    public WebElement drawingChallengesLink;
}
