package charles.com.factory;

import org.openqa.selenium.WebDriver;

/**
 * Driver factory class
 *
 * @author Charles Lana
 * @version 1.0.0
 */
public class DriverFactory {

    private DriverFactory() {
    }

    private static final DriverFactory instance = new DriverFactory();
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void closeBrowser() {
        driver.get().quit();
        driver.remove();
    }

    /**
     * Method that get webdriver
     *
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    /**
     * Method that get instance of webdriver
     *
     * @return DriverFactory
     */
    public static DriverFactory getInstance() {
        return instance;
    }
}
