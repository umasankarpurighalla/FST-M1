package OrangeHRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity1 {
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
    public void pageTitle(){
        //Print title of page
        String pagetitle= driver.getTitle();
        System.out.println("HRM Home page title: " + pagetitle);
        if (pagetitle.contains("OrangeHRM")) {
            Assert.assertEquals(pagetitle, "OrangeHRM");
        } else {
            Assert.assertNotEquals(pagetitle, "OrangeHRM");
        }
    }
    @AfterTest
    public void closeBrowser() {
        //Close the browser
        driver.close();
    }
}


