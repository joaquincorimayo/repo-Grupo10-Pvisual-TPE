package ar.edu.unju.fi.tpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@GetMapping("/inicio")
	public String getIndex() {
		return "index";
	}
	/* Objetivo: Visualizar la pagina principal*/
}
