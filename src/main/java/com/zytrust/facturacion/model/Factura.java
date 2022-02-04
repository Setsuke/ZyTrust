package com.zytrust.facturacion.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table (name = "FAC Facturas")
public class Factura {

    @Id
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
    @Column(name = "FACT_SUBTOTAL")
    private BigDecimal subtotal;
    @Column(name = "FACT_IMPUESTO")
    private BigDecimal impuesto;
    @Column(name = "FACT_TOTAL")
    private BigDecimal total;

    //cliente id
    //relacion con detalles y clientes

    public String getId() {
        return id;
    }

    public void setId(String id) {this.id = id;}

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
