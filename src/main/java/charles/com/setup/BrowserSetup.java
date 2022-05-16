package charles.com.setup;

import charles.com.properties.PropertiesOperations;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserSetup {

    Boolean hasHeadless = Boolean.parseBoolean(PropertiesOperations.getPropertyValueByKey("headless"));

    protected WebDriver createBrowserInstance(String browser) {
        return switch (browser) {
            case "edge" -> setupEdge();
            case "firefox" -> setupFirefox();
            default -> setupChrome();
        };
    }

    private WebDriver setupChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(hasHeadless);
        options.addArguments("--window-size=1920x1080");
        return new ChromeDriver(options);
    }

    private WebDriver setupEdge() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.setHeadless(hasHeadless);
        options.addArguments("--window-size=1920x1080");
        return new EdgeDriver(options);
    }

    private WebDriver setupFirefox() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(hasHeadless);
        return new FirefoxDriver(options);
    }
}
