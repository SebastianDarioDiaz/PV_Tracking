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
@Table(name = "VEHICULOS")
public class Vehiculo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_AUTO")
	private Long idVehiculo;
	
	@Column(name= "PATENTE", length = 150, nullable = true)
	private String patente;
	
	@Column(name= "COLOR", length = 150, nullable = true)
	private String color;
	
	@Column(name= "TITULAR", length = 150, nullable = true)
	private String titular;
	
	@Column(name= "MARCA", length = 150, nullable = true)
	private String marca;
	
	@Column(name= "MODELO", length = 150, nullable = true)
	private String modelo;
	
	@Column(name= "TIPO", length = 150, nullable = true)
	private String tipo;
	
	@Column(name= "CHASIS", length = 150, nullable = true)
	private String numeroChasis;
	
	@Column(name= "MOTOR", length = 150, nullable = true)
	private String numeroMotor;
	
	

	@OneToMany(mappedBy = "vehiculo")
	private List<RegistroTracking> registros = new ArrayList<RegistroTracking>();
	
	public Vehiculo() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param patente
	 * @param color
	 * @param titular
	 * @param marca
	 * @param modelo
	 * @param tipo
	 * @param numeroChasis
	 * @param numeroMotor
	 */
	public Vehiculo(String patente, String color, String titular, String marca, String modelo, String tipo,
			String numeroChasis, String numeroMotor) {
		this.patente = patente;
		this.color = color;
		this.titular = titular;
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
		this.numeroChasis = numeroChasis;
		this.numeroMotor = numeroMotor;
	}


	/**
	 * @return the idVehiculo
	 */
	public Long getIdVehiculo() {
		return idVehiculo;
	}

	/**
	 * @param idVehiculo the idVehiculo to set
	 */
	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	/**
	 * @return the patente
	 */
	public String getPatente() {
		return patente;
	}

	/**
	 * @param patente the patente to set
	 */
	public void setPatente(String patente) {
		this.patente = patente;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the titular
	 */
	public String getTitular() {
		return titular;
	}

	/**
	 * @param titular the titular to set
	 */
	public void setTitular(String titular) {
		this.titular = titular;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the numeroChasis
	 */
	public String getNumeroChasis() {
		return numeroChasis;
	}

	/**
	 * @param numeroChasis the numeroChasis to set
	 */
	public void setNumeroChasis(String numeroChasis) {
		this.numeroChasis = numeroChasis;
	}

	/**
	 * @return the numeroMotor
	 */
	public String getNumeroMotor() {
		return numeroMotor;
	}

	/**
	 * @param numeroMotor the numeroMotor to set
	 */
	public void setNumeroMotor(String numeroMotor) {
		this.numeroMotor = numeroMotor;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
		return "Vehiculo [idVehiculo=" + idVehiculo + ", patente=" + patente + ", color=" + color + ", titular="
				+ titular + ", marca=" + marca + ", modelo=" + modelo + ", tipo=" + tipo + ", numeroChasis="
				+ numeroChasis + ", numeroMotor=" + numeroMotor + "]";
	}
	
	

}
