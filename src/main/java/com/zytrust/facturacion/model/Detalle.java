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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.math.BigDecimal;
import lombok.Data;

@Data
@Entity
@Table(name = "FAC_Detalles")
public class Detalle {

    @Id
    @Column(name = "DET_ID")
    /**Identificador del detalle*/
    private String numero;

    @ManyToOne
    @JoinColumn(name="FACT_ID")
    /**Identificador de la factura*/
    private Factura factura;

    @ManyToOne
    @JoinColumn(name="PROD_ID")
    /**Identificador del producto*/
    private Producto producto;

    @Column(name = "DET_CANTIDAD")
    /**Cantidad del producto*/
    private BigDecimal cantidad;

}
