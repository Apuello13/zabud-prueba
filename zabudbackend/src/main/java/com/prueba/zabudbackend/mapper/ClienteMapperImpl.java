package com.prueba.zabudbackend.mapper;

import com.prueba.zabudbackend.domain.Cliente;
import com.prueba.zabudbackend.dto.ClienteDTO;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ClienteMapperImpl implements ClienteMapper{
    @Override
    public Cliente clienteDTOToCliente(ClienteDTO clienteDTO) {
        if(clienteDTO == null)
            return null;
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setNumeroDocumento(clienteDTO.getNumeroDocumento());
        cliente.setTelefono(clienteDTO.getTelefono());
        cliente.setCreated(new Date());
        return cliente;
    }

    @Override
    public ClienteDTO clienteToClienteDTO(Cliente cliente) {
        if(cliente == null)
            return null;
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setApellido(cliente.getApellido());
        clienteDTO.setEmail(cliente.getEmail());
        clienteDTO.setNumeroDocumento(cliente.getNumeroDocumento());
        clienteDTO.setTelefono(cliente.getTelefono());
        return clienteDTO;
    }
}
