/**
 * 
 */
package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.springframework.stereotype.Component;


/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
@Component
@Entity
@Table(name = "REGISTROTRACKING")
public class RegistroTracking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_AUTO")
	private Long idRegitroT;
	
	@Column(name = "RT_FECHA")
	private LocalDateTime fechaHora;
	
	@Column(name = "RT_NOMBRE")
	private String detalleLugarRegistro;
	

	@ManyToMany
	@JoinTable(name = "REGISTROS_TRIPULANTES",joinColumns = @JoinColumn(name  = "ID_REGISTRO"), inverseJoinColumns = @JoinColumn(name =  "ID_TRIPULANTE") )
	private List<Tripulante> tripulantes = new ArrayList<Tripulante>();
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_VEHICULO")
	private Vehiculo vehiculo;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_LOCALIDAD")
	private Localidad localidad;
	
	public RegistroTracking() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param fechaHora
	 * @param detalleLugarRegistro
	 * @param tripulantes
	 * @param vehiculo
	 * @param localidad
	 */
	public RegistroTracking(LocalDateTime fechaHora, String detalleLugarRegistro, List<Tripulante> tripulantes,
			Vehiculo vehiculo, Localidad localidad) {
		this.fechaHora = fechaHora;
		this.detalleLugarRegistro = detalleLugarRegistro;
		this.tripulantes = tripulantes;
		this.vehiculo = vehiculo;
		this.localidad = localidad;
	}

	/**
	 * @return the idRegitroT
	 */
	public Long getIdRegitroT() {
		return idRegitroT;
	}

	/**
	 * @param idRegitroT the idRegitroT to set
	 */
	public void setIdRegitroT(Long idRegitroT) {
		this.idRegitroT = idRegitroT;
	}

	/**
	 * @return the fechaHora
	 */
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return the detalleLugarRegistro
	 */
	public String getDetalleLugarRegistro() {
		return detalleLugarRegistro;
	}

	/**
	 * @param detalleLugarRegistro the detalleLugarRegistro to set
	 */
	public void setDetalleLugarRegistro(String detalleLugarRegistro) {
		this.detalleLugarRegistro = detalleLugarRegistro;
	}

	/**
	 * @return the tripulantes
	 */
	public List<Tripulante> getTripulantes() {
		return tripulantes;
	}

	/**
	 * @param tripulantes the tripulantes to set
	 */
	public void setTripulantes(List<Tripulante> tripulantes) {
		this.tripulantes = tripulantes;
	}

	/**
	 * @return the vehiculo
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	/**
	 * @param vehiculo the vehiculo to set
	 */
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	/**
	 * @return the localidad
	 */
	public Localidad getLocalidad() {
		return localidad;
	}

	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}



	@Override
	public String toString() {
		return "RegistroTracking [idRegitroT=" + idRegitroT + ", fechaHora=" + fechaHora + ", detalleLugarRegistro="
				+ detalleLugarRegistro + ", tripulantes=" + tripulantes + ", vehiculo=" + vehiculo + ", localidad="
				+ localidad + "]";
	}	

}
