package com.zytrust.facturacion.dto;

/*
 * @(#)FacturaDTO.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta interfaz representa a un FacturaDTO y debe ser usada para
 * almacenar datos e intercambiarlos con otros objetos.
 *
 * @author Sergio Alva
 * @version 1.00, 04/02/2022
 */
import java.math.BigDecimal;
import java.time.LocalDate;

public interface FacturaDTO {

    String getId();

    String getClienteId();

    String getEstado();

    LocalDate getFechaEmision();

    LocalDate getFechaVencimiento();

    LocalDate getFechaPago();

    String getTipoPago();

    BigDecimal getSubtotal();

    BigDecimal getImpuesto();

    BigDecimal getTotal();
}