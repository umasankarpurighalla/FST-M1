package activities;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;

public class W3CActionBase {
    //Create the Pointer
    public static final PointerInput pointer = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    // Create the action
    public static void doSwipe(AppiumDriver driver, Point start, Point end, int duration){
        //Create the sequence of action
        Sequence swipe = new Sequence(pointer, 1)
                .addAction(pointer.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()))
                .addAction(pointer.createPointerDown(LEFT.asArg()))
                .addAction(pointer.createPointerMove(ofMillis(duration), viewport(), start.getX(), start.getY()))
                .addAction(pointer.createPointerUp(LEFT.asArg()));
        //Perform the swipe
        driver.perform(Arrays.asList(swipe));
    }
}