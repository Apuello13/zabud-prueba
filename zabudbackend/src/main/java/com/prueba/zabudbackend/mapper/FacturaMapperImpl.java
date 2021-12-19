package com.prueba.zabudbackend.mapper;

import com.prueba.zabudbackend.domain.Cajero;
import com.prueba.zabudbackend.domain.Cliente;
import com.prueba.zabudbackend.domain.Factura;
import com.prueba.zabudbackend.dto.FacturaDTO;
import com.prueba.zabudbackend.dto.FacturaTableDTO;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class FacturaMapperImpl implements FacturaMapper{
    UUID uuid = UUID.randomUUID();
    @Override
    public Factura faturaDTOToFactura(FacturaDTO facturaDTO) {
        Cajero cajero = new Cajero();
        Cliente cliente = new Cliente();
        if(facturaDTO == null)
            return null;
        cajero.setId(facturaDTO.getIdCajero());
        cliente.setId(facturaDTO.getIdCliente());
        Factura factura = new Factura();
        factura.setId(facturaDTO.getId());
        factura.setNumeroFactura(uuid.toString());
        factura.setCajero(cajero);
        factura.setCliente(cliente);
        factura.setMetodoPago(facturaDTO.getMetodoPago());
        factura.setCreated(new Date());
        return factura;
    }

    @Override
    public FacturaTableDTO facturaToFacturaTableDTO(Factura factura) {
        if(factura == null)
            return null;
        FacturaTableDTO facturaTableDTO = new FacturaTableDTO();
        facturaTableDTO.setId(factura.getId());
        facturaTableDTO.setCliente(factura.getCliente().getNombre() + " " + factura.getCliente().getApellido());
        facturaTableDTO.setNumeroFactura(factura.getNumeroFactura());
        facturaTableDTO.setCreated(factura.getCreated().toString());
        facturaTableDTO.setMetodoPago(factura.getMetodoPago());
        return facturaTableDTO;
    }
}
