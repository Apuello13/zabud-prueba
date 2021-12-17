package com.prueba.zabudbackend.mapper;

import com.prueba.zabudbackend.domain.Cliente;
import com.prueba.zabudbackend.dto.ClienteDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ClienteMapper {
    Cliente clienteDTOToCliente(ClienteDTO clienteDTO);
    ClienteDTO clienteToClienteDTO(Cliente cliente);
}
