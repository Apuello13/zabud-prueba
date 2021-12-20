package com.prueba.zabudbackend.mapper.impl;

import com.prueba.zabudbackend.domain.Producto;
import com.prueba.zabudbackend.dto.ProductoDTO;
import com.prueba.zabudbackend.mapper.ProductoMapper;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ProductoMapperImpl implements ProductoMapper {
    @Override
    public Producto productoDTOToProducto(ProductoDTO productoDTO) {
        if(productoDTO == null)
            return null;
        Producto producto = new Producto();
        producto.setId(productoDTO.getId());
        producto.setNombre(productoDTO.getNombre());
        producto.setCantidad(productoDTO.getCantidad());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setCreated(new Date());
        return producto;
    }

    @Override
    public ProductoDTO productoToProductoDTO(Producto producto) {
        if(producto == null)
            return null;
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setCantidad(producto.getCantidad());
        productoDTO.setPrecio(producto.getPrecio());
        return productoDTO;
    }
}
