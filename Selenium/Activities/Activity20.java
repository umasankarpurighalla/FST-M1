import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Activity20 {
    public static void main(String[] args) throws Exception {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());
        driver.findElement(By.id("prompt")).click();
        Alert alert=driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Text in alert: " + alertText);
        Thread.sleep(2000);
        alert.sendKeys("Awesome!");
        Thread.sleep(2000);
        alert.accept();
        driver.quit();
}
}
