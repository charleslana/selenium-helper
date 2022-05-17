package charles.com.interfaces;

import charles.com.factory.ExtentFactory;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface SeleniumHelperType extends SeleniumHelperElement {

    Logger logger = LoggerFactory.getLogger(SeleniumHelperType.class);

    default void typeByClassName(String className, CharSequence textToType) {
        try {
            sendKeys(findByClassName(className), textToType);
            setLog("className", className, textToType);
        } catch (Exception e) {
            setLog("className", className, textToType, true);
            e.printStackTrace();
        }
    }

    default void typeByClassName(String className, Integer classNameIndex, CharSequence textToType) {
        try {
            sendKeys(findAllByClassName(className).get(classNameIndex), textToType);
            setLog("className", className, textToType);
        } catch (Exception e) {
            setLog("className", className, textToType, true);
            e.printStackTrace();
        }
    }

    default void typeByCss(String css, CharSequence textToType) {
        try {
            sendKeys(findByCss(css), textToType);
            setLog("css", css, textToType);
        } catch (Exception e) {
            setLog("css", css, textToType, true);
            e.printStackTrace();
        }
    }

    default void typeByCss(String css, Integer cssIndex, CharSequence textToType) {
        try {
            sendKeys(findAllByCss(css).get(cssIndex), textToType);
            setLog("css", css, textToType);
        } catch (Exception e) {
            setLog("css", css, textToType, true);
            e.printStackTrace();
        }
    }

    default void typeById(String id, CharSequence textToType) {
        try {
            sendKeys(findById(id), textToType);
            setLog("id", id, textToType);
        } catch (Exception e) {
            setLog("id", id, textToType, true);
            e.printStackTrace();
        }
    }

    default void typeByLinkText(String linkText, CharSequence textToType) {
        try {
            sendKeys(findByLinkText(linkText), textToType);
            setLog("linkText", linkText, textToType);
        } catch (Exception e) {
            setLog("linkText", linkText, textToType, true);
            e.printStackTrace();
        }
    }

    default void typeByLinkText(String linkText, Integer linkTextIndex, CharSequence textToType) {
        try {
            sendKeys(findAllByLinkText(linkText).get(linkTextIndex), textToType);
            setLog("linkText", linkText, textToType);
        } catch (Exception e) {
            setLog("linkText", linkText, textToType, true);
            e.printStackTrace();
        }
    }

    default void typeByName(String name, CharSequence textToType) {
        try {
            sendKeys(findByName(name), textToType);
            setLog("name", name, textToType);
        } catch (Exception e) {
            setLog("name", name, textToType, true);
            e.printStackTrace();
        }
    }

    default void typeByName(String name, Integer nameIndex, CharSequence textToType) {
        try {
            sendKeys(findAllByName(name).get(nameIndex), textToType);
            setLog("name", name, textToType);
        } catch (Exception e) {
            setLog("name", name, textToType, true);
            e.printStackTrace();
        }
    }

    default void typeByPartialLinkText(String partialLinkText, CharSequence textToType) {
        try {
            sendKeys(findByPartialLinkText(partialLinkText), textToType);
            setLog("partialLinkText", partialLinkText, textToType);
        } catch (Exception e) {
            setLog("partialLinkText", partialLinkText, textToType, true);
            e.printStackTrace();
        }
    }

    default void typeByPartialLinkText(String partialLinkText, Integer partialLinkTextIndex, CharSequence textToType) {
        try {
            sendKeys(findAllByPartialLinkText(partialLinkText).get(partialLinkTextIndex), textToType);
            setLog("partialLinkText", partialLinkText, textToType);
        } catch (Exception e) {
            setLog("partialLinkText", partialLinkText, textToType, true);
            e.printStackTrace();
        }
    }

    default void typeByTagName(String tagName, CharSequence textToType) {
        try {
            sendKeys(findByTagName(tagName), textToType);
            setLog("tagName", tagName, textToType);
        } catch (Exception e) {
            setLog("tagName", tagName, textToType, true);
            e.printStackTrace();
        }
    }

    default void typeByTagName(String tagName, Integer tagNameIndex, CharSequence textToType) {
        try {
            sendKeys(findAllByTagName(tagName).get(tagNameIndex), textToType);
            setLog("tagName", tagName, textToType);
        } catch (Exception e) {
            setLog("tagName", tagName, textToType, true);
            e.printStackTrace();
        }
    }

    default void typeByXpath(String xpath, CharSequence textToType) {
        try {
            sendKeys(findByXpath(xpath), textToType);
            setLog("xpath", xpath, textToType);
        } catch (Exception e) {
            setLog("xpath", xpath, textToType, true);
            e.printStackTrace();
        }
    }

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
        if (Boolean.TRUE.equals(isFail)) {
            logger.error("Could not type text {} to element by {} with selector {}", textToType, by, selector);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Could not type text %s to element by %s with selector %s", textToType, by, selector));
            return;
        }
        logger.info("Type text {} to element by {} with selector {}", textToType, by, selector);
        ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Type text %s to element by %s with selector %s", textToType, by, selector));
    }
}
