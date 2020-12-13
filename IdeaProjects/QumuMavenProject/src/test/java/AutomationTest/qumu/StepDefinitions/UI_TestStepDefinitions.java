package AutomationTest.qumu.StepDefinitions;

import AutomationTest.qumu.Pages.CheckoutPage;
import AutomationTest.qumu.Pages.HomePage;
import AutomationTest.qumu.Pages.ProductsPage;
import AutomationTest.qumu.Pages.YourCartPage;
import AutomationTest.qumu.Utilities.BrowserSetup;
import AutomationTest.qumu.Utilities.Driver;
import AutomationTest.qumu.Utilities.TestDataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UI_TestStepDefinitions {

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
       String url= TestDataReader.get("UI_url");
        Driver.get().get(url);
    }

    @Given("I login in with the following details")
    public void i_login_in_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
        HomePage homePage= new HomePage();
        homePage.login(TestDataReader.get("Username"),TestDataReader.get("Password"));
    }

    @Given("I add the following items to the basket")
    public void i_add_the_following_items_to_the_basket(io.cucumber.datatable.DataTable dataTable) {
        ProductsPage productsPage = new ProductsPage();
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
        //System.out.println("actualAmountItems = " + actualAmountItems);


        Assert.assertEquals("verify that "+expectedAmountItems+"added",expectedAmountItems,actualAmountItems);
    }

    @Given("I click on the shopping cart")
    public void i_click_on_the_shopping_cart() {
        ProductsPage productsPage = new ProductsPage();
        productsPage.ShoppingCartContainer.click();
    }

    @Given("I verify that the QTY count for each item should be {int}")
    public void i_verify_that_the_QTY_count_for_each_item_should_be(Integer int1) {
        YourCartPage yourCartPage=new YourCartPage();
        String expectedQTYAmount="1";

        String ItemBackpackAmount=yourCartPage.QTY_SaurceLabsBackpack.getText();
        Assert.assertEquals("verifying that QTY count is 1",expectedQTYAmount,ItemBackpackAmount);

        String ItemBoltT_Shirt=yourCartPage.QTY_SaurceLabsBoltT_Shirt.getText();
        Assert.assertEquals("verifying that QTY count is 1",expectedQTYAmount,ItemBoltT_Shirt);

        String ItemOnesie=yourCartPage.QTY_SaurceLabsOnesie.getText();
        Assert.assertEquals("verifying that QTY count is 1",expectedQTYAmount,ItemOnesie);

        String ItemFleeJacket=yourCartPage.QTY_SaurceLabsFleeJacket.getText();
        Assert.assertEquals("verifying that QTY count is 1",expectedQTYAmount,ItemFleeJacket);


    }

    @Given("I remove the following item:")
    public void i_remove_the_following_item(io.cucumber.datatable.DataTable dataTable) {
        YourCartPage yourCartPage= new YourCartPage();
        yourCartPage.FleeceJacketRemove.click();

        BrowserSetup.waitFor(3);


    }

    @Given("I click on the CHECKOUT button")
    public void i_click_on_the_CHECKOUT_button() {
       YourCartPage yourCartPage=new YourCartPage();
       yourCartPage.Checkout.click();
    }

    @Given("I type {string} for First Name")
    public void i_type_for_First_Name(String string) {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.First_Name.sendKeys(TestDataReader.get("First_Name"));
        checkoutPage.Last_Name.sendKeys(TestDataReader.get("Last_Name"));
        checkoutPage.ZipPostalCode.sendKeys(TestDataReader.get("ZipPostalCode"));
        checkoutPage.Continue.click();
    }

    @Given("I type {string} for Last Name")
    public void i_type_for_Last_Name(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Given("I type {string} for ZIP\\/Postal Code")
    public void i_type_for_ZIP_Postal_Code(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I click on the CONTINUE button")
    public void i_click_on_the_CONTINUE_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Item total will be equal to the total of items on the list")
    public void item_total_will_be_equal_to_the_total_of_items_on_the_list() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("a Tax rate of {int} % is applied to the total")
    public void a_Tax_rate_of_is_applied_to_the_total(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }


    @And("I  should see {int} items added to the shopping cart.")
    public void iShouldSeeItemsAddedToTheShoppingCart(int arg0) {

        String expectedAmountItems="3";
        ProductsPage productsPage= new ProductsPage();
        String actualAmountItems =productsPage.ShoppingCartContainer.getText();
        Assert.assertEquals("verify that "+expectedAmountItems+"added",expectedAmountItems,actualAmountItems);
    }
}
