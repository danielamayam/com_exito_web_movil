package com.exito.certification.tasks;

import com.choucair.moviles.app.interactions.choucair.TakeScreenshot;
import com.exito.certification.utils.GetDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import java.util.logging.Logger;

public class AbrirElNavegador implements Task {

    public static AbrirElNavegador enLikeMe() {
        return Tasks.instrumented(AbrirElNavegador.class);
    }

    @Override
    @Step("Se ingresa a la pagina Web")
    public <T extends Actor> void performAs(T actor) {
        GetDriver.as(actor).webDriver().get("https://www.exito.com/");
        Logger.getAnonymousLogger().info("Se ingresa a la web");
        TakeScreenshot.asEvidence();
    }
}
