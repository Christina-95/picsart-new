package com.qa.picsart.test.blog;

import com.qa.picsart.pages.blog.BlogPage;
import com.qa.picsart.pages.blog.PicsArtJapanPage;
import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.PicsArtBaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PicsArtJapanTest extends PicsArtBaseTest {

    private PicsArtUserPage userPage;
    private BlogPage blogPage;
    private PicsArtJapanPage japanPage;
    private WebDriverWait wait;

    @BeforeClass
    public void start() {
        userPage = new PicsArtUserPage(driver);
        blogPage = new BlogPage(driver);
        japanPage = new PicsArtJapanPage(driver);
        wait = new WebDriverWait(driver, 30);
    }


    @Test
    public void testPicsArtJapan() {
        //Test Case ID:27
        //Given that the user is authenticated,
        //when the user clicks on the "Blog", clicks on the "PicsArt Japan" in the "Categories" section,
        //then the "PicsArt Japan" page is displayed in Japanese

        //Login with correct credentials -- Done in PicsArtBaseTest
        //27.1.Click on the "Blog" link
        wait.until(ExpectedConditions.elementToBeClickable(userPage.blogLink));
        userPage.blogLink.click();

        //27.2.Scroll down the page and click on the "PicsArt Japan" link in the "Categories" section
        wait.until(ExpectedConditions.elementToBeClickable(blogPage.picsartJapanLink));
        blogPage.picsartJapanLink.click();

        //validate that the PicsArt Japan page is displayed in Japanese
        wait.until(ExpectedConditions.visibilityOf(japanPage.picsartJapanPageTitle));
        //Assert.assertTrue(japanPage.picsartJapanPageTitle.isDisplayed());
        Assert.assertEquals(japanPage.picsartJapanPageTitle.getText(),"CATEGORY" + "PicsArt Japan");

        //........
    }
}
