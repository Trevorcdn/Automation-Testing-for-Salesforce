/* ===================================================================
                      myAccFunc.java
    Contain functions that are used with regards to My Account Page
    ==================================================================
 */
package features;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.homePage;

public class myAccFunc extends globalVar {
    /*
     @purpose: From the homepage, clicks the My Accounts tab.
    */
    public static void clickMyAcc(){
        homePage clickPage = new homePage();
        clickPage.myAcc.click();
    }

    /*
     @param: String user gives a name to be click
     @purpose: From the My Accounts list, automatically clicks a name given by
               the user.
     @Notes: The path to the names are iFrames. driver.switchTo().frame is needed
             to access the element. Need a WebDriverWait since it takes the list
             a bit of time to load. A try and catch statements is implemented
             just in case a user inputted a name that is inaccessible.
     @return: boolean true if able to click on name. false if name cannot be found/clicked
    */
    public static boolean clickNameInMyAccount(String nameToClick){
        try{
            driver.switchTo().frame("itarget");
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText(nameToClick))).click();
            //Line below is needed to reset content after accessing an iFrame. Otherwise, Error: access dead object
            driver.switchTo().defaultContent();
        }
        catch (Exception e){
            System.out.println("Error in myAccFunc.java: nameToClick cannot be found\n");
            return false;
        }
        return true;
    }
}
