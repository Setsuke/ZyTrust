package com.zytrust.facturacion.exception;

/*
 * @(#)ZyTrustException.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta interfaz representa a un ZyTrustException y debe ser usada para
 * alertar los errores por medio del CodigoError
 *
 * @author Sergio Alva
 * @version 1.00, 14/02/2022
 */

public class ZyTrustException extends RuntimeException{

    private CodigoError codigoError;

    public ZyTrustException (CodigoError codigoError){
        this.codigoError=codigoError;
    }
}
