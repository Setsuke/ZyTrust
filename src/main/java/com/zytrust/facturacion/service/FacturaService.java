package com.zytrust.facturacion.service;

import com.zytrust.facturacion.model.Factura;
import com.zytrust.facturacion.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public Factura create (Factura factura){
        return facturaRepository.save(factura);
    }

    public List<Factura> getAllFacturas(){
        return facturaRepository.findAll();
    }

    public void delete (Factura factura){
        facturaRepository.delete(factura);
    }

    public Optional<Factura> findById (String id){
        return facturaRepository.findById(id);
    }
}
