package charles.com.interfaces;

import charles.com.factory.DriverFactory;
import charles.com.factory.ExtentFactory;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class responsible for page element controls
 *
 * @author Charles Lana
 * @version 1.0.0
 */
public interface SeleniumHelper extends SeleniumHelperClear, SeleniumHelperClick, SeleniumHelperElement, SeleniumHelperElements, SeleniumHelperType, SeleniumHelperWait, SeleniumHelperWindow {

    Logger logger = LoggerFactory.getLogger(SeleniumHelper.class);

    /**
     * Method to get the driver
     *
     * @return WebElement
     */
    default WebDriver getDriver() {
        return DriverFactory.getInstance().getDriver();
    }

    /**
     * Method to get the title
     *
     * @return WebElement
     */
    default String getTitle() {
        return getDriver().getTitle();
    }

    /**
     * Method to get the url
     *
     * @return WebElement
     */
    default String getUrl() {
        return getDriver().getCurrentUrl();
    }

    /**
     * Method for navigating from an url
     *
     * @param url url page
     */
    default void navigate(String url) {
        try {
            getDriver().get(url);
            logger.info("Navigate to url {}", url);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Navigate to url %s", url));
        } catch (Exception e) {
            logger.error("Could not navigate to url {}", url);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Could not navigate to url %s", url));
            e.printStackTrace();
        }
    }
}
