package com.prueba.zabudbackend.service;

import com.prueba.zabudbackend.domain.DetalleFactura;
import com.prueba.zabudbackend.domain.Factura;
import com.prueba.zabudbackend.domain.Producto;
import com.prueba.zabudbackend.dto.ErrorDTO;
import com.prueba.zabudbackend.dto.FacturaDTO;
import com.prueba.zabudbackend.dto.FacturaTableDTO;
import com.prueba.zabudbackend.mapper.DetalleFacturaMapper;
import com.prueba.zabudbackend.mapper.FacturaMapper;
import com.prueba.zabudbackend.mapper.ProductoMapper;
import com.prueba.zabudbackend.repository.DetalleFacturaRepository;
import com.prueba.zabudbackend.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacturaServiceImpl implements FacturaService{
    //Repositorios
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;
    //Mappers
    @Autowired
    private FacturaMapper facturaMapper;
    @Autowired
    private ProductoMapper productoMapper;
    @Autowired
    private DetalleFacturaMapper detalleFacturaMapper;
    //Services
    @Autowired
    private ProductoService productoService;

    @Override
    @Transactional
    public ErrorDTO save(FacturaDTO facturaDTO) {
        ErrorDTO error = new ErrorDTO();
        try{
            Factura factura = facturaRepository.save(facturaMapper.faturaDTOToFactura(facturaDTO));
            facturaDTO.getProductos().forEach(id -> {
                Producto producto = productoMapper
                        .productoDTOToProducto(productoService.findById(id).get());
                detalleFacturaRepository.save(detalleFacturaMapper.facturaToDetalleFactura(factura, producto));
            });
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
            facturas = facturaRepository.findAll()
                    .stream()
                    .map(factura -> facturaMapper.facturaToFacturaTableDTO(factura))
                    .collect(Collectors.toList());
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
                FacturaTableDTO facturaTableDTO = new FacturaTableDTO();
                facturaTableDTO = facturaMapper
                        .facturaToFacturaTableDTO(facturaRepository.findById(idFactura).get());
                facturaTableDTO.setProductos(detalleFacturaMapper
                        .detalleFacturaToProductoDTO(detalleFacturaRepository.findByIdFactura(idFactura)));
                optional = Optional.of(facturaTableDTO);
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return optional;
    }

    @Override
    @Transactional
    public boolean deleteById(Long idFactura) {
        try{
            if(facturaRepository.existsById(idFactura)){
                detalleFacturaRepository.deleteByIdFactura(idFactura);
                facturaRepository.deleteById(idFactura);
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
