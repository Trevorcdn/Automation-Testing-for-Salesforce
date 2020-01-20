package pageObjects;

import features.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class loginPage {
    private WebDriver driver = globalVar.driver;
    public WebElement txtEmail = driver.findElement(By.xpath("//input[@id='username']"));
    public WebElement txtPassword = driver.findElement(By.xpath("//input[@id='password']"));
    public WebElement loginBTN = driver.findElement(By.xpath("//input[@class='button r4 wide primary']"));

}

