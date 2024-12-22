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

        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--force-device-scale-factor=0.9");

        driver.set(new ChromeDriver(chromeOptions));

    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver(){
        driver.get().quit();
        driver.remove();
    }



}
