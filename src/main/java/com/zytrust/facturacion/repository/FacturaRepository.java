package com.zytrust.facturacion.repository;

import com.zytrust.facturacion.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura,String> {
}
