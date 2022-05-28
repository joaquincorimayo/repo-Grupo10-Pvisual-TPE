package ar.edu.unju.fi.tpe.controller;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import ar.edu.unju.fi.tpe.model.Candidato;
import ar.edu.unju.fi.tpe.service.ICandidatoService;

import ch.qos.logback.classic.Logger;

@Controller
@GetMapping("/candidatos")
public class CandidatosController {

	/* Objetivo: realizar la carga de un nuevo artista */
	
	@Autowired
	@Qualifier("CandidatoServiceImpList")
	private ICandidatoService candidatoService;
	
//	Logger logger = LoggerFactory.getLogger(CandidatosController.class);
	
	@GetMapping("/nuevo")
	public String getFormularioCandidatoNuevoPage(Model model) {
		model.addAttribute("candidato", candidatoService.getCandidato());
//		logger.info(
//				"Method getFormularioCandidatoNuevoPage() - Information: Se envia un objeto Candidato a la pagina nuevo_candidato");
	return "nuevo_candidato"
	}
	
	@PostMapping ("/guardar")
	public ModelAndView getListaCandidatoPage(@Validated @ModelAttribute("candidato") Candidato candidato, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView()"nuevo_candidato";
			mav.addObject("candidato", candidato);
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("lista_candidatos")
				
//		if(candidatoService.guardarCandidato(candidato)) {
//			logger.info("Method: getListaAlumnoPage() - Information: Se agregó un objeto al arrayList de candidato");
//		}
		
		mav.addObject("candidatos", candidatoService.getListaCandidato().getCandidato);
		return mav
	}
	@GetMapping("/listaCandidatos")
	public ModelAndView getListadoCandidatoPage() {
//		logger.info("Method: getListadoCandidatoPage() - Information: Se visualiza los candidatos registrados");
		ModelAndView mav = new ModelAndView("lista_candidatos");
		mav.addObject("candidatos", candidatoService.getListaCandidato().getCandidatos());
		return mav;
	}
	
	/* Objetivo: modificar candidato */
	
	@GetMapping("/editar/{codigo}")
	public ModelAndView getEditarCandidatoPage(@PathVariable(value="codigo") int codigo) {
//		logger.info("Method: getEditarCandidatoPage() - Information: ");
		ModelAndView mav = new ModelAndView("edicion_Candidato");
		Candidato candidato = candidatoService.buscarCandidato(candidato);
		mav.addObject("candidato", candidato);
		return mav;
	}

	@PostMapping("/modificar")
	public ModelAndView editarDatosCandidato(@Validated @ModelAttribute("candidato") Candidato candidato, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()){
//			logger.info("Method: editarDatosCandidato() - Information: Error");
			ModelAndView mav = new ModelAndView("edicion_Candidato");
			mav.addObject("candidato", candidato);
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("redirect:/candidato/listaCandidatos");
		candidatoService.modificarCandidato(candidato);
		return mav;
	}
	
	/* Objetivo: eliminar candidato */
	
	@GetMapping("/eliminar/{codigo}")
	public ModelAndView eliminarDatosCandidato(@PathVariable(value="codigo") int codigo) {
//		logger.info("Method: eliminarDatosCandidato() - Information: ");
		ModelAndView mav = new ModelAndView("redirect:/candidato/listaCandidato");
		candidatoService.eliminarCandidato(codigo);
		return mav;
	}

}
