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
import ar.edu.unju.fi.tpe.service.IUsuarioService;


@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	@Qualifier("UsuarioServiceImpList")
	private IUsuarioService usuarioService;
	
	Logger logger = LoggerFactory.getLogger(UsuariosController.class);
	
	@GetMapping("/listaUsuarios")
	public ModelAndView getListaUsuarioPage() {
		logger.info("Method: getListadoUsuarioPage() - Information: Se visualiza los usuarios registrados");
		ModelAndView mav=new ModelAndView("lista_usuarios");
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
		if(bindingResult.hasErrors()) {
			logger.info(
					"Method addNuevoUsuario() - Information: ERROR");
			ModelAndView mav = new ModelAndView("nuevo_usuario");
			mav.addObject("usuario", usuario);
			return mav;
		}
		
	ModelAndView mav = new ModelAndView("lista_usuarios");
	
	if(usuarioService.guardarUsuario(usuario)) {
		logger.info("Method: addNuevoUsuario() - Information: Se agregó un objeto al arrayList de usuario");
	}
	mav.addObject("usuarios", this.usuarioService.getListaUsuario().getUsuarios());
	return mav;
	}
}
