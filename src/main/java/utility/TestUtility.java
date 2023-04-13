package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.BaseClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class TestUtility extends BaseClass {

    public static Actions actions;
    public static JavascriptExecutor java;

    public static final long IMPLICIT_WAIT = 20;
    public static final long PAGE_LOAD_WAIT = 20;
    public static final long EXPLICIT_WAIT = 20;

    public static void waitUntilElementToBeClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static String getTextOfPage(String title) {
        return driver.getTitle();
    }

    public static void moveToElementActions(WebElement element) {
        actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void scrollDownByPixel() {
        java = (JavascriptExecutor) driver;
        java.executeScript("window.scrollBy(0,1000)");
    }

    public static void scrollUpByPixel() {
        java = (JavascriptExecutor) driver;
        java.executeScript("window.scrollBy(0,-500)");
    }

    public static void scrollByVisibleElement(WebElement element) {
        java = (JavascriptExecutor) driver;
        java.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void takeScreenShot() {
        File files = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(files, new File("C:/IntelJ_files/Project_files/ProjectSwagLabs/ScreenshotStored/filter4.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getWindowHandles() {
        String parentId = driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();
        for (String s : allWindow) {
            if (!parentId.contentEquals(s)) {
                driver.switchTo().window(s);
                driver.close();
            }
            driver.switchTo().window(parentId);
        }
    }

}
