package ar.edu.unju.fi.tpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuariosController {
	@GetMapping("/usuarios")
	public String getIndex() {
		return "usuarios";
	}
	/* Objetivo: Listar usuarios que ya votaron */
}
