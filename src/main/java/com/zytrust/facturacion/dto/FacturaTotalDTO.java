package com.zytrust.facturacion.dto;
/*
 * @(#)FacturaTotalDTO.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta interfaz representa a un FacturaTotalDTO y debe ser usada para
 * almacenar datos e intercambiarlos con otros objetos.
 *
 * @author Sergio Alva
 * @version 1.00, 14/02/2022
 */

import java.math.BigDecimal;
import java.time.LocalDate;

public interface FacturaTotalDTO {

    String getId();

    String getClienteNombre();

    BigDecimal getTotal();

    LocalDate getFechaEmision();
}
