package Test;

import pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testBase.BaseClass;


public class SwagLabsTest extends BaseClass
{
    public LoginSwagLabsPage loginSwagLabs;
    public GoRequestResourcePage requestDemoPage;
    public FillContactDetailsPage contactDetailsPage;
    public ResourcesPage resourcesPage;
    public FacebookPage facebookPage;

    SwagLabsTest(){
        super();
    }

    @BeforeMethod
    public void beforeMethod(){
        initialization();
        loginSwagLabs = new LoginSwagLabsPage();
        requestDemoPage = new GoRequestResourcePage();
        contactDetailsPage = new FillContactDetailsPage();
        resourcesPage = new ResourcesPage();
        facebookPage = new FacebookPage();
    }

    //verify login with valid username & password
    @Test(priority = 1)
    public void verifyLogin() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        loginSwagLabs.login(prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(3000);
        requestDemoPage.request();
        Thread.sleep(3000);
        contactDetailsPage.details(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("email"), prop.getProperty("company"), prop.getProperty("phone") );
        Thread.sleep(9000);
        softAssert.assertAll();
    }

    //take ss after applying filter on webinar
    @Test(priority = 2)
    public void verifyScreenshotAfterFilter() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        loginSwagLabs.login(prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(3000);
        requestDemoPage.request();
        Thread.sleep(3000);
        resourcesPage.moveToElementOnResource();
        Thread.sleep(9000);
        softAssert.assertAll();
    }

    //get title of facebook page
    @Test(priority = 3)
    public void verifyFacbookLink() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        loginSwagLabs.login(prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(3000);
        facebookPage.clickFacebook();
        Thread.sleep(3000);
        softAssert.assertEquals(FacebookPage.getTextOfPage(),"Swag Labs","title must be match");
        Thread.sleep(3000);
        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

}
