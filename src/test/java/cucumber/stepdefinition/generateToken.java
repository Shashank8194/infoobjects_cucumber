package cucumber.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.dataProvider.ConfigFileReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.given;


public class generateToken {
   Response response;
    RequestSpecification request = RestAssured.given();
    ConfigFileReader configFileReader=new ConfigFileReader();

    @Given("^User hit the given URI$")
    public void user_hit_the_given_uri() throws Throwable {

      RestAssured.baseURI="https://87gh1tsvui.execute-api.us-east-1.amazonaws.com";

    }

    @When("^user login with (.+) and (.+)$")
    public void user_login_with_and(String username, String password) throws Throwable  {



        response=given().header("username",username).
                header("password",password)
                .when().get(configFileReader.authorization_endpoint());
                //.get("/token/generate");
    }

    @Then("^Status code should be 200$")
    public void status_code_should_be_200() throws Throwable {
       int statuscode= response.getStatusCode();

       if(statuscode==200)
       {
           System.out.println("Status code is " + statuscode);
       }
       else
       {
           System.out.println("Status code is " + statuscode);
       }
    }

    @And("^Authorization token should be generated$")
    public void authorization_token_should_be_generated() throws Throwable {
        System.out.println(response.asString());
    }

}
