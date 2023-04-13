package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.BaseClass;
import utility.TestUtility;

import java.util.logging.XMLFormatter;

public class ResourcesPage extends BaseClass {

    @FindBy(xpath = "//span[text()='Resources']")
    WebElement resourcedown;

    @FindBy(xpath = "//span[text()='Webinars']")
    WebElement webinar;

    @FindBy(xpath = "//span[text()='View webinar']")
    WebElement scroll;

    @FindBy(xpath = "//div[text()='Filter']")
    WebElement filter;

    @FindBy(xpath = "//span[text()='API Testing']")
    WebElement selectAPI;

    @FindBy(xpath = "(//span[text()='Appium'])[2]")
    WebElement selectAppium;

    @FindBy(xpath = "//button[text()='Apply Filters']")
    WebElement applyFilter;


    public ResourcesPage() {
        PageFactory.initElements(driver, this);
    }

    public void moveToElementOnResource() throws InterruptedException {
        TestUtility.moveToElementActions(resourcedown);
        webinar.click();
        Thread.sleep(5000);
        TestUtility.scrollByVisibleElement(scroll);
        filter.click();
        selectAPI.click();
        selectAppium.click();
        applyFilter.click();
        Thread.sleep(5000);
        TestUtility.takeScreenShot();
    }
}
