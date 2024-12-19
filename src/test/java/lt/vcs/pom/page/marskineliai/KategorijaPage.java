package lt.vcs.pom.page.marskineliai;

import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;

public class KategorijaPage extends ProduktasPage {
    private static final By categoryKempiniukas = By.xpath(
            "//a[@title='Prekių kategorija - Kempiniukas Plačiakelnis']");
    private static final By tShirtVeidukas = By.xpath(
            "(//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link'])[11]");
    public static final By producTtitle = By.xpath("//h1[@class='product-title product_title entry-title']");
    public static int randomNumber = (int) Math.random()*5 + 1;
    private static final By randomItem = By.xpath(
            "(//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link'])[%s]".formatted(randomNumber));

    public static void addItemSpongeBobTshirt() {
        Common.clickOnElement(categoryKempiniukas);
        Common.clickOnElement(tShirtVeidukas);
        System.out.println("Pasirinktas produktas: " + Common.getTextFromElement(producTtitle));
        Common.clickOnElement(buttonAddToCart);
    }

    public static void addRandomItem() {
        Common.clickOnElement(categoryKempiniukas);
        Common.clickOnElement(randomItem);
    }
}
