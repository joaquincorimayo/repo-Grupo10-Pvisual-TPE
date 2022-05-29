package ar.edu.unju.fi.tpe.service;

import ar.edu.unju.fi.tpe.model.Usuario;
import ar.edu.unju.fi.tpe.util.ListaUsuarios;

public interface IUsuarioService {
	public Usuario getUsuario();
	public boolean guardarUsuario(Usuario usuario);
	public void modificarUsuario(Usuario usuario);
	public void eliminarUsuario(String dni);
	public ListaUsuarios getListaUsuario();
	public Usuario buscarUsuario(String dni);
	
}
