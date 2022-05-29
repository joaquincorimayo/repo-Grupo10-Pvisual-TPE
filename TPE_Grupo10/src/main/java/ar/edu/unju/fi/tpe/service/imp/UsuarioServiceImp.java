package ar.edu.unju.fi.tpe.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		boolean resp=listaUsuarios.getUsuarios().add(usuario);
		return resp;
	}

	@Override
	public void modificarUsuario() {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarUsuario(String dni) {
		// TODO Auto-generated method stub

	}

	@Override
	public ListaUsuarios getListaUsuarios() {
		return listaUsuarios;
	}

	@Override
	public Usuario buscarUsuario(String dni) {
		Usuario devolverUsuario=new Usuario();
		for(Usuario user : this.listaUsuarios.getUsuarios()) {
			if(user.getDni().equals(dni)) {
				devolverUsuario.setDni(user.getDni());
				devolverUsuario.setEmail(user.getEmail());
				devolverUsuario.setFechaN(user.getFechaN());
				devolverUsuario.setNombre(user.getNombre());
			}
			
		}
		return devolverUsuario;
	}

}
