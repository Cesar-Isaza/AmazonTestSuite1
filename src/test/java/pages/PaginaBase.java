package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaBase {

    protected static WebDriver navegador;
    protected WebDriverWait espera;

    // Bloque estático para inicializar el driver Chrome y configurar la ventana
    static {
        ChromeOptions opciones = new ChromeOptions();
        navegador = new ChromeDriver(opciones);
        navegador.manage().window().maximize();
    }

    // Constructor que recibe el WebDriver y configura el WebDriverWait
    public PaginaBase(WebDriver navegador) {
        PaginaBase.navegador = navegador;
        espera = new WebDriverWait(navegador, Duration.ofSeconds(10));
    }

    // Abre una URL en el navegador
    public void abrirUrl(String url) {
        navegador.get(url);
    }

    // Cierra la sesión del navegador
    public static void cerrarNavegador() {
        navegador.close();
    }

    // Métodos privados para localizar elementos por distintos selectores
    private WebElement buscarPorXpath(String xpath) {
        return espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    private WebElement buscarPorNombre(String nombre) {
        return espera.until(ExpectedConditions.presenceOfElementLocated(By.name(nombre)));
    }

    private WebElement buscarPorCss(String selector) {
        return espera.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
    }

    private WebElement buscarPorId(String id) {
        return espera.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    // Métodos públicos para interacción con elementos

    // Clic en elemento localizado por ID
    public void hacerClickPorId(String id) {
        buscarPorId(id).click();
    }

    // Clic en elemento localizado por XPath
    public void hacerClickPorXpath(String xpath) {
        buscarPorXpath(xpath).click();
    }

    // Escribe texto en campo localizado por Name
    public void escribirTexto(String nombreCampo, String texto) {
        WebElement campo = buscarPorNombre(nombreCampo);
        campo.clear();
        campo.sendKeys(texto);
    }

    // Clic en paginación mediante XPath
    public void clickEnPagina(String xpath) {
        buscarPorXpath(xpath).click();
    }

    // Selecciona un elemento de una lista desplegable y confirma selección con botón
    public void seleccionarDeLista(String selectorLista, String xpathOpcion, String xpathBotonAgregar, int indice) {
        WebElement lista = buscarPorCss(selectorLista);
        Select desplegable = new Select(lista);

        desplegable.selectByIndex(indice);
        hacerClickPorXpath(xpathOpcion);

        WebElement botonAgregar = espera.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathBotonAgregar)));
        botonAgregar.click();
    }

    // Valida que el texto esperado aparezca en un elemento localizado por XPath
    public void validarTextoEnElemento(String xpath) {
        String textoEsperado = "Agregado al carrito";
        String textoReal = buscarPorXpath(xpath).getText();

        Assert.assertEquals(textoEsperado, textoReal);
        System.out.println("Texto validado: " + textoReal);
    }
}
