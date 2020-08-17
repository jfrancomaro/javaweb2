package com.mitocode.javaweb.semana03._5_streams;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persona {

	public enum Genero {
		MASCULINO, FEMENINO
	}

	private String nombre;
	private Genero genero;
	private LocalDate fechaNacimiento;
	
	public Persona(String nombre, LocalDate fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Persona(String nombre,LocalDate fechaNacimiento, Genero genero) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", genero=" + genero + ", fechaNacimiento=" + fechaNacimiento + ", edad=" + getEdad() + "]";
	}
	
	public static int ordenarPorNombre(Persona p1, Persona p2) {
		return p1.getNombre().compareTo(p2.getNombre());
	}
	
	public Integer getEdad() {
		return (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
	}
	
	public int ordenarPorEdad(Persona p1) {
		return this.getEdad().compareTo(p1.getEdad());
	}

}
