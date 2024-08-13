package OrangeHRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;

public class Activity9 {
        WebDriver driver;
        WebDriverWait wait;

        @BeforeTest(alwaysRun = true)
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
        @Test(priority=0)
        public void loginTestCase() {
            //Find username and pasword fields
            WebElement usernameField = driver.findElement(By.id("txtUsername"));
            WebElement passwordField = driver.findElement(By.id("txtPassword"));

            //Enter values
            usernameField.sendKeys("orange");
            passwordField.sendKeys("orangepassword123");

            //Click Log in
            driver.findElement(By.id("btnLogin")).click();
            String pagetitle= driver.getTitle();
            System.out.println("pagetitle is: "+pagetitle);
            Assert.assertEquals(pagetitle, "OrangeHRM");
        }
        @Test(priority = 1)
        public void addemergencycontacts(){
            driver.findElement(By.id("menu_pim_viewMyDetails")).click();
            driver.findElement(By.xpath("//a[text()='Emergency Contacts']")).click();
            driver.findElement(By.id("btnAddContact")).click();
            driver.findElement(By.id("emgcontacts_name")).sendKeys("abc");
            driver.findElement(By.id("emgcontacts_relationship")).sendKeys("friend");
            driver.findElement(By.id("btnSaveEContact")).click();
            List<WebElement> alldetails=driver.findElements(By.xpath("//*[@id='frmEmpDelEmgContacts']"));
            System.out.println("All records: "+alldetails);
        }
        @AfterTest(alwaysRun = true)
        public void closeBrowser() {
            //Close the browser
            driver.close();
        }
    }
