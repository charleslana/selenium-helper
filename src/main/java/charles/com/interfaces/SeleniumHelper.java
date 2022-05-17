package charles.com.interfaces;

import charles.com.factory.DriverFactory;
import charles.com.factory.ExtentFactory;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface SeleniumHelper extends SeleniumHelperClear, SeleniumHelperClick, SeleniumHelperElement, SeleniumHelperElements, SeleniumHelperType, SeleniumHelperWait {

    Logger logger = LoggerFactory.getLogger(SeleniumHelper.class);

    default WebDriver getDriver() {
        return DriverFactory.getInstance().getDriver();
    }

    default String getTitle() {
        return getDriver().getTitle();
    }

    default String getUrl() {
        return getDriver().getCurrentUrl();
    }

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
