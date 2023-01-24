package com.exito.certification.ui;

import net.serenitybdd.screenplay.targets.Target;

public class UiProductos {

    public static final Target BTN_AGREGAR_AL_CARRITO (String nombre) {
        return Target.the("Boton para agregar al carrito")
                .locatedBy("//h3[span[contains(text(),'"+nombre+"')]]//ancestor::div[@class=\"vtex-flex-layout-0-x-flexCol vtex-flex-layout-0-x-flexCol--product-info  ml0 mr0 pl0 pr0      flex flex-column h-100 w-100\"]//child::div[@class=\"vtex-flex-layout-0-x-flexColChild vtex-flex-layout-0-x-flexColChild--product-info pb0\"]//child::button");

    }

    public static final Target BTN_MAS_CANTIDAD (String nombre) {
        return Target.the("Buton para agregar mas cantidad al producto")
                .locatedBy("//h3[span[contains(text(),'"+nombre+"')]]//ancestor::div[@class=\"vtex-flex-layout-0-x-flexCol vtex-flex-layout-0-x-flexCol--product-info  ml0 mr0 pl0 pr0      flex flex-column h-100 w-100\"]//child::div[@class=\"vtex-flex-layout-0-x-flexColChild vtex-flex-layout-0-x-flexColChild--product-info pb0\"]//child::button[@class=\"exito-vtex-components-4-x-buttonActions exito-vtex-components-4-x-productSummaryAddToCar  product-summary-add-to-car-plus\"]");

    }

    public static final Target LBL_PRECIO (String nombre) {
        return Target.the("Label del precio")
                .locatedBy("//h3[span[contains(text(),'"+nombre+"')]]//ancestor::div[@class=\"vtex-flex-layout-0-x-flexCol vtex-flex-layout-0-x-flexCol--product-info  ml0 mr0 pl0 pr0      flex flex-column h-100 w-100\"]//child::div[@class=\"vtex-flex-layout-0-x-flexColChild vtex-flex-layout-0-x-flexColChild--product-info pb0\"]//child::div[@class=\"exito-vtex-components-4-x-PricePDP\"]//child::span[@class=\"exito-vtex-components-4-x-currencyContainer\"]");

    }



    public static final String BTN_COMPRAR(){
        return "//button//child::span[text()='Comprar ahora']";
    }

    public static final Target BTN_PRODUCTO_MAS(String nombre){
        return Target.the("Botton para visualizar el producto")
                .locatedBy("//a[contains(text(),'"+nombre+"')]//ancestor::tr//child::img//parent::a");
    }

    public static final String LBL_NOMBRE(String nombre){
        return "//a[contains(normalize-space(),'"+nombre+"')]";
    }

    public static final Target LBL_PRECIO_CARD_PRODUCTOS(String nombre){
     return Target.the("")
             .locatedBy("//a[contains(normalize-space(),'"+nombre+"')]//ancestor::tr[@class=\"product-item\"]//child::input");
    }

    public static final Target LBL_CANTIDAD_UNIDAD = Target.the("")
            .locatedBy("//div[@class=\"exito-vtex-components-4-x-stepperContainerQty\"]");

    private UiProductos(){
        throw new IllegalStateException("Error en UiProductos");
    }

}
