package ar.edu.unju.fi.tpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RankingController {
	@GetMapping("/ranking")
	public String getIndex() {
		return "ranking";
	}
	/* Objetivo: Muestra el total de votos de los artistas */
}
