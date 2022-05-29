package ar.edu.unju.fi.tpe.model;

import java.time.LocalDate;
import java.time.Period;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Usuario {
	@Min(value = 1000000, message = "El DNI del alumno debe ser mayor o igual a 1.000.000")
	private String dni;
	@NotEmpty(message = "El nombre del alumno no puede ser vacío")
	@Size(min = 3, max = 100, message = "El nombre debe tener entre 3 a 100 caracteres")
	private String nombre;
	@NotEmpty(message = "El email del alumno no puede ser vacío")
	@Email
	private String email;
	@NotNull
	@Past(message = "La fecha debe ser anterior a la actual")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaN;
	private int votos;
	private int edadUsuario;

	public int getEdadUsuario() {
		LocalDate now = LocalDate.now();
		Period diff = Period.between(this.getFechaN(), now);
		return diff.getYears();
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	// La edad se calcula, no se establece.
	public Usuario(String dni, String nombre, String email, LocalDate fechaN, int votos) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.email = email;
		this.fechaN = fechaN;
		this.votos = votos;
		this.edadUsuario = this.getEdadUsuario();
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaN() {
		return fechaN;
	}

	public void setFechaN(LocalDate fechaN) {
		this.fechaN = fechaN;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}

	public void setEdadUsuario(int edadUsuario) {
		this.edadUsuario = edadUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", nombre=" + nombre + ", email=" + email + ", fechaN=" + fechaN + ", votos="
				+ votos + ", edadUsuario=" + edadUsuario + "]";
	}

}
