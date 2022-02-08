package com.zytrust.facturacion.model;
/*
 * @(#)Producto.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta clase representa a un producto y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Sergio Alva
 * @version 1.00, 04/02/2022
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.math.BigDecimal;
import lombok.Data;

@Data
@Entity
@Table(name = "FAC_Productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROD_ID")
    /**Identificador del producto*/
    private String id;

    @Column(name = "PROD_NOMBRE")
    /**Nombre del producto*/
    private String nombre;

    @Column(name = "PROD_PRECIO")
    /**Precio del producto*/
    private BigDecimal precio;

    @Column(name = "PROD_STOCK")
    /**Cantidad de productos en stock*/
    private Integer stock;

}
