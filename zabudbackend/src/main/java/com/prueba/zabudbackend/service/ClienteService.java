package com.prueba.zabudbackend.service;

import com.prueba.zabudbackend.dto.ClienteDTO;
import com.prueba.zabudbackend.dto.ErrorDTO;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    ErrorDTO saveCliente(ClienteDTO clienteDTO);
    boolean deleteById(Long idCliente);
    List<ClienteDTO> findAll();
    Optional<ClienteDTO> findById(Long idCliente);
}
