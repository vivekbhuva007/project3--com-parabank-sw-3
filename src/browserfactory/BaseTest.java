package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        // open URl
        driver.get(baseUrl);
        //maximise windows
        driver.manage().window().maximize();

        // we give implicit time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    public void closeBrowser(){
        driver.quit();

    }
}
