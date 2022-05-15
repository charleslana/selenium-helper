package charles.com.interfaces;

import charles.com.factory.DriverFactory;
import charles.com.factory.ExtentFactory;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface SeleniumHelperElement extends SeleniumHelperElements {

    Logger logger = LoggerFactory.getLogger(SeleniumHelperElement.class);

    default WebElement find(By by) {
        return getDriver().findElement(by);
    }

    default WebElement findByClassName(String className) {
        return getDriver().findElement(By.className(className));
    }

    default WebElement findByCss(String css) {
        return getDriver().findElement(By.cssSelector(css));
    }

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

    default WebElement findByLinkText(String linkText) {
        return getDriver().findElement(By.linkText(linkText));
    }

    default WebElement findByName(String name) {
        return getDriver().findElement(By.name(name));
    }

    default WebElement findByPartialLinkText(String partialLinkText) {
        return getDriver().findElement(By.partialLinkText(partialLinkText));
    }

    default WebElement findByTagName(String tagName) {
        return getDriver().findElement(By.tagName(tagName));
    }

    default WebElement findByXpath(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    private WebDriver getDriver() {
        return DriverFactory.getInstance().getDriver();
    }

    private void setLog(String by, String selector) {
        setLog(by, selector, false);
    }

    private void setLog(String by, String selector, Boolean isFail) {
        if (Boolean.TRUE.equals(isFail)) {
            logger.error("Could not find element by {} with selector {}", by, selector);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Could not find element by %s with selector %s", by, selector));
            return;
        }
        logger.info("Find element by {} with selector {}", by, selector);
        ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Find element by %s with selector %s", by, selector));
    }
}
