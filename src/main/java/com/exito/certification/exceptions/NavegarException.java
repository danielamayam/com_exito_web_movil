package com.exito.certification.exceptions;

public class NavegarException extends AssertionError {

    private static final String ERROR = "Error al navegar";

    public NavegarException(String mensaje, Throwable motivo) {
        super(mensaje, motivo);
    }

    public static String Error() {
        return ERROR;
    }

}
