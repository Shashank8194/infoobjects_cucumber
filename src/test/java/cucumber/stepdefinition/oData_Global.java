package cucumber.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.dataProvider.ConfigFileReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class oData_Global {

    Response response;
    RequestSpecification request = given();
    ConfigFileReader configFileReader=new ConfigFileReader();

    @Given("^User hit the global URI$")
    public void user_hit_the_global_uri() throws Throwable {
        RestAssured.baseURI="https://87gh1tsvui.execute-api.us-east-1.amazonaws.com";
    }

    @When("^User login with valid username and password$")
    public void user_login_with_valid_username_and_password()   {
        response=given().
                header("username",configFileReader.username()).
                header("password",configFileReader.password())
                .get(configFileReader.oData_global_endpoint());

    }

    @Then("^Status code should be 200 for global API$")
    public void status_code_should_be_200_for_global_api() throws Throwable {
        System.out.println("as");

    }

    @And("^Response should have all the related information$")
    public void response_should_have_all_the_related_information() throws Throwable {
        System.out.println("as");
    }
}
