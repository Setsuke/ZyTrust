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

import com.zytrust.facturacion.model.Cliente;
import com.zytrust.facturacion.model.Factura;
import com.zytrust.facturacion.response.FacturaResponse;
import com.zytrust.facturacion.service.ClienteService;
import com.zytrust.facturacion.service.FacturaService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;
    @Autowired
    private ClienteService clienteService;



    @PostMapping("/factura")
    private ResponseEntity<Factura> guardaFactura (
            @RequestBody Factura factura){
        Factura temp = facturaService.create(factura);
        try{
            return ResponseEntity.created(
                    new URI("/factura"+temp.getId())).body(temp);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
/*
    @PostMapping("/facturaa")
    private FacturaResponse guardaFacturaa (
            @RequestBody FacturaResponse factura){

        String idCliente= factura.getClienteId();
        System.out.println("ENTRA AQUI");
        System.out.println(idCliente);

        Factura temp = new Factura();
        Cliente cliente = clienteService.findById(idCliente);

        temp.setCliente();
        //facturaService.update(temp);


        //Factura temp = facturaService.create(factura);
            return new FacturaResponse();

    }
    */

    @GetMapping("/facturas")
    private ResponseEntity<List<Factura>> listaFacturas (){
        return ResponseEntity.ok(facturaService.getAllFacturas());
    }

}
