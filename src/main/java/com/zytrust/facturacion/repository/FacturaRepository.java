package com.zytrust.facturacion.repository;
/*
 * @(#)FacturaRepository.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta interfaz representa a un FacturaRepository y debe ser usada para
 * almacenar datos e intercambiarlos con otros objetos.
 *
 * @author Sergio Alva
 * @version 1.00, 04/02/2022
 */

import com.zytrust.facturacion.dto.FacturaDTO;
import com.zytrust.facturacion.dto.FacturaTotalDTO;
import com.zytrust.facturacion.model.Factura;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface FacturaRepository extends JpaRepository<Factura,String> {

    List<FacturaDTO> findAllByClienteId(String clienteId);

    @Query(value = "SELECT f.id as id, f.cliente.nombres as " +
            "clienteNombres,f.cliente.apellidos as clienteApellidos, f.total " +
            "as total FROM Factura as f")
    List<FacturaTotalDTO> facturaDTOTotal();

    @Query(value = "SELECT f.id as id, f.cliente.id as " +
            "clienteId,f.estado as estado, f.fechaEmision as fechaEmision, f" +
            ".fechaVencimiento as fechaVencimiento, f.fechaPago as fechaPago," +
            " f.tipoPago as tipoPago, f.subtotal as subtotal, f.impuesto as " +
            "impuesto, f.total as total FROM Factura as f")
    List<FacturaDTO> findAllfacturasDTO();
}
