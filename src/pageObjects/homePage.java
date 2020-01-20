package pageObjects;

import features.globalVar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage {
    private WebDriver driver = globalVar.driver;
    public WebElement myAcc = driver.findElement(By.xpath("//*[@class='wt-My-Accounts']"));
    public WebElement userNavBTN = driver.findElement(By.xpath("//*[@id='userNavButton']"));
    public WebElement logoutBTN = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[2]"));
}
