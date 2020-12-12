package AutomationTest.qumu.Pages;

import AutomationTest.qumu.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BasePage {
        public ProductsPage(){
            PageFactory.initElements(Driver.get(),this);
        }
       @FindBy(xpath = "//*[@id='inventory_container']/div/div[1]/div[3]/button")
       public WebElement SauceLabsBackpackAddToCart;

       @FindBy(xpath = "//*[@id='inventory_container']/div/div[4]/div[3]/button")
       public WebElement SauceLabsFleeceJacketAddToCart;

       @FindBy(xpath = "//*[@id='inventory_container']/div/div[3]/div[3]/button")
       public WebElement SauceLabsBoltT_ShirtAddToCart;

       @FindBy(xpath = "//*[@id='inventory_container']/div/div[5]/div[3]/button")
       public WebElement SauceLabsOnesieAddToCart;




}
