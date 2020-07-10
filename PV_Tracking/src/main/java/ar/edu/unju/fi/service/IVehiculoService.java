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

	public void guardarVehiculo(Vehiculo vehiculo);
	public void eliminarVehiculo(Long id);
	Optional<Vehiculo> obtenerVehiculo();
	List<Vehiculo> obtenerVehiculos();
	public Vehiculo modificarVehiculo( Vehiculo vehiculo) throws Exception;
	public Vehiculo buscarVehiculo(Long id) throws Exception; 
	public Iterable<Vehiculo> listarVehiculos();
	
}
