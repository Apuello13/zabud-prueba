package com.prueba.zabudbackend.dto;

import java.util.List;

public class FacturaDTO {
    private Long id;
    private Long idCliente;
    private Long idCajero;
    private List<Long> productos;
    private String metodoPago;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(Long idCajero) {
        this.idCajero = idCajero;
    }

    public List<Long> getProductos() {
        return productos;
    }

    public void setProductos(List<Long> productos) {
        this.productos = productos;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}
