package com.zytrust.facturacion.service;

import com.zytrust.facturacion.model.Cliente;
import com.zytrust.facturacion.model.Factura;
import com.zytrust.facturacion.repository.ClienteRepository;
import com.zytrust.facturacion.repository.FacturaRepository;
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
