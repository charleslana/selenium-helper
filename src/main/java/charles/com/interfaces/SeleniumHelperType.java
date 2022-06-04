package charles.com.interfaces;

import charles.com.factory.ExtentFactory;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Type-in-element functionality interface
 *
 * @author Charles Lana
 * @version 1.1.0
 */
public interface SeleniumHelperType extends SeleniumHelperElement {

    /**
     * Method that type on element by class name
     *
     * @param className  class name element
     * @param textToType text to type
     */
    default void typeByClassName(String className, CharSequence textToType) {
        try {
            sendKeys(findByClassName(className), textToType);
            setLog("className", className, textToType);
        } catch (Exception e) {
            setLog("className", className, textToType, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that type on element by class name with index
     *
     * @param className      class name element
     * @param classNameIndex class name index
     * @param textToType     text to type
     */
    default void typeByClassName(String className, Integer classNameIndex, CharSequence textToType) {
        try {
            sendKeys(findAllByClassName(className).get(classNameIndex), textToType);
            setLog("className", className, textToType);
        } catch (Exception e) {
            setLog("className", className, textToType, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that type on element by css
     *
     * @param css        css element
     * @param textToType text to type
     */
    default void typeByCss(String css, CharSequence textToType) {
        try {
            sendKeys(findByCss(css), textToType);
            setLog("css", css, textToType);
        } catch (Exception e) {
            setLog("css", css, textToType, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that type on element by css with index
     *
     * @param css        css element
     * @param cssIndex   css index
     * @param textToType text to type
     */
    default void typeByCss(String css, Integer cssIndex, CharSequence textToType) {
        try {
            sendKeys(findAllByCss(css).get(cssIndex), textToType);
            setLog("css", css, textToType);
        } catch (Exception e) {
            setLog("css", css, textToType, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that type on element by id
     *
     * @param id         id element
     * @param textToType text to type
     */
    default void typeById(String id, CharSequence textToType) {
        try {
            sendKeys(findById(id), textToType);
            setLog("id", id, textToType);
        } catch (Exception e) {
            setLog("id", id, textToType, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that type on element by link text
     *
     * @param linkText   link text element
     * @param textToType text to type
     */
    default void typeByLinkText(String linkText, CharSequence textToType) {
        try {
            sendKeys(findByLinkText(linkText), textToType);
            setLog("linkText", linkText, textToType);
        } catch (Exception e) {
            setLog("linkText", linkText, textToType, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that type on element by link text with index
     *
     * @param linkText      link text element
     * @param linkTextIndex link text index
     * @param textToType    text to type
     */
    default void typeByLinkText(String linkText, Integer linkTextIndex, CharSequence textToType) {
        try {
            sendKeys(findAllByLinkText(linkText).get(linkTextIndex), textToType);
            setLog("linkText", linkText, textToType);
        } catch (Exception e) {
            setLog("linkText", linkText, textToType, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that type on element by name
     *
     * @param name       name element
     * @param textToType text to type
     */
    default void typeByName(String name, CharSequence textToType) {
        try {
            sendKeys(findByName(name), textToType);
            setLog("name", name, textToType);
        } catch (Exception e) {
            setLog("name", name, textToType, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that type on element by name with index
     *
     * @param name       name element
     * @param nameIndex  name index
     * @param textToType text to type
     */
    default void typeByName(String name, Integer nameIndex, CharSequence textToType) {
        try {
            sendKeys(findAllByName(name).get(nameIndex), textToType);
            setLog("name", name, textToType);
        } catch (Exception e) {
            setLog("name", name, textToType, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that type on element by partial link text
     *
     * @param partialLinkText link text partial element
     * @param textToType      text to type
     */
    default void typeByPartialLinkText(String partialLinkText, CharSequence textToType) {
        try {
            sendKeys(findByPartialLinkText(partialLinkText), textToType);
            setLog("partialLinkText", partialLinkText, textToType);
        } catch (Exception e) {
            setLog("partialLinkText", partialLinkText, textToType, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that type on element by link text partial with index
     *
     * @param partialLinkText      link text partial element
     * @param partialLinkTextIndex link text partial index
     * @param textToType           text to type
     */
    default void typeByPartialLinkText(String partialLinkText, Integer partialLinkTextIndex, CharSequence textToType) {
        try {
            sendKeys(findAllByPartialLinkText(partialLinkText).get(partialLinkTextIndex), textToType);
            setLog("partialLinkText", partialLinkText, textToType);
        } catch (Exception e) {
            setLog("partialLinkText", partialLinkText, textToType, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that type on element by tag name
     *
     * @param tagName    tag name element
     * @param textToType text to type
     */
    default void typeByTagName(String tagName, CharSequence textToType) {
        try {
            sendKeys(findByTagName(tagName), textToType);
            setLog("tagName", tagName, textToType);
        } catch (Exception e) {
            setLog("tagName", tagName, textToType, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that type on element by tag name with index
     *
     * @param tagName      tag name element
     * @param tagNameIndex tag name index
     * @param textToType   text to type
     */
    default void typeByTagName(String tagName, Integer tagNameIndex, CharSequence textToType) {
        try {
            sendKeys(findAllByTagName(tagName).get(tagNameIndex), textToType);
            setLog("tagName", tagName, textToType);
        } catch (Exception e) {
            setLog("tagName", tagName, textToType, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that type on element by xpath
     *
     * @param xpath      xpath element
     * @param textToType text to type
     */
    default void typeByXpath(String xpath, CharSequence textToType) {
        try {
            sendKeys(findByXpath(xpath), textToType);
            setLog("xpath", xpath, textToType);
        } catch (Exception e) {
            setLog("xpath", xpath, textToType, true);
            e.printStackTrace();
        }
    }

    /**
     * Method that type on element by xpath with index
     *
     * @param xpath      xpath element
     * @param xpathIndex xpath index
     * @param textToType text to type
     */
    default void typeByXpath(String xpath, Integer xpathIndex, CharSequence textToType) {
        try {
            sendKeys(findAllByXpath(xpath).get(xpathIndex), textToType);
            setLog("xpath", xpath, textToType);
        } catch (Exception e) {
            setLog("xpath", xpath, textToType, true);
            e.printStackTrace();
        }
    }

    private void sendKeys(WebElement webElement, CharSequence charSequence) {
        webElement.sendKeys(charSequence);
    }

    private void setLog(String by, String selector, CharSequence textToType) {
        setLog(by, selector, textToType, false);
    }

    private void setLog(String by, String selector, CharSequence textToType, Boolean isFail) {
        Logger log = LoggerFactory.getLogger(SeleniumHelperType.class);
        if (Boolean.TRUE.equals(isFail)) {
            log.error("Could not type text {} to element by {} with selector {}", textToType, by, selector);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Could not type text %s to element by %s with selector %s", textToType, by, selector));
            return;
        }
        log.info("Type text {} to element by {} with selector {}", textToType, by, selector);
        ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Type text %s to element by %s with selector %s", textToType, by, selector));
    }
}
