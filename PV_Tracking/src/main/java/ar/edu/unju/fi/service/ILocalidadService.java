/**
 * 
 */
package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.entity.Localidad;


/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
public interface ILocalidadService {

	void guardarLocalidad();
	void eliminarLocalidad();
	Optional<Localidad> obtenerLocalidad();
	List<Localidad> obtenerLocalidades();
}
