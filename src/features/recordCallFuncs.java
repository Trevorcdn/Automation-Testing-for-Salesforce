/* ===================================================================
                      recordCallFuncs.java
    Contain functions with regards to clicking the Record A Call button,
    which includes changing the Record Type, Detail Priority, and
    Samples and Promotional Items section.
    ==================================================================
 */
package features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.massCallReportPage;
import pageObjects.myAccountPage;
import pageObjects.newCallReportPage;

public class recordCallFuncs extends globalVar{

    //Clicks Record A Call button on the contact's page
    public static void clickRecordACall(){
        myAccountPage clickPage = new myAccountPage();
        clickPage.recordCall.click();
    }

    /* @func: massAddPromoCall
       @purpose: On Call Report page, automates the action of selecting
                 "Mass Add Promo Call" from the Record Type drop down list.
       @Notes: WebDriverWait is introduced to make sure the entire page loads
               before using Select on the drop down list and choosing
               "Mass Add Promo Call"
     */
    public static void massAddPromoCall(){
        newCallReportPage changeType = new newCallReportPage();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(changeType.RecordType));
        Select massPromoCall = new Select(changeType.RecordType);
        massPromoCall.selectByValue(changeType.massAddPromoCallValue);
    }

    /*@func: checkBoxDetailPriority
      @param: String1 name to be checked first, String2 name to be checked next
      @purpose: On Call Report page, automates the action of selecting
                Chole and Labrin in Detail Priority section.
      @Notes: First we check the arguments using .matches to make sure that both arguments
              are either Labrin or Chole.
              Boolean isCholeFirst checks if the user wants to select Chole first.
              If isCholeFirst is true and it has not been selected yet, then select the
              Chole's box. Then check if Labrin has not been selected, select it if not.
              Vice Versa if isCholeFirst is false but this time it selects Labrin first.
      @returns: boolean true if both Chole and Labrin are checked. False if parameters
                are not either Chole and Labrin
      @caveat: This function only works if the parameters are strictly Chole and Labrin
    */
    public static boolean checkBoxDetailPriority(String check1, String check2){
        massCallReportPage checking = new massCallReportPage();
        String check1Lower = check1.toLowerCase();
        String check2Lower = check2.toLowerCase();
        if(!check1Lower.matches("labrin|chole"))
            return false;
        if(!check2Lower.matches("labrin|chole"))
            return false;

        boolean isCholeFirst = check1Lower.equals("chole");
        if(isCholeFirst && !checking.choleChecked.isSelected()) {
            checking.choleChecked.click();
            if(check2Lower.equals("labrin") && !checking.labrinChecked.isSelected())
                checking.labrinoneChecked.click();
        }
        else if(!isCholeFirst && !checking.labrinChecked.isSelected()){
            checking.labrinChecked.click();
            if(check2Lower.equals("chole") && !checking.choleChecked.isSelected())
                checking.choleChecked.click();
        }
        else{
            System.out.println("Error: No match on parameters when checking Detail Priority\n");
            return false;
        }

        return true;
    }

    /* @func: checkBoxCoPay
       @para String what the user wants to change the quantity to
       @purpose: In Samples and Promotional Items section of Call Report page,
                 automates the action of selecting "Co-Pay Card" and changing
                 the quantity to a given value.
       @Notes: We change the quantity when user's quantity is greater than "1", otherwise
               we skip the process since default value is 1. Absolute xpath is used for clicking
               on the quantity box since a relative xpath seemingly cannot be found. After the
               quantity box is clicked, it's xpath would also change. The changeQTY represent the
               new xpath. With this new webElement we clear the text box and input the user's
               given quantity.
     */
    public static void checkBoxCoPay(String quantity){
        massCallReportPage checkCoPay = new massCallReportPage();
        checkCoPay.coPayCard.click();
        if(Integer.parseInt(quantity) > 1){
           WebElement qty = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/span[2]/div/div/div/form/div/div[2]/span[7]/div/div/div/div[2]/div/span/div/div/span/span/span/span/span/div/table/tbody/tr[2]/td/table/tbody[5]/tr[2]/td[3]/span/span/input"));
           WebElement changeQTY = driver.findElement(By.xpath("./html/body/div[1]/div[2]/table/tbody/tr/td[2]/span[2]/div/div/div/form/div/div[2]/span[7]/div/div/div/div[2]/div/span/div/div/span/span/span/span/span/div/table/tbody/tr[2]/td/table/tbody[5]/tr[2]/td[3]/span/span/input"));
            qty.click();
            changeQTY.clear();
            changeQTY.sendKeys(quantity);
        }
        else if(Integer.parseInt(quantity) < 1){
            System.out.println("Error in Samples And Promotional Items: quantity is less than 1\n");
        }

    }
}
