package com.exito.certification.interactions;

import com.choucair.moviles.app.interactions.choucair.TakeScreenshot;
import com.choucair.moviles.app.interactions.choucair.builders.EsperaExplicita;
import com.exito.certification.exceptions.NavegarException;
import com.exito.certification.models.MenuModel;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.exito.certification.ui.UiMenu.*;

public class Navegar implements Interaction {

    private MenuModel menuModel;
    public Navegar(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(BTN_MENU, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(BTN_MENU),
                    TakeScreenshot.asEvidence(),
                    WaitUntil.the(ITEM_CATEGORIA_Y_SUBCATEGORIA(menuModel.getCategoria()), WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                    Click.on(ITEM_CATEGORIA_Y_SUBCATEGORIA(menuModel.getCategoria())),
                    TakeScreenshot.asEvidence(),
                    WaitUntil.the(ITEM_CATEGORIA_Y_SUBCATEGORIA(menuModel.getSubCategoria()), WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                    Click.on(ITEM_CATEGORIA_Y_SUBCATEGORIA(menuModel.getSubCategoria())),
                    TakeScreenshot.asEvidence(),
                    WaitUntil.the(ITEM_SEGMENTO(menuModel.getSegmento()), WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                    Click.on(ITEM_SEGMENTO(menuModel.getSegmento())),
                    EsperaExplicita.empleada(15000),
                    TakeScreenshot.asEvidence()
            );
        } catch (RuntimeException ex) {
            throw new NavegarException(NavegarException.Error(), ex);
        }
    }

    public static Navegar asMenu(MenuModel menuModel) {
        return Instrumented.instanceOf(Navegar.class).withProperties(menuModel);
    }
}
