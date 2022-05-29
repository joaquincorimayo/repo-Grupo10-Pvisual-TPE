package ar.edu.unju.fi.tpe.service;

import ar.edu.unju.fi.tpe.model.Usuario;
import ar.edu.unju.fi.tpe.util.ListaUsuarios;

public interface IUsuarioService {

	public Usuario getUsuario();
	public boolean guardarUsuario(Usuario usuario);
	public void modificarUsuario();
	public void eliminarUsuario(String dni);
	public ListaUsuarios getListaUsuarios();
	public Usuario buscarUsuario(String dni);
	
}
