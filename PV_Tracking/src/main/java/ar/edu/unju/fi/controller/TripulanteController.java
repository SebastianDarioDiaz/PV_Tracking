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

import ar.edu.unju.fi.entity.Tripulante;
import ar.edu.unju.fi.service.ITripulanteService;

public class TripulanteController {
	
	
	@Autowired
	ITripulanteService tripulanteService;
	
	
	@Autowired
	private Tripulante tripulante;
	
	@RequestMapping("/tripulante")
	public String getTripulanteform(Model model) {
		
		return "/";
	}
	
	
	@GetMapping("/nuevoTripulante")
	public String agregar(Model model) {
		model.addAttribute("tripulante", tripulante);
		return "tripulanteForm";
	}
	
	



//agregar
	@GetMapping("/formulario-4")
	public String cargarFormulario(Model model) {
		model.addAttribute("tripulanteForm", new Tripulante());
		model.addAttribute("listaTripulante", tripulanteService.obtenerTripulantes());
		model.addAttribute("formTab", "active");
		return "tripulanteForm";
	}
	
	@PostMapping("/formulario-4")
	public String crearTripulante(@Valid @ModelAttribute("tripulanteForm")Tripulante tripulante,BindingResult result, ModelMap model) {
		//agregado valid(tambien en el modelo)y BindingResult 
		if(result.hasErrors()) {
			//si tira error se vuelve a la vista anterior
			model .addAttribute("tripulanteForm", tripulante);
			model.addAttribute("formTab", "active");
			model.addAttribute("listaTripulantes", tripulanteService.obtenerTripulantes());
		}else {
		try {
			tripulanteService.guardarTripulante();
			model.addAttribute("tripulanteForm", new Tripulante());
			model.addAttribute("listTab", "active");
		}catch (Exception e) {
			//pasar excepciones al html
			model.addAttribute("formTripulanteErrorMessage", e.getMessage());
			model.addAttribute("tripulanteForm",tripulante);
			model.addAttribute("listaTripulantes",tripulanteService.obtenerTripulantes());
			model.addAttribute("formTab", "active");
			
		}
	
	}
		return "tripulanteForm";
}
	@GetMapping("/formulario-4/cancelar")
	public String cancelarEditarTripulante(ModelMap model) {
		
		return "redirect:/formulario-4";
	}
	
	//modificar
	/*
	@GetMapping("/modificarTripulante/{id}")
	public String obtenerFormularioModificarTripulante(Model model,@PathVariable(name="id") Long id) throws Exception{
		try {
			Tripulante tripulanteModificado = tripulanteService.guardarTripulante();// aqui va lo creado en localidad serviceimp y service
			model.addAttribute("tripulanteForm", tripulanteModificado);
			model.addAttribute("editMode", "true");
		}catch (Exception e) {
			model.addAttribute("formTripulanteErrorMessage", e.getMessage());
			model.addAttribute("TripulanteForm", tripulante);
			model.addAttribute("editMode", "false");
		}
		model.addAttribute("listatripulantes", tripulanteService.obtenerTripulantes());
		model.addAttribute("formTab", "active");
		
	return "tripulanteForm";
	}
	
	@PostMapping("/modificarTripulante")
	public String postModificarTripulante(@Valid @ModelAttribute("tripulanteForm") Tripulante tripulante, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			//si da error el objeto recibido se vuelve a enviar a la vista
			model.addAttribute("tripulanteForm", tripulante);
			model.addAttribute("formTab", "active");
			model.addAttribute("editMode", "true");
		}else {
			try {
				localidadService.modificar(tripulante);  // aqui va lo creado en localidad serviceimp y service
				model.addAttribute("tripulanteForm", tripulante);
				model.addAttribute("listTab", "active");
				model.addAttribute("editMode", "false");		
			} catch (Exception e) {
				model.addAttribute("formTripulanteErrorMessage", e.getMessage());
				model.addAttribute("tripulanteForm",tripulante);
				model.addAttribute("listaTripulantes", tripulanteService.obtenerTripulantes());
				model.addAttribute("editMode", "active");
				
			}
		}
		
		model.addAttribute("listaTripulante", tripulanteService.obtenerTripulantes());
		
		
		return "TripulanteForm";
	}*/
	
	// eliminar 
	
	@GetMapping("/eliminarTripulante/{id}")
	public String eliminarTripulante(Model model, @PathVariable(name="id") long id ) {
		try {
			tripulanteService.eliminarTripulante();
		}catch(Exception e) {
			model.addAttribute("listErrorMessage",e.getMessage());
		}
		return cargarFormulario(model);
		
	}

}
