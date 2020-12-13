package AutomationTest.qumu.Pages;

import AutomationTest.qumu.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(xpath = "//*[@id='shopping_cart_container']/a/span")
    public WebElement ShoppingCartContainer;
}
//*[@id="shopping_cart_container"]/a/span