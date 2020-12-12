package AutomationTest.qumu.Pages;

import AutomationTest.qumu.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage{
     public CheckoutPage(){
         PageFactory.initElements(Driver.get(),this);
     }

     @FindBy(id = "first-name")
     public WebElement First_Name;

     @FindBy(id = "last-name")
     public WebElement Last_Name;

     @FindBy(id = "postal-code")
     public WebElement ZipPostalCode;

     @FindBy(xpath = "//*[@id='checkout_info_container']/div/form/div[2]/input")
     public WebElement Continue;

}
