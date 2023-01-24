package com.exito.certification.interactions;

import com.choucair.moviles.app.interactions.choucair.builders.EsperaExplicita;
import com.choucair.moviles.app.interactions.choucair.builders.Tap;
import com.exito.certification.exceptions.CerrarNotificacionException;
import com.exito.certification.exceptions.NavegarException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class CerrarPermisosDeNotificacion implements Interaction {


    public static CerrarPermisosDeNotificacion asCerrar() {
        return Tasks.instrumented(CerrarPermisosDeNotificacion.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    EsperaExplicita.empleada(5000),
                    Tap.on(591, 882),
                    EsperaExplicita.empleada(5000),
                    Tap.on(591, 882),
                    EsperaExplicita.empleada(5000),
                    Tap.on(397, 1300),
                    EsperaExplicita.empleada(5000),
                    Tap.on(666, 1451)
            );
        }catch (RuntimeException ex){
            throw new CerrarNotificacionException(CerrarNotificacionException.Error(), ex);
        }
    }
}
