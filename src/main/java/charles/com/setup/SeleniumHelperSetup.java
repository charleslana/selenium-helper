package charles.com.setup;

import charles.com.factory.DriverFactory;
import charles.com.properties.PropertiesOperations;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.time.Duration;

public class SeleniumHelperSetup {

    @BeforeEach
    public void setup() {
        Browser browser = new Browser();
        DriverFactory.getInstance().setDriver(browser.createBrowserInstance(PropertiesOperations.getPropertyValueByKey("browser")));
        DriverFactory.getInstance().getDriver().manage().window().maximize();
        DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(PropertiesOperations.getPropertyValueByKey("implicitly-wait"))));
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.getInstance().closeBrowser();
    }
}
