/* ===================================================================
                      loginTest.java
    Contain 6 tests to ensure that both logging in and logging out
    works as intended. Test cases include logging in with different
    combination of usernames and passwords.
    ==================================================================
 */
package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import features.commonFuncs;
import features.globalVar;
//Todo: Use excel sheet to hold in values for usernames and passwords and DDT
public class loginTest extends globalVar{
    @BeforeTest
    public void printTestsBegin(){
        System.out.println("*======================================\n" +
                           "            Login Testing\n" +
                           "=======================================*\n");
    }

    /* @func: loginWithWrongUsername
       @purpose: Sets userEmail to gibberish so that the login will fail.
                 When login fail, an expected message saying "Please check your username and password..."
                 will appear with the xpath of "//*[@id='error']". Assert the expected message
                 with what driver.findElement().getText() had found. Should be the same.
     */
    @Test (priority = 1)
    public void loginWithWrongUsername(){
        String userEmail ="asjdkhkjfghakjhbf";
        String password = "[valid password]";
        commonFuncs.login(userEmail, password);
        WebElement loginError = driver.findElement(By.xpath("//*[@id='error']"));
        String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";

        System.out.println("Testing login with incorrect username.");
        Assert.assertEquals(loginError.getText(),expected);
        System.out.println("Testing completed!");
        driver.close();
    }

    /* Test is similar to loginWithWrongUsername except the
       username is correct and the password is gibberish
     */
    @Test (priority = 2)
    public void loginWithWrongPassword(){
        String userEmail = "[valid username]";
        String password = "asjdkhkjfghakjhbf";
        commonFuncs.login(userEmail,password);
        WebElement loginError = driver.findElement(By.xpath("//*[@id='error']"));
        String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";

        System.out.println("Testing login with incorrect password.");
        Assert.assertEquals(loginError.getText(),expected);
        System.out.println("Testing completed!");
        driver.close();
    }

    /* @func: loginWithNoUsername
        @purpose: Sets userEmail to an empty string and tests login.
                  If a user inputs an empty string for the username field, then it redirects user
                  to the default login page with no error message. The test checks if the current url
                  after hitting the login button is the same as the default url for the login screen.
      */
    @Test (priority = 3)
    public void loginWithNoUsername(){
        String userEmail = "";
        String password = "[valid password]";
        commonFuncs.login(userEmail,password);
        String loginError = driver.getCurrentUrl();
        String expected = "https://login.salesforce.com/";
        System.out.println("Testing login with no input in the username field.");
        Assert.assertEquals(loginError,expected);
        System.out.println("Testing completed!");
        driver.close();
    }

    /* @func: loginWithNoPassword
       @purpose: Sets password to an empty string and tests login.
                 If a user inputs an empty string for the password field, then it redirects user
                 to the login page with an error message of "Testing login with no input in the password field"
                 with an xpath of "//*[@id='error']". Assert the expected message with what driver.findElement()
                 had found. Should be the same.
     */
    @Test (priority = 4)
    public void loginWithNoPassword(){
        String userEmail = "[valid username]";
        String password = "";
        commonFuncs.login(userEmail,password);
        WebElement loginError = driver.findElement(By.xpath("//*[@id='error']"));
        String expected = "Please enter your password.";

        System.out.println("Testing login with no input in the password field");
        Assert.assertEquals(loginError.getText(),expected);
        System.out.println("Testing completed!");
        driver.close();
    }

    /* @func: LoginWithRightCredentials
       @purpose: Sets userEmail and password with the right credentials.
               If login is successful, then it should redirect user to the homepage
               where "[User's name] at [Company Name]" should be displayed to welcome them.
               We set the expected string and assert it with the xpath of the expected
               string. If the driver.findElement() cannot find the element, then login
               was not successful.
   */
    @Test (priority = 5)
    public void LoginWithRightCredentials(){

        String userEmail = "[valid username]";
        String password = "[valid password]";
        commonFuncs.login(userEmail,password);
        WebElement loginSuccess = driver.findElement(By.xpath("//*[@class='pageType']"));
        System.out.println("Testing login with the right credentials.");
        Assert.assertEquals(loginSuccess.getText(),"[Your Name] at [Company Name]");
        System.out.println("Testing completed!");
        driver.close();
    }

    /* @func: loggingout
    @purpose: If the user's log out is successful, then the website should
              redirect the user to an expected URL of
              "https://na131.salesforce.com/secur/logout.jsp".
  */
    @Test (priority = 6)
    public void loggingout(){
        String userEmail = "[valid username]";
        String password = "[valid password]";
        commonFuncs.login(userEmail,password);
        commonFuncs.logOut();
        String loggedOut = driver.getCurrentUrl();
        String expected = "https://na131.salesforce.com/secur/logout.jsp";
        System.out.println("Testing logging out.");
        Assert.assertEquals(loggedOut,expected);
        System.out.println("Testing completed!");
        driver.close();
    }

    @AfterTest
    public void printTestsFinished(){
        System.out.println("*======================================\n" +
                "            Login Tests Completed\n" +
                "=======================================*\n");
    }
}
