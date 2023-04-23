package proyecto.Pages;

public class FormularioCompra extends BasePage {

    private String campoFirstName = "//input[@id='first-name']";
    private String campoLastname = "//input[@id='last-name']";
    private String campoCodigoPostal = "//input[@id='postal-code']";
    private String btnContinue = "//input[@id='continue']";

    public FormularioCompra() {
        super(driver);
    }

    public void completarFormularioComprar(String nombre, String apellido, String codidoPostal) {
        write(campoFirstName, nombre);
        write(campoLastname, apellido);
        write(campoCodigoPostal, codidoPostal);
    }

    public void clickContinue() {
        clickElement(btnContinue);
    }

}