package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.BaseClass;

public class GoRequestResourcePage extends BaseClass
{
    @FindBy(id = "react-burger-menu-btn")
    WebElement menuBtn;

    @FindBy(id = "about_sidebar_link")
    WebElement aboutBtn;

    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement cookiesBtn;


    public GoRequestResourcePage(){
        PageFactory.initElements(driver,this);
    }

    public void request()
    {
        menuBtn.click();
        aboutBtn.click();
        cookiesBtn.click();

    }
}
