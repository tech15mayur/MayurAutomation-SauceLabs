package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.BaseClass;
import utility.TestUtility;

public class FacebookPage extends BaseClass
{
    @FindBy(xpath = "//a[text()='Facebook']")
    WebElement facebookLogo;

    public FacebookPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickFacebook(){
        TestUtility.getWindowHandles();
        TestUtility.scrollDownByPixel();
        facebookLogo.click();
    }

    public static String getTextOfPage(){
        return TestUtility.getTextOfPage("");
    }

}
