package lt.vcs.pom.test.marskineliai;

import lt.vcs.pom.page.marskineliai.HomePage;
import lt.vcs.pom.page.marskineliai.PaieskaPage;
import lt.vcs.pom.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PaieskaTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        HomePage.open();
    }

    @Test
    public void testPositivePaieska(){
        String searchValue = "MTV WORLD";
        String expectedRezultataiPagalMessage = "%s".formatted(searchValue);
        String actualRezultataiPagalMessage;
        boolean productsFound = true;

        HomePage.searchFor(searchValue);
        PaieskaPage.checkIfProductsFound();
        actualRezultataiPagalMessage = PaieskaPage.readRezultataiPagalMessage();

        Assert.assertTrue(
                actualRezultataiPagalMessage.contains(expectedRezultataiPagalMessage),
                "\nActual: %s\nExpected contains: %s".formatted(actualRezultataiPagalMessage,actualRezultataiPagalMessage));

        Assert.assertTrue(productsFound);
    }
}
