package lt.vcs.pom.test.marskineliai;

import lt.vcs.pom.page.marskineliai.HomePage;
import lt.vcs.pom.page.marskineliai.PaskyraPage;
import lt.vcs.pom.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        HomePage.open();
    }

    @Test
    public void testMarskineliaiLogout() {
        String expectedHeadline = "PRISIJUNGTI";
        String actualHeadline;
        Boolean expectedResult = true;
        Boolean actualResult;

        HomePage.clickLogInIcon();
        PaskyraPage.enterUserName("martynas_test");
        PaskyraPage.enterPassword("TestPassword01*");
        PaskyraPage.clickButtonLogin();
        PaskyraPage.clickIconLogout();

        actualHeadline = PaskyraPage.readHeadline();

        Assert.assertTrue(
                actualHeadline.contains(expectedHeadline),
                "\nActual: %s\nExpected conatins: %s".formatted(actualHeadline, expectedHeadline));

        actualResult = PaskyraPage.buttonPrisijungtiIsVisible();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
