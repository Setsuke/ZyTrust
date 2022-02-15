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

import com.zytrust.facturacion.dto.FacturaDTO;
import com.zytrust.facturacion.dto.FacturaReq;
import com.zytrust.facturacion.dto.FacturaTotalDTO;
import com.zytrust.facturacion.exception.CodigoError;
import com.zytrust.facturacion.exception.ZyTrustException;
import com.zytrust.facturacion.model.Factura;
import com.zytrust.facturacion.service.FacturaService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    private static final Logger logger =
            LoggerFactory.getLogger(FacturaController.class);

    @PostMapping("/factura")
    private ResponseEntity<?> guardaFactura (
            @RequestBody FacturaReq facturaReq){
        logger.info("Creando la factura con los datos {}",facturaReq.toString());
        Factura temp = facturaService.createReq(facturaReq);
        try{
            return ResponseEntity.created(
                    new URI("/factura"+temp.getId())).body(temp);
        } catch (ZyTrustException | URISyntaxException e) {
            logger.error("No se ha podido crear la factura con los datos {}",
                    facturaReq);
            throw new ZyTrustException(CodigoError.CREACION_FACTURA_FALLO);
        }
    }

    @GetMapping("/facturas")
    private ResponseEntity<List<FacturaDTO>> listaFacturas (){
        return ResponseEntity.ok(facturaService.getAllFacturas());
    }

    @GetMapping("/facturas-id")
    private ResponseEntity<?> listaFacturasId (@RequestParam String id){
        return ResponseEntity.status(HttpStatus.OK).body(facturaService.findAllFacturasByClienteId(id));
    }

    @GetMapping("/facturas-dto")
    private List<FacturaTotalDTO> listaFacturasDtoTotales (){
        logger.debug("Obteniendo listado de Facturas");
        return facturaService.facturaDTOTotal();
    }
}
