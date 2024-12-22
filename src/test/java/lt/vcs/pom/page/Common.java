package lt.vcs.pom.page;

import lt.vcs.pom.util.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class Common {

    public static void setUpChrome(int sec) {
        Driver.setChromeDriver();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
        getWebDriverWait(sec).until(
                driver -> getJsExecutor().executeScript("return document.readyState").equals("complete")
        );
    }

    public static void openUrl(String url) {
        Driver.getDriver().get(url);
    }

    public static void close() {
        Driver.quitDriver();
    }

    public static String getCurrentUrl() {
        return Driver.getDriver().getCurrentUrl();
    }

    private static JavascriptExecutor getJsExecutor() {
        return (JavascriptExecutor) Driver.getDriver();
    }

    public static WebElement getElement(By locator) {
        return Driver.getDriver().findElement(locator);
    }

    private static List<WebElement> getElements(By locator) {
        return Driver.getDriver().findElements(locator);
    }

    public static void sendKeysToElement(By locator, String input) {
        getElement(locator).sendKeys(input);
    }

    public static void clickOnElement(By locator) {
        getElement(locator).click();
    }

    public static String getTextFromElement(By locator) {
        return getElement(locator).getText();
    }

    public static boolean isElementEnabled(By locator) {
        return getElement(locator).isEnabled();
    }


    public static WebDriverWait getWebDriverWait(int seconds) {
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
    }

    public static void waitElementToBeVisible(By locator, int seconds) {
        getWebDriverWait(seconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static boolean isElementDisplayed(By locator) {
        getElement(locator).isDisplayed();
        return true;
    }

    public static void refreshPage() {
        Driver.getDriver().navigate().refresh();
    }
}
