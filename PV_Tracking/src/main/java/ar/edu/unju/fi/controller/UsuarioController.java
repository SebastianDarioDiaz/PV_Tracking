package ar.edu.unju.fi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IUsuarioService;

public class UsuarioController {
	
	
	
	@Autowired
	IUsuarioService usuarioService;
	
	
	@Autowired
	private Usuario usuario;
	
	@RequestMapping("/usuario")
	public String getUsuarioform(Model model) {
		
		return "/";
	}
	
	
	@GetMapping("/nuevoUsuario")
	public String agregar(Model model) {
		model.addAttribute("usuario", usuario);
		return "usuarioForm";
	}
	
	



//agregar
	@GetMapping("/formulario-5")
	public String cargarFormulario(Model model) {
		model.addAttribute("usuarioForm", new Usuario());
		model.addAttribute("listaUsuario", usuarioService.obtenerUsuarios());
		model.addAttribute("formTab", "active");
		return "usuarioForm";
	}
	
	@PostMapping("/formulario-5")
	public String crearUsuario(@Valid @ModelAttribute("usuarioForm")Usuario usuario,BindingResult result, ModelMap model) {
		//agregado valid(tambien en el modelo)y BindingResult 
		if(result.hasErrors()) {
			//si tira error se vuelve a la vista anteriro
			model .addAttribute("usuarioForm", usuario);
			model.addAttribute("formTab", "active");
			model.addAttribute("listaUsuarios", usuarioService.obtenerUsuarios());
		}else {
		try {
			usuarioService.guardarUsuario();
			model.addAttribute("usuarioForm", new Usuario());
			model.addAttribute("listTab", "active");
		}catch (Exception e) {
			//pasar excepciones al html
			model.addAttribute("formUsuarioErrorMessage", e.getMessage());
			model.addAttribute("usuarioForm",usuario);
			model.addAttribute("listaUsuarios", usuarioService.obtenerUsuarios());
			model.addAttribute("formTab", "active");
			
		}
	
	}
		return "usuarioForm";
}
	@GetMapping("/formulario-5/cancelar")
	public String cancelarEditarUsuario(ModelMap model) {
		
		return "redirect:/formulario-5";
	}
	
	//modificar
	/*
	@GetMapping("/modificarUsuario/{id}")
	public String obtenerFormularioModificarUsuario(Model model,@PathVariable(name="id") Long id) throws Exception{
		try {
			Localidad usuarioModificado = usuarioService.guardarUsuario();// aqui va lo creado en localidad serviceimp y service
			model.addAttribute("usuarioForm", usuarioModificado);
			model.addAttribute("editMode", "true");
		}catch (Exception e) {
			model.addAttribute("formUsuarioErrorMessage", e.getMessage());
			model.addAttribute("UsuarioForm", usuario);
			model.addAttribute("editMode", "false");
		}
		model.addAttribute("listaUsuarios", usuarioService.obtenerUsuarios());
		model.addAttribute("formTab", "active");
		
	return "usuarioForm";
	}
	
	@PostMapping("/modificarUsuario")
	public String postModificarUsuario(@Valid @ModelAttribute("localidadForm") Usuario usuario, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			//si da error el objeto recibido se vuelve a enviar a la vista
			model.addAttribute("usuarioForm", usuario);
			model.addAttribute("formTab", "active");
			model.addAttribute("editMode", "true");
		}else {
			try {
				localidadService.modificar(usuario);  // aqui va lo creado en localidad serviceimp y service
				model.addAttribute("usuarioForm", usuario);
				model.addAttribute("listTab", "active");
				model.addAttribute("editMode", "false");		
			} catch (Exception e) {
				model.addAttribute("formUsuarioErrorMessage", e.getMessage());
				model.addAttribute("usuarioForm",usuario);
				model.addAttribute("listaUsuarios", usuarioService.obtenerUsuarios());
				model.addAttribute("editMode", "active");
				
			}
		}
		
		model.addAttribute("listaUsuario", usuarioService.obtenerUsuarios());
		
		
		return "UsuarioForm";
	}*/
	
	// eliminar 
	
	@GetMapping("/eliminarUsuario/{id}")
	public String eliminarUsuario(Model model, @PathVariable(name="id") long id ) {
		try {
			usuarioService.eliminarUsuario();
		}catch(Exception e) {
			model.addAttribute("listErrorMessage",e.getMessage());
		}
		return cargarFormulario(model);
		
	}

}
