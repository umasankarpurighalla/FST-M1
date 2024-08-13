package OrangeHRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity7 {

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
        public void addqualifications(){
            driver.findElement(By.id("menu_pim_viewMyDetails")).click();
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            driver.findElement(By.xpath("//a[text()='Qualifications' and not(@class='arrow')]/parent::li")).click();
            driver.findElement(By.id("addWorkExperience")).click();
            driver.findElement(By.id("experience_employer")).sendKeys("acf");
            driver.findElement(By.id("experience_jobtitle")).sendKeys("test");
            driver.findElement(By.id("btnWorkExpSave")).click();
            Reporter.log("Success message displayed");
        }
        @AfterTest(alwaysRun = true)
        public void closeBrowser() {
            //Close the browser
            driver.close();
        }
    }
