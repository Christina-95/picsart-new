package com.qa.picsart.test.search;

import com.qa.picsart.pages.search.SearchPage;
import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.BaseLoginTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SearchResultsTest extends BaseLoginTest {

    private WebDriverWait wait;
    private PicsArtUserPage userPage;
    private SearchPage searchPage;

    @BeforeClass
    public void start() {
        wait = new WebDriverWait(driver, 30);
        userPage = new PicsArtUserPage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test
    public void testSearchResults() {
        //Test Case ID:40
        //Given that the user is authenticated,
        //when the user enters a specific word in the search field,
        //then the search results start with the entered word.

        //Login with correct credentials -- Done in PicsArtBaseTest
        //40.1.Type "beautiful" in the search field
        userPage.enterSearchItem("beautiful");
        List<String> searchResults = searchPage.searchResults();
        for (String elementText:
                searchResults) {
            Assert.assertTrue(elementText.contains("#beautiful"));
        }
    }

}
