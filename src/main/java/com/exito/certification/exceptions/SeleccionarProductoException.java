package com.exito.certification.exceptions;

public class SeleccionarProductoException extends AssertionError {

    private static final String ERROR = "Error al tratar de seleccionar los produtos";

    public static final String PRODUCTOS_AGREGADOS = "Los productos no coinciden con los del carrito de compras";

    public static final String CANTIDAD_DE_PRODUCTOS = "La cantidad total de productos agregados no es la misma a los productos agregados";

    public static final String CANTIDAD_POR_PRODUCTO = "La cantidad por producto no es la correcta";


    public SeleccionarProductoException(String mensaje, Throwable motivo) {
        super(mensaje, motivo);
    }

    public static String Error() {
        return ERROR;
    }

}
