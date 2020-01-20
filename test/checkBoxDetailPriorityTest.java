/* ===================================================================
                      checkBoxDetailPriorityTest.java
    Contain 5 tests to ensure that the method checkBoxDetailPriority()
    works as intended. Test cases include when both arguments are correct,
    when first argument is correct but second argument is wrong, when first
    argument is wrong but second argument is correct, and when both
    arguments are wrong
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

public class checkBoxDetailPriorityTest extends globalVar {
    public void navigateToMassAddPromoCall(){
        commonFuncs.login("[valid username]",  "[valid password]");
        myAccFunc.clickMyAcc();
        myAccFunc.clickNameInMyAccount("Andy, Samberg");
        recordCallFuncs.clickRecordACall();
        recordCallFuncs.massAddPromoCall();
    }

    @BeforeTest
    public void printTestsBegin() {
        System.out.println("*======================================\n" +
                "       checkBoxDetailPriority Testing\n" +
                "=======================================*\n");
    }

    /* @func: choleLabrinCheckTest
       @purpose: Sets first argument of checkBoxDetailPriority() to be
                 Chole and second argument to be Labrin. The
                 .isSelected() should both return true to indicate
                 that both had been checked.
    */
    @Test (priority = 1)
    public void choleLabrinCheckTest(){
        String chloecap = "//*[@id='chkd_a00U0000006DoZJIA0']";
        String labrinone = "//*[@id='chkd_a00U0000006DoZNIA0']";

        navigateToMassAddPromoCall();
        WebElement choleCheck = driver.findElement(By.xpath(chloe));
        WebElement labrinCheck = driver.findElement(By.xpath(labrin));
        recordCallFuncs.checkBoxDetailPriority("Chole", "Labrin");
        System.out.println("Testing if both Chole and Labrin is checked when they are inputted in the respected order.");
        Assert.assertTrue(choleCheck.isSelected());
        Assert.assertTrue(labrinCheck.isSelected());
        System.out.println("Testing finish.");
        driver.quit();

    }

    //Same test above except swap the arguments
    @Test (priority = 2)
    public void labrinCholeCheckTest(){
        String chloe = "//*[@id='chkd_a00U0000006DoZJIA0']";
        String labrin = "//*[@id='chkd_a00U0000006DoZNIA0']";

        navigateToMassAddPromoCall();
        WebElement choleCheck = driver.findElement(By.xpath(chloe));
        WebElement labrinCheck = driver.findElement(By.xpath(labrin));
        recordCallFuncs.checkBoxDetailPriority("Labrin", "Chole");
        System.out.println("Testing if both Labrin and Chole is checked when they are inputted in the respected order.");
        Assert.assertTrue(labrinCheck.isSelected());
        Assert.assertTrue(choleCheck.isSelected());
        System.out.println("Testing finish.");
        driver.quit();
    }
    /* @func: noArg1Test
       @purpose: Sets first argument of checkBoxDetailPriority() to be
                 an empty string  and second argument to be Cholecap.
                 The checkBoxDetailPriority() method should return
                 false since one of the arguments is neither Chole
                 nor Labrin.
    */
    @Test (priority = 3)
    public void noArg1Test(){
        navigateToMassAddPromoCall();
        boolean noArg1 = recordCallFuncs.checkBoxDetailPriority("", "Chole");
        System.out.println("Testing when there is a wrong argument for argument1.");
        Assert.assertFalse(noArg1);
        System.out.println("Testing finish.");
        driver.quit();
    }

    //Same test as above except argument2 is an empty string
    @Test (priority = 4)
    public void noArg2Test(){
        navigateToMassAddPromoCall();
        boolean noArg2 = recordCallFuncs.checkBoxDetailPriority("Labrin", "");
        System.out.println("Testing when there is a wrong argument for argument2.");
        Assert.assertFalse(noArg2);
        System.out.println("Testing finish.");
        driver.quit();
    }

    //Same test as above except both arguments are empty strings
    @Test (priority = 5)
    public void bothArgWrongTest(){
        navigateToMassAddPromoCall();
        boolean noArg2 = recordCallFuncs.checkBoxDetailPriority("", "");
        System.out.println("Testing when both arguments are wrong.");
        Assert.assertFalse(noArg2);
        System.out.println("Testing finish.");
        driver.quit();
    }

    @AfterTest
    public void printTestsFinished(){
        System.out.println("*======================================\n" +
                "        checkBoxDetailPriority Tests Completed\n" +
                "=======================================*\n");
    }

}


