package com.zytrust.facturacion.dto;
import java.math.BigDecimal;
import lombok.Data;



@Data
public class DetalleReq {

    private String numero;
    private String facturaId;
    private String productoId;
    private BigDecimal cantidad;
}
