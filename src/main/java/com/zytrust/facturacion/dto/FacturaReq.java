package com.zytrust.facturacion.dto;

/*
 * @(#)FacturaReq.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta interfaz representa a un FacturaReq y debe ser usada para
 * almacenar datos e intercambiarlos con otros objetos.
 *
 * @author Sergio Alva
 * @version 1.00, 14/02/2022
 */
import java.time.LocalDate;
import lombok.Data;

@Data
public class FacturaReq {

    /**Identificador de la factura*/
    private String facturaId;

    /**Identificador del cliente*/
    private String clienteId;

    /**Fecha de vencimiento de la factura*/
    private LocalDate fechaVencimiento;

    /**Fecha de pago de la factura*/
    private LocalDate fechaPago;

    /**Tipo de pago de la factura*/
    private String tipoPago;
}
