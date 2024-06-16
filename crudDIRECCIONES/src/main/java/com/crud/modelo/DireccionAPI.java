package com.crud.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Basic;

@Entity
public class DireccionAPI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(name = "calle")
    private String calle;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "estado")
    private String estado;

    @Column(name = "codigo_postal")
    private String codigoPostal;

    @Column(name = "pais")
    private String pais;

    
    public DireccionAPI() {}

    
    public DireccionAPI(Long id, String calle, String ciudad, String estado, String codigoPostal, String pais) {
        this.id = id;
        this.calle = calle;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Direccion [id=" + id + ", calle=" + calle + ", ciudad=" + ciudad + ", estado=" + estado 
                + ", codigoPostal=" + codigoPostal + ", pais=" + pais + "]";
    }
}
