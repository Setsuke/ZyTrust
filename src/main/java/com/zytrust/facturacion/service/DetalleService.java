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

import com.zytrust.facturacion.controller.FacturaController;
import com.zytrust.facturacion.dto.DetalleDTO;
import com.zytrust.facturacion.dto.FacturaDTO;
import com.zytrust.facturacion.exception.CodigoError;
import com.zytrust.facturacion.exception.ZyTrustException;
import com.zytrust.facturacion.model.Detalle;
import com.zytrust.facturacion.model.Factura;
import com.zytrust.facturacion.model.Producto;
import com.zytrust.facturacion.repository.DetalleRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger =
            LoggerFactory.getLogger(FacturaController.class);

    public Detalle create (Detalle detalle){
        /**Crear Detalle y Agregar Montos(subtotal, impuesto, total) a la
         * factura*/

        Optional<Factura> opFactura =
                facturaService.getById(detalle.getFactura().getId());
        if (opFactura.isEmpty()){
            logger.info("No se encontro la factura con codigo {}",
                    detalle.getFactura().getId());
            throw new ZyTrustException(CodigoError.FACTURA_NO_EXISTE);
        }
        Factura factura = facturaService.findById(detalle.getFactura().getId());

        Optional<Producto> opProducto =
                productoService.getById(detalle.getProducto().getId());
        if (opProducto.isEmpty()){
            logger.info("No se encontro el producto con codigo {}",
                    detalle.getProducto().getId());
            throw new ZyTrustException(CodigoError.PRODUCTO_NO_EXISTE);
        }
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

        logger.debug("Actualizando datos de factura {}",factura);
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

    public List<DetalleDTO> findAllDetallesByFacturaId (String facturaId){
        /**Actualizar Factura*/
        List<DetalleDTO> detalles =
                detalleRepository.findAllByFacturaId(facturaId);
        return detalles;
    }
}
