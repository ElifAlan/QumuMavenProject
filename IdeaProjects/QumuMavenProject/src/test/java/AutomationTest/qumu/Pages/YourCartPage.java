package AutomationTest.qumu.Pages;

import AutomationTest.qumu.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage extends BasePage{

       public YourCartPage(){
           PageFactory.initElements(Driver.get(),this);
       }
     /*  public WebElement getQTY( int amount){

           String xpath = "//*[@id='cart_contents_container']/div/div[1]/div["+amount+"]";
           for (int i=3;i<=6;i++){

               amount++;
           }

           return Driver.get().findElement(By.xpath(xpath));
       }*/

    @FindBy (xpath = "//*[@id='cart_contents_container']/div/div[1]/div[3]/div[1]")
    public WebElement QTY_SaurceLabsBackpack;

    @FindBy (xpath = "//*[@id='cart_contents_container']/div/div[1]/div[4]/div[1]")
    public WebElement QTY_SaurceLabsBoltT_Shirt;

    @FindBy (xpath = "//*[@id='cart_contents_container']/div/div[1]/div[5]/div[1]")
    public WebElement QTY_SaurceLabsOnesie;

    @FindBy (xpath = "//*[@id='cart_contents_container']/div/div[1]/div[6]/div[1]")
    public WebElement QTY_SaurceLabsFleeJacket;

    @FindBy(xpath = "//*[@id='cart_contents_container']/div/div[1]/div[6]/div[2]/div[2]/button")
    public WebElement FleeceJacketRemove;

    @FindBy(xpath = "//*[@id='cart_contents_container']/div/div[2]/a[2]")
    public WebElement Checkout;
}
