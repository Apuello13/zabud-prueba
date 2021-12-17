package com.prueba.zabudbackend.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "clientes" )
public class Cliente {
    @Id
    @Column( name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String nombre;
    private String apellido;
    @Column( name = "numero_documento" )
    private String numeroDocumento;
    private String email;
    private String telefono;
    @Temporal( TemporalType.DATE )
    private Date created;
    @OneToMany( mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Factura> facturas = new ArrayList<>();

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
}
