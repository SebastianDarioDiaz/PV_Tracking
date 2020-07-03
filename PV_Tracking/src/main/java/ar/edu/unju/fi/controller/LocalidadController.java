package ar.edu.unju.fi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.entity.Localidad;
import ar.edu.unju.fi.service.ILocalidadService;




@Controller
@RequestMapping
public class LocalidadController {
	
	@Autowired
	ILocalidadService localidadService;
	
	
	@Autowired
	private Localidad localidad;
	
	@RequestMapping("/localidad")
	public String getLocalidadform(Model model) {
		
		return "/";
	}
	
	
	@GetMapping("/nuevaLocalidad")
	public String agregar(Model model) {
		model.addAttribute("localidad", localidad);
		return "localidadForm";
	}
	
	



//agregar
	@GetMapping("/formulario")
	public String cargarFormulario(Model model) {
		model.addAttribute("localidadForm", new Localidad());
		model.addAttribute("listaLocalidad", localidadService.obtenerLocalidades());
		model.addAttribute("formTab", "active");
		return "localidadForm";
	}
	
	@PostMapping("/formulario")
	public String crearLocalidad(@Valid @ModelAttribute("localidadForm")Localidad localidad,BindingResult result, ModelMap model) {
		//agregado valid(tambien en el modelo)y BindingResult 
		if(result.hasErrors()) {
			//si tira error se vuelve a la vista anteriro
			model .addAttribute("localidadForm", localidad);
			model.addAttribute("formTab", "active");
			model.addAttribute("listaLocalidades", localidadService.obtenerLocalidades());
		}else {
		try {
			localidadService.guardarLocalidad();
			model.addAttribute("localidadForm", new Localidad());
			model.addAttribute("listTab", "active");
		}catch (Exception e) {
			//pasar excepciones al html
			model.addAttribute("formLocalidadErrorMessage", e.getMessage());
			model.addAttribute("localidadForm",localidad);
			model.addAttribute("listaLocalidades", localidadService.obtenerLocalidades());
			model.addAttribute("formTab", "active");
			
		}
	
	}
		return "localidadForm";
}
	@GetMapping("/formulario/cancelar")
	public String cancelarEditarLocalidad(ModelMap model) {
		
		return "redirect:/formulario";
	}
	
	//modificar
	/*
	@GetMapping("/modificarLocalidad/{id}")
	public String obtenerFormularioModificarLocalidad(Model model,@PathVariable(name="id") Long id) throws Exception{
		try {
			Localidad localidadModificado = localidadService.guardarLocalidad();// aqui va lo creado en localidad serviceimp y service
			model.addAttribute("localidadForm", localidadModificado);
			model.addAttribute("editMode", "true");
		}catch (Exception e) {
			model.addAttribute("formLocalidadErrorMessage", e.getMessage());
			model.addAttribute("LocalidadForm", localidad);
			model.addAttribute("editMode", "false");
		}
		model.addAttribute("listalocalidades", localidadService.obtenerLocalidades());
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
				localidadService.modificar(localidad);  // aqui va lo creado en localidad serviceimp y service
				model.addAttribute("localidadForm", localidad);
				model.addAttribute("listTab", "active");
				model.addAttribute("editMode", "false");		
			} catch (Exception e) {
				model.addAttribute("formLocalidadErrorMessage", e.getMessage());
				model.addAttribute("localidadForm",localidad);
				model.addAttribute("listaLocalidades", localidadService.obtenerLocalidades());
				model.addAttribute("editMode", "active");
				
			}
		}
		
		model.addAttribute("listaLocalidades", localidadService.obtenerLocalidades());
		
		
		return "LocalidadForm";
	}*/
	
	// eliminar 
	
	@GetMapping("/eliminarLocalidad/{id}")
	public String eliminarLocalidad(Model model, @PathVariable(name="id") long id ) {
		try {
			localidadService.eliminarLocalidad();
		}catch(Exception e) {
			model.addAttribute("listErrorMessage",e.getMessage());
		}
		return cargarFormulario(model);
		
	}
}
