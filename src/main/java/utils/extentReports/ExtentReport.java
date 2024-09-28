	package utils.extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Create a HashMap for extent reports while with running thread as key and value as the extent report.
 * startTest() method creates a new test with the name and description and then that value is put in the HashMap
 * with current running thread id as key.
 */
public class ExtentReport {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
    public static final ExtentReports extentReports = new ExtentReports();
    private static final Path reportFile = Paths.get(
        System.getProperty("user.dir"), "reports", "extent-report.html"
    );

    static {
        extentReports.setSystemInfo("OS", "Windows 10");
    
        extentReports.setSystemInfo("Author", "Kartikey Srivastava");
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportFile.toString());
        reporter.config().setReportName("Automation POC - Extent Report");
        reporter.config().setTheme(Theme.DARK);
        extentReports.attachReporter(reporter);
    }

    public static synchronized ExtentTest startTest(final String testName, final String description) {
        ExtentTest test = extentReports.createTest(testName, description);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }
}
