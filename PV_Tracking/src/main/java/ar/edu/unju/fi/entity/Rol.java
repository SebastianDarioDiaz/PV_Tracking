/**
 * 
 */
package ar.edu.unju.fi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
@Entity
@Component
@Table(name = "ROLES")
public class Rol implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * se asocia a la clave primaria de un registro
	 * en la tabla roles
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROL")
	private Long id;
	/**
	 * Representa un tipo específico de rol
	 */
	@Column(name = "TIPO_ROL", length = 20, nullable = true)
	private String tipoRol;
	/**
	 * Representa una descripción del rol especificado
	 */
	@Column(name = "DESCRIPCION_ROL",length = 220, nullable = true)
	private String descripcionRol;
	
	@ManyToOne()
	private Usuario usuario;
	

	public Rol() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param tipoRol
	 * @param descripcionRol
	 */
	public Rol(Long id, String tipoRol, String descripcionRol) {
		this.id = id;
		this.tipoRol = tipoRol;
		this.descripcionRol = descripcionRol;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the tipoRol
	 */
	public String getTipoRol() {
		return tipoRol;
	}

	/**
	 * @param tipoRol the tipoRol to set
	 */
	public void setTipoRol(String tipoRol) {
		this.tipoRol = tipoRol;
	}

	/**
	 * @return the descripcionRol
	 */
	public String getDescripcionRol() {
		return descripcionRol;
	}

	/**
	 * @param descripcionRol the descripcionRol to set
	 */
	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", tipoRol=" + tipoRol + ", descripcionRol=" + descripcionRol + "]";
	} 
	
}
