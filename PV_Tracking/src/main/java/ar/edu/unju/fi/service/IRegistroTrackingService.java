/**
 * 
 */
package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.entity.RegistroTracking;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
public interface IRegistroTrackingService {

	public void guardarRegistroTracking(RegistroTracking tracking);
	public void eliminarRegistroTracking(RegistroTracking tracking);
	public RegistroTracking buscarRegistroT(Long id) throws Exception;
	Optional<RegistroTracking> obtenerRegistroTracking();
	List<RegistroTracking> obtenerRegistroTrackings();
	Iterable<RegistroTracking>listarRegistros();
	
}
