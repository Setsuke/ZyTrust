package com.zytrust.facturacion.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "FAC_Detalles")
public class Detalle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DET_ID")
    private String numero;

    @Column(name = "DET_CANTIDAD")
    private Integer cantidad;

    //producto y factura
    //relacion producto y factura


    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
