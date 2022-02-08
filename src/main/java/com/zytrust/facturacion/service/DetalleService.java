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
import com.zytrust.facturacion.repository.DetalleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleService {

    @Autowired
    private DetalleRepository detalleRepository;

    public Detalle create (Detalle detalle){
        /**Crear Detalle*/
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
}
