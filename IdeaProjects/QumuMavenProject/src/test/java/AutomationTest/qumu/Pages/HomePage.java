package AutomationTest.qumu.Pages;

import AutomationTest.qumu.Utilities.Driver;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

         public HomePage(){
             PageFactory.initElements(Driver.get(),this);
         }

         @FindBy(id = "user-name")
         public WebElement Username;

         @FindBy(id = "password")
         public WebElement Password;

         @FindBy(id ="login-button")
         public WebElement LOGIN;

         public void login (String userName,String password){
             Username.sendKeys(userName);
             Password.sendKeys(password);
             LOGIN.click();
         }
}
