/**
 * 
 */
package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import ar.edu.unju.fi.entity.Localidad;


/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
public interface ILocalidadService {

	public void guardarLocalidad(Localidad localidad);
	public void eliminarLocalidad(Long id);
	Optional<Localidad> obtenerLocalidad();
	public Localidad modificarLocalidad(Localidad localidad) throws Exception;
	List<Localidad> obtenerLocalidades();
	public Localidad buscarLocalidad(Long id) throws Exception;
	public Iterable<Localidad> listarLocalidades();
}
