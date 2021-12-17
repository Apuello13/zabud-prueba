package com.prueba.zabudbackend.repository;

import com.prueba.zabudbackend.domain.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Long> { }
