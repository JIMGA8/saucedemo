package proyecto.Pages;

public class CompraFinalizada extends BasePage {

    private String txtGraciasPorSuCompra = "//h2[contains(text(),'Thank you for your order!')]";

    public CompraFinalizada() {
        super(driver);
    }

    public String mensajeDeCompra() {
        return textFromElement(txtGraciasPorSuCompra);
    }

}
