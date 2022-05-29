package ar.edu.unju.fi.tpe.util;

import java.time.LocalDate;
//import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tpe.model.Usuario;

@Component
public class ListaUsuarios {
	private ArrayList<Usuario> usuarios;

	public ListaUsuarios() {
		usuarios = new ArrayList<Usuario>();
		
		LocalDate fecha;
		fecha = LocalDate.of(1999, 04, 15);
		// La fecha NO se establece, se calcula automaticamente. 
		usuarios.add(new Usuario("44888999", "Usuario1", "Usuario1@gmail.com", fecha,0));
		fecha = LocalDate.of(1998, 03, 14);
		usuarios.add(new Usuario("45888999", "Usuario2", "Usuario2@gmail.com", fecha,0));
		
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
