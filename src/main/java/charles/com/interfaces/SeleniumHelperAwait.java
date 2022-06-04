package charles.com.interfaces;

import charles.com.factory.DriverFactory;
import charles.com.factory.ExtentFactory;
import charles.com.properties.PropertiesOperations;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.function.Function;

/**
 * Interface for await functionality
 *
 * @author Charles Lana
 * @version 1.1.0
 */
public interface SeleniumHelperAwait {

    /**
     * Method that await something for functionality
     *
     * @param isTrue functionality parameter
     */
    default <T> void await(Function<? super WebDriver, T> isTrue) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(Integer.parseInt(PropertiesOperations.getPropertyValueByKey("web-driver-wait"))));
            webDriverWait.until(isTrue);
            log().info("Await for function {}", isTrue);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Await for function %s", isTrue));
        } catch (Exception e) {
            log().error("Could not await for function {}", isTrue);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Could not await for function %s", isTrue));
            e.printStackTrace();
        }
    }

    /**
     * Method that waits for time and then continues
     *
     * @param milliseconds time in milliseconds
     */
    default void sleep(Integer milliseconds) {
        try {
            Thread.sleep(milliseconds);
            log().info("Wait for sleep in {} milliseconds", milliseconds);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Wait for sleep in %s milliseconds", milliseconds));
        } catch (InterruptedException e) {
            log().error("Could not wait for sleep in {} milliseconds", milliseconds);
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Could not wait for sleep in %s milliseconds", milliseconds));
            throw new RuntimeException(e);
        }
    }

    private Logger log() {
        return LoggerFactory.getLogger(SeleniumHelperAwait.class);
    }
}
