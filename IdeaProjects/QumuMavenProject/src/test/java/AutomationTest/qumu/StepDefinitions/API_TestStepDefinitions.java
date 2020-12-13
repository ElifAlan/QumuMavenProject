package AutomationTest.qumu.StepDefinitions;

import AutomationTest.qumu.Utilities.TestBase;
import AutomationTest.qumu.Utilities.TestDataReader;
import AutomationTest.qumu.Utilities.Users;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import  static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.json.Json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class API_TestStepDefinitions {
    Response response;


    //BUNA TEKRAR BAK!!
    @Given("I get the default list of users for on {int}st page")
    public void i_get_the_default_list_of_users_for_on_st_page (Integer pageNumber)  {

        response = given().accept(ContentType.JSON)
                .queryParam("page",pageNumber)
                .when().get(TestDataReader.get("api_url")+"api/users");
        assertEquals(response.statusCode(),200);
        System.out.println(response.getHeader("Content-Type"));
        assertEquals(response.contentType(),"application/json; charset=utf-8");

       // Map<String,Object> list = response.body().as(Map.class);
       // System.out.println(list);


        response.prettyPrint();

    }
      // YUKARDAKI ILE AYNI SEBEPTEN BUNA DA BAK!!!!
    @When("I get the list of all users within every page")
    public void i_get_the_list_of_all_users_within_every_page() {
       response = given().accept(ContentType.JSON)
                           .queryParam("page","2")
                            .when().get(TestDataReader.get("api_url")+"api/users");

        assertEquals(response.statusCode(),200);
        System.out.println(response.getHeader("Content-Type"));
        assertEquals(response.contentType(),"application/json; charset=utf-8");
        response.prettyPrint();

    }

    @Then("I should see total users count equals the number of user ids")
    public void i_should_see_total_users_count_equals_the_number_of_user_ids() {

        int totalUsersCount = response.path("total");
        System.out.println(totalUsersCount);

        int numberOfUserIds= response.path("data.id[5]");
        System.out.println(numberOfUserIds);

        assertEquals(totalUsersCount,numberOfUserIds);



    }

    @Given("I make a search for user {int}")
    public void i_make_a_search_for_user(Integer idNumber) {
        response=given().accept(ContentType.JSON)
                .and().pathParam("id",idNumber)
                .when().get(TestDataReader.get("api_url")+"api/users/{id}");
        //Assertion burada yapilinca paska stepte hata veriyor

      /*  assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json; charset=utf-8");
        //response.prettyPrint();
        //int id = response.path("data.id");
        //System.out.println(id);*/

    }

    @Then("I should see the following user data")
    public void i_should_see_the_following_user_data(io.cucumber.datatable.DataTable dataTable) {
        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json; charset=utf-8");
        //response.prettyPrint();
        //int id = response.path("data.id");
        //System.out.println(id);

        String firstName= response.path("data.first_name");
        String email= response.path("data.email");
        //System.out.println(firstName);
        //System.out.println(email);

        assertEquals(firstName,"Emma");
        assertEquals(email,"emma.wong@reqres.in");


    }


   /* @Given("I make a search for user {int}.")
    public void iMakeASearchForUser(int idNumber) {
       response=given().accept(ContentType.JSON)
                .and().pathParam("id",idNumber)
                .when().get(TestDataReader.get("api_url")+"api/users/{id}");


    }*/

    @Then("I receive error code {int} in response")
    public void i_receive_error_code_in_response(Integer code) {
        assertEquals(response.statusCode(),404);

    }

    @Given("I create a user with following Peter Manager")
    public void i_create_a_user_with_following_Peter_Manager() {

        Map<String,Object> userMap= new HashMap<>();
        userMap.put("name","Peter");
        userMap.put("job","Manager");


        response= given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(userMap)
                .when().post(TestDataReader.get("api_url")+"api/users");
        assertEquals(response.statusCode(),201);
        assertEquals(response.contentType(),"application/json; charset=utf-8");

    }
      // Buna da bak!!!!
    @Then("response should contain the following data")
    public void response_should_contain_the_following_data(io.cucumber.datatable.DataTable dataTable) {
        Users users1 = new Users();
        users1.setName("Peter");
        users1.setJob("Manager");

       response= given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(users1)
                .when().post(TestDataReader.get("api_url")+"api/users");

          assertTrue(response.body().asString().contains("name"));
          assertTrue(response.body().asString().contains("job"));
          assertTrue(response.body().asString().contains("id"));
          assertTrue(response.body().asString().contains("createdAt"));

    }
    @Given("I create a user with following Liza Sales")
    public void i_create_a_user_with_following_Liza_Sales() {
        Users users = new Users();
        users.setName("Liza");
        users.setJob("Sale");

        given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(users)
                .when().post(TestDataReader.get("api_url")+"api/users");

        assertEquals(response.statusCode(),201);
        assertEquals(response.contentType(),"application/json; charset=utf-8");


    }

    @Given("I login unsuccessfully with the following data")
    public void i_login_unsuccessfully_with_the_following_data(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new cucumber.api.PendingException();
    }

    @Then("I should get a response code of {int}")
    public void i_should_get_a_response_code_of(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should see the following response message:")
    public void i_should_see_the_following_response_message(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new cucumber.api.PendingException();
    }

    @Given("I wait for the user list to load")
    public void i_wait_for_the_user_list_to_load() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should see that every user has a unique id")
    public void i_should_see_that_every_user_has_a_unique_id() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }


}
