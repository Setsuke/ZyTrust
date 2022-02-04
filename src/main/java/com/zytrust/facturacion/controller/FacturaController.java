package com.zytrust.facturacion.controller;

import com.zytrust.facturacion.model.Factura;
import com.zytrust.facturacion.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @PostMapping("/guardar")
    private ResponseEntity<Factura> guardar (@RequestBody Factura factura){
        Factura temp = facturaService.create(factura);
        try{
            return ResponseEntity.created(new URI("/api/guardar"+temp.getId())).body(temp);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/listar")
    private ResponseEntity<List<Factura>> listarFacturas (){
        return ResponseEntity.ok(facturaService.getAllFacturas());
    }

    @DeleteMapping("/eliminar")
    private ResponseEntity<List<Factura>> eliminarFactura (@RequestBody Factura factura){
        facturaService.delete(factura);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscar/{id}")
    private ResponseEntity<Optional<Factura>> buscarFactura (@PathVariable ("id") String id){
        return ResponseEntity.ok(facturaService.findById(id));
    }
}
