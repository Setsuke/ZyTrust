package com.zytrust.facturacion.service;
/*
 * @(#)ProductoService.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta clase representa a un ProductoService y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Sergio Alva
 * @version 1.00, 04/02/2022
 */

import com.zytrust.facturacion.model.Factura;
import com.zytrust.facturacion.model.Producto;
import com.zytrust.facturacion.repository.ProductoRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto create (Producto producto){
        /**Crear Producto*/
        return productoRepository.save(producto);
    }

    public List<Producto> getAllProductos(){
        /**Obtener todas las productos*/
        return productoRepository.findAll();
    }

    public Producto findById (String id){
        /**Obtener producto por ID*/
        return productoRepository.findById(id).get();
    }

    public void update (Producto producto){
        /**Crear producto*/
        productoRepository.save(producto);
    }

    public Optional<Producto> getById (String id){
        /**Obtener detalle por ID*/
        return productoRepository.findById(id);
    }
}
