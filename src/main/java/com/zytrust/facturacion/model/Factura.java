package com.zytrust.facturacion.model;
/*
 * @(#)Factura.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta clase representa a una factura y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Sergio Alva
 * @version 1.00, 04/02/2022
 */


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table (name = "FAC_Facturas")
public class Factura {

    @Id
    @Column(name = "FACT_ID")
    private String id;  // Identificador de la factura

    @ManyToOne
    @JoinColumn(name="CLI_ID")
    private Cliente Cliente;

    @Column(name = "FACT_ESTADO")
    private String estado;

    @Column(name = "FACT_FECHA_EMISION")
    private LocalDate fechaEmision;

    @Column(name = "FACT_FECHA_VENCIMIENTO")
    private LocalDate fechaVencimiento;

    @Column(name = "FACT_FECHA_PAGO")
    private LocalDate fechaPago;

    @Column(name = "FACT_TIPO_PAGO")
    private String tipoPago;

    @Column(name = "FACT_SUBTOTAL", precision = 7,scale = 2,nullable = false)
    private BigDecimal subtotal;

    @Column(name = "FACT_IMPUESTO", precision = 7,scale = 2,nullable = false)
    private BigDecimal impuesto;

    @Column(name = "FACT_TOTAL", precision = 7,scale = 2,nullable = false)
    private BigDecimal total;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(BigDecimal impuesto) {
        this.impuesto = impuesto;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
