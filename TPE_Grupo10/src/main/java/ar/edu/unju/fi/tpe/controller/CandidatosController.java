package ar.edu.unju.fi.tpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CandidatosController {
	@GetMapping("/candidatos")
	public String getIndex() {
		return "candidatos";
	}
	/* Objetivo: realizar la carga de un nuevo artista */
}
