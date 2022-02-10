package com.zytrust.facturacion.service;
/*
 * @(#)ClienteService.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta clase representa a un ClienteService y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Sergio Alva
 * @version 1.00, 04/02/2022
 */

import com.zytrust.facturacion.model.Cliente;
import com.zytrust.facturacion.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente create (Cliente cliente){
        /**Crear cliente*/
        return clienteRepository.save(cliente);
    }

    public List<Cliente> getAllFacturas(){
        /**Obtener todas las clientes*/
        return clienteRepository.findAll();
    }

    public Cliente findById (String id){
        /**Obtener cliente por ID*/
        return clienteRepository.findById(id).get();
    }

    public void update (Cliente cliente){
        /**Actualizar cliente*/
        clienteRepository.save(cliente);
    }
}
