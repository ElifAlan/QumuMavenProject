package AutomationTest.qumu.Pages;

import AutomationTest.qumu.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends BasePage{
      public  CheckoutOverviewPage(){
          PageFactory.initElements(Driver.get(),this);
      }

     @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]")
     public WebElement priceOfBackpack;

     @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[2]")
     public WebElement priceOfT_Shirt;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[1]/div[5]/div[2]/div[2]")
    public WebElement priceOfOnesie;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[@class=\"summary_info\"]/div[@class=\"summary_subtotal_label\"]")
    public WebElement itemTotal;

    // @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]")
    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[@class=\"summary_info\"]/div[@class=\"summary_tax_label\"]")
    public WebElement Tax;

    // @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]")
    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[@class=\"summary_info\"]/div[@class=\"summary_total_label\"]")
    public WebElement Total;

}
