package lt.vcs.pom.page.marskineliai;

import io.github.vcsdailiusrepo.SimpleMath;
import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;

public class KategorijaPage extends ProduktasPage {
    private static final By categoryKempiniukas = By.xpath(
            "//a[@title='Prekių kategorija - Kempiniukas Plačiakelnis']");
    private static final By tShirtVeidukas = By.xpath(
            "(//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link'])[11]");
    public static final By productTitle = By.xpath("//h1[@class='product-title product_title entry-title']");
    public static String randomNumber = String.valueOf(SimpleMath.random(3, 8));
    private static final By randomItem = By.xpath(
            "(//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link'])[%s]".formatted(randomNumber));
     public static int randomAmount = SimpleMath.random(3, 8);

    public static void addItemSpongeBobTshirt() {
        Common.clickOnElement(categoryKempiniukas);
        Common.clickOnElement(tShirtVeidukas);
        System.out.println("Pasirinktas produktas: " + Common.getTextFromElement(productTitle));
        Common.clickOnElement(buttonAddToCart);
    }

    public static void addRandomItem() {
        Common.clickOnElement(categoryKempiniukas);
        Common.clickOnElement(randomItem);
        Common.clickOnElement(buttonAddToCart);
    }

    public static void addRandomAmountOfItems() {
        for (int i = 0; i < randomAmount; i++) {
            HomePage.clickMusuDizainaiElement(); addRandomItem();
        }
    }
}
