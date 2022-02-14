package com.zytrust.facturacion.dto;

/*
 * @(#)DetalleReq.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta interfaz representa a un DetalleReq y debe ser usada para
 * almacenar datos e intercambiarlos con otros objetos.
 *
 * @author Sergio Alva
 * @version 1.00, 14/02/2022
 */
import java.math.BigDecimal;
import lombok.Data;

@Data
public class DetalleReq {

    /**Identificador del detalle*/
    private String numero;

    /**Identificador de la factura*/
    private String facturaId;

    /**Identificador del producto*/
    private String productoId;

    /**Cantidad del producto en el detalle*/
    private BigDecimal cantidad;
}
