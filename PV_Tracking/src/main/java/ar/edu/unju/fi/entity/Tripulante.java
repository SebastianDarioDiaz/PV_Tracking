/**
 * 
 */
package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
@Component
@Entity
@Table(name = "TRIPULANTES")
public class Tripulante implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idTripulante;
	
	@Column(name= "DNI_TRIPULANTE", length = 150, nullable = true)
	private String documentoTripulante;
	
	@Column(name= "NOMBRES_TRIPULANTE", length = 150, nullable = true)
	private String nombresTripulante;
	
	@Column(name= "APELLIDO_TRIPULANTE", length = 150, nullable = true)
	private String apellidoTripulante;
	
	@Column(name= "NACIONALIDAD_TRIPULANTE", length = 150, nullable = true)
	private String nacionalidadTripulante;
	
	@Autowired
	@ManyToMany(mappedBy = "tripulantes")
	private List<RegistroTracking> registros = new ArrayList<RegistroTracking>();
			
			
			
	public Tripulante() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param documentoTripulante
	 * @param nombresTripulante
	 * @param apellidoTripulante
	 * @param nacionalidadTripulante
	 */
	public Tripulante(String documentoTripulante, String nombresTripulante, String apellidoTripulante,
			String nacionalidadTripulante) {
		this.documentoTripulante = documentoTripulante;
		this.nombresTripulante = nombresTripulante;
		this.apellidoTripulante = apellidoTripulante;
		this.nacionalidadTripulante = nacionalidadTripulante;
	}



	/**
	 * @return the idTripulante
	 */
	public Long getIdTripulante() {
		return idTripulante;
	}

	/**
	 * @param idTripulante the idTripulante to set
	 */
	public void setIdTripulante(Long idTripulante) {
		this.idTripulante = idTripulante;
	}

	/**
	 * @return the documentoTripulante
	 */
	public String getDocumentoTripulante() {
		return documentoTripulante;
	}

	/**
	 * @param documentoTripulante the documentoTripulante to set
	 */
	public void setDocumentoTripulante(String documentoTripulante) {
		this.documentoTripulante = documentoTripulante;
	}

	/**
	 * @return the nombresTripulante
	 */
	public String getNombresTripulante() {
		return nombresTripulante;
	}

	/**
	 * @param nombresTripulante the nombresTripulante to set
	 */
	public void setNombresTripulante(String nombresTripulante) {
		this.nombresTripulante = nombresTripulante;
	}

	/**
	 * @return the apellidoTripulante
	 */
	public String getApellidoTripulante() {
		return apellidoTripulante;
	}

	/**
	 * @param apellidoTripulante the apellidoTripulante to set
	 */
	public void setApellidoTripulante(String apellidoTripulante) {
		this.apellidoTripulante = apellidoTripulante;
	}

	/**
	 * @return the nacionalidadTripulante
	 */
	public String getNacionalidadTripulante() {
		return nacionalidadTripulante;
	}

	/**
	 * @param nacionalidadTripulante the nacionalidadTripulante to set
	 */
	public void setNacionalidadTripulante(String nacionalidadTripulante) {
		this.nacionalidadTripulante = nacionalidadTripulante;
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
		return "Tripulante [idTripulante=" + idTripulante + ", documentoTripulante=" + documentoTripulante
				+ ", nombresTripulante=" + nombresTripulante + ", apellidoTripulante=" + apellidoTripulante
				+ ", nacionalidadTripulante=" + nacionalidadTripulante + "]";
	}
	

}
