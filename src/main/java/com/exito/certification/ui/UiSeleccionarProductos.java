package com.exito.certification.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UiSeleccionarProductos {


    public static final Target BTN_CARD =
            Target.the("")
                    .locatedBy("//a[@href=\"/checkout/#/cart\"]");

    public static final Target BTN_CERRAR =
            Target.the("")
                    .located(By.xpath("//div[@class='vtex-alert__close-icon pointer flex items-center pa3 white nr3 nv3']"));

    public static final String LBL_INICIO () {
        return "//span[@class='vtex-search-result-3-x-totalProductsMessage c-muted-2']";
    }


    public static final String LBL_VENDIDO (){
        return "//p[text()='Costo de envío:']";
    }

    public static final Target BTN_ELEMENTOS = Target.the("butones")
            .locatedBy("//div[@class='vtex-search-result-3-x-galleryItem vtex-search-result-3-x-galleryItem--normal vtex-search-result-3-x-galleryItem--default pa4']");


    public static final String LBL_TITULOX () {
        return "//h3[@class=\"vtex-store-components-3-x-productNameContainer mv0 t-heading-4\"]//span[@class='vtex-store-components-3-x-productBrand ']";
    }

    public static final String LBL_NOMBRE_PRODUCTO(String text){
        return "//h3[span[contains(text(),'"+text+"')]]";

    }

    private UiSeleccionarProductos(){
        throw new IllegalStateException("Error en UiSeleccionarProductos");
    }

}
