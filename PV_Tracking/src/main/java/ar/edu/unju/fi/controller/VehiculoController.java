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

import ar.edu.unju.fi.entity.Vehiculo;
import ar.edu.unju.fi.service.IVehiculoService;

public class VehiculoController {
	
	
	
	@Autowired
	IVehiculoService vehiculoService;
	
	
	@Autowired
	private Vehiculo vehiculo;
	
	@RequestMapping("/vehiculo")
	public String getVehiculoform(Model model) {
		
		return "/";
	}
	
	
	@GetMapping("/nuevaVehiculo")
	public String agregar(Model model) {
		model.addAttribute("vehiculo", vehiculo);
		return "vehiculoForm";
	}
	
	



//agregar
	@GetMapping("/formulario-6")
	public String cargarFormulario(Model model) {
		model.addAttribute("vehiculoForm", new Vehiculo());
		model.addAttribute("listaVehiculo", vehiculoService.obtenerVehiculos());
		model.addAttribute("formTab", "active");
		return "vehiculoForm";
	}
	
	

	
	
	@PostMapping("/formulario-6")
	public String crearVehiculo(@Valid @ModelAttribute("vehiculoForm")Vehiculo vehiculo,BindingResult result, ModelMap model) {
		//agregado valid(tambien en el modelo)y BindingResult 
		if(result.hasErrors()) {
			//si tira error se vuelve a la vista anteriro
			model .addAttribute("vehiculoForm", vehiculo);
			model.addAttribute("formTab", "active");
			model.addAttribute("listaVehiculos", vehiculoService.obtenerVehiculos());
		}else {
		try {
			vehiculoService.guardarVehiculo(new Vehiculo());
			model.addAttribute("vehiculoForm", new Vehiculo());
			model.addAttribute("listTab", "active");
		}catch (Exception e) {
			//pasar excepciones al html
			model.addAttribute("formVehiculoErrorMessage", e.getMessage());
			model.addAttribute("vehiculoForm",vehiculo);
			model.addAttribute("listaVehiculos", vehiculoService.obtenerVehiculos());
			model.addAttribute("formTab", "active");
			
		}
	
	}
		return "vehiculoForm";
}
	@GetMapping("/formulario-6/cancelar")
	public String cancelarEditarVehiculo(ModelMap model) {
		
		return "redirect:/formulario-6";
	}
	
	//modificar
	/*
	@GetMapping("/modificarVehiculo/{id}")
	public String obtenerFormularioModificarVehiculo(Model model,@PathVariable(name="id") Long id) throws Exception{
		try {
			Vehiculo vehiculoModificado = vehiculoService.guardarVehiculo();// aqui va lo creado en localidad serviceimp y service
			model.addAttribute("vehiculoForm", vehiculoModificado);
			model.addAttribute("editMode", "true");
		}catch (Exception e) {
			model.addAttribute("formVehiculoErrorMessage", e.getMessage());
			model.addAttribute("VehiculoForm", vehiculo);
			model.addAttribute("editMode", "false");
		}
		model.addAttribute("listavehiculos", vehiculoService.obtenerVehiculos());
		model.addAttribute("formTab", "active");
		
	return "vehiculoForm";
	}
	
	@PostMapping("/modificarVehiculo")
	public String postModificarVehiculo(@Valid @ModelAttribute("vehiculoForm") Vehiculo vehiculo, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			//si da error el objeto recibido se vuelve a enviar a la vista
			model.addAttribute("vehiculoForm", vehiculo);
			model.addAttribute("formTab", "active");
			model.addAttribute("editMode", "true");
		}else {
			try {
				localidadService.modificar(vehiculo);  // aqui va lo creado en localidad serviceimp y service
				model.addAttribute("vehiculoForm", vehiculo);
				model.addAttribute("listTab", "active");
				model.addAttribute("editMode", "false");		
			} catch (Exception e) {
				model.addAttribute("formVehiculoErrorMessage", e.getMessage());
				model.addAttribute("vehiculoForm",vehiculo);
				model.addAttribute("listaVehiculos", vehiculoService.obtenerVehiculos());
				model.addAttribute("editMode", "active");
				
			}
		}
		
		model.addAttribute("listaVehiculos", vehiculoService.obtenerVehiculos());
		
		
		return "VehiculoForm";
	}*/
	
	// eliminar 
	
	@GetMapping("/eliminarVehiculo/{id}")
	public String eliminarVehiculo(Model model, @PathVariable(name="id") long id ) {
		try {
			vehiculoService.eliminarVehiculo();
		}catch(Exception e) {
			model.addAttribute("listErrorMessage",e.getMessage());
		}
		return cargarFormulario(model);
		
	}

}
