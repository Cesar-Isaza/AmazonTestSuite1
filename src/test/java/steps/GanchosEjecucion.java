package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.*;
import pages.PaginaBase;

public class GanchosEjecucion extends PaginaBase {
    
    public GanchosEjecucion(){
        super(navegador);
    }

    @After
    public void finalizarEscenario(Scenario escenario){
        if (escenario.isFailed()){
            escenario.log("Escenario fallido. Se adjunta evidencia en imagen.");
            final byte[] captura = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.BYTES);
            escenario.attach(captura, "image/png", "EvidenciaError");
        }
    }

    @AfterStep
    public void capturarPaso(Scenario escenario) {
        final byte[] capturaPaso = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.BYTES);
        escenario.attach(capturaPaso, "image/png", "EvidenciaPaso");
    }
}