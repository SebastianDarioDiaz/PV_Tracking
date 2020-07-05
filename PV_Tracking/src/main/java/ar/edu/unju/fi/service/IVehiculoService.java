/**
 * 
 */
package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.entity.Vehiculo;


/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
public interface IVehiculoService {

	void guardarVehiculo(Vehiculo vehiculo);
	void eliminarVehiculo();
	Optional<Vehiculo> obtenerVehiculo();
	List<Vehiculo> obtenerVehiculos();
	
}
