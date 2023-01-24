package com.exito.certification.tasks;

import com.choucair.moviles.app.interactions.choucair.builders.EsperaExplicita;
import com.exito.certification.interactions.*;
import com.exito.certification.models.MenuModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Scroll;

import static com.exito.certification.ui.UiSeleccionarProductos.*;

public class SeleccionarProductos implements Task {

    private MenuModel menuModel;

    public SeleccionarProductos(MenuModel menuModel){
        this.menuModel = menuModel;
    }

    public static SeleccionarProductos asSeleccionar(MenuModel menuModel){
        return Tasks.instrumented(SeleccionarProductos.class, menuModel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CerrarPermisosDeNotificacion.asCerrar(),
                Navegar.asMenu(menuModel),
                EsperaExplicita.empleada(10000),
                ScrollElement.to(LBL_INICIO()),
                EsperaExplicita.empleada(10000),
                SeleccionarProducto.asSeleccionar(BTN_ELEMENTOS)

        );
    }
}
