package charles.com.interfaces;

import charles.com.factory.DriverFactory;
import charles.com.properties.PropertiesOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public interface SeleniumHelperAwait {

    default <T> void await(Function<? super WebDriver, T> isTrue) {
        WebDriverWait webDriverWait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(Integer.parseInt(PropertiesOperations.getPropertyValueByKey("implicitly-wait"))));
        webDriverWait.until(isTrue);
    }
}
