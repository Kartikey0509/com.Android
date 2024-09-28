package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage {
    private AndroidDriver<AndroidElement> driver;
    private WebDriverWait wait;
    private final static Logger Log = LogManager.getLogger(Login.class);

    @AndroidFindBy(id = "com.windstream.enterprise.we:id/welcome_user")
    private AndroidElement welcomeUserTextPath;

    @AndroidFindBy(id = "com.windstream.enterprise.we:id/skip")
    public AndroidElement skipButtonPath;

    @AndroidFindBy(id = "com.windstream.enterprise.we:id/start")
    public AndroidElement getStartedButtonPath;

    public WelcomePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
        wait = new WebDriverWait(this.driver, 60);

        Log.info("Waiting for Welcome screen to load");
        wait.until(ExpectedConditions.and(
            ExpectedConditions.visibilityOf(welcomeUserTextPath),
            ExpectedConditions.visibilityOf(skipButtonPath),
            ExpectedConditions.visibilityOf(getStartedButtonPath)
        ));
    }
}
