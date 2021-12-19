package com.prueba.zabudbackend.mapper;

import com.prueba.zabudbackend.domain.Factura;
import com.prueba.zabudbackend.dto.FacturaDTO;
import com.prueba.zabudbackend.dto.FacturaTableDTO;
import org.mapstruct.Mapper;

@Mapper
public interface FacturaMapper {
    Factura faturaDTOToFactura(FacturaDTO facturaDTO);
    FacturaTableDTO facturaToFacturaTableDTO(Factura factura);
}
