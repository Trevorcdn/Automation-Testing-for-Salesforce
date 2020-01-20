package pageObjects;

import features.globalVar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class myAccountPage extends globalVar{
    public WebElement recordCall = driver.findElement(By.xpath("//input[@value='Record a Call']"));

}