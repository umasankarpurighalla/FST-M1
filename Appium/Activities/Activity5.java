package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity5 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException{
        //Desired Capabilities
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("com.android.mms");
        caps.setAppActivity(".ui.MmsTabActivity");
        caps.noReset();

        //Set server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        //Initialize Android driver
        driver = new AndroidDriver(serverURL, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @Test
    public void SMStest(){
        //Find element and click
        driver.findElement(AppiumBy.accessibilityId("Compose")).click();
        driver.findElement(AppiumBy.accessibilityId("Recipient: ")).click();
        driver.findElement(AppiumBy.id("com.android.mms:id/recipients_editor")).sendKeys("9704797928");
        //Press enter or OK
        //driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
        driver.findElement(AppiumBy.accessibilityId("OK")).click();
        driver.findElement(AppiumBy.id("com.android.mms:id/embedded_text_editor")).sendKeys("Hello from Appium");

        //Wait for the visibility of send button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Send message")));
        driver.findElement(AppiumBy.accessibilityId("Send message")).click();
        // Assertion
        String messageTextSent = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Hello from Appium']")).getText();
        Assert.assertEquals(messageTextSent, "Hello from Appium");
    }
    @AfterClass
//Tear down script
    public void tearDown(){
        driver.quit();
    }
}


