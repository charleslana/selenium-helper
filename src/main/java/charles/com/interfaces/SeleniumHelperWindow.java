package charles.com.interfaces;

import charles.com.factory.DriverFactory;

/**
 * Class for window functionality
 *
 * @author Charles Lana
 * @version 1.0.0
 */
public interface SeleniumHelperWindow {

    /**
     * Method going to new open window
     */
    default void goToNewWindow() {
        String originalWindow = DriverFactory.getInstance().getDriver().getWindowHandle();
        for (String windowHandle : DriverFactory.getInstance().getDriver().getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                DriverFactory.getInstance().getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }
}
