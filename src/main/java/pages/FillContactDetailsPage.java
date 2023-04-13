package pages;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import testBase.BaseClass;
import utility.TestUtility;

import java.io.File;
import java.io.IOException;

public class FillContactDetailsPage extends BaseClass
{
    @FindBy(xpath = "//button[text()='Request a demo'][2]")
    WebElement reqBtn;

    @FindBy(id = "FirstName")
    WebElement firstName;

    @FindBy(id = "LastName")
    WebElement lastName;

    @FindBy(id = "Email")
    WebElement emailId;

    @FindBy(id = "Company")
    WebElement companyName;

    @FindBy(id = "Country")
    WebElement country;

    @FindBy(id = "Phone")
    WebElement phoneNum;

    @FindBy(id = "Product_Interest__c")
    WebElement interestIn;

    @FindBy(id = "mktoCheckbox_35273_0")
    WebElement checkBox;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitBtn;

    public FillContactDetailsPage(){
        PageFactory.initElements(driver,this);
    }

    public void details(String firstname, String lastname, String email, String company, String phone){
        reqBtn.click();
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        emailId.sendKeys(email);
        companyName.sendKeys(company);

        Select select = new Select(country);
        select.selectByValue("India");

        phoneNum.sendKeys(phone);

        Select select1 = new Select(interestIn);
        select1.selectByValue("Mobile App Testing");

        checkBox.click();
        submitBtn.click();

    }


}
