package com.prueba.zabudbackend.repository;

import com.prueba.zabudbackend.domain.Cajero;
import com.prueba.zabudbackend.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CajeroRepository extends JpaRepository<Cajero, Long> {
    Cajero findByUsuario(Usuario usuario);
}
