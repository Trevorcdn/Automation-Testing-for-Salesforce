package pageObjects;

import features.globalVar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class newCallReportPage extends globalVar{
    public WebElement RecordType  = driver.findElement(By.xpath("//*[@id='RecordTypeId']"));
    public String massAddPromoCallValue = "string:012U0000000MBvLIAW";
}
