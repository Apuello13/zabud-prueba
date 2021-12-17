package com.prueba.zabudbackend.repository;

import com.prueba.zabudbackend.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByNumeroDocumento(String numeroDocumento);
}
