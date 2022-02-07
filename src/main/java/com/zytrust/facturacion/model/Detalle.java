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
    private Factura factura;  // Identificador de la factura

    @ManyToOne
    @JoinColumn(name="PROD_ID")
    private Producto producto;  // Identificador del producto

    @Column(name = "DET_CANTIDAD")
    private Integer cantidad;  // Cantidad del producto

}
