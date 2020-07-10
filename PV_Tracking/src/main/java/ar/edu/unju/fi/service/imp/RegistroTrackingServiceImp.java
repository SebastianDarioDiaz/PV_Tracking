/**
 * 
 */
package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.RegistroTracking;
import ar.edu.unju.fi.repository.IRegistroTrackingRepository;
import ar.edu.unju.fi.service.IRegistroTrackingService;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
@Service
public class RegistroTrackingServiceImp implements IRegistroTrackingService {

	@Autowired
	private IRegistroTrackingRepository registroTrackingRepository;
	@Autowired
	private RegistroTracking registroTracking;
	
	@Override
	public void guardarRegistroTracking(RegistroTracking tracking) {
		// TODO Auto-generated method stub
		registroTrackingRepository.save(tracking);
	}

	@Override
	public void eliminarRegistroTracking(RegistroTracking tracking) {
		// TODO Auto-generated method stub
		registroTrackingRepository.delete(tracking);

	}

	@Override
	public Optional<RegistroTracking> obtenerRegistroTracking() {
		// TODO Auto-generated method stub
		return registroTrackingRepository.findById(registroTracking.getIdRegitroT());
	}

	@Override
	public List<RegistroTracking> obtenerRegistroTrackings() {
		// TODO Auto-generated method stub
		return registroTrackingRepository.findAll();
	}

	@Override
	public RegistroTracking buscarRegistroT(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<RegistroTracking> listarRegistros() {
		// TODO Auto-generated method stub
		return registroTrackingRepository.findAll();
	}

}
