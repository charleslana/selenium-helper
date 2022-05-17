package charles.com.extension;

import charles.com.factory.DriverFactory;
import charles.com.factory.ExtentFactory;
import charles.com.properties.PropertiesOperations;
import charles.com.setup.ReportSetup;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportExtension implements BeforeAllCallback, BeforeTestExecutionCallback, AfterAllCallback, AfterTestExecutionCallback {

    ExtentReports report;
    ExtentTest test;

    Logger logger = LoggerFactory.getLogger(ReportExtension.class);

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        logger.info("Selenium Helper finished tests");
        report.flush();
        if (Boolean.parseBoolean(PropertiesOperations.getPropertyValueByKey("open-report-after-tests"))) {
            File htmlFile = new File(ReportSetup.reportPath);
            Desktop.getDesktop().browse(htmlFile.toURI());
        }
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        logger.info("{} finished test", extensionContext.getDisplayName());
        if (extensionContext.getExecutionException().isEmpty()) {
            ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Test Case: %s is Passed", extensionContext.getDisplayName()));
        } else {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Test Case: %s is Failed", extensionContext.getDisplayName()));
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, extensionContext.getExecutionException().orElseThrow());
            String screenshotPath = getSetupScreenshot();
            ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(screenshotPath, "Test case failure screenshot");
        }
        ExtentFactory.getInstance().removeExtentObject();
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        logger.info("Started Selenium Helper tests");
        report = ReportSetup.setupExtentReport();
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) {
        logger.info("Start test {}", extensionContext.getDisplayName());
        test = report.createTest(extensionContext.getDisplayName());
        ExtentFactory.getInstance().setExtent(test);
    }

    private String getSetupScreenshot() {
        File file = ((TakesScreenshot) DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat format = new SimpleDateFormat(PropertiesOperations.getPropertyValueByKey("report-datetime-format"));
        Date date = new Date();
        String actualDate = format.format(date);
        String screenshotPath = System.getProperty("user.dir").concat(String.format("/src/test/resources/reports/screenshots/Screenshot %s.jpeg", actualDate));
        File destination = new File(screenshotPath);
        try {
            FileUtils.copyFile(file, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }
}
