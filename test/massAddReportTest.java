/* ===================================================================
                      massAddReportTest.java
    Contain 2 tests to ensure that we are able to click the
    Record A Call button, and we are able to select Mass Add
    Promo Call from the drop down.
    ==================================================================
 */
package test;

import features.myAccFunc;
import features.recordCallFuncs;
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

public class massAddReportTest extends globalVar{
    @BeforeTest
    public void printTestsBegin(){
        System.out.println("*======================================\n" +
                "       Mass Add Report Testing\n" +
                "=======================================*\n");
    }

    public void navigateToAndy(){
        commonFuncs.login("[valid username]",  "[valid password]");
        myAccFunc.clickMyAcc();
        myAccFunc.clickNameInMyAccount("Andy, Samberg");
    }

    /* @func: recordACallTest
       @purpose: If we are able to click on Record A Call button, then it
                 should redirect us to a page where the page description
                 is "New Call Report". If we are able to find the element
                 then the test is a success.
    */
    @Test (priority = 1)
    public void recordACallTest(){
        navigateToAndy();
        recordCallFuncs.clickRecordACall();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='Save']")));
        WebElement newCallReport = driver.findElement(By.xpath("//*[@class='pageDescription ng-binding']"));

        System.out.println("Testing on clicking on Record A Call button.");
        Assert.assertEquals(newCallReport.getText(), "New Call Report");
        System.out.println("Testing finish.");
        driver.close();
    }

    /* @func: massAddPromoCallTest
       @purpose: From the New Call Report page, we should be able
                 to select Mass Add Promo Call from the dropdown. Once
                 we select the option, then it should redirect us to a
                 page where the page description is "New Mass Add Promo Call"
    */
    @Test (priority = 2)
    public void massAddPromoCallTest(){
        navigateToAndy();
        recordCallFuncs.clickRecordACall();
        recordCallFuncs.massAddPromoCall();
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='Save']")));
        WebElement newMassAddPromoCall = driver.findElement(By.xpath("//*[@class='pageDescription ng-binding']"));

        System.out.println("\nTest on selecting New Mass Add Promo Call from dropdown.");
        Assert.assertEquals(newMassAddPromoCall.getText(),"New Mass Add Promo Call");
        System.out.println("Testing finish.");
        driver.close();
    }

    @AfterTest
    public void printTestsFinished(){
        System.out.println("*======================================\n" +
                "        Mass Add Report Tests Completed\n" +
                "=======================================*\n");
    }
}
