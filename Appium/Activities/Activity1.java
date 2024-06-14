package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    //Driver Declaration
    AndroidDriver driver;
    //Set up Method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Set the capabilities
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.miui.calculator")
                .setAppActivity(".cal.CalculatorActivity")
                .noReset();
        //Set the server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Initialize the android driver
        driver = new AndroidDriver(serverURL, caps);

    }
    @Test
    public void multiplyTest(){
        //Find the number 7 and tap it
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_7_s")).click();

        //Find the multiply button and tap it
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_mul_s")).click();

        //Find the number 9 and tap it
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_9_s")).click();

        // Find the equal button and tap it
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        //Assertions
        String result = driver.findElement(AppiumBy.id("result")).getText();
        Assert.assertEquals(result, "= 63");

    }
    // Tear down method
    @AfterClass
    public void tearDown(){
        // Close the app
        driver.quit();
    }
}