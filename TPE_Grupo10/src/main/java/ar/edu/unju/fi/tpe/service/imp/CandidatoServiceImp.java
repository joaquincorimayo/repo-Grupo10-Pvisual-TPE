package ar.edu.unju.fi.tpe.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpe.model.Candidato;
import ar.edu.unju.fi.tpe.service.ICandidatoService;
import ar.edu.unju.fi.tpe.util.ListaCandidatos;

@Service("CandidatoServiceImpList")
public class CandidatoServiceImp implements ICandidatoService {

	@Autowired
	private ListaCandidatos listaCandidatos;
	
	@Override
	public Candidato getCandidato() {
		return new Candidato();
	}

	@Override
	public boolean guardarCandidato(Candidato candidato) {
		return listaCandidatos.getCandidatos().add(candidato);
	}

	@Override
	public void modificarCandidato(Candidato candidato) {
		for (Candidato can : this.listaCandidatos.getCandidatos()) {
			if (can.getCodigo() == candidato.getCodigo()) {
				can.setCantidadVotos(candidato.getCantidadVotos());
				can.setCodigo(candidato.getCodigo());
				can.setDescripcion(candidato.getDescripcion());
				can.setGenero(candidato.getGenero());
				can.setNombre(candidato.getNombre());
				can.setUri(candidato.getUri());
			}
		}
	}

	@Override
	public void eliminarCandidato(int codigo) {
		for (int i = 0; i < this.listaCandidatos.getCandidatos().size(); i++) {
			if (this.listaCandidatos.getCandidatos().get(i).getCodigo() == codigo) {
				this.listaCandidatos.getCandidatos().remove(i);
			}
		}
	}

	@Override
	public ListaCandidatos getListaCandidato() {
		return this.listaCandidatos;
	}

	@Override
	public Candidato buscarCandidato(int codigo) {
		Optional<Candidato> a = this.listaCandidatos.getCandidatos().stream().filter(ar -> ar.getCodigo() == codigo)
				.findFirst();
		return a.get();
	}

	@Override
	public void agregarVotoCandidato(int codigo) {
		for (Candidato can : this.listaCandidatos.getCandidatos()) {
			if(can.getCodigo() == codigo) {
				can.setCantidadVotos(can.getCantidadVotos()+1);			
			}
		}
	}
}
