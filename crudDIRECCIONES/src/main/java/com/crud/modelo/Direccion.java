package com.crud.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "direccion")
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d"),
    @NamedQuery(name = "Direccion.findById", query = "SELECT d FROM Direccion d WHERE d.id = :id"),
    @NamedQuery(name = "Direccion.findByCalle", query = "SELECT d FROM Direccion d WHERE d.calle = :calle"),
    @NamedQuery(name = "Direccion.findByCiudad", query = "SELECT d FROM Direccion d WHERE d.ciudad = :ciudad"),
    @NamedQuery(name = "Direccion.findByEstado", query = "SELECT d FROM Direccion d WHERE d.estado = :estado"),
    @NamedQuery(name = "Direccion.findByCodigoPostal", query = "SELECT d FROM Direccion d WHERE d.codigoPostal = :codigoPostal"),
    @NamedQuery(name = "Direccion.findByPais", query = "SELECT d FROM Direccion d WHERE d.pais = :pais")
})
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "calle")
    private String calle;

    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;

    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;

    @Basic(optional = false)
    @Column(name = "codigo_postal")
    private String codigoPostal;

    @Basic(optional = false)
    @Column(name = "pais")
    private String pais;

    public Direccion() {}

    public Direccion(Long id, String calle, String ciudad, String estado, String codigoPostal, String pais) {
        this.id = id;
        this.calle = calle;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
    }

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
        return "Direccion [id=" + id + ", calle=" + calle + ", ciudad=" + ciudad + ", estado=" + estado + ", codigoPostal=" + codigoPostal + ", pais=" + pais + "]";
    }
}
