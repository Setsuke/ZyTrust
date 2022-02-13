package com.zytrust.facturacion.dto;
import java.time.LocalDate;
import lombok.Data;


@Data
public class FacturaReq {

    private String facturaId;
    private String clienteId;
    private LocalDate fechaVencimiento;
    private LocalDate fechaPago;
    private String tipoPago;
}
