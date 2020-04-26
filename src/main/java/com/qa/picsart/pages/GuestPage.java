package com.qa.picsart.pages;

import com.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class GuestPage  extends PicsArtBasePage {
    public GuestPage(WebDriver driver) {
        super(driver);
    }

    protected final String PRODUCTS_LINKS = "//div[@class='col-content']/*";


    @FindBy (xpath = PRODUCTS_LINKS)
    public List<WebElement> productsLinks;


    public void valListElementsSize() {
       Assert.assertTrue(productsLinks.size()<27);
    }

    public String linksOfTheProducts (int i) {
        String functions = driver.findElement(By.xpath("//div[@class='col-content']/*["+i+"]")).getText();
        return functions;
    }
}
