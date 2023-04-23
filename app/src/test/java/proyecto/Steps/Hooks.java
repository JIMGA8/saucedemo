package proyecto.Steps;

import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import proyecto.Pages.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import io.cucumber.java.Before;

public class Hooks extends BasePage {

    private static Scenario scenario;
    public static int tamanoLista;
    public static double precioProductos;
    public static List<String> listaProductos;
    public static Response response;

    public Hooks() {
        super(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("escenario Fallando referirse a la imagen adjunta");
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "escenario fallado");
        }
    }

    @Before
    public void before(Scenario scenario) {
        Hooks.scenario = scenario;
    }

    public static Scenario getScenario() {
        return Hooks.scenario;
    }

}
