package charles.com.interfaces;

import charles.com.factory.DriverFactory;
import charles.com.factory.ExtentFactory;
import com.aventstack.extentreports.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Interface for windows functionality
 *
 * @author Charles Lana
 * @version 1.1.0
 */
public interface SeleniumHelperWindow {

    /**
     * Method to switch window
     */
    default void switchWindow() {
        Logger log = LoggerFactory.getLogger(SeleniumHelper.class);
        try {
            toggleWindow();
            log.info("Switch to window");
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Switch to window");
        } catch (Exception e) {
            log.error("Could not switch to window");
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Could not switch to window");
            e.printStackTrace();
        }
    }

    private void toggleWindow() {
        String currentWindow = DriverFactory.getInstance().getDriver().getWindowHandle();
        for (String windowHandle : DriverFactory.getInstance().getDriver().getWindowHandles()) {
            if (!currentWindow.contentEquals(windowHandle)) {
                DriverFactory.getInstance().getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }
}
