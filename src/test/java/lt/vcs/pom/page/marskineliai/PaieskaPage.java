package lt.vcs.pom.page.marskineliai;

import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;

public class PaieskaPage {
    private static final By rezultataiPagalElement = By.xpath(
            "//nav[@class='woocommerce-breadcrumb breadcrumbs uppercase']/h2");
    private static final By rastiProduktaiElement = By.xpath(
            "//div[@class='woocommerce-notices-wrapper']");
    private static final By produktuNerastaElement = By.xpath(
            "//div[@class='woocommerce-no-products-found']");



    public static String readRezultataiPagalMessage() {
       return Common.getTextFromElement(rezultataiPagalElement);
    }

    public static void checkIfProductsFound() {
        Common.isElementDisplayed(rastiProduktaiElement);
    }
}
