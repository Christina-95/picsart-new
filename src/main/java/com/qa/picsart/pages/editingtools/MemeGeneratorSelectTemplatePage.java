package com.qa.picsart.pages.editingtools;

import com.qa.picsart.pages.base.PicsArtBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.util.Random;

public class MemeGeneratorSelectTemplatePage extends PicsArtBasePage {
    public MemeGeneratorSelectTemplatePage(WebDriver driver) {
        super(driver);
    }



    public void clickOnRandomTemplate() {
       Random random = new Random();
        int i = random.nextInt(10);
        if (i > 0 && i <= 12) {
            driver.findElement(By.xpath("(//img[contains(@alt,'img')])["+i+"]")).click();
        }
    }
}
