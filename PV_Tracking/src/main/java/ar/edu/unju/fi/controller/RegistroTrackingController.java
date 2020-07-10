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

import ar.edu.unju.fi.entity.RegistroTracking;
import ar.edu.unju.fi.service.IRegistroTrackingService;

public class RegistroTrackingController {
	/*
	 * @Controller
	 * 
	 * @RequestMapping public class LocalidadController {
	 * 
	 * @Autowired private IRegistroTrackingService registroTrackingService;
	 * 
	 * 
	 * @Autowired private RegistroTracking registroTracking;
	 * 
	 * @RequestMapping("/registroTracking") public String
	 * getRegistroTrackingform(Model model) {
	 * 
	 * return "/"; }
	 * 
	 * 
	 * @GetMapping("/nuevaLocalidad") public String agregar(Model model) {
	 * model.addAttribute("registroTracking", registroTracking); return
	 * "registroTrackingForm"; }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //agregar
	 * 
	 * @GetMapping("/formulario-2") public String cargarFormulario(Model model) {
	 * model.addAttribute("registroTrackingForm", new RegistroTracking());
	 * model.addAttribute("listaRegistroTracking",
	 * registroTrackingService.obtenerRegistroTrackings());
	 * model.addAttribute("formTab", "active"); return "registroTrackingForm"; }
	 * 
	 * @PostMapping("/formulario-2") public String
	 * crearRegistroTracking(@Valid @ModelAttribute("registroTrackingForm")
	 * RegistroTracking registroTracking,BindingResult result, ModelMap model) {
	 * //agregado valid(tambien en el modelo)y BindingResult if(result.hasErrors())
	 * { //si tira error se vuelve a la vista anteriro model
	 * .addAttribute("registroTrackingForm", registroTracking);
	 * model.addAttribute("formTab", "active");
	 * model.addAttribute("listaRegistroTracking",
	 * registroTrackingService.obtenerRegistroTrackings()); }else { try {
	 * registroTrackingService.guardarRegistroTracking(registroTracking);
	 * model.addAttribute("registroTrackingForm", new RegistroTracking());
	 * model.addAttribute("listTab", "active"); }catch (Exception e) { //pasar
	 * excepciones al html model.addAttribute("formLocalidadErrorMessage",
	 * e.getMessage()); model.addAttribute("registroTrackingForm",registroTracking);
	 * model.addAttribute("registroTracking",
	 * registroTrackingService.obtenerRegistroTrackings());
	 * model.addAttribute("formTab", "active");
	 * 
	 * }
	 * 
	 * } return "registroTrackingForm"; }
	 * 
	 * @GetMapping("/formulario-2/cancelar") public String
	 * cancelarEditarRegistroTracking(ModelMap model) {
	 * 
	 * return "redirect:/formulario-2"; }
	 * 
	 * //modificar
	 * 
	 * @GetMapping("/modificarRegistroTracking/{id}") public String
	 * obtenerFormularioModificarRegistroTracking(Model
	 * model,@PathVariable(name="id") Long id) throws Exception{ try {
	 * RegistroTracking registroTrackingModificado =
	 * registroTrackingService.guardarRegistroTracking();// aqui va lo creado en
	 * localidad serviceimp y service model.addAttribute("registroTrackingForm",
	 * registroTrackingModificado); model.addAttribute("editMode", "true"); }catch
	 * (Exception e) { model.addAttribute("formRegistroTrackingErrorMessage",
	 * e.getMessage()); model.addAttribute("RegistroTrackingForm",
	 * registroTracking); model.addAttribute("editMode", "false"); }
	 * model.addAttribute("listaRegistroTrackings",
	 * registroTrackingService.obtenerRegistroTrackings());
	 * model.addAttribute("formTab", "active");
	 * 
	 * return "registroTrackingForm"; }
	 * 
	 * @PostMapping("/modificarRegistroTracking") public String
	 * postModificarRegistroTracking(@Valid @ModelAttribute("registroTrackingForm")
	 * RegistroTracking registroTracking, BindingResult result, ModelMap model) {
	 * if(result.hasErrors()) { //si da error el objeto recibido se vuelve a enviar
	 * a la vista model.addAttribute("registroTrackingForm", registroTracking);
	 * model.addAttribute("formTab", "active"); model.addAttribute("editMode",
	 * "true"); }else { try { registroTrackingService.modificar(registroTracking);
	 * // aqui va lo creado en localidad serviceimp y service
	 * model.addAttribute("registroTrackingForm", registroTracking);
	 * model.addAttribute("listTab", "active"); model.addAttribute("editMode",
	 * "false"); } catch (Exception e) {
	 * model.addAttribute("formRegistroTrackingErrorMessage", e.getMessage());
	 * model.addAttribute("registroTrackingForm",registroTracking);
	 * model.addAttribute("listaRegistroTrackings",
	 * registroTrackingService.obtenerRegistroTrackings());
	 * model.addAttribute("editMode", "active");
	 * 
	 * } }
	 * 
	 * model.addAttribute("listaRegistroTrackings",
	 * registroTrackingService.obtenerRegistroTrackings());
	 * 
	 * 
	 * return "RegistroTrackingForm"; }
	 * 
	 * // eliminar
	 * 
	 * @GetMapping("/eliminarRegistroTracking/{id}") public String
	 * eliminarRegistroTracking(Model model, @PathVariable(name="id") long id ) {
	 * try { registroTrackingService.eliminarRegistroTracking(registroTracking);
	 * }catch(Exception e) { model.addAttribute("listErrorMessage",e.getMessage());
	 * } return cargarFormulario(model);
	 * 
	 * } }
	 */

}
