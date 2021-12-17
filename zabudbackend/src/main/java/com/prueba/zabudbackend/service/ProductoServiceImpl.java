package com.prueba.zabudbackend.service;

import com.prueba.zabudbackend.domain.Producto;
import com.prueba.zabudbackend.dto.ErrorDTO;
import com.prueba.zabudbackend.dto.ProductoDTO;
import com.prueba.zabudbackend.mapper.ProductoMapper;
import com.prueba.zabudbackend.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService{
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public ErrorDTO save(ProductoDTO productoDTO) {
        ErrorDTO error = new ErrorDTO();
        try{
            productoRepository.save(productoMapper.productoDTOToProducto(productoDTO));
        }catch(Exception e){
            e.printStackTrace();
            error.setMensaje(e.getCause().toString());
        }
        return error;
    }

    @Override
    public boolean deleteById(Long idProducto) {
        try{
            if(productoRepository.existsById(idProducto))
                productoRepository.deleteById(idProducto);
            else
                return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Optional<ProductoDTO> findById(Long idProducto) {
        Optional<ProductoDTO> optional = Optional.empty();
        try{
            if(productoRepository.existsById(idProducto)){
                Producto producto = productoRepository.findById(idProducto).orElse(null);
                optional = Optional.of(productoMapper.productoToProductoDTO(producto));
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return optional;
    }

    @Override
    public List<ProductoDTO> findAll() {
        List<ProductoDTO> productos = new ArrayList<>();
        try{
            productos = productoRepository.findAll()
                    .stream()
                    .map(producto -> productoMapper.productoToProductoDTO(producto))
                    .collect(Collectors.toList());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return productos;
    }
}
