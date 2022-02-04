package com.zytrust.facturacion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "FAC Productos")
public class Producto {

    @Id
    @Column(name = "PROD_ID")
    private String id;

    @Column(name = "PROD_NOMBRE")
    private String nombre;
    @Column(name = "PROD_PRECIO")
    private BigDecimal precio;
    @Column(name = "PROD_STOCK")
    private Integer stock;

    //relacion detalle

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
