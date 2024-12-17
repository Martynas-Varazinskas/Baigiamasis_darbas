package lt.vcs.pom.page.rrr;

import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    public static void open() {
        Common.setUpChrome(7);
        Common.openUrl("https://rrr.lt/en");
    }
//    private static final By logInLinkIcon = By.xpath("//button[@data-testid='nav-login-link']");
    private static final By logInLinkIcon = By.xpath("//a[@aria-label='Prisijungti']");

//    private static final By inputYouAreHuman = By.xpath("//*[@id=\"rvwE0\"]/div/label/input");



    public static void clickLogInLinkIcon() {
        Common.waitElementToBeVisible(logInLinkIcon,4);
        Common.clickOnElement(logInLinkIcon);
    }

}
