package lt.vcs.pom.page.marskineliai;

import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;

public class HomePage {

    private static final By logInLinkIcon = By.xpath("(//i[@class='icon-user'])[1]");



    public static void open() {
        Common.setUpChrome(7);
        Common.openUrl("https://marskineliai.lt/");
    }


    public static void clickLogInIcon() {
        Common.waitElementToBeVisible(logInLinkIcon,4);
        Common.clickOnElement(logInLinkIcon);
    }



}
