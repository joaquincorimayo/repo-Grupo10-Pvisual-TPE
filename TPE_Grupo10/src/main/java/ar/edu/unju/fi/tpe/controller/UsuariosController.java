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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpe.model.Usuario;
import ar.edu.unju.fi.tpe.service.ICandidatoService;
import ar.edu.unju.fi.tpe.service.IUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	@Qualifier("UsuarioServiceImpList")
	private IUsuarioService usuarioService;

	@Autowired
	@Qualifier("CandidatoServiceImpList")
	private ICandidatoService candidatoService;

	Logger logger = LoggerFactory.getLogger(UsuariosController.class);

	@GetMapping("/listaUsuarios")
	public ModelAndView getListaUsuarioPage() {
		logger.info("Method: getListadoUsuarioPage() - Information: Se visualiza los usuarios registrados");
		ModelAndView mav = new ModelAndView("lista_usuarios");
		mav.addObject("usuarios", this.usuarioService.getListaUsuario().getUsuarios());
		return mav;
	}

	@GetMapping("/nuevo")
	public String getFormUsuarioNuevoPage(Model model) {
		model.addAttribute("usuario", this.usuarioService.getUsuario());
		logger.info(
				"Method getFormUsuarioNuevoPage() - Information: Se envia un objeto Usuario a la pagina nuevo_usuario");
		return "nuevo_usuario";
	}

	@PostMapping("/guardar")
	public ModelAndView addNuevoUsuario(@Validated @ModelAttribute("usuario") Usuario usuario,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			logger.info("Method addNuevoUsuario() - Information: ERROR");
			ModelAndView mav = new ModelAndView("nuevo_usuario");
			mav.addObject("usuario", usuario);
			return mav;
		}

		if (usuarioService.guardarUsuario(usuario)) {
			logger.info("Method: addNuevoUsuario() - Information: Se agregó un objeto al arrayList de usuario");
		}

		// Pagina donde se gestionara la votacion.
		ModelAndView mav = new ModelAndView("iniciar_votacion");
		// Solo quiero trabajar con el usuario que inicio la votacion.
		Usuario user = this.usuarioService.buscarUsuario(usuario.getDni());
		// Envio a la pagina el usuario particular y la lista de candidatos.
		mav.addObject("usuario", user);
		mav.addObject("candidatos", this.candidatoService.getListaCandidato().getCandidatos());
		return mav;
	}
}
