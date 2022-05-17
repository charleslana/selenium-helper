package charles.com.interfaces;

import charles.com.factory.ExtentFactory;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public interface SeleniumHelperWait extends SeleniumHelperAwait, SeleniumHelperElement {

    Logger logger = LoggerFactory.getLogger(SeleniumHelperWait.class);

    default void waitInvisibility(WebElement element) {
        try {
            await(ExpectedConditions.invisibilityOf(element));
            setLog("element", element, "invisible");
        } catch (Exception e) {
            setLog("element", element, "invisible", true);
            e.printStackTrace();
        }
    }

    default void waitInvisibility(List<WebElement> element, Integer invisibilityIndex) {
        try {
            await(ExpectedConditions.invisibilityOf(element.get(invisibilityIndex)));
            setLog("element", element, "invisible");
        } catch (Exception e) {
            setLog("element", element, "invisible", true);
            e.printStackTrace();
        }
    }

    default void waitInvisibilityByClassName(String className) {
        try {
            await(ExpectedConditions.invisibilityOf(findByClassName(className)));
            setLog("className", className, "invisible");
        } catch (Exception e) {
            setLog("className", className, "invisible", true);
            e.printStackTrace();
        }
    }

    default void waitInvisibilityByClassName(String className, Integer classNameIndex) {
        try {
            await(ExpectedConditions.invisibilityOf(findAllByClassName(className).get(classNameIndex)));
            setLog("className", className, "invisible");
        } catch (Exception e) {
            setLog("className", className, "invisible", true);
            e.printStackTrace();
        }
    }

    default void waitInvisibilityByCss(String css) {
        try {
            await(ExpectedConditions.invisibilityOf(findByCss(css)));
            setLog("css", css, "invisible");
        } catch (Exception e) {
            setLog("css", css, "invisible", true);
            e.printStackTrace();
        }
    }

    default void waitInvisibilityByCss(String css, Integer cssIndex) {
        try {
            await(ExpectedConditions.invisibilityOf(findAllByCss(css).get(cssIndex)));
            setLog("css", css, "invisible");
        } catch (Exception e) {
            setLog("css", css, "invisible", true);
            e.printStackTrace();
        }
    }

    default void waitInvisibilityById(String id) {
        try {
            await(ExpectedConditions.invisibilityOf(findById(id)));
            setLog("id", id, "invisible");
        } catch (Exception e) {
            setLog("id", id, "invisible", true);
            e.printStackTrace();
        }
    }

    default void waitInvisibilityByLinkText(String linkText) {
        try {
            await(ExpectedConditions.invisibilityOf(findByLinkText(linkText)));
            setLog("linkText", linkText, "invisible");
        } catch (Exception e) {
            setLog("linkText", linkText, "invisible", true);
            e.printStackTrace();
        }
    }

    default void waitInvisibilityByLinkText(String linkText, Integer linkTextIndex) {
        try {
            await(ExpectedConditions.invisibilityOf(findAllByLinkText(linkText).get(linkTextIndex)));
            setLog("linkText", linkText, "invisible");
        } catch (Exception e) {
            setLog("linkText", linkText, "invisible", true);
            e.printStackTrace();
        }
    }

    default void waitInvisibilityByName(String name) {
        try {
            await(ExpectedConditions.invisibilityOf(findByName(name)));
            setLog("name", name, "invisible");
        } catch (Exception e) {
            setLog("name", name, "invisible", true);
            e.printStackTrace();
        }
    }

    default void waitInvisibilityByName(String name, Integer nameIndex) {
        try {
            await(ExpectedConditions.invisibilityOf(findAllByName(name).get(nameIndex)));
            setLog("name", name, "invisible");
        } catch (Exception e) {
            setLog("name", name, "invisible", true);
            e.printStackTrace();
        }
    }

    default void waitInvisibilityByPartialLinkText(String partialLinkText) {
        try {
            await(ExpectedConditions.invisibilityOf(findByPartialLinkText(partialLinkText)));
            setLog("partialLinkText", partialLinkText, "invisible");
        } catch (Exception e) {
            setLog("partialLinkText", partialLinkText, "invisible", true);
            e.printStackTrace();
        }
    }

    default void waitInvisibilityByPartialLinkText(String partialLinkText, Integer partialLinkTextIndex) {
        try {
            await(ExpectedConditions.invisibilityOf(findAllByPartialLinkText(partialLinkText).get(partialLinkTextIndex)));
            setLog("partialLinkText", partialLinkText, "invisible");
        } catch (Exception e) {
            setLog("partialLinkText", partialLinkText, "invisible", true);
            e.printStackTrace();
        }
    }

    default void waitInvisibilityByTagName(String tagName) {
        try {
            await(ExpectedConditions.invisibilityOf(findByTagName(tagName)));
            setLog("tagName", tagName, "invisible");
        } catch (Exception e) {
            setLog("tagName", tagName, "invisible", true);
            e.printStackTrace();
        }
    }

    default void waitInvisibilityByTagName(String tagName, Integer tagNameIndex) {
        try {
            await(ExpectedConditions.invisibilityOf(findAllByTagName(tagName).get(tagNameIndex)));
            setLog("tagName", tagName, "invisible");
        } catch (Exception e) {
            setLog("tagName", tagName, "invisible", true);
            e.printStackTrace();
        }
    }

    default void waitInvisibilityByXpath(String xpath) {
        try {
            await(ExpectedConditions.invisibilityOf(findByXpath(xpath)));
            setLog("xpath", xpath, "invisible");
        } catch (Exception e) {
            setLog("xpath", xpath, "invisible", true);
            e.printStackTrace();
        }
    }

    default void waitInvisibilityByXpath(String xpath, Integer xpathIndex) {
        try {
            await(ExpectedConditions.invisibilityOf(findAllByXpath(xpath).get(xpathIndex)));
            setLog("xpath", xpath, "invisible");
        } catch (Exception e) {
            setLog("xpath", xpath, "invisible", true);
            e.printStackTrace();
        }
    }

    default void waitUrlContains(String path) {
        try {
            await(ExpectedConditions.urlContains(path));
            logger.info("Wait url contain path {}", path);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Wait url contain path %s", path));
        } catch (Exception e) {
            logger.error("Could not wait url contain path {}", path);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Could not wait url contain path %s", path));
            e.printStackTrace();
        }
    }

    default void waitVisibility(WebElement element) {
        try {
            await(ExpectedConditions.visibilityOf(element));
            setLog("element", element, "visible");
        } catch (Exception e) {
            setLog("element", element, "visible", true);
            e.printStackTrace();
        }
    }

    default void waitVisibility(List<WebElement> element, Integer visibilityIndex) {
        try {
            await(ExpectedConditions.visibilityOf(element.get(visibilityIndex)));
            setLog("element", element, "visible");
        } catch (Exception e) {
            setLog("element", element, "visible", true);
            e.printStackTrace();
        }
    }

    default void waitVisibilityByClassName(String className) {
        try {
            await(ExpectedConditions.visibilityOf(findByClassName(className)));
            setLog("className", className, "visible");
        } catch (Exception e) {
            setLog("className", className, "visible", true);
            e.printStackTrace();
        }
    }

    default void waitVisibilityByClassName(String className, Integer classNameIndex) {
        try {
            await(ExpectedConditions.visibilityOf(findAllByClassName(className).get(classNameIndex)));
            setLog("className", className, "visible");
        } catch (Exception e) {
            setLog("className", className, "visible", true);
            e.printStackTrace();
        }
    }

    default void waitVisibilityByCss(String css) {
        try {
            await(ExpectedConditions.visibilityOf(findByCss(css)));
            setLog("css", css, "visible");
        } catch (Exception e) {
            setLog("css", css, "visible", true);
            e.printStackTrace();
        }
    }

    default void waitVisibilityByCss(String css, Integer cssIndex) {
        try {
            await(ExpectedConditions.visibilityOf(findAllByCss(css).get(cssIndex)));
            setLog("css", css, "visible");
        } catch (Exception e) {
            setLog("css", css, "visible", true);
            e.printStackTrace();
        }
    }

    default void waitVisibilityById(String id) {
        try {
            await(ExpectedConditions.visibilityOf(findById(id)));
            setLog("id", id, "visible");
        } catch (Exception e) {
            setLog("id", id, "visible", true);
            e.printStackTrace();
        }
    }

    default void waitVisibilityByLinkText(String linkText) {
        try {
            await(ExpectedConditions.visibilityOf(findByLinkText(linkText)));
            setLog("linkText", linkText, "visible");
        } catch (Exception e) {
            setLog("linkText", linkText, "visible", true);
            e.printStackTrace();
        }
    }

    default void waitVisibilityByLinkText(String linkText, Integer linkTextIndex) {
        try {
            await(ExpectedConditions.visibilityOf(findAllByLinkText(linkText).get(linkTextIndex)));
            setLog("linkText", linkText, "visible");
        } catch (Exception e) {
            setLog("linkText", linkText, "visible", true);
            e.printStackTrace();
        }
    }

    default void waitVisibilityByName(String name) {
        try {
            await(ExpectedConditions.visibilityOf(findByName(name)));
            setLog("name", name, "visible");
        } catch (Exception e) {
            setLog("name", name, "visible", true);
            e.printStackTrace();
        }
    }

    default void waitVisibilityByName(String name, Integer nameIndex) {
        try {
            await(ExpectedConditions.visibilityOf(findAllByName(name).get(nameIndex)));
            setLog("name", name, "visible");
        } catch (Exception e) {
            setLog("name", name, "visible", true);
            e.printStackTrace();
        }
    }

    default void waitVisibilityByPartialLinkText(String partialLinkText) {
        try {
            await(ExpectedConditions.visibilityOf(findByPartialLinkText(partialLinkText)));
            setLog("partialLinkText", partialLinkText, "visible");
        } catch (Exception e) {
            setLog("partialLinkText", partialLinkText, "visible", true);
            e.printStackTrace();
        }
    }

    default void waitVisibilityByPartialLinkText(String partialLinkText, Integer partialLinkTextIndex) {
        try {
            await(ExpectedConditions.visibilityOf(findAllByPartialLinkText(partialLinkText).get(partialLinkTextIndex)));
            setLog("partialLinkText", partialLinkText, "visible");
        } catch (Exception e) {
            setLog("partialLinkText", partialLinkText, "visible", true);
            e.printStackTrace();
        }
    }

    default void waitVisibilityByTagName(String tagName) {
        try {
            await(ExpectedConditions.visibilityOf(findByTagName(tagName)));
            setLog("tagName", tagName, "visible");
        } catch (Exception e) {
            setLog("tagName", tagName, "visible", true);
            e.printStackTrace();
        }
    }

    default void waitVisibilityByTagName(String tagName, Integer tagNameIndex) {
        try {
            await(ExpectedConditions.visibilityOf(findAllByTagName(tagName).get(tagNameIndex)));
            setLog("tagName", tagName, "visible");
        } catch (Exception e) {
            setLog("tagName", tagName, "visible", true);
            e.printStackTrace();
        }
    }

    default void waitVisibilityByXpath(String xpath) {
        try {
            await(ExpectedConditions.visibilityOf(findByXpath(xpath)));
            setLog("xpath", xpath, "visible");
        } catch (Exception e) {
            setLog("xpath", xpath, "visible", true);
            e.printStackTrace();
        }
    }

    default void waitVisibilityByXpath(String xpath, Integer xpathIndex) {
        try {
            await(ExpectedConditions.visibilityOf(findAllByXpath(xpath).get(xpathIndex)));
            setLog("xpath", xpath, "visible");
        } catch (Exception e) {
            setLog("xpath", xpath, "visible", true);
            e.printStackTrace();
        }
    }

    private void setLog(String by, Object selector, String visibility) {
        setLog(by, selector, visibility, false);
    }

    private void setLog(String by, Object selector, String visibility, Boolean isFail) {
        if (Boolean.TRUE.equals(isFail)) {
            logger.error("Could not wait element by {} with selector {} to {}", by, selector, visibility);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Could not wait element by %s with selector %s to %s", by, selector, visibility));
            return;
        }
        logger.info("Wait element by {} with selector {} to {}", by, selector, visibility);
        ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Wait element by %s with selector %s to %s", by, selector, visibility));
    }
}
