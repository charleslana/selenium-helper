package charles.com.interfaces;

import charles.com.factory.DriverFactory;
import charles.com.properties.PropertiesOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public interface SeleniumHelper extends SeleniumHelperElement, SeleniumHelperElements {

    default void clearByClassName(String className) {
        findByClassName(className).clear();
    }

    default void clickByTagName(String tagName, Integer tagNameIndex) {
        findAllByTagName(tagName).get(tagNameIndex).click();
    }

    default void clickByTagName(String tagName) {
        findByTagName(tagName).click();
    }

    default String getTitle() {
        return getDriver().getTitle();
    }

    default String getUrl() {
        return getDriver().getCurrentUrl();
    }

    default void navigate(String url) {
        getDriver().get(url);
    }

    default void typeByClassName(String className, CharSequence textToType) {
        sendKeys(findByClassName(className), textToType);
    }

    default void typeById(String id, CharSequence textToType) {
        sendKeys(findById(id), textToType);
    }

    default void typeByName(String name, CharSequence textToType) {
        sendKeys(findByName(name), textToType);
    }

    default void waitVisibilityByClassName(String className) {
        await(ExpectedConditions.visibilityOf(findByClassName(className)));
    }

    private <T> void await(Function<? super WebDriver, T> isTrue) {
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(Integer.parseInt(PropertiesOperations.getPropertyValueByKey("implicitly-wait"))));
        webDriverWait.until(isTrue);
    }

    private WebDriver getDriver() {
        return DriverFactory.getInstance().getDriver();
    }

    private void sendKeys(WebElement webElement, CharSequence charSequence) {
        webElement.sendKeys(charSequence);
    }
}
