package lt.vcs.pom.page.marskineliai;

import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;


public class KrepselisPage {

    private static final By spanCartCount = By.xpath("//span[@class='cart-count']");
    private static final By itemPrice = By.xpath(
            "(//td[@class='product-subtotal'])//span[@class='woocommerce-Price-amount amount']/bdi");
    private static final By totalShoppingCartPrice = By.xpath("//td[@data-title='Viso']//bdi");




    public static String readCartBadgeNumber() {
        return Common.getTextFromElement(spanCartCount);
    }


    public static String countTotalItemsPrice() {
       return Common.getTextFromElement(itemPrice);
//        return Common.getElementAttributeValue(itemPrice, "text");
    }

    public static String getTotalShoppingCartPrice() {
        return Common.getTextFromElement(totalShoppingCartPrice);
    }
}
