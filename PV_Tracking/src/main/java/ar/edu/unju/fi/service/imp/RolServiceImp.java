/**
 * 
 */
package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Rol;
import ar.edu.unju.fi.repository.IRolRepository;
import ar.edu.unju.fi.service.IRolService;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
@Service
public class RolServiceImp implements IRolService {

	
	@Autowired
	private IRolRepository rolRepository;
	@Autowired
	private Rol rol;
	
	@Override
	public void eliminarRol() {
		// TODO Auto-generated method stub
		rolRepository.delete(rol);
		
	}

	@Override
	public void guardarRol() {
		// TODO Auto-generated method stub
		rolRepository.save(rol);
		
	}

	@Override
	public Optional<Rol> obtenerRol() {
		// TODO Auto-generated method stub
		return rolRepository.findById(rol.getId());
	}

	@Override
	public List<Rol> obtenerRoles() {
		// TODO Auto-generated method stub
		return rolRepository.findAll();
	}

}
