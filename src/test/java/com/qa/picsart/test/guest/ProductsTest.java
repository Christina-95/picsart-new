package com.qa.picsart.test.guest;

import com.qa.picsart.pages.GuestPage;
import com.qa.picsart.test.base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    private GuestPage guestPage;
    private WebDriverWait wait;

    @BeforeClass
    public void start() {
        guestPage = new GuestPage(driver);
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void testProducts() {
        //Test Case ID:41
        //Given that the user is on the PicsArt.com page,
        //when the user scrolls the page down to the "Products",
        //then the following links are available:
        //Editing Tools, Photo Editor, Collage Maker, Sticker Maker, Mobile Apps

        //Navigate to picsart.com -- Done in BaseTest
        //41.1.Scroll down to the "Products"
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");

        //validate that the Editing Tools, Photo Editor,
        //Collage Maker, Sticker Maker, Mobile Apps are available
        guestPage.valListElementsSize();
        for (int i = 0; i < guestPage.productsLinks.size() ; i++) {
            if (i < 2) {
                Assert.assertEquals(guestPage.linksOfTheProducts(1), "Editing Tools");
            }
            else if (i < 3) {
                Assert.assertEquals(guestPage.linksOfTheProducts(2), "Photo Editor");
            }
            else if (i < 3) {
                Assert.assertEquals(guestPage.linksOfTheProducts(3), "Collage Maker");
            }
            else if (i < 5) {
                Assert.assertEquals(guestPage.linksOfTheProducts(4), "Sticker Maker");
            }
            else if (i < 6) {
                Assert.assertEquals(guestPage.linksOfTheProducts(5), "Mobile Apps");
            }
        }


    }
}
