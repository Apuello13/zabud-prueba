package com.prueba.zabudbackend.repository;

import com.prueba.zabudbackend.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> { }
