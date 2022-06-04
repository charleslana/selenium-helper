package charles.com.interfaces;

import charles.com.factory.DriverFactory;
import charles.com.factory.ExtentFactory;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Interface responsible for drag drop
 *
 * @author Charles Lana
 * @version 1.0.0
 */
public interface SeleniumHelperDragDrop {

    /**
     * Method for drag drop
     *
     * @param sourceElement source element
     * @param targetElement target element
     */
    default void dragDrop(WebElement sourceElement, WebElement targetElement) {
        try {
            Actions actions = new Actions(getDriver());
            actions.dragAndDrop(sourceElement, targetElement).perform();
            log().info("Drag element {} and drop in {} element", sourceElement, targetElement);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Drag element %s and drop in %s element", sourceElement, targetElement));
        } catch (Exception e) {
            log().error("Could not drag element {} and drop in {} element", sourceElement, targetElement);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Could not drag element %s and drop in %s element", sourceElement, targetElement));
            e.printStackTrace();
        }
    }

    /**
     * Method for drag drop by location
     *
     * @param element element from page
     * @param xOffset offset position x
     * @param yOffset offset position y
     */
    default void dragDropByLocation(WebElement element, Integer xOffset, Integer yOffset) {
        try {
            Actions actions = new Actions(getDriver());
            actions.dragAndDropBy(element, xOffset, yOffset).perform();
            log().info("Drag element {} by {} position x and {} position y", element, xOffset, yOffset);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Drag element %s by %s position x and %s position y", element, xOffset, yOffset));
        } catch (Exception e) {
            log().error("Could not drag element {} by {} position x and {} position y", element, xOffset, yOffset);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Could not drag element %s by %s position x and %s position y", element, xOffset, yOffset));
            e.printStackTrace();
        }
    }

    private WebDriver getDriver() {
        return DriverFactory.getInstance().getDriver();
    }

    private Logger log() {
        return LoggerFactory.getLogger(SeleniumHelperDragDrop.class);
    }
}
