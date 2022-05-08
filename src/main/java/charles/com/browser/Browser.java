package charles.com.browser;

import charles.com.properties.PropertiesOperations;
import charles.com.utils.FunctionUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Browser {

    Boolean hasHeadless = Boolean.parseBoolean(PropertiesOperations.getPropertyValueByKey("headless"));

    public WebDriver createBrowserInstance(String browser) {
        return switch (browser) {
            case "edge" -> setupEdge();
            case "firefox" -> setupFirefox();
            default -> setupChrome();
        };
    }

    private WebDriver setupChrome() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(hasHeadless);
        options.addArguments("--window-size=1920x1080");
        System.setProperty("webdriver.chrome.driver", FunctionUtils.getResourcesWebDriverDir().concat("chromedriver"));
        return new ChromeDriver(options);
    }

    private WebDriver setupEdge() {
        EdgeOptions options = new EdgeOptions();
        options.setHeadless(hasHeadless);
        options.addArguments("--window-size=1920x1080");
        System.setProperty("webdriver.edge.driver", FunctionUtils.getResourcesWebDriverDir().concat("msedgedriver"));
        return new EdgeDriver(options);
    }

    private WebDriver setupFirefox() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(hasHeadless);
        System.setProperty("webdriver.gecko.driver", FunctionUtils.getResourcesWebDriverDir().concat("geckodriver"));
        return new FirefoxDriver(options);
    }
}
