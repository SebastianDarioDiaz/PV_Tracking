/**
 * 
 */
package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.entity.Tripulante;


/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
public interface ITripulanteService {

	void guardarTripulante();
	void eliminarTripulante();
	Optional<Tripulante> obtenerTripulante();
	List<Tripulante> obtenerTripulantes();
}
