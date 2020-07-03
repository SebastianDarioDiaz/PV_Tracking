/**
 * 
 */
package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.entity.Rol;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
public interface IRolService {

	void eliminarRol();
	void guardarRol();
	Optional<Rol> obtenerRol();
	List<Rol> obtenerRoles();
}
