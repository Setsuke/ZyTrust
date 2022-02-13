package com.zytrust.facturacion.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FacturaReq {

    private String facturaId;
    private String clienteId;
    private LocalDate fechaVencimiento;
    private LocalDate fechaPago;
    private String tipoPago;
}
