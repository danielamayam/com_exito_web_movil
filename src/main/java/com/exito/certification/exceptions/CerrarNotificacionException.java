package com.exito.certification.exceptions;

public class CerrarNotificacionException extends AssertionError {

    private static final String ERROR = "Error al gestionar la notificacion";

    public CerrarNotificacionException(String mensaje, Throwable motivo) {
        super(mensaje, motivo);
    }

    public static String Error() {
        return ERROR;
    }

}
