package tests;

import com.Web.utilities.AndroidBaseTest;
import com.aventstack.extentreports.ExtentTest;

import pages.Login;
import pages.WelcomePage;


import org.testng.annotations.*;

import static utils.extentReports.ExtentReport.startTest;

import java.lang.reflect.Method;

public class LoginTest extends AndroidBaseTest {
    @Test
    @Parameters({"username", "password"})
    public void loginWithCorrectCredentials(final String username, final String password, Method method) {
        ExtentTest test = startTest(
            method.getName(),
            "Test login screen on valid credentials"
        );
        test.assignAuthor("Kartikey");
        test.assignCategory("Android", "WEConnect");
        test.info("Waiting for login screen to load");
        Login lt = new Login(getDriver());
        test.info("Enter username");
        lt.enterUserName(username);
        test.info("Enter password");
        lt.enterPassword(password);
        test.info("Tap Sign In");
        lt.SignIn();
        test.info("Waiting for Welcome screen to load");
        new WelcomePage(getDriver());
    }

    @Test
    public void loginWithIncorrectCredentials(Method method) {
        ExtentTest test = startTest(
            method.getName(),
            "Test error message on login screen with incorrect credentials"
        );
        test.assignAuthor("Kartikey Srivastava");
        test.assignCategory("Android", "WEConnect");
        test.info("Waiting for login screen to load");
        Login lt = new Login(getDriver());
        test.info("Enter username");
        lt.enterUserName("idonotexist");
        test.info("Enter password");
        lt.enterPassword("ialsodonotexist");
        test.info("Tap Sign In");
        lt.SignIn();
        
    }

 

}