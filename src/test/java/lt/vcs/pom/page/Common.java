package lt.vcs.pom.page;

import lt.vcs.pom.util.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Common {

    public static void setUpChrome(int sec){
        Driver.setChromeDriver();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
        getWebDriverWait(sec).until(
                driver ->  getJsExecutor().executeScript("return document.readyState").equals("complete")
        );
    }

    public static void openUrl(String url) {
        Driver.getDriver().get(url);
    }

    public static void close() {
        Driver.quitDriver();
    }

    public static String getTabTitle() {
        return Driver.getDriver().getTitle();
    }

    public static String getCurrentUrl() {
        return Driver.getDriver().getCurrentUrl();
    }
    private static JavascriptExecutor getJsExecutor(){
        return (JavascriptExecutor)  Driver.getDriver();
    }

    public static WebElement getElement(By locator){
        return Driver.getDriver().findElement(locator);
    }

    private static List<WebElement> getElements(By locator){
        return Driver.getDriver().findElements(locator);
    }

    public static void sendKeysToElement(By locator, String input) {
        getElement(locator).sendKeys(input);

    }

    public static void clickOnElement(By locator) {
        getElement(locator).click();
    }

    public static String getTextFromElement(By locator) {
        return getElement(locator).getText();
    }

    public static Map<String, Object> getCommonElementDetails(By locator){
        Map<String, Object> elementDetails = new LinkedHashMap<>();
        WebElement element = getElement(locator);


        elementDetails.put("tagName", element.getTagName());
        elementDetails.put("isDisplayed", element.isDisplayed());
        elementDetails.put("isEnabled", element.isEnabled());
        elementDetails.put("isSelected", element.isSelected());
        elementDetails.put("location", element.getLocation());

        return elementDetails;

    }

    public static String getElementAttributeValue(By locator, String attributeName) {
        return getElement(locator).getAttribute(attributeName);
    }

    public static Map<String, String> getElementAllAttributes(By locator) {
        String script =
                "var items = {}; " +
                        "for (index = 0; index < arguments[0].attributes.length; ++index) { " +
                        "   items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value; " +
                        "}; " +
                        "return items;";

        return (Map<String, String>) getJsExecutor().executeScript(script, getElement(locator));
    }

    public static boolean isElementEnabled(By locator) {
        return getElement(locator).isEnabled();
    }

    public static boolean isElementSelected(By locator) {
        return getElement(locator).isSelected();
    }

    public static boolean waitCustomisedElementSelected(By locator, int seconds) {
        WebElement element = getElement(locator);

        for (int i = 0; i < seconds * 2; i++) {
            try {
                if (element.isSelected()) return true;
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public static WebDriverWait getWebDriverWait( int seconds){
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
    }

    public static void waitElementSelected(By locator, int seconds) {
        getWebDriverWait(seconds).until(ExpectedConditions.elementToBeSelected(locator));
    }

    public static void waitElementIsClickable(By locator, int seconds) {
        getWebDriverWait(seconds).until(ExpectedConditions.elementToBeSelected(locator));


    }

    public static void waitElementAttributeContains(
            By locator, String attributeName, String attributeValueContains, int seconds)
    {
        getWebDriverWait(seconds)
                .until(ExpectedConditions.attributeContains(locator, attributeName, attributeValueContains));
    }

    public static void waitElementIsVisible(By locator, int seconds) {
        getWebDriverWait(seconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitElementToBeVisible(By locator, int seconds) {
        getWebDriverWait(seconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public static boolean isElementDisplayed(By locator) {
        getElement(locator).isDisplayed();
        return true;
    }

    public static void waitForPageLoadAndAjaxComplete(int seconds) {
        getWebDriverWait(seconds).until(driver -> {
            // Tikrina puslapio būklę ir aktyvias užklausas
            String readyState = (String) getJsExecutor().executeScript("return document.readyState");
            Boolean ajaxComplete = (Boolean) getJsExecutor().executeScript(
                    "return (typeof jQuery !== 'undefined' ? jQuery.active == 0 : true) && " +
                            "!(window.fetch && window.__pendingFetchCount > 0);"
            );
            return "complete".equals(readyState) && ajaxComplete;
        });
    }

    private static Select getSelectElement(By locator){
        return new Select(getElement(locator));
    }

    public static void selectOptionByValue(By locator, String value) {
        getSelectElement(locator).selectByValue(value);
    }

    public static String readSelectedOptionValue(By locator) {
        return getSelectElement(locator).getFirstSelectedOption().getAttribute("value");
    }

    public static void selectMultipleValues(By locator, List<String> values) {
        Select select = getSelectElement(locator);
        for (String value : values) {
            select.selectByValue(value);
        }
    }

    public static List<String> getSelectedOptionValues(By locator) {
        List<String> selectedValues = new ArrayList<>();
        List<WebElement> allSelectedOptions = getSelectElement(locator).getAllSelectedOptions();

        for (WebElement element : allSelectedOptions) {
            selectedValues.add(element.getAttribute("value"));
        }

        return  selectedValues;
    }

    public static void clickOnElements(By locator) {
        getElements(locator).forEach(WebElement::click);
    }

    public static List<String> getTextFromElements(By locator) {
        List<String> textFromElements = new ArrayList<>();
        for (WebElement element : getElements(locator)) {
            textFromElements.add(element.getText());

        }
        return textFromElements;
    }

    public static void scrollDownWithJSExecutor() {
        getJsExecutor().executeScript("window.scroll(0, 800)");
    }

    public static void scrollDownWithJSExecutorToElement(By locator) {
        getJsExecutor().executeScript("arguments[0].scrollIntoView(true)", getElement(locator));
    }

    public static void scrollDownWithActions() {
        Actions actions = new Actions(Driver.getDriver());
        actions
                .sendKeys(Keys.PAGE_DOWN)
                .build()
                .perform();
    }

    public static void clickOnElementWithActions(By locator) {
        Actions actions = new Actions(Driver.getDriver());
        actions
                .click(getElement(locator))
                .build()
                .perform();
    }

    public static void doubleClickElementWithActions(By locator) {
        Actions actions = new Actions(Driver.getDriver());
        actions
                .doubleClick(getElement(locator))
                .build()
                .perform();
    }

    public static void rightClickElementWitActions(By locator) {
        Actions actions = new Actions(Driver.getDriver());
        actions
                .contextClick(getElement(locator))
                .build()
                .perform();
    }

    public static List<Boolean> getListAllElementsSelected(By locator) {
        List<Boolean> selectedElements = new ArrayList<>();
        for (WebElement element : Common.getElements(locator)) {
            selectedElements.add(element.isSelected());
        }
        return selectedElements;
    }
}
