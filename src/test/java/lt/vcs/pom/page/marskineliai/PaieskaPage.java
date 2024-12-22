package lt.vcs.pom.page.marskineliai;

import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class PaieskaPage {
    private static final By rezultataiPagalElement = By.xpath(
            "//nav[@class='woocommerce-breadcrumb breadcrumbs uppercase']/h2");
    private static final By rastiProduktaiElement = By.xpath(
            "//div[@class='woocommerce-notices-wrapper']");

    public static String readRezultataiPagalMessage() {
        return Common.getTextFromElement(rezultataiPagalElement);
    }

    public static Boolean checkIfProductsFound() {
        try {
            return Common.isElementEnabled(rastiProduktaiElement);
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
