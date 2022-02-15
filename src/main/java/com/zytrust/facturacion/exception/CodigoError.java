package com.zytrust.facturacion.exception;

/*
 * @(#)CodigoError.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta interfaz representa a un CodigoError y debe ser usada para
 * alertar errores utilizando un logger.
 *
 * @author Sergio Alva
 * @version 1.00, 14/02/2022
 */

public enum CodigoError {

    CLIENTE_NO_EXISTE("El cliente con el id indicado no existe"),
    FACTURA_NO_EXISTE("La factura con el id indicado no existe"),
    PRODUCTO_NO_EXISTE("El producto con el id indicado no existe"),
    CREACION_FACTURA_FALLO("No se pudo crear la factura con exito");

    private final String descripcion;

    CodigoError(String descripcion){
        this.descripcion=descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
