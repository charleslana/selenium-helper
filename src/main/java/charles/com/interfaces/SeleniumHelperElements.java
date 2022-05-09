package charles.com.interfaces;

import charles.com.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface SeleniumHelperElements {

    default List<WebElement> findAllByClassName(String className) {
        return getDriver().findElements(By.className(className));
    }

    default List<WebElement> findAllByCss(String css) {
        return getDriver().findElements(By.cssSelector(css));
    }

    default List<WebElement> findAllByLinkText(String linkText) {
        return getDriver().findElements(By.linkText(linkText));
    }

    default List<WebElement> findAllByName(String name) {
        return getDriver().findElements(By.name(name));
    }

    default List<WebElement> findAllByPartialLinkText(String partialLinkText) {
        return getDriver().findElements(By.partialLinkText(partialLinkText));
    }

    /**
     * Method that fetches all page element name tags
     *
     * @param tagName tag name from element
     * @return List of WebElement
     */
    default List<WebElement> findAllByTagName(String tagName) {
        return getDriver().findElements(By.tagName(tagName));
    }

    default List<WebElement> findAllByXpath(String xpath) {
        return getDriver().findElements(By.xpath(xpath));
    }

    private WebDriver getDriver() {
        return DriverFactory.getInstance().getDriver();
    }
}
