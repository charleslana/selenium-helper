package charles.com.interfaces;

import charles.com.factory.DriverFactory;
import charles.com.factory.ExtentFactory;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Interface for frames functionality
 *
 * @author Charles Lana
 * @version 1.0.0
 */
public interface SeleniumHelperFrame {

    /**
     * Method to switch default frame
     */
    default void switchFrame() {
        try {
            getDriver().switchTo().defaultContent();
            log().info("Switch to default frame");
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Switch to default frame");
        } catch (Exception e) {
            log().error("Could not switch to default frame");
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Could not switch to default frame");
            e.printStackTrace();
        }
    }

    /**
     * Method to switch frame index
     *
     * @param index frame index
     */
    default void switchFrame(Integer index) {
        try {
            getDriver().switchTo().frame(index);
            log().info("Switch to frame {} index", index);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Switch to frame %s index", index));
        } catch (Exception e) {
            log().error("Could not switch to frame {} index", index);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Could not switch to frame %s index", index));
            e.printStackTrace();
        }
    }

    /**
     * Method to switch frame by name or id
     *
     * @param nameOrId name or id
     */
    default void switchFrame(String nameOrId) {
        try {
            getDriver().switchTo().frame(nameOrId);
            log().info("Switch to frame by name or id {}", nameOrId);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Switch to frame by name or id %s", nameOrId));
        } catch (Exception e) {
            log().error("Could not switch to frame by name or id {}", nameOrId);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Could not switch to frame by name or id %s", nameOrId));
            e.printStackTrace();
        }
    }

    /**
     * Method to switch frame by page element
     *
     * @param element page element
     */
    default void switchFrame(WebElement element) {
        try {
            getDriver().switchTo().frame(element);
            log().info("Switch to frame by element {}", element);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Switch to frame by element %s", element));
        } catch (Exception e) {
            log().error("Could not switch to frame by element {}", element);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Could not switch to frame by element %s", element));
            e.printStackTrace();
        }
    }

    private WebDriver getDriver() {
        return DriverFactory.getInstance().getDriver();
    }

    private Logger log() {
        return LoggerFactory.getLogger(SeleniumHelperFrame.class);
    }
}
