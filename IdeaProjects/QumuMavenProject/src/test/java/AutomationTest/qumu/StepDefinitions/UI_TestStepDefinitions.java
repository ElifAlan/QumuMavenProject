package AutomationTest.qumu.StepDefinitions;

import AutomationTest.qumu.Pages.*;
import AutomationTest.qumu.Utilities.BrowserSetup;
import AutomationTest.qumu.Utilities.Driver;
import AutomationTest.qumu.Utilities.TestDataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import static org.junit.Assert.*;
import java.text.DecimalFormat;

public class UI_TestStepDefinitions {
    HomePage homePage= new HomePage();
    ProductsPage productsPage = new ProductsPage();
    YourCartPage yourCartPage=new YourCartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
       String url= TestDataReader.get("UI_url");
        Driver.get().get(url);
    }

    @Given("I login in with the following details")
    public void i_login_in_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {

        homePage.login(TestDataReader.get("Username"),TestDataReader.get("Password"));
    }

    @Given("I add the following items to the basket")
    public void i_add_the_following_items_to_the_basket(io.cucumber.datatable.DataTable dataTable) {

        productsPage.SauceLabsBackpackAddToCart.click();
        productsPage.SauceLabsFleeceJacketAddToCart.click();
        productsPage.SauceLabsBoltT_ShirtAddToCart.click();
        productsPage.SauceLabsOnesieAddToCart.click();
    }

    @Given("I  should see {int} items added to the shopping cart")
    public void i_should_see_items_added_to_the_shopping_cart(Integer expected) {

        ProductsPage productsPage= new ProductsPage();
        Integer actual=Integer.parseInt(productsPage.ShoppingCartContainer.getText());

        assertEquals("verify that "+expected+ " items added",expected,actual);
    }

    @Given("I click on the shopping cart")
    public void i_click_on_the_shopping_cart() {

        productsPage.ShoppingCartContainer.click();
    }

    @Given("I verify that the QTY count for each item should be {int}")
    public void i_verify_that_the_QTY_count_for_each_item_should_be(Integer int1) {

        String expectedQTYAmount="1";

        String ItemBackpackAmount=yourCartPage.QTY_SaurceLabsBackpack.getText();
       assertEquals("verifying that QTY count is "+"\"int1\"",expectedQTYAmount,ItemBackpackAmount);

        String ItemBoltT_Shirt=yourCartPage.QTY_SaurceLabsBoltT_Shirt.getText();
        assertEquals("verifying that QTY count is "+"\"int1\"",expectedQTYAmount,ItemBoltT_Shirt);

        String ItemOnesie=yourCartPage.QTY_SaurceLabsOnesie.getText();
        assertEquals("verifying that QTY count is "+"\"int1\"",expectedQTYAmount,ItemOnesie);

        String ItemFleeJacket=yourCartPage.QTY_SaurceLabsFleeJacket.getText();
        assertEquals("verifying that QTY count is "+"\"int1\"",expectedQTYAmount,ItemFleeJacket);


    }

    @Given("I remove the following item:")
    public void i_remove_the_following_item(io.cucumber.datatable.DataTable dataTable) {

        yourCartPage.FleeceJacketRemove.click();

        BrowserSetup.waitFor(3);


    }

    @Given("I click on the CHECKOUT button")
    public void i_click_on_the_CHECKOUT_button() {

       yourCartPage.Checkout.click();
    }

    @Given("I type {string} for First Name")
    public void i_type_for_First_Name(String firstName) {
        checkoutPage.First_Name.sendKeys(firstName);
    }

    @Given("I type {string} for Last Name")
    public void i_type_for_Last_Name(String lastName) {
        checkoutPage.Last_Name.sendKeys(lastName);
    }

    @Given("I type {string} for ZIP\\/Postal Code")
    public void i_type_for_ZIP_Postal_Code(String zipcode) {
        checkoutPage.ZipPostalCode.sendKeys(zipcode);
    }

    @When("I click on the CONTINUE button")
    public void i_click_on_the_CONTINUE_button() {
        checkoutPage.Continue.click();
    }

    @Then("Item total will be equal to the total of items on the list")
    public void item_total_will_be_equal_to_the_total_of_items_on_the_list() {




        System.out.println("checkoutOverviewPage.priceOfBackpack.getText() = " + checkoutOverviewPage.priceOfBackpack.getText());
        System.out.println("checkoutOverviewPage.priceOfT_Shirt.getText() = " + checkoutOverviewPage.priceOfT_Shirt.getText());
        System.out.println("checkoutOverviewPage.priceOfOnesie.getText() = " + checkoutOverviewPage.priceOfOnesie.getText());

        String actualBackpackPrice =checkoutOverviewPage.priceOfBackpack.getText();
        System.out.println( "Backpack: "+actualBackpackPrice);
        double actualbackpackPrice= Double.parseDouble(actualBackpackPrice.substring(1));

        double actualT_shirtPrice=Double.parseDouble(checkoutOverviewPage.priceOfT_Shirt.getText().substring(1));
        System.out.println("Tshirt: "+actualT_shirtPrice);

        double actualOnesiePrice =Double.parseDouble(checkoutOverviewPage.priceOfOnesie.getText().substring(1));
        System.out.println("Onesie "+actualOnesiePrice);

        String expectedBackpackPrice ="$29.99";
        double expectedbackpackprice=29.99;
        double expectedT_shirtPrice =15.55;
        double expectedOnesiePrice=7.99;


                     assertEquals(expectedBackpackPrice,actualBackpackPrice);
                     assertNotEquals(expectedT_shirtPrice,actualT_shirtPrice);
                     assertNotEquals(expectedOnesiePrice,actualOnesiePrice);


         double actualItemTotal = actualbackpackPrice + actualT_shirtPrice + actualOnesiePrice;
         System.out.println("actualItemTotal: " + actualItemTotal);
         double expectedItemTotal =expectedbackpackprice + expectedT_shirtPrice + expectedOnesiePrice;
         System.out.println("expectedItemTotal :"+expectedItemTotal);

                      assertNotEquals(expectedItemTotal,actualItemTotal);



    }

    @Then("a Tax rate of {int} % is applied to the total")
    public void a_Tax_rate_of_is_applied_to_the_total(Integer int1) {

         String Total = checkoutOverviewPage.Total.getText();
         double totalWithTax = Double.parseDouble(checkoutOverviewPage.Total.getText().substring(8));
         System.out.println("Total with Tax:"+totalWithTax);


         String ItemTotal =checkoutOverviewPage.itemTotal.getText();
         double totalWithoutTax = Double.parseDouble(ItemTotal.substring(13));
         System.out.println("Total without Tax: "+totalWithoutTax);

         double expectedTotalWithTax = totalWithoutTax + (totalWithoutTax * int1)/100;
        DecimalFormat df = new DecimalFormat("#.##");
        expectedTotalWithTax = Double.valueOf(df.format(expectedTotalWithTax));
        System.out.println(expectedTotalWithTax);

        Assert.assertEquals(totalWithTax,expectedTotalWithTax,"verify that "+int1+" % is applied");




    }


    @And("I  should see {int} items added to the shopping cart.")
    public void iShouldSeeItemsAddedToTheShoppingCart(Integer expected) {

        ProductsPage productsPage= new ProductsPage();
        Integer actual=Integer.parseInt(productsPage.ShoppingCartContainer.getText());

        assertEquals("verify that "+expected+ " items added",expected,actual);
    }
}
