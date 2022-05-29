package charles.com.interfaces;

import charles.com.factory.DriverFactory;

/**
 * Class for windows functionality
 *
 * @author Charles Lana
 * @version 1.0.0
 */
public interface SeleniumHelperWindow {

    /**
     * Method to switch window
     */
    default void switchWindow() {
        String currentWindow = DriverFactory.getInstance().getDriver().getWindowHandle();
        for (String windowHandle : DriverFactory.getInstance().getDriver().getWindowHandles()) {
            if (!currentWindow.contentEquals(windowHandle)) {
                DriverFactory.getInstance().getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }
}
