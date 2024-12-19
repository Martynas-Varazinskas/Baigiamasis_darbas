package lt.vcs.pom.test.marskineliai;

import lt.vcs.pom.page.marskineliai.HomePage;
import lt.vcs.pom.page.marskineliai.PaieskaPage;
import lt.vcs.pom.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PaieskaTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        HomePage.open();
    }
    @DataProvider(name = "provideDataForPaieska")
    public Object[][] provideDataForPaieska(){
        return new Object[][]{
                {"MTV WORLD", true },
                {"Kempiniukas", true },
                {"Kake Make", true },
                {"not found", false},
                {"blabla bla", false},
                {"false", false}
        };
    }
    @Test(dataProvider = "provideDataForPaieska")
    public void testPaieska(String searchValue, Boolean expectedValue ){
        String expectedRezultataiPagalMessage = "%s".formatted(searchValue).toUpperCase();
        String actualRezultataiPagalMessage;
        boolean actualValue;

        HomePage.searchFor(searchValue);
        actualValue =  PaieskaPage.checkIfProductsFound();
        actualRezultataiPagalMessage = PaieskaPage.readRezultataiPagalMessage();

        Assert.assertTrue(
                actualRezultataiPagalMessage.contains(expectedRezultataiPagalMessage),
                "\nActual: %s\nExpected contains: %s".formatted(actualRezultataiPagalMessage,actualRezultataiPagalMessage));

        Assert.assertEquals(expectedValue,actualValue);
        if (actualValue = false){
            System.out.println("Produktų nerasta pagal: %s".formatted(searchValue));
        };
    }
}
