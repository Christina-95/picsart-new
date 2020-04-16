package com.qa.picsart.test.blog;

import com.qa.picsart.pages.blog.BlogPage;
import com.qa.picsart.pages.blog.PicsArtJapanPage;
import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.PicsArtBaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PicsArtJapanTest extends PicsArtBaseTest {

    @Test
    public void testPicsArtJapan() {
        //Test Case ID:27
        //Given that the user is authenticated,
        //when the user clicks on the "Blog", clicks on the "PicsArt Japan" in the "Categories" section,
        //then the "PicsArt Japan" page is displayed in Japanese

        //Login with correct credentials -- Done in PicsArtBaseTest
        //27.1.Click on the "Blog" link
        PicsArtUserPage userPage = new PicsArtUserPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(userPage.blogLink));
        userPage.blogLink.click();

        //27.2.Scroll down the page and click on the "PicsArt Japan" link in the "Categories" section
        BlogPage blogPage = new BlogPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(blogPage.picsartJapanLink));
        blogPage.picsartJapanLink.click();

        //validate that the PicsArt Japan page is displayed in Japanese
        PicsArtJapanPage japanPage = new PicsArtJapanPage(driver);
        wait.until(ExpectedConditions.visibilityOf(japanPage.picsartJapanPageTitle));
        Assert.assertTrue(japanPage.picsartJapanPageTitle.isDisplayed());

        //........
    }
}
