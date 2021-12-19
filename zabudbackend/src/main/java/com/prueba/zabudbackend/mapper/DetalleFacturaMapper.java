package com.prueba.zabudbackend.mapper;

import com.prueba.zabudbackend.domain.DetalleFactura;
import com.prueba.zabudbackend.domain.Factura;
import com.prueba.zabudbackend.domain.Producto;
import com.prueba.zabudbackend.dto.ProductoDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DetalleFacturaMapper {
    DetalleFactura facturaToDetalleFactura(Factura factura, Producto producto);
    List<ProductoDTO> detalleFacturaToProductoDTO(List<DetalleFactura> detalleFacturas);
}
