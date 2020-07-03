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

	void guardarRegistroTracking();
	void eliminarRegistroTracking();
	Optional<RegistroTracking> obtenerRegistroTracking();
	List<RegistroTracking> obtenerRegistroTrackings();
	
}
