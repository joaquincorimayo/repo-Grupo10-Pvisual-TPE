package ar.edu.unju.fi.tpe.util;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tpe.model.Usuario;

@Component
public class ListaUsuarios {
	private ArrayList<Usuario> usuarios;
	
	public ListaUsuarios() {
		LocalDate fechaN;
		fechaN=LocalDate.of(1999, 04, 15);
		usuarios=new ArrayList<Usuario>();
		usuarios.add(new Usuario("44888999", "Juan", "juan@gmail.com", fechaN));
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	

}
