package lt.vcs.pom.page.marskineliai;

import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;

public class KrepselisPage {

    private static final By spanCartCount = By.xpath("//span[@class='cart-count']");


    public static String readCartBadgeNumber() {
        return Common.getTextFromElement(spanCartCount);
    }
}
