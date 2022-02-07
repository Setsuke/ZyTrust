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

import com.zytrust.facturacion.model.Factura;
import com.zytrust.facturacion.repository.FacturaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public Factura create (Factura factura){
        return facturaRepository.save(factura);  // Crear Factura
    }

    public List<Factura> getAllFacturas(){
        return facturaRepository.findAll();  // Obtener todas las facturas
    }

    public Optional<Factura> findById (String id){
        return facturaRepository.findById(id);  // Obtener factura por ID
    }
}
