package certus.edu.pe.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "transacciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transacciones.findAll", query = "SELECT f FROM Transacciones f")
    , @NamedQuery(name = "Transacciones.findByIdTransacciones", query = "SELECT f FROM Transacciones f WHERE f.idTransacciones = :idTransacciones")
    , @NamedQuery(name = "Transacciones.findByTipo", query = "SELECT f FROM Transacciones f WHERE f.tipo = :tipo")
    , @NamedQuery(name = "Transacciones.findByFecha", query = "SELECT f FROM Transacciones f WHERE f.fecha = :fecha")
    , @NamedQuery(name = "Transacciones.findByUsuario", query = "SELECT f FROM Transacciones f WHERE f.usuario = :usuario")
    , @NamedQuery(name = "Transacciones.findByHora", query = "SELECT f FROM Transacciones f WHERE f.hora = :hora")})
	




public class Transacciones implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional= false)
	@Column(name= "idTransacciones")
	private Integer idTransacciones;
	
	@Basic(optional= false)
	@Column(name= "tipo")
	private String tipo;
	
	@Basic(optional= false)
	@Column(name= "fecha")
	private String fecha;
	
	@Basic(optional= false)
	@Column(name= "hora")
	private String hora;
	
	@Basic(optional= false)
	@Column(name= "usuario")
	private String usuario;
	
	
	public Transacciones() {
		
	}

	public Transacciones(Integer idTransacciones, String tipo, String fecha, String hora, String usuario) {
		super();
		this.idTransacciones = idTransacciones;
		this.tipo = tipo;
		this.fecha = fecha;
		this.hora = hora;
		this.usuario = usuario;
	}

	public Integer getIdTransacciones() {
		return idTransacciones;
	}

	public void setIdTransacciones(Integer idTransacciones) {
		this.idTransacciones = idTransacciones;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	@Override
	public int hashCode() {
		return Objects.hash(fecha, tipo, idTransacciones, usuario, hora);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacciones other = (Transacciones) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(tipo, other.tipo)
				&& Objects.equals(idTransacciones, other.idTransacciones) && Objects.equals(usuario, other.usuario)
				&& Objects.equals(hora, other.hora);
	}

	@Override
	public String toString() {
		return "certus.edu.pe.modelo.Transacciones[idTransacciones=" + idTransacciones + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
