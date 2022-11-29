package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.UtilitiesMain;

public class RegisterTest extends UtilitiesMain {

    String baseUrl ="https://parabank.parasoft.com/parabank/index.htm/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);


    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        // Click on register link
        clickOnElement(By.xpath("//a[text()='Register']"));




        // Verify the text 'Signing up is easy!'
        // This is from requirement
        String expectedMessage = "Signing up is easy!";

        // Find the welcome text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Signing up is easy!']"));

        // Validate actual and expected message
        Assert.assertEquals("No such message displayed :",expectedMessage, actualMessage);





    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        // Click on register link
        clickOnElement(By.xpath("//a[text()='Register']"));


        //Enter First name
        sendTextToElement(By.name("customer.firstName"),"Jay");
        sendTextToElement(By.name("customer.lastName"),"patel");
        sendTextToElement(By.id("customer.address.street"),"Flat86,BLock C, The Assembly,");
        sendTextToElement(By.id("customer.address.city"),"Wembley");
        sendTextToElement(By.id("customer.address.state"),"United Kingdom");
        sendTextToElement(By.id("customer.address.zipCode"),"HA04AH");
        sendTextToElement(By.id("customer.phoneNumber"),"07405179973");
        sendTextToElement(By.id("customer.ssn"),"995684231");
        sendTextToElement(By.id("customer.username"),"jaypatel3");
        sendTextToElement(By.id("customer.password"),"jaypatel123");
        sendTextToElement(By.id("repeatedPassword"),"jaypatel123");

        // Click on register
        clickOnElement(By.xpath("//input[@value='Register']"));

        // Verify the text Your account was created successfully. You are now logged in.

        String expectedMessage="Your account was created successfully. You are now logged in.";

       WebElement actualTextFromElement = driver.findElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']"));
       String actualMessage =actualTextFromElement.getText();

       // Validate actual and expected message
        Assert.assertEquals("no message found",expectedMessage,actualMessage);













    }

}
