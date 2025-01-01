package lt.vcs.pom.test.marskineliai;

import lt.vcs.pom.page.marskineliai.HomePage;
import lt.vcs.pom.page.marskineliai.KategorijaPage;
import lt.vcs.pom.page.marskineliai.KrepselisPage;
import lt.vcs.pom.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingCartTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        HomePage.open();
    }

    @Test
    public void testShoppingCartAddItem() {
        String expectedResult = "1";
        String actualResult;

        HomePage.clickMusuDizainaiElement();
        KategorijaPage.addItemSpongeBobTshirt();
        actualResult = KrepselisPage.readCartBadgeNumber();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult));
    }

    @Test
    public void testShoppingCartAddMultipleItems() {
        int expectedItemsAmount = KategorijaPage.randomAmount;
        int actualItemsAmount;
        String expectedTotalPrice;
        String actualTotalPrice;

        HomePage.clickMusuDizainaiElement();
        KategorijaPage.addRandomAmountOfItems();
        actualItemsAmount = Integer.parseInt(KrepselisPage.readCartBadgeNumber());
        expectedTotalPrice = KrepselisPage.countTotalItemsPrice();
        actualTotalPrice = KrepselisPage.getTotalShoppingCartPrice();

        System.out.println("Į krepšelį įdėtų produktų skaičius: " + actualItemsAmount);

        Assert.assertEquals(expectedItemsAmount, actualItemsAmount);

        Assert.assertTrue(
                actualTotalPrice.contains(expectedTotalPrice),
                "\nActual: %s\nExpected contains: %s".formatted(actualTotalPrice, expectedTotalPrice));
    }
}
