package com.exito.certification.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;

import static com.exito.certification.ui.UiProductos.*;

public class EliminarTextoString {



    public static String eliminarPesos(Actor actor, String nombre){
        String charsToRemove = "$ ";
        String cantidad;
        cantidad = Text.of(LBL_PRECIO(nombre)).viewedBy(actor).asString();
        for (char c : charsToRemove.toCharArray()) {
            cantidad = cantidad.replace(String.valueOf(c), "");
        }
        return cantidad;
    }

    public static String eliminarTextoUnidades(Actor actor){
        String charsToRemove = ".00  un";
        String cantidad;
        cantidad = Text.of(LBL_CANTIDAD_UNIDAD).viewedBy(actor).asString();
        for (char c : charsToRemove.toCharArray()) {
            cantidad = cantidad.replace(String.valueOf(c), "");
        }
        return cantidad;
    }

}
