package com.exito.certification.ui;

import io.appium.java_client.MobileBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UiMenu {


    public static final Target BTN_MENU =
            Target.the("")
                    .located(By.xpath("(//button[//child::div[@id=\"category-menu\"]])[1]"));

    public static final Target ITEM_CATEGORIA_Y_SUBCATEGORIA (String item){
        return  Target.the("")
                .located(By.xpath("//div[@class='exito-category-menu-3-x-contentCategory']//child::p[text()='"+item+"']"));
    }

    public static final Target ITEM_SEGMENTO (String item){
        return Target.the("")
                .located(By.xpath("//a[text()='"+item+"']//parent::li[@class=\"exito-category-menu-3-x-lastItem\"]"));
    }

    private UiMenu(){
        throw new IllegalStateException("Error en UiMenu");
    }
}
