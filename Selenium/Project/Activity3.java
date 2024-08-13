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

public class Activity3 {
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
    @Test(priority = 2)
    public void EditInfo(){
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.findElement(By.xpath("//input[@value='Edit']")).click();
       WebElement firstname= driver.findElement(By.xpath("//input[@title='First Name']"));
        firstname.clear();
        firstname.sendKeys("yuvraj");
        driver.findElement(By.id("btnSave")).click();
    }

    @Test(priority = 3)
    public void directory(){
        driver.findElement(By.id("menu_directory_viewDirectory")).click();
      // WebElement searchdirectory= driver.findElement(By.xpath("//a[@class='toggle tiptip']"));
      System.out.println("Heading of the page is: "+driver.getTitle().contains("Search Directory"));
    }
    @Test(priority = 4)
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

    @Test(priority = 5)
    public void applyleave(){
        driver.findElement(By.xpath("//b[text()='Leave']")).click();
        driver.findElement(By.xpath("//a[text()='Apply']")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.findElement(By.id("btnSearch")).click();
        String status=driver.findElement(By.xpath("//a[contains(text(),'Pending Approval')]")).getText();
       System.out.println(status);
    }
@Test(priority = 6)
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
