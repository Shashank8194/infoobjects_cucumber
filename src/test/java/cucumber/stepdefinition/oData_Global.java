package cucumber.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import main.utilities.Commons.Commons;
import main.utilities.dataProvider.ConfigFileReader;


import static io.restassured.RestAssured.given;

public class oData_Global {

   public Response response;
    RequestSpecification request = given();
    Commons commons=new Commons();
    ConfigFileReader configFileReader=new ConfigFileReader();

    @Given("^User hit the global URI$")
    public void user_hit_the_global_uri() throws Throwable {
        //RestAssured.baseURI="https://87gh1tsvui.execute-api.us-east-1.amazonaws.com";
        RestAssured.baseURI=commons.generate_request_url();


    }

    @When("^User login with valid username and password$")
    public void user_login_with_valid_username_and_password()   {
        response=given().
                header("username",configFileReader.username()).
                header("password",configFileReader.password())
                .get(commons.getEnd_Point() +"/global");

    }

    @Then("^Status code should be 200 for global API$")
    public void status_code_should_be_200_for_global_api()  {
  commons.Status_code(response);
    }

    @And("^Response should have all the related information$")
    public void response_should_have_all_the_related_information() {
        commons.print_response(response);
       // System.out.println("as");
    }
}
