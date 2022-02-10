package com.zytrust.facturacion.service;
/*
 * @(#)DetalleService.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta clase representa a un DetalleService y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Sergio Alva
 * @version 1.00, 04/02/2022
 */

import com.zytrust.facturacion.model.Detalle;
import com.zytrust.facturacion.model.Factura;
import com.zytrust.facturacion.model.Producto;
import com.zytrust.facturacion.repository.DetalleRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.zytrust.facturacion.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleService {

    @Autowired
    private DetalleRepository detalleRepository;

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private ProductoService productoService;

    public Detalle create (Detalle detalle){

        Factura factura =facturaService.findById(detalle.getFactura().getId());
        Producto producto = productoService.findById(detalle.getProducto()
                .getId());

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

        return detalleRepository.save(detalle);
    }

    public List<Detalle> getAllDetalles(){
        /**Obtener todos los detalles*/
        return detalleRepository.findAll();
    }

    public void delete (Detalle detalle){
        /**eliminar detalle*/
        detalleRepository.delete(detalle);
    }

    public Optional<Detalle> findById (String id){
        /**Obtener detalle por ID*/
        return detalleRepository.findById(id);
    }
    public void update (Detalle detalle){
        /**Actualizar Detalle*/
        detalleRepository.save(detalle);
    }
}
