package com.exito.certification.interactions;

import com.choucair.moviles.app.interactions.choucair.TakeScreenshot;
import com.choucair.moviles.app.interactions.choucair.builders.EsperaExplicita;
import com.exito.certification.exceptions.NavegarException;
import com.exito.certification.exceptions.SeleccionarProductoException;
import com.exito.certification.utils.EliminarTextoString;
import com.exito.certification.utils.GenerarNumero;
import com.exito.certification.utils.ArrayProductos;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import net.serenitybdd.screenplay.targets.Target;
import static com.exito.certification.ui.UiProductos.*;
import static com.exito.certification.ui.UiSeleccionarProductos.*;

public class SeleccionarProducto implements Interaction {
    Target selector;

    public SeleccionarProducto(Target selector) {
        this.selector = selector;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            for (int i = 0; i < 5; i++) {
                WebElement elemento = selector.resolveFor(actor);
                List<WebElement> productElements = elemento.findElements(By.xpath(LBL_TITULOX()));
                int producto = GenerarNumero.getRandomNumber(productElements.size());
                int numero = GenerarNumero.cantidadProductos();
                WebElement randomProduct = productElements.get(producto);
                actor.attemptsTo(
                        ScrollElement.to(LBL_NOMBRE_PRODUCTO(randomProduct.getText())),
                        WaitUntil.the(BTN_AGREGAR_AL_CARRITO(randomProduct.getText()), WebElementStateMatchers.isClickable()).forNoMoreThan(10).seconds(),
                        Click.on(BTN_AGREGAR_AL_CARRITO(randomProduct.getText())),
                        EsperaExplicita.empleada(10000)
                );


                ArrayProductos.setArrayProductos(randomProduct.getText(), String.valueOf(numero), EliminarTextoString.eliminarPesos(actor, randomProduct.getText()));
                actor.attemptsTo(
                        AgregarCantidad.as(numero, randomProduct.getText())
                );
            }
            actor.attemptsTo(
                    TakeScreenshot.asEvidence(),
                    WaitUntil.the(BTN_CARD, WebElementStateMatchers.isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(BTN_CARD),
                    EsperaExplicita.empleada(20000),
                    TakeScreenshot.asEvidence()
            );
        }catch (RuntimeException ex){
            throw new SeleccionarProductoException(SeleccionarProductoException.Error(), ex);
        }
    }

    public static SeleccionarProducto asSeleccionar(Target selector){
        return Instrumented.instanceOf(SeleccionarProducto.class).withProperties(selector);
    }
}
