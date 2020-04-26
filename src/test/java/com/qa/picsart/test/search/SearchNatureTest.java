package com.qa.picsart.test.search;

import com.qa.picsart.pages.search.SearchPage;
import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.BaseLoginTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchNatureTest extends BaseLoginTest {
    private PicsArtUserPage userPage;
    private WebDriverWait wait;
    private SearchPage searchPage;


    @BeforeClass
    public void start() {
        userPage = new PicsArtUserPage(driver);
        wait = new WebDriverWait(driver, 30);
        searchPage = new SearchPage(driver);
    }

    @Test
    public void testSearchNature() {
        //Test Case ID:24
        //Given that the user is authenticated
        //when the user searchs "Nature", clicks on the "Hashtag" link
        //then the first hashtag result is "#nature"

        //Login with correct credentials -- Done in PicsArtBaseTest
        //24.1.Type "nature" in the search field and click enter
        wait.until(ExpectedConditions.elementToBeClickable(userPage.searchField));
        userPage.searchField.click();
        userPage.searchField.sendKeys("nature");
        userPage.searchField.submit();

        //validate that the "All", "Stickers", "Images", "Hashtags" and "Artists" links are displayed
        wait.until(ExpectedConditions.elementToBeClickable(searchPage.allLink));
        Assert.assertTrue(searchPage.allLink.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(searchPage.stickersLink));
        Assert.assertTrue(searchPage.stickersLink.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(searchPage.imagesLink));
        Assert.assertTrue(searchPage.imagesLink.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(searchPage.hashtagLink));
        Assert.assertTrue(searchPage.hashtagLink.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(searchPage.artistsLink));
        Assert.assertTrue(searchPage.artistsLink.isDisplayed());

        //24.2.Click on the "Hashtags" link
        wait.until(ExpectedConditions.elementToBeClickable(searchPage.hashtagLink));
        searchPage.hashtagLink.click();

        //validate that the "#nature" hashtag is displayed
        wait.until(ExpectedConditions.elementToBeClickable(searchPage.natureHashtag));
        Assert.assertTrue(searchPage.natureHashtag.isDisplayed());
    }

}
