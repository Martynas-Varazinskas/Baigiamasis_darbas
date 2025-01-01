package lt.vcs.pom.test.marskineliai;

import lt.vcs.pom.page.Common;
import lt.vcs.pom.page.marskineliai.*;
import lt.vcs.pom.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishListTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        String userName = "martynas_test";
        String password = "TestPassword01*";

        HomePage.open();
        HomePage.clickLogInIcon();
        PaskyraPage.enterUserName(userName);
        PaskyraPage.enterPassword(password);
        PaskyraPage.clickButtonLogin();
    }

    @Test
    public void testAddItemToWishList() {
        String expectedWishListIconCount = "1";
        String actualWishListIconCount;
        String expectedProductTitle;
        String actualProductTitle;

        HomePage.clickMusuDizainaiElement();
        KategorijaPage.addItemTotWishList();
        expectedProductTitle = ProduktasPage.readItemTitle().replaceAll("[“”„”]", "\"");
        ProduktasPage.openWishList();
        Common.refreshPage();
        actualProductTitle = WishListPage.readWishlistItemTitle();
        actualWishListIconCount = WishListPage.getWishListIconCount();

        Assert.assertTrue(
                actualProductTitle.contains(expectedProductTitle),
                "\nActual: %s\nExpected contains: %s".formatted(actualProductTitle, expectedProductTitle));
        Assert.assertEquals(actualWishListIconCount, expectedWishListIconCount);

        WishListPage.removeItemFromWishList();
    }

}
