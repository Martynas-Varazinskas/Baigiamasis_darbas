package lt.vcs.pom.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setChromeDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();

//        chromeOptions.addArguments("--window-position=4000,0");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--force-device-scale-factor=0.9");
//        chromeOptions.addArguments("window-size=2000,2000");
//        chromeOptions.addArguments("--headless=new");

        driver.set(new ChromeDriver(chromeOptions));

        /**
         * Zoom solution for Mac
         */
//        chromeDriver.get("chrome://settings");
//        ((JavascriptExecutor) chromeDriver).executeScript("chrome.settingsPrivate.setDefaultZoom(0.5)");
//        Thread.sleep(3000);
    }

    public static void setFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        driver.set(new FirefoxDriver(firefoxOptions));

    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver(){
        driver.get().quit();
        driver.remove();
    }
}
