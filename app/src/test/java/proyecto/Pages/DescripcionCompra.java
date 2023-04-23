package proyecto.Pages;

import proyecto.Steps.Hooks;
import proyecto.helpers.Helpers;

import java.util.List;

public class DescripcionCompra extends BasePage {

    private String nombresClasseProductos = "inventory_item_name";
    private String montoSubtotal = "//div[@class='summary_subtotal_label']";
    private String btnFinish = "//button[@id='finish']";

    Helpers helpers = new Helpers();

    public DescripcionCompra() {
        super(driver);
    }

    public boolean validoProductoDescripcionCompra() {
        List<String> productosCarrito = getAllList(nombresClasseProductos);
        List<String> productosAgregados = Hooks.listaProductos;
        System.out.println(productosAgregados);
        return productosCarrito.equals(productosAgregados);
    }

    public double getSubTotal() {
        String subtotalString = textFromElement(montoSubtotal);
        return helpers.eliminarCaracteresDeUnMonto(subtotalString);
    }

    public void clickFinish() {
        clickElement(btnFinish);
    }

}
