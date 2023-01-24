package com.exito.certification.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.lang.annotation.Target;

import static com.exito.certification.ui.UiProductos.BTN_MAS_CANTIDAD;
import static com.exito.certification.ui.UiSeleccionarProductos.BTN_CERRAR;

public class AgregarCantidad implements Interaction {

    private int numero;
    private String nombre;

    public AgregarCantidad(int numero, String nombre){
        this.numero = numero;
        this.nombre = nombre;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int j = 1; j < numero; j++) {
            actor.attemptsTo(
                    Check.whether(BTN_CERRAR.resolveFor(actor).isVisible())
                            .andIfSo(
                                    Click.on(BTN_CERRAR)
                            ),
                    WaitUntil.the(BTN_MAS_CANTIDAD(nombre), WebElementStateMatchers.isClickable()).forNoMoreThan(5).seconds(),
                    Click.on(BTN_MAS_CANTIDAD(nombre))
            );
        }
    }


    public static AgregarCantidad as(int numero, String nombre){
        return Instrumented.instanceOf(AgregarCantidad.class).withProperties(numero, nombre);
    }
}
