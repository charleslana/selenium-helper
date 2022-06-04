package charles.com.interfaces;

import charles.com.factory.DriverFactory;
import charles.com.factory.ExtentFactory;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Interface get all page elements
 *
 * @author Charles Lana
 * @version 1.1.0
 */
public interface SeleniumHelperElements {

    /**
     * Method that fetches all page element by
     *
     * @param by by from element
     * @return List of WebElement
     */
    default List<WebElement> findAll(By by) {
        List<WebElement> elements = null;
        try {
            elements = getDriver().findElements(by);
            setLog("by", by);
        } catch (Exception e) {
            setLog("by", by, true);
            e.printStackTrace();
        }
        return elements;
    }

    /**
     * Method that fetches all element class name from page
     *
     * @param className class name from element
     * @return List of WebElement
     */
    default List<WebElement> findAllByClassName(String className) {
        List<WebElement> elements = null;
        try {
            elements = getDriver().findElements(By.className(className));
            setLog("className", className);
        } catch (Exception e) {
            setLog("className", className, true);
            e.printStackTrace();
        }
        return elements;
    }

    /**
     * Method that fetches all element css from page
     *
     * @param css css from element
     * @return List of WebElement
     */
    default List<WebElement> findAllByCss(String css) {
        List<WebElement> elements = null;
        try {
            elements = getDriver().findElements(By.cssSelector(css));
            setLog("css", css);
        } catch (Exception e) {
            setLog("css", css, true);
            e.printStackTrace();
        }
        return elements;
    }

    /**
     * Method that fetches all element link text from page
     *
     * @param linkText link text from element
     * @return List of WebElement
     */
    default List<WebElement> findAllByLinkText(String linkText) {
        List<WebElement> elements = null;
        try {
            elements = getDriver().findElements(By.linkText(linkText));
            setLog("linkText", linkText);
        } catch (Exception e) {
            setLog("linkText", linkText, true);
            e.printStackTrace();
        }
        return elements;
    }

    /**
     * Method that fetches all element name from page
     *
     * @param name name from element
     * @return List of WebElement
     */
    default List<WebElement> findAllByName(String name) {
        List<WebElement> elements = null;
        try {
            elements = getDriver().findElements(By.name(name));
            setLog("name", name);
        } catch (Exception e) {
            setLog("name", name, true);
            e.printStackTrace();
        }
        return elements;
    }

    /**
     * Method that fetches all element partial link text from page
     *
     * @param partialLinkText link text partial from element
     * @return List of WebElement
     */
    default List<WebElement> findAllByPartialLinkText(String partialLinkText) {
        List<WebElement> elements = null;
        try {
            elements = getDriver().findElements(By.partialLinkText(partialLinkText));
            setLog("partialLinkText", partialLinkText);
        } catch (Exception e) {
            setLog("partialLinkText", partialLinkText, true);
            e.printStackTrace();
        }
        return elements;
    }

    /**
     * Method that fetches all element tag name from page
     *
     * @param tagName tag name from element
     * @return List of WebElement
     */
    default List<WebElement> findAllByTagName(String tagName) {
        List<WebElement> elements = null;
        try {
            elements = getDriver().findElements(By.tagName(tagName));
            setLog("tagName", tagName);
        } catch (Exception e) {
            setLog("tagName", tagName, true);
            e.printStackTrace();
        }
        return elements;
    }

    /**
     * Method that fetches all element xpath from page
     *
     * @param xpath xpath from element
     * @return List of WebElement
     */
    default List<WebElement> findAllByXpath(String xpath) {
        List<WebElement> elements = null;
        try {
            elements = getDriver().findElements(By.xpath(xpath));
            setLog("xpath", xpath);
        } catch (Exception e) {
            setLog("xpath", xpath, true);
            e.printStackTrace();
        }
        return elements;
    }

    private WebDriver getDriver() {
        return DriverFactory.getInstance().getDriver();
    }

    private void setLog(String by, Object selector) {
        setLog(by, selector, false);
    }

    private void setLog(String by, Object selector, Boolean isFail) {
        Logger log = LoggerFactory.getLogger(SeleniumHelperElements.class);
        if (Boolean.TRUE.equals(isFail)) {
            log.error("Could not find elements by {} with selector {}", by, selector);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Could not find elements by %s with selector %s", by, selector));
            return;
        }
        log.info("Find elements by {} with selector {}", by, selector);
        ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Find elements by %s with selector %s", by, selector));
    }
}
