package com.zytrust.facturacion.exception;

public class ZyTrustException extends RuntimeException{

    private CodigoError codigoError;

    public ZyTrustException (CodigoError codigoError){
        this.codigoError=codigoError;
    }
}
