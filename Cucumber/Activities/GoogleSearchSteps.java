package StepDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GoogleSearchSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on Google Home Page$")
    public void userIsOnGooglePage() throws Exception  {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(15));

        //Open the browser
        driver.get("https://www.google.com");
    }

    @When("^User types in Cheese and hits ENTER$")
    public void userTypesInCheeseAndHitsENTER() throws Exception  {
        driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);
        wait = new WebDriverWait(driver,Duration.ofSeconds(25));
    }

    @Then("^Show how many search results were shown$")
    public void showHowManySearchResultsWereShown() throws Exception  {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
        wait = new WebDriverWait(driver,Duration.ofSeconds(25));
        String resultStats = driver.findElement(By.id("result-stats")).getText();
        System.out.println("Number of results found: " + resultStats);
    }

    @And("^Close the browser$")
    public void closeTheBrowser() throws Exception {
        driver.quit();
    }
}