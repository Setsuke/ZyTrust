package com.zytrust.facturacion.model;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table (name = "FAC_Facturas")
public class Factura {

    @Id
    @Column(name = "FACT_ID")
    private String id;

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

    //cliente id
    //relacion con detalles y clientes


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
