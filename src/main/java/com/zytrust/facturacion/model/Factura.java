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
    private Cliente Cliente;    // Identificador del cliente

    @Column(name = "FACT_ESTADO")
    private String estado;  // Estado de la factura

    @Column(name = "FACT_FECHA_EMISION")
    private LocalDate fechaEmision;  // Fecha de emision de la factura

    @Column(name = "FACT_FECHA_VENCIMIENTO")
    private LocalDate fechaVencimiento;  // Fecha de vencimiento de la factura

    @Column(name = "FACT_FECHA_PAGO")
    private LocalDate fechaPago;  // Fecha de pago de la factura

    @Column(name = "FACT_TIPO_PAGO")
    private String tipoPago;  // Tipo de pago de la factura

    @Column(name = "FACT_SUBTOTAL", precision = 7,scale = 2,nullable = false)
    private BigDecimal subtotal;  // Subtotal de la factura

    @Column(name = "FACT_IMPUESTO", precision = 7,scale = 2,nullable = false)
    private BigDecimal impuesto;  // Impuesto de la factura

    @Column(name = "FACT_TOTAL", precision = 7,scale = 2,nullable = false)
    private BigDecimal total;  // Total de la factura

}
