package utils.listeners;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Screenshot {
    private static String screenshotFilename(final String testCaseName) {
        return Paths.get(
            System.getProperty("user.dir"), "target", "screenshots", testCaseName + ".png"
        ).toString();
    }

    public static String takeScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts= (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String filename = screenshotFilename(testCaseName);
        FileUtils.copyFile(source, new File(filename));
        return filename;
    }

    public static String takeScreenshot(String testCaseName, AndroidDriver<AndroidElement> driver) throws IOException {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filename = screenshotFilename(testCaseName);
        FileUtils.copyFile(source, new File(filename));
        return filename;
    }
}
