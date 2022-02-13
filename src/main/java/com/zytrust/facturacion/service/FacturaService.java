package com.zytrust.facturacion.service;
/*
 * @(#)FacturaService.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta clase representa a un FacturaService y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Sergio Alva
 * @version 1.00, 04/02/2022
 */

import com.zytrust.facturacion.dto.FacturaDTO;
import com.zytrust.facturacion.dto.FacturaReq;
import com.zytrust.facturacion.model.Cliente;
import com.zytrust.facturacion.model.Factura;
import com.zytrust.facturacion.repository.FacturaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteService clienteService;

    public Factura create (Factura factura){
        /**Crear Factura*/
        return facturaRepository.save(factura);
    }

    public Factura createReq (FacturaReq facturaReq){
        /**Crear Factura*/

        String facturaId = facturaReq.getFacturaId();
        String clienteId = facturaReq.getClienteId();
        LocalDate fechaVencimiento = facturaReq.getFechaVencimiento();
        LocalDate fechaPago = facturaReq.getFechaPago();
        String tipoPago = facturaReq.getTipoPago();

        Cliente cliente = clienteService.findById(clienteId);

        Factura factura = new Factura();
        factura.setId(facturaId);
        factura.setCliente(cliente);
        factura.setFechaVencimiento(fechaVencimiento);
        factura.setFechaPago(fechaPago);
        factura.setTipoPago(tipoPago);

        return facturaRepository.save(factura);
    }

    public List<Factura> getAllFacturas(){
        /**Obtener todas las facturas*/
        return facturaRepository.findAll();
    }

    public Factura findById (String id){
        /**Obtener factura por ID*/
        return facturaRepository.findById(id).get();
    }

    public Optional<Factura> getById (String id){
        /**Obtener detalle por ID*/
        return facturaRepository.findById(id);
    }

    public void update (Factura factura){
        /**Actualizar Factura*/
        facturaRepository.save(factura);
    }

    public List<FacturaDTO> findAllFacturasByClienteId (String clienteId){
        /**Actualizar Factura*/
        List<FacturaDTO> facturas =
                facturaRepository.findAllByClienteId(clienteId);
        return facturas;
    }
}
