package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.UtilitiesMain;

import java.io.IOException;

public class LoginTest extends UtilitiesMain {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);


    }
    // 1st method
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials()  {
        //Enter valid username
        sendTextToElement(By.name("username"),"jaypatel3");
        // Enter valid password
        sendTextToElement(By.name("password"),"jaypatel123");
        //click on login button
        clickOnElement(By.xpath("//input[@value='Log In']"));

        // Verify account overview  text is display
        String expectedMessage ="Accounts Overview";

      WebElement actualTextFromElement= driver.findElement(By.xpath("//a[contains(text(),'Accounts Overview')]"));
      String actualMessage=actualTextFromElement.getText();

        Assert.assertEquals("Accounts Overview",expectedMessage,actualMessage);





    }
    @Test
    public void verifyTheErrorMessage(){
        sendTextToElement(By.name("username"),"jaypatel32");
        sendTextToElement(By.name("password"),"jaypatel1234");
        clickOnElement(By.xpath("//input[@value='Log In']"));

        // Verify the error message The username and password could not be verified.



    }
    @Test
    public void userShouldLogOutSuccessfully(){
        sendTextToElement(By.name("username"),"jaypatel3");
        sendTextToElement(By.name("password"),"jaypatel123");
        clickOnElement(By.xpath("//input[@value='Log In']"));
        clickOnElement(By.xpath("//a[text()='Log Out']"));

        assertVerifyText(By.xpath("//h2[contains(text(),'Customer Login')]"),"Customer Login");


    }
}

