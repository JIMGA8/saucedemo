package proyecto.Steps;

import org.junit.Assert;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class LoginApiSteps {

    private ValidatableResponse json;

    @Then("^verifico que en la respuesta llegue el token y un codigo (.+)$")
    public void validateLogin(int statusCodeEsperado) {
        Response response = Hooks.response;
        json = response.then().statusCode(statusCodeEsperado);
        String responseBody = response.getBody().asString();
        Assert.assertTrue("no se envio el token en la respuesta", responseBody.contains("Auth_token"));
    }

}
