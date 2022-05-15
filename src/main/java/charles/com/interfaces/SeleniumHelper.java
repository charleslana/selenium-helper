package charles.com.interfaces;

import charles.com.factory.DriverFactory;
import org.openqa.selenium.WebDriver;

public interface SeleniumHelper extends SeleniumHelperClear, SeleniumHelperClick, SeleniumHelperElement, SeleniumHelperElements, SeleniumHelperType, SeleniumHelperWait {

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
        getDriver().get(url);
    }
}
