package com.prueba.zabudbackend.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "productos" )
public class Producto {
    @Id
    @Column( name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String nombre;
    private Double precio;
    private Integer cantidad;
    @Temporal( TemporalType.DATE )
    private Date created;
    @OneToMany( mappedBy = "producto", fetch = FetchType.LAZY )
    private List<DetalleFactura> detalleFacturas = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<DetalleFactura> getDetalleFacturas() {
        return detalleFacturas;
    }

    public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
        this.detalleFacturas = detalleFacturas;
    }
}
