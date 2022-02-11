package com.zytrust.facturacion.dto;
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