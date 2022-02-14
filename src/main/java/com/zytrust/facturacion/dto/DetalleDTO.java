package com.zytrust.facturacion.dto;
/*
 * @(#)DetalleDTO.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta interfaz representa a un DetalleDTO y debe ser usada para
 * almacenar datos e intercambiarlos con otros objetos.
 *
 * @author Sergio Alva
 * @version 1.00, 14/02/2022
 */

import java.math.BigDecimal;

public interface DetalleDTO {

    String getNumero();

    String getFacturaId();

    String getProductoId();

    BigDecimal getCantidad();
}
