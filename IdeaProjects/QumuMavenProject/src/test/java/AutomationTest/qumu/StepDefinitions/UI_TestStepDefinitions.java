package AutomationTest.qumu.StepDefinitions;

import AutomationTest.qumu.Pages.*;
import AutomationTest.qumu.Utilities.BrowserSetup;
import AutomationTest.qumu.Utilities.Driver;
import AutomationTest.qumu.Utilities.TestDataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import java.sql.SQLOutput;

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
    public void i_should_see_items_added_to_the_shopping_cart(Integer int1) {
       String expectedAmountItems="4";
       ProductsPage productsPage= new ProductsPage();
       String actualAmountItems =productsPage.ShoppingCartContainer.getText();
        System.out.println("actualAmountItems = " + actualAmountItems);


       assertEquals("verify that "+expectedAmountItems+"added",expectedAmountItems,actualAmountItems);
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
    public void i_type_for_First_Name(String string) {
        checkoutPage.First_Name.sendKeys(TestDataReader.get("First_Name"));
    }

    @Given("I type {string} for Last Name")
    public void i_type_for_Last_Name(String string) {
        checkoutPage.Last_Name.sendKeys(TestDataReader.get("Last_Name"));
    }

    @Given("I type {string} for ZIP\\/Postal Code")
    public void i_type_for_ZIP_Postal_Code(String string) {
        checkoutPage.ZipPostalCode.sendKeys(TestDataReader.get("ZipPostalCode"));
    }

    @When("I click on the CONTINUE button")
    public void i_click_on_the_CONTINUE_button() {
        checkoutPage.Continue.click();
    }

    @Then("Item total will be equal to the total of items on the list")
    public void item_total_will_be_equal_to_the_total_of_items_on_the_list() {
        String expectedBackpackPrice="$29.99";
        String expectedT_shirtPrice="$15.99";
        String expectedOnesiePrice="$7.99";

        String backpackPrice =checkoutOverviewPage.priceOfBackpack.getText();
        String t_shirtPrice=checkoutOverviewPage.priceOfT_Shirt.getText();
        String onesiePrice=checkoutOverviewPage.priceOfOnesie.getText();

        System.out.println(backpackPrice);
        System.out.println(t_shirtPrice);
        System.out.println(onesiePrice);

        assertEquals(expectedBackpackPrice,backpackPrice);
        assertEquals(expectedT_shirtPrice,t_shirtPrice);
        assertEquals(expectedOnesiePrice,onesiePrice);

    }

    @Then("a Tax rate of {int} % is applied to the total")
    public void a_Tax_rate_of_is_applied_to_the_total(Integer int1) {


    }


    @And("I  should see {int} items added to the shopping cart.")
    public void iShouldSeeItemsAddedToTheShoppingCart(int arg0) {

        String expectedAmountItems="3";
        ProductsPage productsPage= new ProductsPage();
        String actualAmountItems =productsPage.ShoppingCartContainer.getText();
        assertEquals("verify that "+expectedAmountItems+"added",expectedAmountItems,actualAmountItems);
    }
}
