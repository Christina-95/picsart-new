package am.qa.picsart.pages.editingtools;

import am.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DoubleExposurePage extends PicsArtBasePage {
    public DoubleExposurePage(WebDriver driver) {
        super(driver);
    }

    protected final String FILTERS= "//div[@class='item-0-2-208']";

    @FindBy (xpath = FILTERS)
    public List<WebElement> filters;


    public boolean filtersCount() {
      if (filters.size()>= 19) {
          System.out.println("NONE, DMX1 .... DMX19 are displayed");
          return true;
        }
      else return false;
    }

}
