package charles.com.interfaces;

import charles.com.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface SeleniumHelperElement extends SeleniumHelperElements {

    default WebElement findByClassName(String className) {
        return getDriver().findElement(By.className(className));
    }

    default WebElement findById(String id) {
        return getDriver().findElement(By.id(id));
    }

    default WebElement findByName(String name) {
        return getDriver().findElement(By.name(name));
    }

    default WebElement findByTagName(String tagName) {
        return getDriver().findElement(By.tagName(tagName));
    }

    private WebDriver getDriver() {
        return DriverFactory.getInstance().getDriver();
    }
}
