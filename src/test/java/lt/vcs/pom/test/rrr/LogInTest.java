package lt.vcs.pom.test.rrr;

import lt.vcs.pom.page.Common;
import lt.vcs.pom.page.rrr.HomePage;
import lt.vcs.pom.test.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        HomePage.open();
    }

    @Test
    public void testRrrLogInPositive()  {
        String expectedResult = "";
        String actualResult = "";

        HomePage.clickLogInLinkIcon();
//        HomePage.clickCaptchaCheckbox();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected conatins: %s".formatted(actualResult,expectedResult));

    }

    @Test
    public void test() throws InterruptedException {

        By whishListButton = By.xpath("//a[@aria-label='Prisijungti']");
        Thread.sleep(3);
        Common.clickOnElement(whishListButton);

    }
}
