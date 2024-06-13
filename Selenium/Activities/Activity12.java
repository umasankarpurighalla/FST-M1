package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Open the page
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Home page title: " + driver.getTitle());
        WebElement inputtext=driver.findElement(By.xpath("//input[@id='input-text']"));
        System.out.println("textbox is enabled: "+inputtext.isEnabled());
        driver.findElement(By.xpath("//button[@id='toggleInput']")).click();
        System.out.println("textbox is enabled: "+inputtext.isEnabled());
        inputtext.sendKeys("test");
        driver.close();
    }
}

