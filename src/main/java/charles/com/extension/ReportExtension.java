package charles.com.extension;

import charles.com.factory.DriverFactory;
import charles.com.factory.ExtentFactory;
import charles.com.setup.ReportSetup;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportExtension implements BeforeAllCallback, BeforeTestExecutionCallback, AfterAllCallback, AfterTestExecutionCallback {

    ExtentReports report;
    ExtentTest test;

    Logger logger = Logger.getLogger(ReportExtension.class);

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        logger.info("Selenium Helper finished tests");
        report.flush();
        File htmlFile = new File(ReportSetup.reportPath);
        Desktop.getDesktop().browse(htmlFile.toURI());
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        logger.info(String.format("%s finished test", extensionContext.getDisplayName()));
        if (extensionContext.getExecutionException().isEmpty()) {
            ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Test Case: %s is Passed", extensionContext.getDisplayName()));
        } else {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Test Case: %s is Failed", extensionContext.getDisplayName()));
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, extensionContext.getExecutionException().get().getLocalizedMessage());
            String screenshotPath = getSetupScreenshot();
            ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(screenshotPath, "Test case failure screenshot");
        }
        ExtentFactory.getInstance().removeExtentObject();
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        logger.info("Started Selenium Helper tests");
        report = ReportSetup.setupExtentReport();
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        logger.info(String.format("Start test %s", extensionContext.getDisplayName()));
        test = report.createTest(extensionContext.getDisplayName());
        ExtentFactory.getInstance().setExtent(test);
    }

    private String getSetupScreenshot() {
        File file = ((TakesScreenshot) DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);
        String screenshotPath = System.getProperty("user.dir").concat(String.format("/src/test/resources/reports/screenshots/%s.jpeg", actualDate));
        File destination = new File(screenshotPath);
        try {
            FileUtils.copyFile(file, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }
}
