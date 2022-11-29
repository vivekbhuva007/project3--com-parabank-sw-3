package utility;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UtilitiesMain extends BaseTest {

    public void clickOnElement(By by){
        driver.findElement(by).click();



    }
    public void sendTextToElement(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    public String getTextFromElement(By by){
        WebElement actualTextMessageElement =driver.findElement(by);
        return actualTextMessageElement.getText();




    }
    //This method verify the expected text
    public void assertVerifyText(By by, String expectedtext) {
        String actualText = getTextFromElement(by);
        String expectedText = expectedtext;
        Assert.assertEquals("Error has occurred --->  Test failed : ", expectedText, actualText);
    }


}

