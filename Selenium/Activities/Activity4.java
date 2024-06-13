package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Activity4 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
        System.out.println("Home page title: " + driver.getTitle());
        String third=driver.findElement(By.xpath("//h3[(@id='third-header')]")).getText();
        System.out.println("third text: "+third);
        String fifth=driver.findElement(By.xpath("//h5[@class='ui green header']")).getCssValue("color");
        System.out.println("fifth color: "+fifth);
        String violet=driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class");
        System.out.println("violet class: "+violet);
        String grey=driver.findElement(By.xpath("//button[text()='Grey']")).getText();
        System.out.println("grey text: "+grey);
        driver.close();


    }
}
