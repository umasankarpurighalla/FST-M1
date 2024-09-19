package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;


public class Login extends BaseClass {


    @Given("User is on Login page")
    public void openBroswer() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @When("user enters {string} and {string}")
    public void enterCredentials(String username, String password) {

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @Then("Read the page title and confirmation message")
    public void readThePageTitleAndConfirmationMessage() {
        System.out.println("Tittle of page : " + driver.getTitle());
    }

    @Then("Close the Browser")
    public void close_the_browser() {
        driver.close();
    }

    @When("User enters {string} and {string}")
    public void user_enters_and(String userName, String passwd) {
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(passwd);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @When("User enters Usernames and Password")
    public void user_enters_username_and_password(DataTable credentials) {
        List<List<String>> data = credentials.asLists();
        driver.findElement(By.id("username")).sendKeys(data.get(0).get(0));
        driver.findElement(By.id("password")).sendKeys(data.get(0).get(1));
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

    }
}
