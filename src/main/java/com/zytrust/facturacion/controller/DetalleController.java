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

import com.zytrust.facturacion.model.Detalle;
import com.zytrust.facturacion.model.Factura;
import com.zytrust.facturacion.model.Producto;
import com.zytrust.facturacion.repository.DetalleRepository;
import com.zytrust.facturacion.service.DetalleService;
import com.zytrust.facturacion.service.FacturaService;
import com.zytrust.facturacion.service.ProductoService;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/facturacion")
public class DetalleController {

    @Autowired
    private DetalleService detalleService;

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private DetalleRepository detalleRepository;

    @Autowired
    private DetalleRepository facturaRepository;

    @PostMapping("/detalle")
    private ResponseEntity<Detalle> Detalle (
            @RequestBody Detalle detalle){
        Factura factura =facturaService.findById(detalle.getFactura().getId());
        Producto producto =
                productoService.findById(detalle.getProducto().getId());
        BigDecimal subtotalAnterior;
        BigDecimal impuestoAnterior;
        BigDecimal totalAnterior;
        BigDecimal subtotalDetalle;
        BigDecimal impuestoDetalle;
        BigDecimal totalDetalle;
        BigDecimal subtotal;
        BigDecimal impuesto;
        BigDecimal total;

        subtotalAnterior = factura.getSubtotal();
        impuestoAnterior = factura.getImpuesto();
        totalAnterior = factura.getTotal();

        BigDecimal precioProducto = producto.getPrecio();
        BigDecimal cantidadProducto= detalle.getCantidad();
        totalDetalle = precioProducto.multiply(cantidadProducto);
        impuestoDetalle= precioProducto.multiply(BigDecimal.valueOf(0.18))
                .multiply(cantidadProducto);
        subtotalDetalle= totalDetalle.subtract(impuestoDetalle);

        subtotal = subtotalAnterior.add(subtotalDetalle);
        impuesto = impuestoAnterior.add(impuestoDetalle);
        total = totalAnterior.add(totalDetalle);

        detalle.getFactura().setTotal(total);
        factura.setTotal(total);
        factura.setSubtotal(subtotal);
        factura.setImpuesto(impuesto);
        detalle.getFactura().setTotal(total);

        facturaService.update(factura);
        Detalle temp = detalleService.create(detalle);

        try{
            return ResponseEntity.created(
                            new URI("/detalle"+temp.getNumero()))
                    .body(temp);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/detalles")
    private ResponseEntity<List<Detalle>> listarDetalles (){
        return ResponseEntity.ok(detalleService.getAllDetalles());
    }

    @DeleteMapping("/detalle")
    private ResponseEntity<List<Detalle>> eliminarDetalle (
            @RequestBody Detalle detalle){
        detalleService.delete(detalle);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/detalle/{numero}")
    private ResponseEntity<Optional<Detalle>> buscarDetalle (
            @PathVariable ("numero") String numero){
        return ResponseEntity.ok(detalleService.findById(numero));
    }
}
