package charles.com.interfaces;

import charles.com.factory.ExtentFactory;
import com.aventstack.extentreports.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clear fields functionality interface
 *
 * @author Charles Lana
 * @version 1.1.0
 */
public interface SeleniumHelperClear extends SeleniumHelperElement {

    /**
     * Method that clears field by class name
     *
     * @param className class name field
     */
    default void clearByClassName(String className) {
        try {
            findByClassName(className).clear();
            setLog("className", className);
        } catch (Exception e) {
            setLog("className", className, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clears field by class name with index
     *
     * @param className      class name field
     * @param classNameIndex class name index
     */
    default void clearByClassName(String className, Integer classNameIndex) {
        try {
            findAllByClassName(className).get(classNameIndex).clear();
            setLog("className", className);
        } catch (Exception e) {
            setLog("className", className, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clears field by css
     *
     * @param css css field
     */
    default void clearByCss(String css) {
        try {
            findByCss(css).clear();
            setLog("css", css);
        } catch (Exception e) {
            setLog("css", css, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clears field by css with index
     *
     * @param css      css field
     * @param cssIndex css index
     */
    default void clearByCss(String css, Integer cssIndex) {
        try {
            findAllByCss(css).get(cssIndex).clear();
            setLog("css", css);
        } catch (Exception e) {
            setLog("css", css, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clears field by id
     *
     * @param id css field
     */
    default void clearById(String id) {
        try {
            findById(id).clear();
            setLog("id", id);
        } catch (Exception e) {
            setLog("id", id, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clears field by link text
     *
     * @param linkText link text field
     */
    default void clearByLinkText(String linkText) {
        try {
            findByLinkText(linkText).clear();
            setLog("linkText", linkText);
        } catch (Exception e) {
            setLog("linkText", linkText, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clears field by link text with index
     *
     * @param linkText      link text field
     * @param linkTextIndex link text index
     */
    default void clearByLinkText(String linkText, Integer linkTextIndex) {
        try {
            findAllByLinkText(linkText).get(linkTextIndex).clear();
            setLog("linkText", linkText);
        } catch (Exception e) {
            setLog("linkText", linkText, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clears field by name
     *
     * @param name name field
     */
    default void clearByName(String name) {
        try {
            findByName(name).clear();
            setLog("name", name);
        } catch (Exception e) {
            setLog("name", name, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clears field by name with index
     *
     * @param name      name field
     * @param nameIndex name index
     */
    default void clearByName(String name, Integer nameIndex) {
        try {
            findAllByName(name).get(nameIndex).clear();
            setLog("name", name);
        } catch (Exception e) {
            setLog("name", name, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clears field by partial link text
     *
     * @param partialLinkText link text partial field
     */
    default void clearByPartialLinkText(String partialLinkText) {
        try {
            findByPartialLinkText(partialLinkText).clear();
            setLog("partialLinkText", partialLinkText);
        } catch (Exception e) {
            setLog("partialLinkText", partialLinkText, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clears field by partial link text with index
     *
     * @param partialLinkText      link text partial field
     * @param partialLinkTextIndex link text partial index
     */
    default void clearByPartialLinkText(String partialLinkText, Integer partialLinkTextIndex) {
        try {
            findAllByPartialLinkText(partialLinkText).get(partialLinkTextIndex).clear();
            setLog("partialLinkText", partialLinkText);
        } catch (Exception e) {
            setLog("partialLinkText", partialLinkText, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clears field by tag name
     *
     * @param tagName tag name field
     */
    default void clearByTagName(String tagName) {
        try {
            findByTagName(tagName).clear();
            setLog("tagName", tagName);
        } catch (Exception e) {
            setLog("tagName", tagName, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clears field by tag name with index
     *
     * @param tagName      tag name field
     * @param tagNameIndex tag name index
     */
    default void clearByTagName(String tagName, Integer tagNameIndex) {
        try {
            findAllByTagName(tagName).get(tagNameIndex).clear();
            setLog("tagName", tagName);
        } catch (Exception e) {
            setLog("tagName", tagName, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clears field by xpath
     *
     * @param xpath xpath field
     */
    default void clearByXpath(String xpath) {
        try {
            findByXpath(xpath).clear();
            setLog("xpath", xpath);
        } catch (Exception e) {
            setLog("xpath", xpath, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that clears field by xpath with index
     *
     * @param xpath      xpath field
     * @param xpathIndex xpath index
     */
    default void clearByXpath(String xpath, Integer xpathIndex) {
        try {
            findAllByXpath(xpath).get(xpathIndex).clear();
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
        Logger log = LoggerFactory.getLogger(SeleniumHelperClear.class);
        if (Boolean.TRUE.equals(isFail)) {
            log.error("Could not clear element by {} with selector {}", by, selector);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Could not clear element by %s with selector %s", by, selector));
            return;
        }
        log.info("Clear element by {} with selector {}", by, selector);
        ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Clear element by %s with selector %s", by, selector));
    }
}
