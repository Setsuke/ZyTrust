package com.zytrust.facturacion.model;
/*
 * @(#)Cliente.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta clase representa a un cliente y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Sergio Alva
 * @version 1.00, 04/02/2022
 */

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "FAC_Clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLI_ID")
    private String id;  // Identificador del cliente

    @Column(name = "CLI_NOMBRES")
    private String nombres;  // Nombres del cliente

    @Column(name = "CLI_APELLIDOS")
    private String apellidos;  // Apellidos del cliente

    @Column(name = "CLI_DNI")
    private String dni;  // DNI del cliente

    @Column(name = "CLI_TELEFONO")
    private String telefono;  // Telefono del cliente

    @Column(name = "CLI_RUC")
    private String ruc;  // RUC del cliente

    @Column(name = "CLI_RAZON_SOCIAL")
    private String razonSocial;  // Razon social del cliente

    @Column(name = "CLI_DIRECCION")
    private String direccion;  // Direccion del cliente

}
