package charles.com.setup;

import charles.com.extension.ReportExtension;
import charles.com.factory.DriverFactory;
import charles.com.properties.PropertiesOperations;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.MethodSorters;

@ExtendWith(ReportExtension.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeleniumHelperTest {

    @BeforeEach
    public void setup() {
        BrowserSetup browserSetup = new BrowserSetup();
        DriverFactory.getInstance().setDriver(browserSetup.createBrowserInstance(PropertiesOperations.getPropertyValueByKey("browser")));
        DriverFactory.getInstance().getDriver().manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.getInstance().closeBrowser();
    }
}
