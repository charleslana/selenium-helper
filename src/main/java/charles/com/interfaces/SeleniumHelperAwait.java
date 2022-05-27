package charles.com.interfaces;

import charles.com.factory.DriverFactory;
import charles.com.properties.PropertiesOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

/**
 * Class for await functionality
 *
 * @author Charles Lana
 * @version 1.0.0
 */
public interface SeleniumHelperAwait {

    /**
     * Method that await something for functionality
     *
     * @param isTrue functionality parameter
     */
    default <T> void await(Function<? super WebDriver, T> isTrue) {
        WebDriverWait webDriverWait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(Integer.parseInt(PropertiesOperations.getPropertyValueByKey("web-driver-wait"))));
        webDriverWait.until(isTrue);
    }
}
