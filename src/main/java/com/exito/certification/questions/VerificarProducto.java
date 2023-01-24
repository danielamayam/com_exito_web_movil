package com.exito.certification.questions;

import com.choucair.moviles.app.interactions.choucair.builders.EsperaExplicita;
import com.exito.certification.interactions.ScrollElement;
import com.exito.certification.utils.ArrayProductos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import java.util.logging.Logger;

import static com.exito.certification.ui.UiProductos.*;

public class VerificarProducto implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
         boolean response = false;

        for (int i = 0; i < 5; i++) {
            actor.attemptsTo(
                    EsperaExplicita.empleada(10000),
                    ScrollElement.to(LBL_NOMBRE(ArrayProductos.getArrayProductos().get(i).getNombre())),
                    EsperaExplicita.empleada(5000),
                    WaitUntil.the(LBL_NOMBRE(ArrayProductos.getArrayProductos().get(i).getNombre()), WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds()
            );
            response = ArrayProductos.getArrayProductos().get(i).getNombre().equals(Text.of(LBL_NOMBRE(ArrayProductos.getArrayProductos().get(i).getNombre())).viewedBy(actor).asString());
            if (response == false){
                Logger.getAnonymousLogger().info("El nombre no es igual al producto real");
                break;
            }
        }
        Logger.getAnonymousLogger().info("Verificación de productos existentes");
        return response;
    }

    public static VerificarProducto enElCarrito() {
        return new VerificarProducto();
    }
}
