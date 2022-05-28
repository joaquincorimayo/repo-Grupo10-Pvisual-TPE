package ar.edu.unju.fi.tpe.controller;

import org.slf4j.Logger;
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

import ar.edu.unju.fi.tpe.model.Candidato;
import ar.edu.unju.fi.tpe.service.ICandidatoService;

@Controller
@RequestMapping("/candidatos")
public class CandidatosController {
	@Autowired
	@Qualifier("CandidatoServiceImpList")
	private ICandidatoService candidatoService;

	Logger logger = LoggerFactory.getLogger(CandidatosController.class);

	@GetMapping("/listaCandidatos")
	public ModelAndView getListadoCandidatoPage() {
		logger.info("Method: getListadoCandidatoPage() - Information: Se visualiza los candidatos registrados");
		ModelAndView mav = new ModelAndView("lista_candidatos");
		mav.addObject("candidatos", this.candidatoService.getListaCandidato().getCandidatos());
		return mav;
	}
	
	@GetMapping("/nuevo")
	public String getFormCandidatoNuevoPage(Model model) {
		model.addAttribute("candidato", this.candidatoService.getCandidato());
		logger.info(
				"Method getFormCandidatoNuevoPage() - Information: Se envia un objeto Candidato a la pagina nuevo_candidato");
		return "nuevo_candidato";
	}

	@PostMapping("/guardar")
	public ModelAndView addNuevoCandidato(@Validated @ModelAttribute("candidato") Candidato candidato,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			logger.info(
					"Method addNuevoCandidato() - Information: ERROR");
			ModelAndView mav = new ModelAndView("nuevo_candidato");
			mav.addObject("candidato", candidato);
			return mav;
		}

		ModelAndView mav = new ModelAndView("lista_candidatos");

		if (candidatoService.guardarCandidato(candidato)) {
			logger.info("Method: addNuevoCandidato() - Information: Se agregó un objeto al arrayList de candidato");
		}
		mav.addObject("candidatos", this.candidatoService.getListaCandidato().getCandidatos());
		return mav;
	}

	

	/* Objetivo: modificar candidato */
	@GetMapping("/editar/{codigo}")
	public ModelAndView getEditarCandidatoPage(@PathVariable(value = "codigo") int codigo) {
		logger.info("Method: getEditarCandidatoPage() - Information: ");
		ModelAndView mav = new ModelAndView("edicion_Candidato");
		Candidato candidato = this.candidatoService.buscarCandidato(codigo);
		mav.addObject("candidato", candidato);
		return mav;
	}

	@PostMapping("/modificar")
	public ModelAndView setDatosNuevosCandidato(@Validated @ModelAttribute("candidato") Candidato candidato,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			logger.info("Method: setDatosNuevosCandidato() - Information: Error");
			ModelAndView mav = new ModelAndView("edicion_Candidato");
			mav.addObject("candidato", candidato);
			return mav;
		}
		
		logger.info("Method: setDatosNuevosCandidato() - Information: Se modificaron los datos.");
		ModelAndView mav = new ModelAndView("redirect:/candidatos/listaCandidatos");
		candidatoService.modificarCandidato(candidato);
		return mav;
	}

	/* Objetivo: eliminar candidato */
	@GetMapping("/eliminar/{codigo}")
	public ModelAndView eliminarDatosCandidato(@PathVariable(value = "codigo") int codigo) {
		logger.info("Method: eliminarDatosCandidato() - Information: Se elimina el candidato");
		ModelAndView mav = new ModelAndView("redirect:/candidatos/listaCandidatos");
		candidatoService.eliminarCandidato(codigo);
		return mav;
	}

}
