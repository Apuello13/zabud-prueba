package com.prueba.zabudbackend.service;

import com.prueba.zabudbackend.domain.Cliente;
import com.prueba.zabudbackend.dto.ClienteDTO;
import com.prueba.zabudbackend.dto.ErrorDTO;
import com.prueba.zabudbackend.mapper.ClienteMapper;
import com.prueba.zabudbackend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService{
    //Repositorios
    @Autowired
    private ClienteRepository clienteRepository;
    //Mappers
    @Autowired
    private ClienteMapper clienteMapper;
    //Constantes
    private final Long nuevoCliente = 0L;
    @Override
    public ErrorDTO saveCliente(ClienteDTO clienteDTO) {
        ErrorDTO error = new ErrorDTO();
        try{
            if(clienteRepository.existsByNumeroDocumento(clienteDTO.getNumeroDocumento())
                    && clienteDTO.getId() == nuevoCliente){
                error.setMensaje("Ya existe un cliente con ese numero de documento");
            }else{
                clienteRepository.save(clienteMapper.clienteDTOToCliente(clienteDTO));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return error;
    }

    @Override
    public boolean deleteById(Long idCliente) {
        try{
            if(clienteRepository.existsById(idCliente))
                clienteRepository.deleteById(idCliente);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<ClienteDTO> findAll() {
        List<ClienteDTO> clientes = new ArrayList<>();
        try{
            clientes = clienteRepository.findAll()
                    .stream()
                    .map(cliente -> clienteMapper.clienteToClienteDTO(cliente))
                    .collect(Collectors.toList());
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return clientes;
    }

    @Override
    public Optional<ClienteDTO> findById(Long idCliente) {
        Optional<ClienteDTO> optional = Optional.empty();
        try{
            if(clienteRepository.existsById(idCliente)){
                Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
                optional = Optional.of(clienteMapper.clienteToClienteDTO(cliente));
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return optional;
    }
}
