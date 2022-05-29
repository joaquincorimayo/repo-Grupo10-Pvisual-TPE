package ar.edu.unju.fi.tpe.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpe.model.Candidato;
import ar.edu.unju.fi.tpe.model.Usuario;
import ar.edu.unju.fi.tpe.service.IUsuarioService;
import ar.edu.unju.fi.tpe.util.ListaUsuarios;

@Service("UsuarioServiceImpList")
public class UsuarioServiceImp implements IUsuarioService {

	@Autowired
	private ListaUsuarios listaUsuarios;
	
	
	@Override
	public Usuario getUsuario() {
		return new Usuario();
	}

	@Override
	public boolean guardarUsuario(Usuario usuario) {
		return listaUsuarios.getUsuarios().add(usuario);
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		for (Usuario can : this.listaUsuarios.getUsuarios()) {
			if (can.getDni().equals(usuario.getDni())) {
				can.setDni(usuario.getDni());
				can.setEdadUsuario(usuario.getEdadUsuario());
				can.setEmail(usuario.getEmail());
				can.setFechaN(usuario.getFechaN());
				can.setNombre(usuario.getNombre());
				can.setVotos(usuario.getVotos());
			}
		}

	}

	@Override
	public void eliminarUsuario(String dni) {
		// TODO Auto-generated method stub

	}

	@Override
	public ListaUsuarios getListaUsuario() {
		return this.listaUsuarios;
	}

	@Override
	public Usuario buscarUsuario(String dni) {
		Usuario devolverUsuario = new Usuario();
		for(Usuario usu : this.listaUsuarios.getUsuarios()) {
			if(usu.getDni().equals(dni)) {
				devolverUsuario.setDni(usu.getDni());
				devolverUsuario.setEdadUsuario(usu.getEdadUsuario());
				devolverUsuario.setEmail(usu.getEmail());
				devolverUsuario.setFechaN(usu.getFechaN());
				devolverUsuario.setNombre(usu.getNombre());
				devolverUsuario.setVotos(usu.getVotos());
			}
		}
		return devolverUsuario;
	}
	
	@Override
	public void agregarVoto(Usuario usuario) {
		for(Usuario usu : this.listaUsuarios.getUsuarios()) {
			if(usu.getDni().equals(usuario.getDni())) {
				usu.setVotos(usuario.getVotos()+1);
			}
		}
	}
}
