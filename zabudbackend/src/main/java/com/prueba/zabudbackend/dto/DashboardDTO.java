package com.prueba.zabudbackend.dto;

public class DashboardDTO {
    private Integer clientes;
    private Integer facturas;
    private Integer productos;

    public Integer getClientes() {
        return clientes;
    }

    public void setClientes(Integer clientes) {
        this.clientes = clientes;
    }

    public Integer getFacturas() {
        return facturas;
    }

    public void setFacturas(Integer facturas) {
        this.facturas = facturas;
    }

    public Integer getProductos() {
        return productos;
    }

    public void setProductos(Integer productos) {
        this.productos = productos;
    }
}
