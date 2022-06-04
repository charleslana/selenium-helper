package charles.com.interfaces;

import charles.com.factory.DriverFactory;
import charles.com.factory.ExtentFactory;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Interface for move functionality
 *
 * @author Charles Lana
 * @version 1.0.0
 */
public interface SeleniumHelperMove extends SeleniumHelperElement {

    /**
     * Method that move on element
     *
     * @param element element page
     */
    default void move(WebElement element) {
        try {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(element).perform();
            setLog("element", element);
        } catch (Exception e) {
            setLog("element", element, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that move on element by class name
     *
     * @param className class name element
     */
    default void moveByClassName(String className) {
        try {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(findByClassName(className)).perform();
            setLog("className", className);
        } catch (Exception e) {
            setLog("className", className, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that move on element by class name with index
     *
     * @param className      class name element
     * @param classNameIndex class name index
     */
    default void moveByClassName(String className, Integer classNameIndex) {
        try {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(findAllByClassName(className).get(classNameIndex)).perform();
            setLog("className", className);
        } catch (Exception e) {
            setLog("className", className, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that move on element by css
     *
     * @param css css element
     */
    default void moveByCss(String css) {
        try {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(findByCss(css)).perform();
            setLog("css", css);
        } catch (Exception e) {
            setLog("css", css, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that move on element by css with index
     *
     * @param css      css element
     * @param cssIndex css index
     */
    default void moveByCss(String css, Integer cssIndex) {
        try {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(findAllByCss(css).get(cssIndex)).perform();
            setLog("css", css);
        } catch (Exception e) {
            setLog("css", css, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that move on element by id
     *
     * @param id id element
     */
    default void moveById(String id) {
        try {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(findById(id)).perform();
            setLog("id", id);
        } catch (Exception e) {
            setLog("id", id, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that move on element by link text
     *
     * @param linkText link text element
     */
    default void moveByLinkText(String linkText) {
        try {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(findByLinkText(linkText)).perform();
            setLog("linkText", linkText);
        } catch (Exception e) {
            setLog("linkText", linkText, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that move on element by link text with index
     *
     * @param linkText      link text element
     * @param linkTextIndex link text index
     */
    default void moveByLinkText(String linkText, Integer linkTextIndex) {
        try {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(findAllByLinkText(linkText).get(linkTextIndex)).perform();
            setLog("linkText", linkText);
        } catch (Exception e) {
            setLog("linkText", linkText, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that move on element by name
     *
     * @param name name element
     */
    default void moveByName(String name) {
        try {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(findByName(name)).perform();
            setLog("name", name);
        } catch (Exception e) {
            setLog("name", name, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that move on element by name with index
     *
     * @param name      name element
     * @param nameIndex name index
     */
    default void moveByName(String name, Integer nameIndex) {
        try {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(findAllByName(name).get(nameIndex)).perform();
            setLog("name", name);
        } catch (Exception e) {
            setLog("name", name, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that move on element by partial link text
     *
     * @param partialLinkText link text partial element
     */
    default void moveByPartialLinkText(String partialLinkText) {
        try {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(findByPartialLinkText(partialLinkText)).perform();
            setLog("partialLinkText", partialLinkText);
        } catch (Exception e) {
            setLog("partialLinkText", partialLinkText, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that move on element by link text partial with index
     *
     * @param partialLinkText      link text partial element
     * @param partialLinkTextIndex link text partial index
     */
    default void moveByPartialLinkText(String partialLinkText, Integer partialLinkTextIndex) {
        try {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(findAllByPartialLinkText(partialLinkText).get(partialLinkTextIndex)).perform();
            setLog("partialLinkText", partialLinkText);
        } catch (Exception e) {
            setLog("partialLinkText", partialLinkText, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that move on element by tag name
     *
     * @param tagName tag name element
     */
    default void moveByTagName(String tagName) {
        try {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(findByTagName(tagName)).perform();
            setLog("tagName", tagName);
        } catch (Exception e) {
            setLog("tagName", tagName, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that move on element by tag name with index
     *
     * @param tagName      tag name element
     * @param tagNameIndex tag name index
     */
    default void moveByTagName(String tagName, Integer tagNameIndex) {
        try {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(findAllByTagName(tagName).get(tagNameIndex)).perform();
            setLog("tagName", tagName);
        } catch (Exception e) {
            setLog("tagName", tagName, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that move on element by xpath
     *
     * @param xpath xpath element
     */
    default void moveByXpath(String xpath) {
        try {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(findByXpath(xpath)).perform();
            setLog("xpath", xpath);
        } catch (Exception e) {
            setLog("xpath", xpath, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that move on element by xpath with index
     *
     * @param xpath      xpath element
     * @param xpathIndex xpath index
     */
    default void moveByXpath(String xpath, Integer xpathIndex) {
        try {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(findAllByXpath(xpath).get(xpathIndex)).perform();
            setLog("xpath", xpath);
        } catch (Exception e) {
            setLog("xpath", xpath, true);
            e.printStackTrace();
        }
    }

    private WebDriver getDriver() {
        return DriverFactory.getInstance().getDriver();
    }

    private void setLog(String by, Object selector) {
        setLog(by, selector, false);
    }

    private void setLog(String by, Object selector, Boolean isFail) {
        Logger log = LoggerFactory.getLogger(SeleniumHelperMove.class);
        if (Boolean.TRUE.equals(isFail)) {
            log.error("Could not move element by {} with selector {}", by, selector);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Could not move element by %s with selector %s", by, selector));
            return;
        }
        log.info("Move element by {} with selector {}", by, selector);
        ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Move element by %s with selector %s", by, selector));
    }
}
