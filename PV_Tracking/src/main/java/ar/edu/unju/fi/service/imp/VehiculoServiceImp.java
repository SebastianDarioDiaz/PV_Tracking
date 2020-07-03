/**
 * 
 */
package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Vehiculo;
import ar.edu.unju.fi.repository.IVehiculoRepository;
import ar.edu.unju.fi.service.IVehiculoService;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
@Service
public class VehiculoServiceImp implements IVehiculoService {

	@Autowired
	private IVehiculoRepository vehiculoRepository;
	@Autowired
	private Vehiculo vehiculo;
	
	@Override
	public void guardarVehiculo() {
		// TODO Auto-generated method stub
		vehiculoRepository.save(vehiculo);

	}

	@Override
	public void eliminarVehiculo() {
		// TODO Auto-generated method stub
		vehiculoRepository.delete(vehiculo);
	}

	@Override
	public Optional<Vehiculo> obtenerVehiculo() {
		// TODO Auto-generated method stub
		return vehiculoRepository.findById(vehiculo.getIdVehiculo());
	}

	@Override
	public List<Vehiculo> obtenerVehiculos() {
		// TODO Auto-generated method stub
		return vehiculoRepository.findAll();
	}

}
