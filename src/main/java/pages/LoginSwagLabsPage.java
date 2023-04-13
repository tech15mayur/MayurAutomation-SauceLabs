package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.BaseClass;

public class LoginSwagLabsPage extends BaseClass
{
    @FindBy(id = "user-name")
    WebElement userName;

    @FindBy(id = "password")
    WebElement passWord;

    @FindBy(id = "login-button")
    WebElement logInBtn;

    public LoginSwagLabsPage(){
        PageFactory.initElements(driver,this);
    }

    public void login(String username, String password){
        userName.sendKeys(username);
        passWord.sendKeys(password);
        logInBtn.click();
    }
}
