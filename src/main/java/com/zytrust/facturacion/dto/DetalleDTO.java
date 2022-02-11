package com.zytrust.facturacion.dto;

import java.math.BigDecimal;

public interface DetalleDTO {

    String getNumero();

    String getFacturaId();

    String getProductoId();

    BigDecimal getCantidad();
}
