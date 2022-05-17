package charles.com.interfaces;

import charles.com.factory.ExtentFactory;
import com.aventstack.extentreports.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface SeleniumHelperClear extends SeleniumHelperElement {

    Logger logger = LoggerFactory.getLogger(SeleniumHelperClear.class);

    default void clearByClassName(String className) {
        try {
            findByClassName(className).clear();
            setLog("className", className);
        } catch (Exception e) {
            setLog("className", className, true);
            e.printStackTrace();
        }
    }

    default void clearByClassName(String className, Integer classNameIndex) {
        try {
            findAllByClassName(className).get(classNameIndex).clear();
            setLog("className", className);
        } catch (Exception e) {
            setLog("className", className, true);
            e.printStackTrace();
        }
    }

    default void clearByCss(String css) {
        try {
            findByCss(css).clear();
            setLog("css", css);
        } catch (Exception e) {
            setLog("css", css, true);
            e.printStackTrace();
        }
    }

    default void clearByCss(String css, Integer cssIndex) {
        try {
            findAllByCss(css).get(cssIndex).clear();
            setLog("css", css);
        } catch (Exception e) {
            setLog("css", css, true);
            e.printStackTrace();
        }
    }

    default void clearById(String id) {
        try {
            findById(id).clear();
            setLog("id", id);
        } catch (Exception e) {
            setLog("id", id, true);
            e.printStackTrace();
        }
    }

    default void clearByLinkText(String linkText) {
        try {
            findByLinkText(linkText).clear();
            setLog("linkText", linkText);
        } catch (Exception e) {
            setLog("linkText", linkText, true);
            e.printStackTrace();
        }
    }

    default void clearByLinkText(String linkText, Integer linkTextIndex) {
        try {
            findAllByLinkText(linkText).get(linkTextIndex).clear();
            setLog("linkText", linkText);
        } catch (Exception e) {
            setLog("linkText", linkText, true);
            e.printStackTrace();
        }
    }

    default void clearByName(String name) {
        try {
            findByName(name).clear();
            setLog("name", name);
        } catch (Exception e) {
            setLog("name", name, true);
            e.printStackTrace();
        }
    }

    default void clearByName(String name, Integer nameIndex) {
        try {
            findAllByName(name).get(nameIndex).clear();
            setLog("name", name);
        } catch (Exception e) {
            setLog("name", name, true);
            e.printStackTrace();
        }
    }

    default void clearByPartialLinkText(String partialLinkText) {
        try {
            findByPartialLinkText(partialLinkText).clear();
            setLog("partialLinkText", partialLinkText);
        } catch (Exception e) {
            setLog("partialLinkText", partialLinkText, true);
            e.printStackTrace();
        }
    }

    default void clearByPartialLinkText(String partialLinkText, Integer partialLinkTextIndex) {
        try {
            findAllByPartialLinkText(partialLinkText).get(partialLinkTextIndex).clear();
            setLog("partialLinkText", partialLinkText);
        } catch (Exception e) {
            setLog("partialLinkText", partialLinkText, true);
            e.printStackTrace();
        }
    }

    default void clearByTagName(String tagName) {
        try {
            findByTagName(tagName).clear();
            setLog("tagName", tagName);
        } catch (Exception e) {
            setLog("tagName", tagName, true);
            e.printStackTrace();
        }
    }

    default void clearByTagName(String tagName, Integer tagNameIndex) {
        try {
            findAllByTagName(tagName).get(tagNameIndex).clear();
            setLog("tagName", tagName);
        } catch (Exception e) {
            setLog("tagName", tagName, true);
            e.printStackTrace();
        }
    }

    default void clearByXpath(String xpath) {
        try {
            findByXpath(xpath).clear();
            setLog("xpath", xpath);
        } catch (Exception e) {
            setLog("xpath", xpath, true);
            e.printStackTrace();
        }
    }

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
        if (Boolean.TRUE.equals(isFail)) {
            logger.error("Could not clear element by {} with selector {}", by, selector);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Could not clear element by %s with selector %s", by, selector));
            return;
        }
        logger.info("Clear element by {} with selector {}", by, selector);
        ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Clear element by %s with selector %s", by, selector));
    }
}
