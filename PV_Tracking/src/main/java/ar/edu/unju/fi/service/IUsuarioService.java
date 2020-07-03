/**
 * 
 */
package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.entity.Usuario;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
public interface IUsuarioService {

	void guardarUsuario();
	void eliminarUsuario();
	Optional<Usuario> obtenerUsuario();
	List<Usuario> obtenerUsuarios();
	
}
