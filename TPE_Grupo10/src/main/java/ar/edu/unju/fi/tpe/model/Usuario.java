package ar.edu.unju.fi.tpe.model;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Usuario {
	@Min(value=1000000, message="El DNI del alumno debe ser mayor o igual a 1.000.000")
	private String dni;
	@Size(min=3, max=100, message="El nombre debe tener entre 3 a 100 caracteres")
	private String nombre;
	@Email
	private String email;
	@Past(message = "La fecha debe ser anterior a la actual")
	private LocalDate fechaN;
	
public Usuario() {
	// TODO Auto-generated constructor stub
}




	
public Usuario(String dni, String nombre, String email, LocalDate fechaN) {
	super();
	this.dni = dni;
	this.nombre = nombre;
	this.email = email;
	this.fechaN = fechaN;
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



	@Override
public String toString() {
	return "Usuario [dni=" + dni + ", nombre=" + nombre + ", email=" + email + ", fechaN=" + fechaN + "]";
}



	public int calcularEdad() {
		LocalDate hoy = LocalDate.now();
		int edad = hoy.getYear() - this.fechaN.getYear();
		return edad;
	}


	

}
