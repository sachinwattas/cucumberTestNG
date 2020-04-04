package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitUtils {

    public static WebElement waitForVisiblity(WebDriver driver, By by)
    {
        return new WebDriverWait(driver, 10).ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
