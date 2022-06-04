package charles.com.interfaces;

import charles.com.factory.DriverFactory;
import charles.com.factory.ExtentFactory;
import charles.com.properties.PropertiesOperations;
import com.aventstack.extentreports.Status;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Interface responsible for page element controls
 *
 * @author Charles Lana
 * @version 1.1.0
 */
public interface SeleniumHelper extends SeleniumHelperAlert, SeleniumHelperClear, SeleniumHelperClick, SeleniumHelperDragDrop, SeleniumHelperElement, SeleniumHelperElements, SeleniumHelperFrame, SeleniumHelperMove, SeleniumHelperType, SeleniumHelperWait, SeleniumHelperWindow {

    /**
     * Method to get the driver
     *
     * @return WebDriver
     */
    default WebDriver getDriver() {
        return DriverFactory.getInstance().getDriver();
    }

    /**
     * Method to get the title
     *
     * @return String
     */
    default String getTitle() {
        try {
            String title = getDriver().getTitle();
            log().info("Get title {}", title);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Get title %s", title));
            return title;
        } catch (Exception e) {
            log().error("Could not get title");
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Could not get title");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method to get the url
     *
     * @return String
     */
    default String getUrl() {
        try {
            String url = getDriver().getCurrentUrl();
            log().info("Get url {}", url);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Get url %s", url));
            return url;
        } catch (Exception e) {
            log().error("Could not get url");
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Could not get url");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method for navigating from an url
     *
     * @param url url page
     */
    default void navigate(String url) {
        ExtentFactory.getInstance().getExtent().log(Status.INFO, String.format("Init browser %s with session id %s", StringUtils.capitalize(PropertiesOperations.getPropertyValueByKey("browser")), ((RemoteWebDriver) getDriver()).getSessionId().toString()));
        try {
            getDriver().get(url);
            log().info("Navigate to url {}", url);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Navigate to url %s", url));
        } catch (Exception e) {
            log().error("Could not navigate to url {}", url);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Could not navigate to url %s", url));
            e.printStackTrace();
        }
    }

    /**
     * Method for navigating to back
     */
    default void navigateBack() {
        try {
            getDriver().navigate().back();
            log().info("Navigate to back");
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Navigate to back");
        } catch (Exception e) {
            log().error("Could not navigate to back");
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Could not navigate to back");
            e.printStackTrace();
        }
    }

    /**
     * Method for navigating to forward
     */
    default void navigateForward() {
        try {
            getDriver().navigate().forward();
            log().info("Navigate to forward");
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Navigate to forward");
        } catch (Exception e) {
            log().error("Could not navigate to forward");
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Could not navigate to forward");
            e.printStackTrace();
        }
    }

    /**
     * Method for navigating to from an url
     *
     * @param url url page
     */
    default void navigateTo(String url) {
        try {
            getDriver().navigate().to(url);
            log().info("Navigate to url {}", url);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Navigate to url %s", url));
        } catch (Exception e) {
            log().error("Could not navigate to url {}", url);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Could not navigate to url %s", url));
            e.printStackTrace();
        }
    }

    private Logger log() {
        return LoggerFactory.getLogger(SeleniumHelper.class);
    }
}
