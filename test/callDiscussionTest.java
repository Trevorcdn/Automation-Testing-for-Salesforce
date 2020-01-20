/* ===================================================================
                      callDiscussionTest.java
    Contain 2 tests to ensure that dropdown menu when selecting either
    Cholecap or Labrinone works as intended. Test cases is checking if
    the dropdown from top to bottom matches the order of when we selected
    Cholecap and Labrinone.
    ==================================================================
 */

package test;

import features.myAccFunc;
import features.recordCallFuncs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import features.commonFuncs;
import features.globalVar;

public class callDiscussionTest extends globalVar{
    public void navigateToMassAddPromoCall(){
        commonFuncs.login("[valid username]",  "[valid password]");
        myAccFunc.clickMyAcc();
        myAccFunc.clickNameInMyAccount("Andy, Samberg");
        recordCallFuncs.clickRecordACall();
        recordCallFuncs.massAddPromoCall();
        recordCallFuncs.checkBoxDetailPriority("Chole", "Labrin");
    }

    @BeforeTest
    public void printTestsBegin() {
        System.out.println("*======================================\n" +
                "       Call Discussion Testing\n" +
                "=======================================*\n");
    }

    /* @func: choleFirstCheckTest
       @purpose: When Chole is selected first, making sure that the
                 most top dropdown box is Chole and the dropdown below it
                 is Labrin.
    */
    @Test (priority = 1)
    public void choleFirstCheckTest(){
        navigateToMassAddPromoCall();
        WebElement product1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/span[2]/div/div/div/form/div/div[2]/span[3]/div/div/div/div[2]/div/span/div/div/span/span/span/span/span/div/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div/div[1]/div[1]/div[2]/span/div/span/select"));
        WebElement product2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/span[2]/div/div/div/form/div/div[2]/span[3]/div/div/div/div[2]/div/span/div/div/span/span/span/span/span/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/div/div[1]/div[1]/div[2]/span/div/span/select"));
        Select firstSelect = new Select(product1);
        Select secondSelect = new Select(product2);

        WebElement option1 = firstSelect.getFirstSelectedOption();
        String chole = option1.getText();
        WebElement option2 = secondSelect.getFirstSelectedOption();
        String labrin = option2.getText();
        System.out.println("Testing the dropdown when Chole was selected first.");
        Assert.assertEquals(cholecap,"Chole");//First dropdown should be Chole
        Assert.assertEquals(labrinone,"Labrin");//Second dropdown should be Labrin
        System.out.println("Testing complete.");
        driver.close();
    }

    /*Same test above except Labrin is selected first so
      most top dropdown should be Labrin and the one below it
      should be Chole.
     */
    @Test (priority = 2)
    public void labrinoneFirstCheckTest(){
        navigateToMassAddPromoCall();
        WebElement product1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/span[2]/div/div/div/form/div/div[2]/span[3]/div/div/div/div[2]/div/span/div/div/span/span/span/span/span/div/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div/div[1]/div[1]/div[2]/span/div/span/select"));
        WebElement product2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/span[2]/div/div/div/form/div/div[2]/span[3]/div/div/div/div[2]/div/span/div/div/span/span/span/span/span/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/div/div[1]/div[1]/div[2]/span/div/span/select"));
        Select firstSelect = new Select(product1);
        Select secondSelect = new Select(product2);

        WebElement option1 = firstSelect.getFirstSelectedOption();
        String chole = option1.getText();
        WebElement option2 = secondSelect.getFirstSelectedOption();
        String labrin = option2.getText();
        System.out.println("Testing the dropdown when Labrin was selected first.");
        Assert.assertEquals(labrin,"Labrin");//First dropdown should be Labrin
        Assert.assertEquals(chole,"Chole");//Second dropdown should be Chole
        System.out.println("Testing complete.");
        driver.close();
    }

    @AfterTest
    public void printTestsFinished(){
        System.out.println("*======================================\n" +
                "          Call Discussion Test Completed\n" +
                "=======================================*\n");
    }
}
