package charles.com.interfaces;

import charles.com.factory.ExtentFactory;
import com.aventstack.extentreports.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Element click functionality class
 *
 * @author Charles Lana
 * @version 1.0.0
 */
public interface SeleniumHelperClick extends SeleniumHelperElement {

    Logger logger = LoggerFactory.getLogger(SeleniumHelperClick.class);

    /**
     * Method that clicks on element by class name
     *
     * @param className class name element
     */
    default void clickByClassName(String className) {
        try {
            findByClassName(className).click();
            setLog("className", className);
        } catch (Exception e) {
            setLog("className", className, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clicks on element by class name with index
     *
     * @param className      class name element
     * @param classNameIndex class name index
     */
    default void clickByClassName(String className, Integer classNameIndex) {
        try {
            findAllByClassName(className).get(classNameIndex).click();
            setLog("className", className);
        } catch (Exception e) {
            setLog("className", className, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clicks on element by css
     *
     * @param css css element
     */
    default void clickByCss(String css) {
        try {
            findByCss(css).click();
            setLog("css", css);
        } catch (Exception e) {
            setLog("css", css, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clicks on element by css with index
     *
     * @param css      css element
     * @param cssIndex css index
     */
    default void clickByCss(String css, Integer cssIndex) {
        try {
            findAllByCss(css).get(cssIndex).click();
            setLog("css", css);
        } catch (Exception e) {
            setLog("css", css, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clicks on element by id
     *
     * @param id id element
     */
    default void clickById(String id) {
        try {
            findById(id).click();
            setLog("id", id);
        } catch (Exception e) {
            setLog("id", id, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clicks on element by link text
     *
     * @param linkText link text element
     */
    default void clickByLinkText(String linkText) {
        try {
            findByLinkText(linkText).click();
            setLog("linkText", linkText);
        } catch (Exception e) {
            setLog("linkText", linkText, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clicks on element by link text with index
     *
     * @param linkText      link text element
     * @param linkTextIndex link text index
     */
    default void clickByLinkText(String linkText, Integer linkTextIndex) {
        try {
            findAllByLinkText(linkText).get(linkTextIndex).click();
            setLog("linkText", linkText);
        } catch (Exception e) {
            setLog("linkText", linkText, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clicks on element by name
     *
     * @param name name element
     */
    default void clickByName(String name) {
        try {
            findByName(name).click();
            setLog("name", name);
        } catch (Exception e) {
            setLog("name", name, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clicks on element by name with index
     *
     * @param name      name element
     * @param nameIndex name index
     */
    default void clickByName(String name, Integer nameIndex) {
        try {
            findAllByName(name).get(nameIndex).click();
            setLog("name", name);
        } catch (Exception e) {
            setLog("name", name, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clicks on element by partial link text
     *
     * @param partialLinkText link text partial element
     */
    default void clickByPartialLinkText(String partialLinkText) {
        try {
            findByPartialLinkText(partialLinkText).click();
            setLog("partialLinkText", partialLinkText);
        } catch (Exception e) {
            setLog("partialLinkText", partialLinkText, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clicks on element by link text partial with index
     *
     * @param partialLinkText      link text partial element
     * @param partialLinkTextIndex link text partial index
     */
    default void clickByPartialLinkText(String partialLinkText, Integer partialLinkTextIndex) {
        try {
            findAllByPartialLinkText(partialLinkText).get(partialLinkTextIndex).click();
            setLog("partialLinkText", partialLinkText);
        } catch (Exception e) {
            setLog("partialLinkText", partialLinkText, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clicks on element by tag name
     *
     * @param tagName tag name element
     */
    default void clickByTagName(String tagName) {
        try {
            findByTagName(tagName).click();
            setLog("tagName", tagName);
        } catch (Exception e) {
            setLog("tagName", tagName, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clicks on element by tag name with index
     *
     * @param tagName      tag name element
     * @param tagNameIndex tag name index
     */
    default void clickByTagName(String tagName, Integer tagNameIndex) {
        try {
            findAllByTagName(tagName).get(tagNameIndex).click();
            setLog("tagName", tagName);
        } catch (Exception e) {
            setLog("tagName", tagName, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clicks on element by xpath
     *
     * @param xpath xpath element
     */
    default void clickByXpath(String xpath) {
        try {
            findByXpath(xpath).click();
            setLog("xpath", xpath);
        } catch (Exception e) {
            setLog("xpath", xpath, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clicks on element by xpath with index
     *
     * @param xpath      xpath element
     * @param xpathIndex xpath index
     */
    default void clickByXpath(String xpath, Integer xpathIndex) {
        try {
            findAllByXpath(xpath).get(xpathIndex).click();
            setLog("xpath", xpath);
        } catch (Exception e) {
            setLog("xpath", xpath, true);
            e.printStackTrace();
        }
    }

    private void setLog(String by, String selector) {
        setLog(by, selector, false);
    }

    private void setLog(String by, String selector, Boolean isFail) {
        if (Boolean.TRUE.equals(isFail)) {
            logger.error("Could not click element by {} with selector {}", by, selector);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Could not click element by %s with selector %s", by, selector));
            return;
        }
        logger.info("Click element by {} with selector {}", by, selector);
        ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Click element by %s with selector %s", by, selector));
    }
}
