package lt.vcs.pom.test.marskineliai;

import lt.vcs.pom.page.Common;
import lt.vcs.pom.page.marskineliai.HomePage;
import lt.vcs.pom.page.marskineliai.KategorijaPage;
import lt.vcs.pom.page.marskineliai.ProduktasPage;
import lt.vcs.pom.page.marskineliai.WishListPage;
import lt.vcs.pom.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishListTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        HomePage.open();
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
        Common.refreshPageWithActions();
        Common.refreshPage();
        actualProductTitle = WishListPage.readWishlistItemTitle();
        actualWishListIconCount = WishListPage.getWishListIconCount();

        Assert.assertTrue(
                actualProductTitle.contains(expectedProductTitle),
                "\nActual: %s\nExpected contains: %s".formatted(actualProductTitle, expectedProductTitle));
        Assert.assertEquals(actualWishListIconCount, expectedWishListIconCount);

    }


}
