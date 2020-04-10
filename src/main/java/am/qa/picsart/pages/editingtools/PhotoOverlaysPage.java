package am.qa.picsart.pages.editingtools;

import am.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class PhotoOverlaysPage extends PicsArtBasePage {
    public PhotoOverlaysPage(WebDriver driver) {
        super(driver);
    }
    PicsArtBasePage wait = new PicsArtBasePage(driver);
    int index;

    protected final String OVERLAYS_CATEGORY = "//*[text()='Overlays']";
    protected final String MORE_OPTIONS = "//div[@class='overlays-0-2-176']//*[text()='More']";
    protected final String BACK_OPTION = "//span[contains(text(),'Back')]";
    //public String moreOption = "(//div[@class='moreOverlays-0-2-178'][contains(.,'More')])["+index+"]")";

    @FindBy (xpath = OVERLAYS_CATEGORY)
    public WebElement overlaysCategory;

    @FindBy (xpath = MORE_OPTIONS)
    public List<WebElement> moreOptions;

    @FindBy (xpath = BACK_OPTION)
    public WebElement backOption;


    public void clickOnTheMoreOption(int index) throws InterruptedException {
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moreOption));
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class='moreOverlays-0-2-178'][contains(.,'More')])["+index+"]")).click();
        System.out.println("More option");
        Thread.sleep(1000);
        backOption.click();
    }

}
