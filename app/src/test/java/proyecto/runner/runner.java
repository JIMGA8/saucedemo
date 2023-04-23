package proyecto.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import proyecto.Pages.BasePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "proyecto.Steps", monochrome = true, plugin = {
        "pretty", "html:target/cucumber-reports" }, tags = "@ComprarProducto")

public class runner {
    @AfterClass
    public static void cleanDriver() {
        BasePage.driverClose();
    }

}