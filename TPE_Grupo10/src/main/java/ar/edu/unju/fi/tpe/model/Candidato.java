package ar.edu.unju.fi.tpe.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Candidato {

	@Min(value = 1, message = "El Codigo del Candidato debe ser mayor a 0")
	private int codigo;
	@NotEmpty(message = "Debe ingresar nombre del Artista o Banda")
	@Size(min = 3, max = 100, message = "El nombre debe tener entre 3 a 100 caracteres")
	private String nombre;
	@NotEmpty(message = "Debe ingresar el genero musical")
	private String genero;
	@NotEmpty(message = "Debe ingresar una breve descripcion")
	private String descripcion;
	private String uri;
	private int cantidadVotos;

	
	public Candidato() {
		
	}

	public Candidato(int codigo, String nombre, String genero, String descripcion, String uri, int cantidadVotos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.genero = genero;
		this.descripcion = descripcion;
		this.uri = uri;
		this.cantidadVotos = cantidadVotos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getCantidadVotos() {
		return cantidadVotos;
	}

	public void setCantidadVotos(int cantidadVotos) {
		this.cantidadVotos = cantidadVotos;
	}

	@Override
	public String toString() {
		return "Candidato [codigo=" + codigo + ", nombre=" + nombre + ", genero=" + genero + ", descripcion="
				+ descripcion + ", uri=" + uri + ", cantidadVotos=" + cantidadVotos + "]";
	}

}
