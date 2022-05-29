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
		// Envio a la pagina el ultimo usuario y la lista de candidatos.
		int ultimoUsuario = this.usuarioService.getListaUsuario().getUsuarios().size() - 1;
		mav.addObject("usuario", this.usuarioService.getListaUsuario().getUsuarios().get(ultimoUsuario));
		mav.addObject("candidatos", this.candidatoService.getListaCandidato().getCandidatos());
		return mav;
	}

	@GetMapping("/votacion/{codigo}")
	public ModelAndView getFormUsuarioVotacionPage(@PathVariable(value = "codigo") int codigo) {
		// Control para usuario "Ninguno"
		if (codigo == 0) {
			this.candidatoService.agregarVotoCandidato(codigo);
			ModelAndView mav2 = new ModelAndView("agredecimiento");
			return mav2;
		}
		ModelAndView mav = new ModelAndView("iniciar_votacion");
		// Se trabaja con el ultimo usuario agregado
		int ultimoUsuario = this.usuarioService.getListaUsuario().getUsuarios().size() - 1;
		this.usuarioService.agregarVoto(this.usuarioService.getListaUsuario().getUsuarios().get(ultimoUsuario));
		mav.addObject("usuario", this.usuarioService.getListaUsuario().getUsuarios().get(ultimoUsuario));

		// Incrementar voto al candidato seleccionado
		this.candidatoService.agregarVotoCandidato(codigo);
		mav.addObject("candidatos", candidatoService.getListaCandidato().getCandidatos());

		// Se controla que el usuario solamente realice 3 votos.
		if (this.usuarioService.getListaUsuario().getUsuarios().get(ultimoUsuario).getVotos() == 3) {
			ModelAndView mav2 = new ModelAndView("agredecimiento");
			return mav2;
		}

		return mav;

	}

}
