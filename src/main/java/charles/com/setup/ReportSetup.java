package charles.com.setup;

import charles.com.properties.PropertiesOperations;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportSetup {

    private ReportSetup() {
    }

    public static String reportPath;
    static ExtentReports extent;

    public static ExtentReports setupExtentReport() {
        SimpleDateFormat format = new SimpleDateFormat(PropertiesOperations.getPropertyValueByKey("report-datetime-format"));
        Date date = new Date();
        String actualDate = format.format(date);
        reportPath = System.getProperty("user.dir").concat(String.format("/src/test/resources/reports/Selenium Helper Report %s.html", actualDate));
        ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
        return setupExtent(sparkReport);
    }

    private static ExtentReports setupExtent(ExtentSparkReporter sparkReport) {
        extent = new ExtentReports();
        extent.attachReporter(sparkReport);
        setupHtmlReport(sparkReport);
        extent.setSystemInfo("Executed on Browser: ", PropertiesOperations.getPropertyValueByKey("browser"));
        extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
        extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));
        return extent;
    }

    private static void setupHtmlReport(ExtentSparkReporter sparkReport) {
        sparkReport.config().setDocumentTitle("Report Selenium Helper");
        sparkReport.config().setTheme(Theme.valueOf(PropertiesOperations.getPropertyValueByKey("report-theme").toUpperCase()));
        sparkReport.config().setReportName("Report Selenium Helper");
        sparkReport.config().setTimeStampFormat(PropertiesOperations.getPropertyValueByKey("report-datetime-format"));
        sparkReport.config().setProtocol(Protocol.HTTPS);
        sparkReport.config().setCss(String.format(".logo { background-image: url('%s') !important; background-size: contain; }", PropertiesOperations.getPropertyValueByKey("report-logo-url")));
    }
}
