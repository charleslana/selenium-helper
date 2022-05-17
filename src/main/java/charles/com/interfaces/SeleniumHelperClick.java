package charles.com.interfaces;

import charles.com.factory.ExtentFactory;
import com.aventstack.extentreports.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface SeleniumHelperClick extends SeleniumHelperElement {

    Logger logger = LoggerFactory.getLogger(SeleniumHelperClick.class);

    default void clickByClassName(String className) {
        try {
            findByClassName(className).click();
            setLog("className", className);
        } catch (Exception e) {
            setLog("className", className, true);
            e.printStackTrace();
        }
    }

    default void clickByClassName(String className, Integer classNameIndex) {
        try {
            findAllByClassName(className).get(classNameIndex).click();
            setLog("className", className);
        } catch (Exception e) {
            setLog("className", className, true);
            e.printStackTrace();
        }
    }

    default void clickByCss(String css) {
        try {
            findByCss(css).click();
            setLog("css", css);
        } catch (Exception e) {
            setLog("css", css, true);
            e.printStackTrace();
        }
    }

    default void clickByCss(String css, Integer cssIndex) {
        try {
            findAllByCss(css).get(cssIndex).click();
            setLog("css", css);
        } catch (Exception e) {
            setLog("css", css, true);
            e.printStackTrace();
        }
    }

    default void clickById(String id) {
        try {
            findById(id).click();
            setLog("id", id);
        } catch (Exception e) {
            setLog("id", id, true);
            e.printStackTrace();
        }
    }

    default void clickByLinkText(String linkText) {
        try {
            findByLinkText(linkText).click();
            setLog("linkText", linkText);
        } catch (Exception e) {
            setLog("linkText", linkText, true);
            e.printStackTrace();
        }
    }

    default void clickByLinkText(String linkText, Integer linkTextIndex) {
        try {
            findAllByLinkText(linkText).get(linkTextIndex).click();
            setLog("linkText", linkText);
        } catch (Exception e) {
            setLog("linkText", linkText, true);
            e.printStackTrace();
        }
    }

    default void clickByName(String name) {
        try {
            findByName(name).click();
            setLog("name", name);
        } catch (Exception e) {
            setLog("name", name, true);
            e.printStackTrace();
        }
    }

    default void clickByName(String name, Integer nameIndex) {
        try {
            findAllByName(name).get(nameIndex).click();
            setLog("name", name);
        } catch (Exception e) {
            setLog("name", name, true);
            e.printStackTrace();
        }
    }

    default void clickByPartialLinkText(String partialLinkText) {
        try {
            findByPartialLinkText(partialLinkText).click();
            setLog("partialLinkText", partialLinkText);
        } catch (Exception e) {
            setLog("partialLinkText", partialLinkText, true);
            e.printStackTrace();
        }
    }

    default void clickByPartialLinkText(String partialLinkText, Integer partialLinkTextIndex) {
        try {
            findAllByPartialLinkText(partialLinkText).get(partialLinkTextIndex).click();
            setLog("partialLinkText", partialLinkText);
        } catch (Exception e) {
            setLog("partialLinkText", partialLinkText, true);
            e.printStackTrace();
        }
    }

    default void clickByTagName(String tagName) {
        try {
            findByTagName(tagName).click();
            setLog("tagName", tagName);
        } catch (Exception e) {
            setLog("tagName", tagName, true);
            e.printStackTrace();
        }
    }

    default void clickByTagName(String tagName, Integer tagNameIndex) {
        try {
            findAllByTagName(tagName).get(tagNameIndex).click();
            setLog("tagName", tagName);
        } catch (Exception e) {
            setLog("tagName", tagName, true);
            e.printStackTrace();
        }
    }

    default void clickByXpath(String xpath) {
        try {
            findByXpath(xpath).click();
            setLog("xpath", xpath);
        } catch (Exception e) {
            setLog("xpath", xpath, true);
            e.printStackTrace();
        }
    }

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
