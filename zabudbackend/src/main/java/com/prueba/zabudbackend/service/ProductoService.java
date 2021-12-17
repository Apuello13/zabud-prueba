package com.prueba.zabudbackend.service;

import com.prueba.zabudbackend.dto.ErrorDTO;
import com.prueba.zabudbackend.dto.ProductoDTO;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    ErrorDTO save(ProductoDTO productoDTO);
    boolean deleteById(Long idProducto);
    Optional<ProductoDTO> findById(Long idProducto);
    List<ProductoDTO> findAll();
}
