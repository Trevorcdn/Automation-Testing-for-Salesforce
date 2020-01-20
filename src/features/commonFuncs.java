/* ===================================================================
                      commonFuncs.java
    Contain basic common functions which includes login(), saveChanges(),
    logout(), and initWebDriver().
    ==================================================================
 */
package features;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.homePage;
import pageObjects.loginPage;
import pageObjects.massCallReportPage;

import java.util.concurrent.TimeUnit;

public class commonFuncs extends globalVar{
    //@purpose: sets the global value (driver) and initialize gecko driver
    public static void initWebDriver() {
        String path = "C:\\[insert-your-driver-path-here\\";
        String exePath = path+"geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", exePath);
        driver = new FirefoxDriver();
    }

    /* @purpose: Takes the user to the login screen and login with a given
                 Email and Password.
       @Note: After the a correct login attempt, it takes time for the browser to
              load into the homepage thus an implicitlyWait is introduced to give
              time for the next action
     */
    public static void login(String userEmail, String password){
        initWebDriver();
        driver.get(loginURL);
        loginPage autoLogin = new loginPage();
        autoLogin.txtEmail.sendKeys(userEmail);
        autoLogin.txtPassword.sendKeys(password);
        autoLogin.loginBTN.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    //@purpose: Presses the Save button on the Call Report page
    public static void saveChanges(){
        massCallReportPage saving = new massCallReportPage();
        saving.save.click();
    }

    /*
      @purpose: logs the user out.
      @Notes: clicks on the user's navigational button and uses
              implicitlyWait to ensure that the drop down menu
              values can be clicked.
     */
    public static void logOut() {
        System.out.println("Logging out");
        homePage autoLogout = new homePage();
        autoLogout.userNavBTN.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        autoLogout.logoutBTN.click();
    }
}
