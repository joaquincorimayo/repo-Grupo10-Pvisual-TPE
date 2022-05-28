package ar.edu.unju.fi.tpe.util;

import java.util.ArrayList;
import org.springframework.stereotype.Component;
import ar.edu.unju.fi.tpe.model.Candidato;

@Component
public class ListaCandidatos {
	
	private ArrayList<Candidato> candidatos;
	//Clase que gestiona la lista de Candidatos
	
	public ListaCandidatos() {
		candidatos = new ArrayList<Candidato>();
		candidatos.add(new Candidato(0, null, null, null, 0));
		candidatos.add(new Candidato(1, "banda1", "rock", "descripcion 1", "imagen1.jpg", 0));
		candidatos.add(new Candidato(2, "banda2", "pop", "descripcion 2", "imagen2.jpg", 0));
		candidatos.add(new Candidato(3, "banda3", "romantico", "descripcion 3", "imagen3.jpg", 0));
		candidatos.add(new Candidato(4, "banda3", "reggaeton", "descripcion 4", "imagen4.jpg", 0));
	}
	
	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(ArrayList<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
}
