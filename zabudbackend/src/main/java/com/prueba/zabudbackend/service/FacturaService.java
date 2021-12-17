package com.prueba.zabudbackend.service;

import com.prueba.zabudbackend.dto.ErrorDTO;
import com.prueba.zabudbackend.dto.FacturaDTO;
import com.prueba.zabudbackend.dto.FacturaTableDTO;

import java.util.List;
import java.util.Optional;

public interface FacturaService {
    ErrorDTO save(FacturaDTO facturaDTO);
    List<FacturaTableDTO> findAll();
    Optional<FacturaTableDTO> findById(Long idFactura);
    boolean deleteById(Long idFactura);
}
