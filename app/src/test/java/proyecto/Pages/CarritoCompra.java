package proyecto.Pages;

import java.util.ArrayList;
import java.util.List;

import proyecto.Steps.Hooks;
import proyecto.helpers.Helpers;

public class CarritoCompra extends BasePage {

    private String btnCarritoCompra = "//div[@id='shopping_cart_container']";
    private String nombreClasseProductos = "inventory_item_name";
    private String nombreClassePrecios = "inventory_item_price";
    private String btnCheckout = "//button[@id='checkout']";

    Helpers helpers = new Helpers();

    public CarritoCompra() {
        super(driver);
    }

    public boolean validosProductoCarritoCompras() {
        clickElement(btnCarritoCompra);
        List<String> productosCarrito = getAllList(nombreClasseProductos);
        List<String> productosAgregados = Hooks.listaProductos;
        return productosCarrito.equals(productosAgregados);
    }

    public void clickCheckout() {
        clickElement(btnCheckout);
    }

    public double obtenerPrecioProductosEnCarrito() {
        List<String> montosProductos = getAllList(nombreClassePrecios);
        List<Double> listaMontosDouble = new ArrayList<>();
        for (String e : montosProductos) {
            listaMontosDouble.add(helpers.eliminarCaracteresDeUnMonto(e));
        }
        double total = 0.0;
        for (double monto : listaMontosDouble) {
            total += monto;
        }
        return total;
    }

}
