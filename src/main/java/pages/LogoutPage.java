package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.BaseClass;

public class LogoutPage extends BaseClass
{
    @FindBy(id = "react-burger-menu-btn")
    WebElement menuBtn;

    @FindBy(id = "logout_sidebar_link")
    WebElement logOut;

    public LogoutPage(){
        PageFactory.initElements(driver,this);
    }

    public void logout(){
        menuBtn.click();
        logOut.click();
    }
}
