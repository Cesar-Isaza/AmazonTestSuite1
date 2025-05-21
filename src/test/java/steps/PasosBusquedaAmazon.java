package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BusquedaAmazon;

public class PasosBusquedaAmazon {

    private BusquedaAmazon paginaAmazon = new BusquedaAmazon();

    @Given("el usuario accede al sitio de Amazon")
    public void abrirAmazon(){
        paginaAmazon.abrirAmazon();
        paginaAmazon.pausaParaCaptcha();
    }

    @And("^realiza la búsqueda del producto (.*)$")
    public void ingresarBusqueda(String producto){
        paginaAmazon.buscarProducto(producto);
    }

    @And("^accede a la segunda página de resultados$")
    public void irSegundaPagina(){
        paginaAmazon.irASegundaPagina();
    }

    @And("^elige el tercer artículo listado$")
    public void seleccionarTercerArticulo(){
        paginaAmazon.seleccionarTercerArticulo();
    }

    @Then("^el usuario puede añadir el artículo al carrito$")
    public void anadirAlCarrito(){
        paginaAmazon.agregarProductoAlCarrito();
        paginaAmazon.validarConfirmacionDeCompra();
    }
}