package charles.com.interfaces;

import charles.com.factory.DriverFactory;
import charles.com.factory.ExtentFactory;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class get page element
 *
 * @author Charles Lana
 * @version 1.0.0
 */
public interface SeleniumHelperElement extends SeleniumHelperElements {

    Logger logger = LoggerFactory.getLogger(SeleniumHelperElement.class);

    /**
     * Method that fetch page element by
     *
     * @param by by from element
     * @return WebElement
     */
    default WebElement find(By by) {
        WebElement element = null;
        try {
            element = getDriver().findElement(by);
            setLog("by", by);
        } catch (Exception e) {
            setLog("by", by, true);
            e.printStackTrace();
        }
        return element;
    }

    /**
     * Method that fetch element class name from page
     *
     * @param className class name from element
     * @return WebElement
     */
    default WebElement findByClassName(String className) {
        WebElement element = null;
        try {
            element = getDriver().findElement(By.className(className));
            setLog("className", className);
        } catch (Exception e) {
            setLog("className", className, true);
            e.printStackTrace();
        }
        return element;
    }

    /**
     * Method that fetch element css from page
     *
     * @param css css from element
     * @return WebElement
     */
    default WebElement findByCss(String css) {
        WebElement element = null;
        try {
            element = getDriver().findElement(By.cssSelector(css));
            setLog("css", css);
        } catch (Exception e) {
            setLog("css", css, true);
            e.printStackTrace();
        }
        return element;
    }

    /**
     * Method that fetch element id from page
     *
     * @param id id from element
     * @return WebElement
     */
    default WebElement findById(String id) {
        WebElement element = null;
        try {
            element = getDriver().findElement(By.id(id));
            setLog("id", id);
        } catch (Exception e) {
            setLog("id", id, true);
            e.printStackTrace();
        }
        return element;
    }

    /**
     * Method that fetch element link text from page
     *
     * @param linkText link text from element
     * @return WebElement
     */
    default WebElement findByLinkText(String linkText) {
        WebElement element = null;
        try {
            element = getDriver().findElement(By.linkText(linkText));
            setLog("linkText", linkText);
        } catch (Exception e) {
            setLog("linkText", linkText, true);
            e.printStackTrace();
        }
        return element;
    }

    /**
     * Method that fetch element name from page
     *
     * @param name name from element
     * @return WebElement
     */
    default WebElement findByName(String name) {
        WebElement element = null;
        try {
            element = getDriver().findElement(By.name(name));
            setLog("name", name);
        } catch (Exception e) {
            setLog("name", name, true);
            e.printStackTrace();
        }
        return element;
    }

    /**
     * Method that fetch element partial link text from page
     *
     * @param partialLinkText link text partial from element
     * @return WebElement
     */
    default WebElement findByPartialLinkText(String partialLinkText) {
        WebElement element = null;
        try {
            element = getDriver().findElement(By.partialLinkText(partialLinkText));
            setLog("partialLinkText", partialLinkText);
        } catch (Exception e) {
            setLog("partialLinkText", partialLinkText, true);
            e.printStackTrace();
        }
        return element;
    }

    /**
     * Method that fetch element tag name from page
     *
     * @param tagName tag name from element
     * @return WebElement
     */
    default WebElement findByTagName(String tagName) {
        WebElement element = null;
        try {
            element = getDriver().findElement(By.tagName(tagName));
            setLog("tagName", tagName);
        } catch (Exception e) {
            setLog("tagName", tagName, true);
            e.printStackTrace();
        }
        return element;
    }

    /**
     * Method that fetch element xpath from page
     *
     * @param xpath xpath from element
     * @return WebElement
     */
    default WebElement findByXpath(String xpath) {
        WebElement element = null;
        try {
            element = getDriver().findElement(By.xpath(xpath));
            setLog("xpath", xpath);
        } catch (Exception e) {
            setLog("xpath", xpath, true);
            e.printStackTrace();
        }
        return element;
    }

    private WebDriver getDriver() {
        return DriverFactory.getInstance().getDriver();
    }

    private void setLog(String by, Object selector) {
        setLog(by, selector, false);
    }

    private void setLog(String by, Object selector, Boolean isFail) {
        if (Boolean.TRUE.equals(isFail)) {
            logger.error("Could not find element by {} with selector {}", by, selector);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Could not find element by %s with selector %s", by, selector));
            return;
        }
        logger.info("Find element by {} with selector {}", by, selector);
        ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Find element by %s with selector %s", by, selector));
    }
}
