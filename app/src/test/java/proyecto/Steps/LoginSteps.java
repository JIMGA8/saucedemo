package proyecto.Steps;

import proyecto.Pages.Login;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginSteps {

    Login login = new Login();

    @Given("^navego a la pagina de saucedemo$")
    public void navigateToSaucedemo() {
        login.navigateToSaucedemo();
    }

    @When("^ingreso mi usuario (.+) y contrasena (.+)$")
    public void WriteUserAndPass(String usuario, String contrasena) {
        login.WriteUserAndPass(usuario, contrasena);
    }

    @When("^valido el inicio de seccion$")
    public void validateResultlogin() {
        Assert.assertTrue("No se realizo el login verifique sus credenciales", login.validateLogin());

    }

}
