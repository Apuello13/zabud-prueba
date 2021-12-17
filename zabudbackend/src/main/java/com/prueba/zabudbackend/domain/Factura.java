package com.prueba.zabudbackend.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "facturas" )
public class Factura {
    @Id
    @Column( name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    @Column( name = "numero_factura" )
    private String numeroFactura;
    @Column( name = "metodo_pago" )
    private String metodoPago;
    @ManyToOne
    @JoinColumn( name = "id_cajero", foreignKey = @ForeignKey(name = "FK_ID_CAJERO") )
    private Cajero cajero;
    @ManyToOne
    @JoinColumn( name = "id_cliente", foreignKey = @ForeignKey(name = "FK_ID_CLIENTE") )
    private Cliente cliente;
    @Temporal( TemporalType.DATE )
    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Cajero getCajero() {
        return cajero;
    }

    public void setCajero(Cajero cajero) {
        this.cajero = cajero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
