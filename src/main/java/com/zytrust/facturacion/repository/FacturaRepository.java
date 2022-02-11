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
import com.zytrust.facturacion.model.Factura;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface FacturaRepository extends JpaRepository<Factura,String> {

    List<FacturaDTO> findAllByClienteId(String clienteId);
}
