package com.zytrust.facturacion.exception;

public enum CodigoError {

    CLIENTE_NO_EXISTE("El cliente con el id indicado no existe"),
    FACTURA_NO_EXISTE("La factura con el id indicado no existe"),
    PRODUCTO_NO_EXISTE("El producto con el id indicado no existe");

    private final String descripcion;

    CodigoError(String descripcion){
        this.descripcion=descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
