package com.zytrust.facturacion.controller;
/*
 * @(#)FacturaController.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta clase representa a un FacturaController y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Sergio Alva
 * @version 1.00, 04/02/2022
 */

import com.zytrust.facturacion.model.Factura;
import com.zytrust.facturacion.service.FacturaService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @PostMapping("/guardar")
    private ResponseEntity<Factura> guardarFactura (
            @RequestBody Factura factura){
        Factura temp = facturaService.create(factura);
        try{
            return ResponseEntity.created(
                    new URI("/factura/guardar"+temp.getId())).body(temp);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/listar")
    private ResponseEntity<List<Factura>> listarFacturas (){
        return ResponseEntity.ok(facturaService.getAllFacturas());
    }

    @DeleteMapping("/eliminar")
    private ResponseEntity<List<Factura>> eliminarFactura (
            @RequestBody Factura factura){
        facturaService.delete(factura);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscar/{id}")
    private ResponseEntity<Optional<Factura>> buscarFactura (
            @PathVariable ("id") String id){
        return ResponseEntity.ok(facturaService.findById(id));
    }
}
