package OrangeHRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity2 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setup() {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        // Open the page
        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");

        Reporter.log("Opened Browser |");
    }
    @Test
    public void pageurl(){
        //Print title of page
        WebElement urlheaderimage= driver.findElement(By.xpath("//img[contains(@src,'logo')]"));
        System.out.println("HRM Home page url header image: " + urlheaderimage);
        String geturl=driver.getCurrentUrl();
        System.out.println("url is: "+geturl);
    }
    @AfterTest
    public void closeBrowser() {
        //Close the browser
        driver.close();
    }
}
