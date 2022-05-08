package charles.com.factory;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private DriverFactory() {
    }

    private static final DriverFactory instance = new DriverFactory();
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void closeBrowser() {
        driver.get().quit();
        driver.remove();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public static DriverFactory getInstance() {
        return instance;
    }
}
