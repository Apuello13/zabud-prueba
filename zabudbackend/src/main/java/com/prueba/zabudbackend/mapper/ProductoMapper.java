package com.prueba.zabudbackend.mapper;

import com.prueba.zabudbackend.domain.Producto;
import com.prueba.zabudbackend.dto.ProductoDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ProductoMapper {
    Producto productoDTOToProducto(ProductoDTO productoDTO);
    ProductoDTO productoToProductoDTO(Producto producto);
}
