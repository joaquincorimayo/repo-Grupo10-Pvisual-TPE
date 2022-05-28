package ar.edu.unju.fi.tpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VotarController {
	@GetMapping("/votar")
	public String getIndex() {
		return "votar";
	}
	/* Objetivo: Realizar una nueva votacion */
}
