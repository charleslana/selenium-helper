package charles.com.setup;

import charles.com.extension.ReportExtension;
import charles.com.factory.DriverFactory;
import charles.com.properties.PropertiesOperations;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Class to start the initial test settings
 *
 * @author Charles Lana
 * @version 1.1.0
 */
@Slf4j
@ExtendWith(ReportExtension.class)
public class SeleniumHelperTest {

    @BeforeEach
    public void setup() {
        BrowserSetup browserSetup = new BrowserSetup();
        DriverFactory.getInstance().setDriver(browserSetup.createBrowserInstance(PropertiesOperations.getPropertyValueByKey("browser")));
        DriverFactory.getInstance().getDriver().manage().window().maximize();
        String sessionId = ((RemoteWebDriver) DriverFactory.getInstance().getDriver()).getSessionId().toString();
        log.info("Browser session id: {}", sessionId);
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.getInstance().closeBrowser();
    }
}
