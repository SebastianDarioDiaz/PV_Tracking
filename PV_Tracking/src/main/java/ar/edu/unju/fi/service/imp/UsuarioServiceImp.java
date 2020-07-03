/**
 * 
 */
package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.service.IUsuarioService;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
@Service
public class UsuarioServiceImp implements IUsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepository;
	@Autowired
	private Usuario usuario;
	
	@Override
	public void guardarUsuario() {
		// TODO Auto-generated method stub
		usuarioRepository.save(usuario);
	}

	@Override
	public void eliminarUsuario() {
		// TODO Auto-generated method stub
		usuarioRepository.delete(usuario);
	}

	@Override
	public Optional<Usuario> obtenerUsuario() {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(usuario.getIdUsuario());
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

}
