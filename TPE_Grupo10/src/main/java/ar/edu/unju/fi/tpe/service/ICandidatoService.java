package ar.edu.unju.fi.tpe.service;

import ar.edu.unju.fi.tpe.model.Candidato;
import ar.edu.unju.fi.tpe.util.ListaCandidatos;

public interface ICandidatoService {
	public Candidato getCandidato();
	public boolean guardarCandidato(Candidato candidato);
	public void modificarCandidato(Candidato candidato);
	public void eliminarCandidato(int codigo);
	public ListaCandidatos getListaCandidato();
	public Candidato buscarCandidato(int codigo);
}