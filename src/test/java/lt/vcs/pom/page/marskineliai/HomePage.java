package lt.vcs.pom.page.marskineliai;

import lt.vcs.pom.page.Common;
import lt.vcs.pom.util.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;

public class HomePage {

    private static final By logInLinkIcon = By.xpath("(//i[@class='icon-user'])[1]");
    private static final By MusuDizainaiElement = By.xpath("//li[@id='menu-item-14005']");
    private static final By inputPaieska = By.xpath("//input[@id='woocommerce-product-search-field-0']");



    public static void open() {
        Common.setUpChrome(7);
        Common.openUrl("https://marskineliai.lt/");
    }

    public static void clickLogInIcon() {
        Common.waitElementToBeVisible(logInLinkIcon, 4);
        Common.clickOnElement(logInLinkIcon);
    }

    public static void clickMusuDizainaiElement() {
        Common.clickOnElement(MusuDizainaiElement);
    }

    public static void searchFor(String value) {
        Common.sendKeysToElement(inputPaieska,value);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ENTER).build().perform();

    }
}
