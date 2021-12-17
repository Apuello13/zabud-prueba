package com.prueba.zabudbackend.service;

import com.prueba.zabudbackend.dto.ErrorDTO;
import com.prueba.zabudbackend.dto.FacturaDTO;
import com.prueba.zabudbackend.dto.FacturaTableDTO;
import com.prueba.zabudbackend.repository.DetalleFacturaRepository;
import com.prueba.zabudbackend.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService{
    //Repositorios
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;
    //Mappers

    @Override
    public ErrorDTO save(FacturaDTO facturaDTO) {
        ErrorDTO error = new ErrorDTO();
        try{

        }catch(Exception e){
            e.printStackTrace();
            error.setMensaje(e.getCause().toString());
        }
        return error;
    }

    @Override
    public List<FacturaTableDTO> findAll() {
        List<FacturaTableDTO> facturas = new ArrayList<>();
        try{

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return facturas;
    }

    @Override
    public Optional<FacturaTableDTO> findById(Long idFactura) {
        Optional<FacturaTableDTO> optional = Optional.empty();
        try{
            if(facturaRepository.existsById(idFactura)){

            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return optional;
    }

    @Override
    public boolean deleteById(Long idFactura) {
        try{
            if(facturaRepository.existsById(idFactura)){
                facturaRepository.deleteById(idFactura);
                //Eliminar en detalleFactura
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
