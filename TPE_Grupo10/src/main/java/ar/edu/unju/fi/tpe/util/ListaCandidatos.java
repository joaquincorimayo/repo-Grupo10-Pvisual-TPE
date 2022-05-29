package ar.edu.unju.fi.tpe.util;

import java.util.ArrayList;
import org.springframework.stereotype.Component;
import ar.edu.unju.fi.tpe.model.Candidato;

@Component
public class ListaCandidatos {
	// Clase que gestiona la lista de Candidatos
	// {codigo;nombre;genero;descripcion;uri;cantidadVotos;}

	private ArrayList<Candidato> candidatos;

	public ListaCandidatos() {
		candidatos = new ArrayList<Candidato>();
		candidatos.add(new Candidato(0, "Ninguno", "Ninguno", "Vota en blanco", "ninguno.jpg", 0));
		candidatos.add(new Candidato(1, "banda1", "rock", "descripcion 1", "bersuit.jpg", 0));
		candidatos.add(new Candidato(2, "banda2", "pop", "descripcion 2", "callejeros.jpg", 0));
		candidatos.add(new Candidato(3, "banda3", "romantico", "descripcion 3", "Intoxicados.jpg", 0));
		candidatos.add(new Candidato(4, "banda3", "reggaeton", "descripcion 4", "fitopaez.jpg", 0));
	}

	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(ArrayList<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
}
