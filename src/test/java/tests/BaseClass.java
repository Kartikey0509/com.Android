package tests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	AndroidDriver<AndroidElement> driver;
	@Test
	public void setup() throws Exception {
	
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability("appPackage", "com.windstream.enterprise.we");
		caps.setCapability("appActivity", "com.windstream.po3.business.features.winauth.WinAuthActivity");
		
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
//		caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\global\\eclipse-workspace\\com.Android\\src\\test\\resources\\apps\\mobile-we-universal-appcenteruat (2).apk");
	
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<AndroidElement>(url, caps);
		
		System.out.println("Ready Steady Po...");
		Thread.sleep(20000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		AndroidElement userN = driver.findElement(By.xpath("//android.widget.EditText[@resource-id ='username']"));
		AndroidElement pswd = driver.findElement(By.xpath("//android.widget.EditText[@resource-id ='password']"));
		AndroidElement signin = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View"));
		
	
		  wait.until(ExpectedConditions.and( ExpectedConditions.visibilityOf(userN),
		  ExpectedConditions.visibilityOf(pswd),
		  ExpectedConditions.visibilityOf(signin) ));
		
		
		
		Thread.sleep(1000);
		userN.click();
		Thread.sleep(1000);
		userN.sendKeys("");
		
		Thread.sleep(1000);
		pswd.click();
		Thread.sleep(1000);
		pswd.sendKeys("");
		
		Thread.sleep(1000);
		Thread.sleep(1000);
		signin.click();
		Thread.sleep(10000);
	}
	
	@AfterTest	
public void teardown() {
		driver.close();
	}

}
