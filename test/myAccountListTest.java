/* ===================================================================
                      myAccountListTest.java
    Contain 3 tests to ensure that clicking on My Account and My Account List page
    is working as intended. Test cases include verifying if clicking on My Account
    button is successful, clicking on a name that doesn't exist, and clicking on
    Adams, Bob.
    ==================================================================
 */
package test;

import features.myAccFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import features.commonFuncs;
import features.globalVar;

public class myAccountListTest extends globalVar{
    @BeforeTest
    public void printTestsBegin(){
        System.out.println("*======================================\n" +
                "            My Account List Testing\n" +
                "=======================================*\n");
    }
    /* @func: clickingMyAcc
       @purpose: Verify if clicking on My Account button was successful.
       @Notes: Uses driver.switchTo().frame() and WebDriverWait to access the iFrame
               of the "New" button to ensure that the entire page loads first before
               verifying the page. To verify that the page is My Account List,
               the xpath to top and xpath to pageDescription should be
               "My Accounts" and "Home" respectively.
    */
    @Test (priority = 1)
    public void clickingMyAcc(){
        commonFuncs.login("[valid username]",  "[valid password]");
        myAccFunc.clickMyAcc();
        driver.switchTo().frame("itarget");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("newAcctButton")));
        WebElement myAcc = driver.findElement(By.xpath("//*[@id='top']"));
        WebElement home = driver.findElement(By.xpath("//*[@class='pageDescription']"));
        Assert.assertEquals(myAcc.getText(),"My Accounts");
        Assert.assertEquals(home.getText(),"Home");
        driver.switchTo().defaultContent();
        driver.close();
    }

    /* @func: clickingWrongName
      @purpose: Verify the result(boolean) when clicking on an element that doesn't exist.
      @Notes: clickNameInMyAccount returns a boolean and it should return false since
              nameToClick should not exist.
              This test runs a a bit slow.
   */
    @Test (priority = 2)
    public void clickingWrongName(){
        commonFuncs.login("[valid username]",  "[valid password]");
        myAccFunc.clickMyAcc();
        System.out.println("Testing when clicking on a name that doesn't exist.");
        boolean isSuccessful = myAccFunc.clickNameInMyAccount("Doesn't, Exists");
        Assert.assertFalse(isSuccessful);
        System.out.println("Testing complete.");
        driver.close();
    }

    /* @func: clickingBobAdams
      @purpose: Verify if clicking on "Andy, Samberg was successful.
      @Notes: If clicking on name was successful, then the
              page description should be the full name of the person
              including the title. Ex: "Dr. Bob Adams"
   */
    @Test (priority = 3)
    public void clickingBobAdams(){
        commonFuncs.login("[valid username]",  "[valid password]");
        myAccFunc.clickMyAcc();
        myAccFunc.clickNameInMyAccount("Andy, Samberg");
        WebElement accName = driver.findElement(By.xpath("//*[@class='pageDescription']"));
        System.out.println("Testing if Andy, Samberg was clicked correctly");
        Assert.assertEquals(accName.getText(),"Dr. Andy Samberg");
        System.out.println("Testing completed.");
        driver.close();
    }

    @AfterTest
    public void printTestsFinished(){
        System.out.println("*======================================\n" +
                           "        My Account List Tests Completed\n" +
                           "=======================================*\n");
    }

}
