package lt.vcs.pom.page.marskineliai;

import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;

public class WishListPage {
    public static final By productTitleInWishlist = By.xpath("//td[@class='product-name']");
    public static final By spanWishListIconCount = By.xpath("//span[@class='wishlist-count']");

    public static String readWishlistItemTitle() {
        return Common.getTextFromElement(productTitleInWishlist);
    }

    public static String getWishListIconCount() {
        return Common.getTextFromElement(spanWishListIconCount);
    }
}
