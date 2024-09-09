import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/ajax");
        System.out.println("Home page title: " + driver.getTitle());
        driver.findElement(By.xpath("//button[contains(text(),'Change Content')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String text= driver.findElement(By.xpath("//h1[contains(text(),'HELLO!')]")).getText();
        System.out.println("text" +text);
        WebElement delayedText = driver.findElement(By.tagName("h3"));
        System.out.println(delayedText.getText());
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"), "I'm late!"));
        String latetext= driver.findElement(By.xpath("//h3[contains(text(),'m late!')]")).getText();
        System.out.println(latetext);


driver.close();

    }
}
