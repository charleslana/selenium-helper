package charles.com.setup;

import charles.com.properties.PropertiesOperations;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserSetup {

    Boolean hasHeadless = Boolean.parseBoolean(PropertiesOperations.getPropertyValueByKey("headless"));

    protected WebDriver createBrowserInstance(String browser) {
        return switch (browser) {
            case "chrome-remote" -> setupChromeRemote();
            case "edge" -> setupEdge();
            case "edge-remote" -> setupEdgeRemote();
            case "firefox" -> setupFirefox();
            case "firefox-remote" -> setupFirefoxRemote();
            default -> setupChrome();
        };
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(hasHeadless);
        options.addArguments("--window-size=1920x1080");
        return options;
    }

    private EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.setHeadless(hasHeadless);
        options.addArguments("--window-size=1920x1080");
        return options;
    }

    private FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(hasHeadless);
        return options;
    }

    private RemoteWebDriver getRemoteWebDriver(Capabilities options) {
        try {
            return new RemoteWebDriver(new URL(PropertiesOperations.getPropertyValueByKey("remote-url")), options);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private WebDriver setupChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = getChromeOptions();
        return new ChromeDriver(options);
    }

    private WebDriver setupChromeRemote() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = getChromeOptions();
        return getRemoteWebDriver(options);
    }

    private WebDriver setupEdge() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = getEdgeOptions();
        return new EdgeDriver(options);
    }

    private WebDriver setupEdgeRemote() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = getEdgeOptions();
        return getRemoteWebDriver(options);
    }

    private WebDriver setupFirefox() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = getFirefoxOptions();
        return new FirefoxDriver(options);
    }

    private WebDriver setupFirefoxRemote() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = getFirefoxOptions();
        return getRemoteWebDriver(options);
    }
}
