/* ===================================================================
                      samplesAndPromoItemsTest.java
    Contain 2 tests to ensure that the call is saved and that the quantity is set
    to the correct number. Test cases include verifying if the page got redirected
    to the correct page after saving and if the quantity is set correctly.
    ==================================================================
 */
package test;

import features.myAccFunc;
import features.recordCallFuncs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import features.commonFuncs;
import features.globalVar;

public class samplesAndPromoItemsTest extends globalVar{
    public void navigateToMassAddPromoCall(){
        commonFuncs.login("[valid username]",  "[valid password]");
        myAccFunc.clickMyAcc();
        myAccFunc.clickNameInMyAccount("Andy, Samberg");
        recordCallFuncs.clickRecordACall();
        recordCallFuncs.massAddPromoCall();
        recordCallFuncs.checkBoxDetailPriority("Chole", "Labrin");
    }

    @BeforeTest
    public void printTestsBegin(){
        System.out.println("*======================================\n" +
                "Samples And Promotional Items Testing\n" +
                "=======================================*\n");
    }

    /* @func: saveSuccessTest
       @purpose: If saving the call was successful, then it should redirect
                 you to a Mass Add Promo Call page that details the information
                 that was inputted. There should be an xpath to "Status"
                 and then use .getText() to extract whether the report was save
                 or not
   */
    @Test (priority = 1)
    public void saveSuccessTest(){
        navigateToMassAddPromoCall();
        recordCallFuncs.checkBoxCoPay("2");
        commonFuncs.saveChanges();
        WebElement massAddPromoText = driver.findElement(By.xpath("//*[@class='pageType ng-binding']"));
        WebElement savedStatus = driver.findElement(By.xpath("//*[@name='Status_vod__c']"));

        System.out.println("Testing if the call report is saved");
        Assert.assertEquals(massAddPromoText.getText(),"Mass Add Promo Call");
        Assert.assertEquals(savedStatus.getText(),"Saved");
        System.out.println("Testing complete");
        driver.close();
    }

    /* @func: quantityTest
       @purpose: On the successful saved report page, the quantity number is
                 displayed under the Samples And Promotional Items section. Use
                 the .getText() from the WebElement and compare it with the value
                 the user enters for checkBoxCoPay() method
   */
    @Test (priority = 2)
    public void quantityTest(){
        navigateToMassAddPromoCall();
        recordCallFuncs.checkBoxCoPay("2");
        commonFuncs.saveChanges();
        WebElement quantity = driver.findElement(By.xpath("//*[@name='Quantity_vod__c']"));

        System.out.println("Testing if quantity is set to 2");
        Assert.assertEquals(quantity.getText(),"2");
        System.out.println("Testing complete");
        driver.close();
    }

    @AfterTest
    public void printTestsFinished(){
        System.out.println("*======================================\n" +
                "   Samples And Promotional Items Tests Completed\n" +
                "=======================================*\n");
    }
}
