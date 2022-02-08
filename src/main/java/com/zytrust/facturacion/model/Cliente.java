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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Data;

@Data
@Entity
@Table(name = "FAC_Clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLI_ID")
    /**Identificador del cliente*/
    private String id;

    @Column(name = "CLI_NOMBRES")
    /**Nombres del cliente*/
    private String nombres;

    @Column(name = "CLI_APELLIDOS")
    /**Apellidos del cliente*/
    private String apellidos;

    @Column(name = "CLI_DNI")
    /**DNI del cliente*/
    private String dni;

    @Column(name = "CLI_TELEFONO")
    /**Telefono del cliente*/
    private String telefono;

    @Column(name = "CLI_RUC")
    /**RUC del cliente*/
    private String ruc;

    @Column(name = "CLI_RAZON_SOCIAL")
    /**Razon social del cliente*/
    private String razonSocial;

    @Column(name = "CLI_DIRECCION")
    /**Direccion del cliente*/
    private String direccion;

}
