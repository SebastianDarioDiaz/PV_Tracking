/**
 * 
 */
package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Localidad;
import ar.edu.unju.fi.repository.ILocalidadRepository;
import ar.edu.unju.fi.service.ILocalidadService;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
@Service
public class LocalidadServiceImp implements ILocalidadService {

	@Autowired
	private ILocalidadRepository localidadRepository;
	@Autowired
	private Localidad localidad;
	
	@Override
	public void guardarLocalidad() {
		// TODO Auto-generated method stub
		localidadRepository.save(localidad);
	}

	@Override
	public void eliminarLocalidad() {
		// TODO Auto-generated method stub
		localidadRepository.delete(localidad);
		
	}

	@Override
	public Optional<Localidad> obtenerLocalidad() {
		// TODO Auto-generated method stub
		return localidadRepository.findById(localidad.getId());
	}

	@Override
	public List<Localidad> obtenerLocalidades() {
		// TODO Auto-generated method stub
		return localidadRepository.findAll();
	}

}
