package OrangeHRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity8 {

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
        public void applyleave(){
            WebElement dropdown = driver.findElement(By.id("applyleave_txtLeaveType"));
            Select leaveType = new Select(dropdown);
            dropdown.click();
            leaveType.selectByValue("1");

            WebElement from = driver.findElement(By.id("applyleave_txtFromDate"));
            from.clear();
            from.sendKeys("2024-06-26");
            WebElement to = driver.findElement(By.id("applyleave_txtToDate"));
            to.clear();
            to.sendKeys("2024-06-26");
            driver.findElement(By.id("applyleave_txtComment")).click();
            driver.findElement(By.id("applyBtn")).click();

            driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
            from = driver.findElement(By.id("calFromDate"));
            to = driver.findElement(By.id("calToDate"));
            from.clear();
            to.clear();
            from.sendKeys("2024-06-26");
            to.sendKeys("2024-06-26");

            driver.findElement(By.id("btnSearch")).click();
            Assert.assertEquals(driver.findElement(By.xpath("//table[@id = 'resultTable']/tbody/tr/td[6]")).getText(), "Pending Approval(1.00)");
        }
        @AfterTest(alwaysRun = true)
        public void closeBrowser() {
            //Close the browser
            driver.close();
        }
    }
