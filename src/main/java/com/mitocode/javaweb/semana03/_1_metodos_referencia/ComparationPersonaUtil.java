package com.mitocode.javaweb.semana03._1_metodos_referencia;

public class ComparationPersonaUtil {
	
	public int ordenarPorFechaNacimiento(Persona p1, Persona p2) {
		return p1.getFechaNacimiento().compareTo(p2.getFechaNacimiento());
	}
}
