package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity4 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.dialer");
        options.setAppActivity(".extensions.GoogleDialtactsActivity");
        options.noReset();

        //Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Open Selenium page
        //driver.get("https://v1.training-support.net/selenium");
    }

    @Test
    public void ContactsTest() {
        //FInd and click the add button
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Create new contact']")).click();
        //Wait for element
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.EditText[@text='First name']")));
        //Enter the details
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']"
        )).sendKeys("Aaditya");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Surname']"
        )).sendKeys("Verma-MobileTesting");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']"
        )).sendKeys("999148292");
        //Save
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.contacts:id/toolbar_button"))).click();

        //Assertions
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.dialer:id/contact_name")));
        List<WebElement> contacts = driver.findElements(AppiumBy.id("com.google.android.dialer:id/contact_name"));
        String contactName = contacts.get(1).getText();
        Assert.assertEquals(contactName, "Aaditya Verma-MobileTesting");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }
}

