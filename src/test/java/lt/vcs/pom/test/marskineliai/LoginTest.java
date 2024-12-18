package lt.vcs.pom.test.marskineliai;

import lt.vcs.pom.page.marskineliai.HomePage;
import lt.vcs.pom.page.marskineliai.PaskyraPage;
import lt.vcs.pom.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        HomePage.open();
    }

    @Test
    public void testMarskineliaiLoginWithUserName_Positive() {
        String userName = "martynas_test";
        String password = "TestPassword01*";
        String expectedUserName = "martynas_test";
        String actualUserName;
        String expectedUrl = "https://marskineliai.lt/paskyra/";
        String actualUrl;

        HomePage.clickLogInIcon();
        PaskyraPage.enterUserName(userName);
        PaskyraPage.enterPassword(password);
        PaskyraPage.clickButtonLogin();

        actualUserName = PaskyraPage.readUserNameBlock();
        actualUrl = PaskyraPage.readUrl();

        Assert.assertTrue(
                actualUserName.contains(expectedUserName),
                "\nActual: %s\nExpected contains: %s".formatted(actualUserName, expectedUserName));

        Assert.assertTrue(
                actualUrl.contains(expectedUrl),
                "\nActual: %s\nExpected contains: %s".formatted(actualUrl, expectedUrl));
    }
}
