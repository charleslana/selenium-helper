package charles.com.interfaces;

import charles.com.factory.DriverFactory;
import org.openqa.selenium.WebDriver;

public interface SeleniumHelper extends SeleniumHelperClear, SeleniumHelperClick, SeleniumHelperElement, SeleniumHelperElements, SeleniumHelperGetText, SeleniumHelperType, SeleniumHelperWait {

    default String getTitle() {
        return getDriver().getTitle();
    }

    default String getUrl() {
        return getDriver().getCurrentUrl();
    }

    default void navigate(String url) {
        getDriver().get(url);
    }

    private WebDriver getDriver() {
        return DriverFactory.getInstance().getDriver();
    }
}
