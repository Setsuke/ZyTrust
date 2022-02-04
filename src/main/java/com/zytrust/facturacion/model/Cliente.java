package com.zytrust.facturacion.model;

import javax.persistence.*;

@Entity
@Table(name = "FAC Clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLI_ID")
    private Integer id;

    @Column(name = "CLI_NOMBRES")
    private String nombres;
    @Column(name = "CLI_APELLIDOS")
    private String apellidos;
    @Column(name = "CLI_DNI")
    private String dni;
    @Column(name = "CLI_TELEFONO")
    private String telefono;
    @Column(name = "CLI_RUC")
    private String ruc;
    @Column(name = "CLI_RAZON_SOCIAL")
    private String razonSocial;
    @Column(name = "CLI_DIRECCION")
    private String direccion;
    //relacion factura

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
