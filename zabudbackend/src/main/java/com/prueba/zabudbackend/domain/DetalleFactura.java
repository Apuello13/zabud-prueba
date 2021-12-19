package com.prueba.zabudbackend.domain;

import javax.persistence.*;

@Entity
@Table( name = "detalle_factura" )
public class DetalleFactura {
    @Id
    @Column( name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private Integer cantidad;
    @Column( name = "valor_unidad" )
    private Double valorUnidad;
    private Double total;
    @ManyToOne
    @JoinColumn( name = "id_factura", foreignKey = @ForeignKey(name = "FK_ID_FACTURA"))
    private Factura factura;
    @ManyToOne
    @JoinColumn( name = "id_producto", foreignKey = @ForeignKey( name = "FK_ID_PRODUCTO"))
    private Producto producto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValorUnidad() {
        return valorUnidad;
    }

    public void setValorUnidad(Double valorUnidad) {
        this.valorUnidad = valorUnidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
