package pages;

public class BusquedaAmazon extends PaginaBase {

    // Selectores para los elementos de la página de Amazon
    private final String selectorBarraBusqueda = "field-keywords"; // Selector por Name
    private final String botonBusqueda = "nav-search-submit-button"; // Selector por ID
    private final String botonPaginaDos = "//a[@aria-label='Ir a la página 2' and @href]"; // Selector XPath
    private final String tercerArticulo = "(//div[@data-cy='title-recipe']/a)[3]"; // XPath absoluto
    private final String selectorListaCantidad = "select[name='quantity']"; // Selector CSS
    private final String opcionCantidad = "//*[@id='quantity_1']"; // Selector XPath
    private final String botonAgregarCarrito = "//input[@title='Agregar al Carrito']"; // Selector XPath
    private final String mensajeConfirmacion = "//h1[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']"; // Selector XPath

    // Constructor que llama al constructor de la clase base
    public BusquedaAmazon() {
        super(navegador);
    }

    // Navega a la página principal de Amazon
    public void abrirAmazon() {
        abrirUrl("https://www.amazon.com");
    }

    // Pausa la ejecución para permitir resolver posibles captchas
    public void pausaParaCaptcha() {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Ingresa un término en la barra de búsqueda y ejecuta la búsqueda
    public void buscarProducto(String terminoBusqueda) {
        escribirTexto(selectorBarraBusqueda, terminoBusqueda);
        hacerClickPorId(botonBusqueda);
    }

    // Navega a la segunda página de resultados
    public void irASegundaPagina() {
        clickEnPagina(botonPaginaDos);
    }

    // Clic en el tercer artículo de la lista de resultados
    public void seleccionarTercerArticulo() {
        hacerClickPorXpath(tercerArticulo);
    }

    // Selecciona cantidad y agrega el producto al carrito
    public void agregarProductoAlCarrito() {
        seleccionarDeLista(selectorListaCantidad, opcionCantidad, botonAgregarCarrito, 1);
    }

    // Valida que el mensaje de confirmación se muestre correctamente
    public void validarConfirmacionDeCompra() {
        validarTextoEnElemento(mensajeConfirmacion);
    }
}
