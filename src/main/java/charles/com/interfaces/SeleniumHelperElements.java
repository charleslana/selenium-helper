package charles.com.interfaces;

import charles.com.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface SeleniumHelperElements {

    default List<WebElement> findAllById(String id) {
        return getDriver().findElements(By.id(id));
    }

    default List<WebElement> findAllByName(String name) {
        return getDriver().findElements(By.name(name));
    }

    /**
     * Method that fetches all page element name tags
     *
     * @param tagName tag name from element
     * @return List of WebElement
     */
    default List<WebElement> findAllByTagName(String tagName) {
        return getDriver().findElements(By.tagName(tagName));
    }

    private WebDriver getDriver() {
        return DriverFactory.getInstance().getDriver();
    }
}
