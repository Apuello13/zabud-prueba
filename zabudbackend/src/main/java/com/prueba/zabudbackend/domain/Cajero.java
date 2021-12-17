package com.prueba.zabudbackend.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "cajeros" )
public class Cajero {
    @Id
    @Column( name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String nombre;
    @OneToOne
    @JoinColumn( name = "id_usuario", foreignKey =  @ForeignKey( name = "FK_ID_USUARIO" ) )
    private Usuario usuario;
    @OneToMany( mappedBy = "cajero", fetch = FetchType.LAZY )
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
