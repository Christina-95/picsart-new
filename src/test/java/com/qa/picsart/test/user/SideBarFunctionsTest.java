package com.qa.picsart.test.user;

import com.qa.picsart.pages.user.PicsArtUserPage;
import com.qa.picsart.test.base.PicsArtBaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SideBarFunctionsTest extends PicsArtBaseTest {

    private WebDriverWait wait;
    private PicsArtUserPage userPage;

    @BeforeClass
    public void start() {
        wait = new WebDriverWait(driver, 30);
        userPage = new PicsArtUserPage(driver);
    }

    @Test
    public void testSidebarFunctions() {
        //Given that the user is on the PicsArt.com page,
        //when the user logs in, then the following functions are displayed:
        //Feed, Explore, PicsArt Gold, Categories, Hashtags,
        //Artists, Stickers, Gifs, Challenges, Careers, About,
        //Brands, Products, Features, Blog, Support, Events,
        //PicsArt Store, Permission Details, Community Guidelines,
        //Privacy, Terms and Conditions, Interes-based Advertising, DMCA.


        //Login with correct credentials -- Done in PicsArtBaseTest
        //validate that the Feed, Explore, PicsArt Gold, Categories, Hashtags,
        //Artists, Stickers, Gifs, Challenges, Careers, About,
        //Brands, Products, Features, Blog, Support, Events are displayed
        Assert.assertTrue(userPage.sidebarFunctions.size()<=20);
        for (int i = 0; i < userPage.sidebarFunctions.size(); i++) {
            if (i < 2) {
                Assert.assertEquals(userPage.sideBarFunctions(1), "Feed");
            }
           else if (i < 3) {
                Assert.assertEquals(userPage.sideBarFunctions(2), "Explore");
            }
            else if (i < 4) {
                Assert.assertEquals(userPage.sideBarFunctions(3), "PicsArt Gold");
            }
            else if (i < 5) {
                Assert.assertEquals(userPage.sideBarFunctions(6), "Categories");
            }
            else if (i < 8) {
                Assert.assertEquals(userPage.sideBarFunctions(7), "Hashtags");
            }
            else if (i < 9) {
                Assert.assertEquals(userPage.sideBarFunctions(8), "Artists");
            }
            else if (i < 10) {
                Assert.assertEquals(userPage.sideBarFunctions(9), "Stickers");
            }
            else if (i < 11) {
                Assert.assertEquals(userPage.sideBarFunctions(10), "Gifs");
            }
            else if (i < 12) {
                Assert.assertEquals(userPage.sideBarFunctions(11), "Challenges");
            }
            else if (i < 14) {
                Assert.assertEquals(userPage.sideBarFunctions(13), "Careers");
            }
            else if (i < 15) {
                Assert.assertEquals(userPage.sideBarFunctions(14), "About");
            }
            else if (i < 16) {
                Assert.assertEquals(userPage.sideBarFunctions(15), "Brands");
            }
            else if (i < 17) {
                Assert.assertEquals(userPage.sideBarFunctions(16), "Products");
            }
            else if (i < 18) {
                Assert.assertEquals(userPage.sideBarFunctions(17), "Features");
            }
            else if (i < 19) {
                Assert.assertEquals(userPage.sideBarFunctions(18), "Blog");
            }
            else if (i < 20) {
                Assert.assertEquals(userPage.sideBarFunctions(19), "Support");
            }
            else {
                Assert.assertEquals(userPage.sideBarFunctions(20), "Events");
            }
        }

        //validate that the PicsArt Store, Permission Details, Community Guidelines,
        //Privacy, Terms and Conditions, Interest-Based Advertising, DMCA links are displayed
        Assert.assertTrue(userPage.footerLinks.size()<=7);
        for (int i = 0; i < userPage.sidebarFunctions.size(); i++) {
            if (i < 2) {
                Assert.assertEquals(userPage.footerLinks(1), "PicsArt Store");
            }
            else if (i < 3) {
                Assert.assertEquals(userPage.footerLinks(2), "Permission Details");
            }
            else if (i < 4) {
                Assert.assertEquals(userPage.footerLinks(3), "Community Guidelines");
            }
            else if (i < 5) {
                Assert.assertEquals(userPage.footerLinks(4), "Privacy");
            }
            else if (i < 6) {
                Assert.assertEquals(userPage.footerLinks(5), "Terms and Conditions");
            }
            else if (i < 7) {
                Assert.assertEquals(userPage.footerLinks(6), "Interest-Based Advertising");
            }
            else {
                Assert.assertEquals(userPage.footerLinks(7), "DMCA");
            }
        }

    }
}
