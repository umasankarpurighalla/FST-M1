package StepDefinitions;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Activity2LoginSteps {
        WebDriver driver;
        WebDriverWait wait;

        @Given("^User is on Test Login page$")
        public void loginPage() {
            //Setup instances
            driver = new FirefoxDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            //Open browser
            driver.get("https://v1.training-support.net/selenium/login-form");
            Assertions.assertEquals("Login Form",driver.getTitle());
        }

        @When("^User enters username and password in Login Form Page$")
        public void enterCredentials() {
            //Enter username
            driver.findElement(By.id("username")).sendKeys("admin");
            //Enter password
            driver.findElement(By.id("password")).sendKeys("password");
            //Click Login
            driver.findElement(By.xpath("//button[@type='submit']")).click();
        }

        @Then("^Read the page title and confirmation message in Login Form Page$")
        public void readTitleAndHeading() {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));

            //Read the page title and heading
            String pageTitle = driver.getTitle();
            String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();

            //Print the page title and heading
            System.out.println("Page title is: " + pageTitle);
            System.out.println("Login message is: " + confirmMessage);
        }

        @And("^Close the Login Browser$")
        public void closeBrowser() {
            //Close browser
            driver.close();
        }
    }