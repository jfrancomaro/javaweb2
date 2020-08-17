package com.mitocode.javaweb.semana03._3_supplier;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public class Programa {

	public static void main(String[] args) {
		Supplier<LocalDateTime> supplierTime = () -> LocalDateTime.now();
		System.out.println(supplierTime.get());
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMM/yyyy hh:mm a");
		Supplier<String> supplierFormato = () -> dtf.format(LocalDateTime.now());
		System.out.println(supplierFormato.get());
		
		System.out.println("=================");
//		Supplier<Persona> sPersona = () -> new Persona();
//		Supplier<Persona> sPersona = Persona::new;
//		Supplier<Persona> sPersona2 = () -> new Persona("", null);
		
		Persona p1 = getPersona(Persona::new);
		System.out.println(p1);
		Persona p2 = getPersona(() -> new Persona("Diego", LocalDate.of(2000, 6, 7)));
		System.out.println(p2);
		
	}
	
	public static Persona getPersona(Supplier<Persona> supplier) {
		Persona persona = supplier.get();
		if(persona.getNombre() == null) {
			persona.setNombre("Nombre Default");
		}
		if(persona.getFechaNacimiento() == null) {
			persona.setFechaNacimiento(LocalDate.of(1990, 1, 1));
		}
		return persona;
	}
}
