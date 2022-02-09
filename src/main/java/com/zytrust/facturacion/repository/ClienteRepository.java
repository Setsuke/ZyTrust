package com.zytrust.facturacion.repository;

import com.zytrust.facturacion.model.Cliente;
import com.zytrust.facturacion.model.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,String> {
}