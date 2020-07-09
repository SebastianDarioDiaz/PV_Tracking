/**
 * 
 */
package ar.edu.unju.fi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.entity.Localidad;
import ar.edu.unju.fi.entity.RegistroTracking;
import ar.edu.unju.fi.entity.Vehiculo;
import ar.edu.unju.fi.service.ILocalidadService;
import ar.edu.unju.fi.service.IRegistroTrackingService;
import ar.edu.unju.fi.service.ITripulanteService;
import ar.edu.unju.fi.service.IVehiculoService;


/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
@Controller
public class MainController {
	
	@Autowired
	private IRegistroTrackingService trackingService;

	@Autowired
	private ILocalidadService localidadService;
	
	@Autowired
	private ITripulanteService tripulanteService;
	
	
	@Autowired
	private Localidad localidad;
	
	@Autowired
	private IVehiculoService vehiculoService;
	
	@Autowired
	private RegistroTracking nuevotracking;
	
	
	
	@RequestMapping("/home")
	public String main(Model model) {
		
		return "index";
	}
	
	@GetMapping({"/","/login"})
	public String ingresar(Model model) {
		return "index";
	}
	///USUARIO///
	//METODO REDIRECCIONA EL HOME DEL LOCALHOST/usuarios A /usuarioFormTest.html
		@GetMapping("/usuarios")
		public String abrirF(Model model) {
			return "usuarioFormTest";
		}
		
		
		
	///LOCALIDAD///
		@GetMapping("/localidades")
		public String cargarFormLocalidad(Model model) {
			model.addAttribute("nuevaLocalidad", new Localidad());
			model.addAttribute("localidades", localidadService.listarLocalidades());
			model.addAttribute("formTab","active");
			return "formLocalidad";
		}
		
		@PostMapping("/localidades")
		public String gestionarLocalidad(@ModelAttribute ("nuevaLocalidad") Localidad localidad, ModelMap model) {	
			//AGREGAR
			localidadService.guardarLocalidad(localidad);
			model.addAttribute("nuevaLocalidad", new Localidad());
			
			//LISTAR
			model.addAttribute("localidades", localidadService.listarLocalidades());
			model.addAttribute("listTab","active");
			return "formLocalidad";
		}
		

	@GetMapping({"/indexTest"})
	public String ingresarTest(Model model) {
		model.addAttribute("vehiculo", new Vehiculo());
		return "indexTest";
	}
	
	
	
	@PostMapping("/altaVehiculo")
	public String altaVehiculo(@ModelAttribute("vehiculo") Vehiculo vehiculo, Model model) throws Exception{
		try {
			vehiculoService.guardarVehiculo(vehiculo);
			model.addAttribute("vehiculo", new Vehiculo());
		}
		catch (Exception e) {
			model.addAttribute("formAltaVehiculoError",e.getMessage());
		}
		return "indexTest";
	}
	
	
	
	///TRACKING///
			@GetMapping("/tracking")
			public String tracking(Model model) {
				model.addAttribute("nuevoTracking", new RegistroTracking());
				model.addAttribute("tripulantes", tripulanteService.obtenerTripulantes());
				model.addAttribute("vehiculo", vehiculoService.obtenerVehiculos());
				model.addAttribute("localidades", localidadService.listarLocalidades());
				model.addAttribute("formTab","active");
				return "tracking";
			}
			
			@PostMapping("/tracking")
			public String gestionarTracking(@ModelAttribute ("nuevaTracking") RegistroTracking tracking, ModelMap model) {	
				//AGREGAR
				trackingService.guardarRegistroTracking(tracking);
				model.addAttribute("nuevoTracking", new RegistroTracking());
				
				
				return "tracking";
			}
	
}
