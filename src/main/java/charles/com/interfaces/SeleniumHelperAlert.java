package charles.com.interfaces;

import charles.com.factory.DriverFactory;
import charles.com.factory.ExtentFactory;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Interface for alert functionality
 *
 * @author Charles Lana
 * @version 1.0.0
 */
public interface SeleniumHelperAlert {

    /**
     * Method for accept alert
     */
    default void alertAccept() {
        try {
            Alert alert = getDriver().switchTo().alert();
            alert.accept();
            log().info("Accept the alert");
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Accept the alert");
        } catch (Exception e) {
            log().error("Could not accept the alert");
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Could not accept the alert");
            e.printStackTrace();
        }
    }

    /**
     * Method for dismiss alert
     */
    default void alertDismiss() {
        try {
            Alert alert = getDriver().switchTo().alert();
            alert.dismiss();
            log().info("Dismiss the alert");
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Dismiss the alert");
        } catch (Exception e) {
            log().error("Could not dismiss the alert");
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Could not dismiss the alert");
            e.printStackTrace();
        }
    }

    /**
     * Method for get alert
     *
     * @return Alert
     */
    default Alert getAlert() {
        return getDriver().switchTo().alert();
    }

    /**
     * Method for get alert text
     *
     * @return String
     */
    default String getAlertText() {
        return getDriver().switchTo().alert().getText();
    }

    /**
     * Method for typing in alert
     *
     * @param textToType text to type
     */
    default void typeAlert(String textToType) {
        try {
            Alert alert = getDriver().switchTo().alert();
            alert.sendKeys(textToType);
            log().info("Type in alert text {}", textToType);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Type in alert text %s", textToType));
        } catch (Exception e) {
            log().error("Could not type in alert text {}", textToType);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Could not type in alert text %s", textToType));
            e.printStackTrace();
        }
    }

    private WebDriver getDriver() {
        return DriverFactory.getInstance().getDriver();
    }

    private Logger log() {
        return LoggerFactory.getLogger(SeleniumHelperAlert.class);
    }
}
