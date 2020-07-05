/**
 * 
 */
package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.springframework.stereotype.Component;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
@Component
@Entity
@Table(name = "LOCALIDADES")
public class Localidad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_AUTO")
	private Long id;
	
	@Column(name = "NOMBRE_LOCALIDAD")
	private String nombreLocalidad;
	

	@OneToMany(mappedBy = "localidad")
	private List<RegistroTracking> registros = new ArrayList<RegistroTracking>();
	
	public Localidad() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param nombreLocalidad
	 */
	public Localidad(String nombreLocalidad) {
		this.nombreLocalidad = nombreLocalidad;
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
	 * @return the nombreLocalidad
	 */
	public String getNombreLocalidad() {
		return nombreLocalidad;
	}

	/**
	 * @param nombreLocalidad the nombreLocalidad to set
	 */
	public void setNombreLocalidad(String nombreLocalidad) {
		this.nombreLocalidad = nombreLocalidad;
	}
	


	/**
	 * @return the registros
	 */
	public List<RegistroTracking> getRegistros() {
		return registros;
	}


	/**
	 * @param registros the registros to set
	 */
	public void setRegistros(List<RegistroTracking> registros) {
		this.registros = registros;
	}


	@Override
	public String toString() {
		return "Localidad [id=" + id + ", nombreLocalidad=" + nombreLocalidad + "]";
	} 
	
}
