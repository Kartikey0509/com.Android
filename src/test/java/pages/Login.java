package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Login {
    private final AndroidDriver<AndroidElement> driver;
    private final WebDriverWait wait;
    private final static Logger Log = LogManager.getLogger(Login.class);

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id ='username']")
    public AndroidElement username;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id ='password']")
    public AndroidElement password;

    @AndroidFindBy(accessibility = " /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View")
    public AndroidElement signInBtn;

   
 //   public List<AndroidElement> middleElements;

    public Login(final AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
        wait = new WebDriverWait(this.driver, 60);

        Log.info("Waiting for login screen to load");
        wait.until(ExpectedConditions.and(
            ExpectedConditions.visibilityOf(username),
            ExpectedConditions.visibilityOf(password),
            ExpectedConditions.visibilityOf(signInBtn)
        ));
    }

   
    public void enterUserName(String username) {
    	this.username.click();
    	this.username.sendKeys(username);
    }

    public void enterPassword(String password) {
    	this.password.click();
    	this.password.sendKeys(password);
    }
    public void SignIn() {
    	this.signInBtn.click();
    }


}
    