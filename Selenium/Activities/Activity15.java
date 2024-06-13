import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Activity15 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Open the page
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println("Home page title: " + driver.getTitle());
        driver.findElement(By.xpath("//input[@placeholder='Username' and @type='text']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@placeholder='Password' and @type='password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        String welcomemessage=driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: "+welcomemessage);
        driver.quit();
    }
}