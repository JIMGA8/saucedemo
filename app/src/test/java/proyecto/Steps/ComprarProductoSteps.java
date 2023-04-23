package proyecto.Steps;

import org.junit.Assert;

import io.cucumber.java.en.*;
import proyecto.Pages.CarritoCompra;
import proyecto.Pages.CompraFinalizada;
import proyecto.Pages.DescripcionCompra;
import proyecto.Pages.FormularioCompra;
import proyecto.Pages.ListadoProducto;
import proyecto.helpers.Helpers;

public class ComprarProductoSteps {

    ListadoProducto listadoProducto = new ListadoProducto();
    Helpers helpers = new Helpers();
    CarritoCompra carritoCompra = new CarritoCompra();
    FormularioCompra formularioCompra = new FormularioCompra();
    DescripcionCompra descripcionCompra = new DescripcionCompra();
    CompraFinalizada compraFinalizada = new CompraFinalizada();

    @When("^agrego los productos (.*) al carrito de compra$")
    public void agregarProductoAlCarrito(String productos) {
        Assert.assertTrue("no se agregaron todos los productos verifique " + productos,
                listadoProducto.AgregarProductosAlCarrito(helpers.convertirStringEnLista(productos)));
        int tamañoLista = Hooks.tamañoLista;
        Assert.assertEquals(tamañoLista, listadoProducto.getCantidaddeitemCarrito());
    }

    @Then("^ingreso al carro de compra y valido que se encuentran los productos agregados$")
    public void validosProductoCarritoCompras() {
        Assert.assertTrue("se agregaro otros productos al carrito de compra " + Hooks.listaProductos,
                carritoCompra.validosProductoCarritoCompras());
        Assert.assertEquals(listadoProducto.precioProductosAgregadosAlCarrito(),
                carritoCompra.obtenerPrecioProductosEnCarrito(), 2);
    }

    @And("^completo el formulario de compra con el nombre (.+), apellido (.+) y codipo postal (.+)$")
    public void completoFormularioCompra(String nombre, String apellido, String codigoPostal) {
        carritoCompra.clickCheckout();
        formularioCompra.completarFormularioComprar(nombre, apellido, codigoPostal);
        formularioCompra.clickContinue();
    }

    @Then("^verifico los productos a comprar y que el monto total corresponda con los productos agregados$")
    public void validoProductoyMonto() {
        Assert.assertTrue("no se agregaron todos los productos verifique",
                descripcionCompra.validoProductoDescripcionCompra());
        double precioProductos = Hooks.precioProductos;
        Assert.assertEquals(precioProductos, descripcionCompra.getSubTotal(), 2);
    }

    @Then("^finalizo la compra y valido el mensaje (.+)$")
    public void validoMensajeCompra(String mensajeGraciasPorSuCompra) {
        descripcionCompra.clickFinish();
        String mensajeDeCompra = mensajeGraciasPorSuCompra;
        Assert.assertEquals(mensajeDeCompra, compraFinalizada.mensajeDeCompra());
    }

}
