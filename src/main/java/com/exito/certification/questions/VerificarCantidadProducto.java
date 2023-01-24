package com.exito.certification.questions;

import com.choucair.moviles.app.interactions.choucair.builders.EsperaExplicita;
import com.exito.certification.utils.ArrayProductos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.logging.Logger;

import static com.exito.certification.ui.UiProductos.LBL_PRECIO_CARD_PRODUCTOS;

public class VerificarCantidadProducto implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {
        Integer cantidad = ArrayProductos.getCantidad();
        Integer cantidadapp = 0;
        for (int i = 0; i < 5; i++) {
            actor.attemptsTo(EsperaExplicita.empleada(10000));
            if (Text.of(LBL_PRECIO_CARD_PRODUCTOS(ArrayProductos.getArrayProductos().get(i).getNombre())).viewedBy(actor).asString() != null) {
                cantidadapp++;
            }
        }
        Logger.getAnonymousLogger().info("Validación cantidad de productos en el carro");
        return cantidad.equals(cantidadapp);
    }


    public static VerificarCantidadProducto enElCarrito() {
        return new VerificarCantidadProducto();
    }
}
