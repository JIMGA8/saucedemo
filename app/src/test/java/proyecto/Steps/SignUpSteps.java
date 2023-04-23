package proyecto.Steps;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import proyecto.helpers.UsuarioAleatorio;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Assert;

public class SignUpSteps {

    private static RequestSpecification request;
    private Response response;
    private ValidatableResponse json;

    @Given("^envio una solicitud post a la (.+) URI$")
    public void sendGETRequest(String URI) {
        request = given()
                .baseUri(URI)
                .contentType(ContentType.JSON)
                .log().all();
    }

    @When("^ingreso los datos de (.+) en el endpoint (.+)$")
    public void envioUsuarioContrasena(String payloads, String endpoint) throws JSONException, FileNotFoundException {

        if (payloads.toLowerCase().equals("usuarionuevo")) {
            File requestBodyFile = new File("src/test/resources/Payloads/" + payloads + ".json");
            JSONObject requestBody = new JSONObject(new JSONTokener(new FileInputStream(requestBodyFile)));

            requestBody.put("username", UsuarioAleatorio.generarUsernameAleatorio());

            response = request.when().body(requestBody.toString()).post(endpoint).prettyPeek();
        } else {

            File requestBody = new File("src/test/resources/Payloads/" + payloads + ".json");

            response = request.when().body(requestBody).post(endpoint).prettyPeek();
            Hooks.response = response;
        }

    }

    @Then("^verifico que en la respuesta llegue un codigo (.+)$")
    public void validoRespuesta(int statusCodeEsperado) {
        json = response.then().statusCode(statusCodeEsperado);
        String responseBody = response.getBody().asString().trim();
        Assert.assertEquals("\"\"", responseBody);
    }

    @Then("^verifico que llegue el mensaje (.+) y el status code (.+)$")
    public void validoRespuestaUsuarioCreado(String mensaje, int statusCodeEsperado) {
        json = response.then().statusCode(statusCodeEsperado);
        String responseBody = response.jsonPath().getString("errorMessage");
        Assert.assertEquals(mensaje, responseBody);
    }

}
