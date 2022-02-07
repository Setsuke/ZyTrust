package com.zytrust.facturacion.model;
/*
 * @(#)Detalle.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta clase representa a un detalle y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Sergio Alva
 * @version 1.00, 04/02/2022
 */

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "FAC_Detalles")
public class Detalle {

    @Id
    @Column(name = "DET_ID")
    private String numero;  // Identificador del detalle

    @ManyToOne
    @JoinColumn(name="FACT_ID")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name="PROD_ID")
    private Producto producto;

    @Column(name = "DET_CANTIDAD")
    private Integer cantidad;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
