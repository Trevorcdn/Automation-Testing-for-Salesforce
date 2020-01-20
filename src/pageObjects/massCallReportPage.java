package pageObjects;

import features.globalVar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class massCallReportPage extends globalVar{
    public String chole = "//*[@id='chkd_a00U0000006DoZJIA0']";
    public String labrin = "//*[@id='chkd_a00U0000006DoZNIA0']";
    public WebElement choleChecked = driver.findElement(By.xpath(chole));
    public WebElement labrinChecked = driver.findElement(By.xpath(labrin));
    public WebElement coPayCard = driver.findElement(By.xpath("//input[@id='chka00U0000006DoX4IAK']"));
    public WebElement save = driver.findElement(By.xpath("//input[@class='ng-scope btn']"));

}
