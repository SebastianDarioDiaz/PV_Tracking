/**
 * 
 */
package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Tripulante;
import ar.edu.unju.fi.repository.ITripulanteRepository;
import ar.edu.unju.fi.service.ITripulanteService;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
@Service
public class TripulanteServiceImp implements ITripulanteService {

	@Autowired
	private ITripulanteRepository tripulanteRepository;
	@Autowired
	private Tripulante tripulante;
	
	@Override
	public void guardarTripulante() {
		// TODO Auto-generated method stub
		tripulanteRepository.save(tripulante);
	}

	@Override
	public void eliminarTripulante() {
		// TODO Auto-generated method stub
		tripulanteRepository.delete(tripulante);

	}

	@Override
	public Optional<Tripulante> obtenerTripulante() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tripulante> obtenerTripulantes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Tripulante> listarTripulantes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
