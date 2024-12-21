package lt.vcs.pom.page.marskineliai;

import lt.vcs.pom.page.Common;
import lt.vcs.pom.util.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaskyraPage {
    private static final By inputUserName = By.xpath("//input[@id='username']");
    private static final By inputPassword = By.xpath("//input[@id='password']");
    private static final By buttonLogin = By.xpath("//button[@name='login']");
    private static final By spanUserName = By.xpath("//span[@class='user-name block']");
    private static final By iconLogout = By.xpath("//a[@class='log-out__icon']");
    private static final By buttonPrisijungti = By.xpath("//button[@value='Prisijungti']");
    private static final By headlineLogin = By.xpath("(//h3)[1]");
    private static final By errorMessage = By.xpath("//div[@class='message-container container alert-color medium-text-center']");

    public static void enterUserName(String value) {
        Common.sendKeysToElement(inputUserName, value);
    }

    public static void enterPassword(String value) {
        Common.sendKeysToElement(inputPassword, value);
    }

    public static void clickButtonLogin() {
        Common.waitElementToBeVisible(buttonLogin,3);
        Common.clickOnElement(buttonLogin);
    }

    public static String readUserNameBlock() {
        return Common.getTextFromElement(spanUserName);
    }

    public static String readUrl() {
        return Common.getCurrentUrl();
    }

    public static void clickIconLogout() {
        Common.waitElementToBeVisible(iconLogout, 5);
        Common.clickOnElement(iconLogout);
    }

    public static Boolean buttonPrisijungtiIsVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(buttonPrisijungti));
            return Common.isElementDisplayed(buttonPrisijungti);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String readHeadline() {
        return Common.getTextFromElement(headlineLogin);
    }

    public static String readErrorMessage() {
        return Common.getTextFromElement(errorMessage);
    }
}
