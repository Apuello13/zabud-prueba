package com.prueba.zabudbackend.mapper;

import com.prueba.zabudbackend.domain.DetalleFactura;
import com.prueba.zabudbackend.domain.Factura;
import com.prueba.zabudbackend.domain.Producto;
import com.prueba.zabudbackend.dto.ProductoDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class DetalleFacturaMapperImpl implements DetalleFacturaMapper{
    @Override
    public DetalleFactura facturaToDetalleFactura(Factura factura, Producto producto) {
        if(factura == null && producto == null)
            return null;
        DetalleFactura detalleFactura = new DetalleFactura();
        detalleFactura.setId(0L);
        detalleFactura.setFactura(factura);
        detalleFactura.setProducto(producto);
        detalleFactura.setCantidad(producto.getCantidad());
        detalleFactura.setValorUnidad(producto.getPrecio());
        detalleFactura.setTotal(producto.getPrecio() * producto.getCantidad());
        return detalleFactura;
    }

    @Override
    public List<ProductoDTO> detalleFacturaToProductoDTO(List<DetalleFactura> detalleFacturas) {
        List<ProductoDTO> productoDTOS = new ArrayList<>();
        if(Objects.isNull(detalleFacturas))
            return null;
        detalleFacturas.forEach(detalleFactura -> {
            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.setNombre(detalleFactura.getProducto().getNombre());
            productoDTO.setPrecio(detalleFactura.getProducto().getPrecio());
            productoDTO.setCantidad(detalleFactura.getProducto().getCantidad());
            productoDTOS.add(productoDTO);
        });
        return productoDTOS;
    }
}
