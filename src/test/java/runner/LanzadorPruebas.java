package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.PaginaBase;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources",
    glue = "steps",
    plugin = { "pretty", "html:target/informe-ejecucion" }
)
public class LanzadorPruebas {
    @AfterClass
    public static void cerrarDriver(){
        PaginaBase.cerrarNavegador();
    }
}