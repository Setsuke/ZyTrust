package com.zytrust.facturacion.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface FacturaTotalDTO {

    String getId();

    String getClienteNombres();

    String getClienteApellidos();

    BigDecimal getTotal();
}
