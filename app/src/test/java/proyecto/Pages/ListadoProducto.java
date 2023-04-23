package proyecto.Pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import proyecto.Steps.Hooks;
import proyecto.helpers.Helpers;

public class ListadoProducto extends BasePage {

    private String cantidadItemCarrito = "//span[@class='shopping_cart_badge']";

    Hooks hooks = new Hooks();
    Helpers helpers = new Helpers();

    public ListadoProducto() {
        super(driver);
    }

    public boolean AgregarProductosAlCarrito(List<String> productos) {
        int cantItem = 0;
        int tamañoListaProductos = productos.size();
        Hooks.tamañoLista = tamañoListaProductos;
        Hooks.listaProductos = productos;
        for (String producto : productos) {
            String btnAgregarCarrito = "//button[contains(@data-test, 'add-to-cart-"
                    + producto.toLowerCase().replace(" ", "-") + "')]";
            WebElement btnAgregar = find(btnAgregarCarrito);
            btnAgregar.click();
            cantItem += 1;
        }
        return cantItem == tamañoListaProductos;
    }

    public int getCantidaddeitemCarrito() {
        String cantidadItemCarritoStr = textFromElement(cantidadItemCarrito);
        int cantidadItemCarritoInt = Integer.parseInt(cantidadItemCarritoStr);
        return cantidadItemCarritoInt;
    }

    public double precioProductosAgregadosAlCarrito() {
        double precioProductos = 0;
        List<String> productos = Hooks.listaProductos;
        for (String producto : productos) {
            String precioProductoConDolar = textFromElement("//button[@id='remove-"
                    + producto.toLowerCase().replace(" ", "-")
                    + "']/preceding-sibling::div[@class='inventory_item_price']");
            double precioProductoDouble = helpers.eliminarCaracteresDeUnMonto(precioProductoConDolar);
            precioProductos += precioProductoDouble;
        }
        Hooks.precioProductos = precioProductos;
        return precioProductos;
    }

}
