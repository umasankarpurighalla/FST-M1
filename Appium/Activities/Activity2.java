package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        //Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        //Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Open Selenium page
        driver.get("https://www.training-support.net");
    }
    @Test
    public void ChromeTest(){
        //Page heading
        String pageTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Training Support']")).getText();
        //Page headline
        System.out.println("Heading: " + pageTitle);
        //Click on About Us
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")).click();
        //Find new page title and print it
        String newpageTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")).getText();
        //Page headline
        System.out.println("Heading: " + newpageTitle);

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}