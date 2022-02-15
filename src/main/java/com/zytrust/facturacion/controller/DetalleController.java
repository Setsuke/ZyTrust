package com.zytrust.facturacion.controller;
/*
 * @(#)DetalleController.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta clase representa a un DetalleController y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Sergio Alva
 * @version 1.00, 04/02/2022
 */

import com.zytrust.facturacion.dto.DetalleReq;
import com.zytrust.facturacion.exception.ZyTrustException;
import com.zytrust.facturacion.model.Detalle;
import com.zytrust.facturacion.service.DetalleService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class DetalleController {

    @Autowired
    private DetalleService detalleService;

    private static final Logger logger =
            LoggerFactory.getLogger(FacturaController.class);


    @PostMapping("/detalle")
    private ResponseEntity<Detalle> guardaDetalle (
            @RequestBody DetalleReq detalleReq){
        logger.info("Creando el detalle con los datos {}",detalleReq.toString());
        Detalle temp = detalleService.create(detalleReq);
        try{
            return ResponseEntity.created(
                            new URI("/detalle"+temp.getNumero()))
                    .body(temp);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/detalles")
    private ResponseEntity<List<Detalle>> listaDetalles (){
        return ResponseEntity.ok(detalleService.getAllDetalles());
    }

    @DeleteMapping("/detalle")
    private ResponseEntity<List<Detalle>> eliminaDetalle (
            @RequestBody Detalle detalle){
        detalleService.delete(detalle);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/detalle/{numero}")
    private ResponseEntity<Optional<Detalle>> buscaDetalle (
            @PathVariable ("numero") String numero){
        return ResponseEntity.ok(detalleService.findById(numero));
    }

    @GetMapping("/detalles-id")
    private ResponseEntity<?> listaDetallesId (@RequestParam String id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(detalleService.findAllDetallesByFacturaId(id));
        }catch (ZyTrustException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
