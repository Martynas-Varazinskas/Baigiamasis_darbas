package lt.vcs.pom.page.marskineliai;

import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;

public class ProduktasPage {

    public static final By buttonAddToCart = By.xpath(
            "//button[@class='single_add_to_cart_button button alt']");
    public static final By productTitle = By.xpath("//h1[@class='product-title product_title entry-title']");
    public static final By iconWishList = By.xpath("//div[@id='favorites']");

    public static String readItemTitle() {
        return Common.getTextFromElement(productTitle);
    }

    public static void openWishList() {
        Common.clickOnElement(iconWishList);
        Common.getWebDriverWait(3);
    }
}
