package com.prueba.zabudbackend.repository;

import com.prueba.zabudbackend.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> { }
