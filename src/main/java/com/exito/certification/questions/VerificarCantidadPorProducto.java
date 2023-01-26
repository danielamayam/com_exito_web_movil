package com.exito.certification.questions;

import com.choucair.moviles.app.interactions.choucair.builders.EsperaExplicita;
import com.exito.certification.interactions.ScrollElement;
import com.exito.certification.utils.ArrayProductos;
import com.exito.certification.utils.EliminarTextoString;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import java.util.logging.Logger;
import static com.exito.certification.ui.UiProductos.*;

public class VerificarCantidadPorProducto implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean response = false;
        for (int A = 0; A < 1; A++) {
            actor.attemptsTo(
                    EsperaExplicita.empleada(10000),
                    ScrollElement.to(LBL_NOMBRE(ArrayProductos.getArrayProductos().get(A).getNombre())),
                    EsperaExplicita.empleada(10000),
                    Click.on(BTN_PRODUCTO_MAS(ArrayProductos.getArrayProductos().get(A).getNombre())),
                    EsperaExplicita.empleada(15000),
                    ScrollElement.to(BTN_COMPRAR()),
                    EsperaExplicita.empleada(15000)
            );
            String cantidad = EliminarTextoString.eliminarTextoUnidades(actor);
            response = cantidad.equals(ArrayProductos.getArrayProductos().get(A).getCantidad());
            BrowseTheWeb.as(actor).getDriver().navigate().back();
            actor.attemptsTo(EsperaExplicita.empleada(15000));

            if (response == false) {
                Logger.getAnonymousLogger().info("La cantidad en cada producto no es el que se escogió");
                break;
            }
        }
        Logger.getAnonymousLogger().info("Verificar la cantidad por producto exitoso");
        return response;
    }


    public static VerificarCantidadPorProducto enElCarrito() {
        return new VerificarCantidadPorProducto();
    }
}
