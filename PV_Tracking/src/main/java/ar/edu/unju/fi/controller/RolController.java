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

import ar.edu.unju.fi.entity.Rol;
import ar.edu.unju.fi.service.IRolService;

public class RolController {
	
	@Autowired
	IRolService rolService;
	
	
	@Autowired
	private Rol rol;
	
	@RequestMapping("/rol")
	public String getRolform(Model model) {
		
		return "/";
	}
	
	
	@GetMapping("/nuevoRol")
	public String agregar(Model model) {
		model.addAttribute("rol", rol);
		return "rolForm";
	}
	
	



//agregar
	@GetMapping("/formulario-3")
	public String cargarFormulario(Model model) {
		model.addAttribute("rolForm", new Rol());
		model.addAttribute("listaRoles", rolService.obtenerRoles());
		model.addAttribute("formTab", "active");
		return "rolForm";
	}
	
	@PostMapping("/formulario-3")
	public String crearRol(@Valid @ModelAttribute("rolForm")Rol rol,BindingResult result, ModelMap model) {
		//agregado valid(tambien en el modelo)y BindingResult 
		if(result.hasErrors()) {
			//si tira error se vuelve a la vista anteriro
			model .addAttribute("rolForm", rol);
			model.addAttribute("formTab", "active");
			model.addAttribute("listaRols", rolService.obtenerRoles());
		}else {
		try {
			rolService.guardarRol();
			model.addAttribute("rolForm", new Rol());
			model.addAttribute("listTab", "active");
		}catch (Exception e) {
			//pasar excepciones al html
			model.addAttribute("formRolErrorMessage", e.getMessage());
			model.addAttribute("rolForm",rol);
			model.addAttribute("listaRoles", rolService.obtenerRoles());
			model.addAttribute("formTab", "active");
			
		}
	
	}
		return "localidadForm";
}
	@GetMapping("/formulario-3/cancelar")
	public String cancelarEditarRol(ModelMap model) {
		
		return "redirect:/formulario-2";
	}
	
	//modificar
	/*
	@GetMapping("/modificarRol/{id}")
	public String obtenerFormularioModificarRol(Model model,@PathVariable(name="id") Long id) throws Exception{
		try {
			Rol rolModificado = rolService.guardarRol();// aqui va lo creado en localidad serviceimp y service
			model.addAttribute("rolForm", rolModificado);
			model.addAttribute("editMode", "true");
		}catch (Exception e) {
			model.addAttribute("formLocalidadErrorMessage", e.getMessage());
			model.addAttribute("RolForm",rol);
			model.addAttribute("editMode", "false");
		}
		model.addAttribute("listaRoles", rolService.obtenerRoles());
		model.addAttribute("formTab", "active");
		
	return "localidadForm";
	}
	
	@PostMapping("/modificarLocalidad")
	public String postModificarLocalidad(@Valid @ModelAttribute("localidadForm") Localidad localidad, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			//si da error el objeto recibido se vuelve a enviar a la vista
			model.addAttribute("localidadForm", localidad);
			model.addAttribute("formTab", "active");
			model.addAttribute("editMode", "true");
		}else {
			try {
				rolService.modificar(rol);  // aqui va lo creado en localidad serviceimp y service
				model.addAttribute("localidadForm", rol);
				model.addAttribute("listTab", "active");
				model.addAttribute("editMode", "false");		
			} catch (Exception e) {
				model.addAttribute("formLocalidadErrorMessage", e.getMessage());
				model.addAttribute("localidadForm",rol);
				model.addAttribute("listaRoles", rolService.obtenerRoles());
				model.addAttribute("editMode", "active");
				
			}
		}
		
		model.addAttribute("listaRoles", rolService.obtenerRoles());
		
		
		return "RolForm";
	}*/
	
	// eliminar 
	
	@GetMapping("/eliminarRol/{id}")
	public String eliminarRol(Model model, @PathVariable(name="id") long id ) {
		try {
			rolService.eliminarRol();
		}catch(Exception e) {
			model.addAttribute("listErrorMessage",e.getMessage());
			
		}
		return cargarFormulario(model);
	
	}
	

	
	
	
	

}
