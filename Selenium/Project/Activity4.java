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
import java.util.List;

public class Activity4 {
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
    @Test (priority=0)
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
    @Test(priority=1)
    public void AddEmployee(){
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        //Click Employee list
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("firstName")).sendKeys("abc");
        driver.findElement(By.id("lastName")).sendKeys("def1");
        String empid=driver.findElement(By.id("employeeId")).getAttribute("value");
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("empsearch_id")).sendKeys(empid);
        driver.findElement(By.id("searchBtn")).click();
        List<WebElement> tableResult = driver.findElements(By.xpath("//table[@id = 'resultTable']/tbody/tr/td"));
        Assert.assertEquals(tableResult.size(), 8, "No record found for " + empid);
    }
    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        //Close the browser
        driver.close();
    }
}
