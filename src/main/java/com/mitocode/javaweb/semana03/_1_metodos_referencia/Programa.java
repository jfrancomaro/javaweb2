package com.mitocode.javaweb.semana03._1_metodos_referencia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.mitocode.javaweb.semana03._1_metodos_referencia.Persona.Genero;

public class Programa {
	
	List<Persona> lista;
	
	public Programa() {
		lista = new ArrayList<>();
		lista.add(new Persona("Jean", LocalDate.of(1990, 5, 10)));
		lista.add(new Persona("Christian", LocalDate.of(1995, 3, 20)));
		lista.add(new Persona("Martin", LocalDate.of(1990, 5, 23)));
		lista.add(new Persona("Elar", LocalDate.of(1988, 10, 31)));
		lista.add(new Persona("Jaime", LocalDate.of(1997, 7, 5)));
	}

	public static void main(String[] args) {
		Programa programa = new Programa();
//		programa.imprimir("Lista Original");
		
		programa.referenciaEstatica2();
//		programa.referenciaEstatica();
//		programa.referenciaMetodoDeInstancia();
//		programa.objetoArbitrario();
//		programa.objetoArbitrarioPersona();
//		programa.referenciaConstructor();
	}
	
	public void referenciaConstructor() {
		IPersona interfaz = (nombre, fechaNacimiento) -> new Persona(nombre, fechaNacimiento);
		interfaz = Persona::new;
		System.out.println(interfaz.crearPersona("Christian", LocalDate.of(2000, 7, 28)));
		
		IPersona2 interfaz2 = (nombre, fecha, genero) -> new Persona(nombre, fecha, genero);
		interfaz2 = Persona::new;
		System.out.println(interfaz2.crearPersona("Zannier", LocalDate.of(2000, 7, 28), Genero.MASCULINO));
	}
	
	public void objetoArbitrarioPersona() {
		lista.sort((o1, o2) -> o1.getEdad().compareTo(o2.getEdad()));
		lista.sort((o1,o2) ->  o1.ordenarPorEdad(o2) );
		lista.sort(Persona::ordenarPorEdad);
		
		imprimir("Ordenado por edad");
		
	}
	
	public void objetoArbitrario() {
		String[] students = { "Elar", "Jorge", "Jessy", "Mauricio", "Zanier", "Jaime", "Sebastian", "Christian", "Alan",
				"Martin", "Jahiro", "Carlos", "Jean" };
		
//		Arrays.sort(students, (String s1, String s2) -> s1.compareTo(s2));
		Arrays.sort(students, String::compareTo);
		
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i]);
		}
	}
	
	public void referenciaEstatica2() {
		lista.sort(Persona::ordenarPorFecha);
		lista.forEach(System.out::println);
	}
	
	public void referenciaMetodoDeInstancia() {
		ComparationPersonaUtil util = new ComparationPersonaUtil();
		lista.sort((o1, o2) -> util.ordenarPorFechaNacimiento(o1, o2));
		lista.sort(util::ordenarPorFechaNacimiento);
		
		imprimir("Lista ordenada");
	}
	
	public void referenciaEstatica() {
		Persona persona = new Persona("Diego", LocalDate.of(1885, 1, 19));
		System.out.println(persona);
		
		String fecha = persona.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MMM/yyyy"));
		System.out.println(fecha);
		
		lista.sort((o1, o2) -> o1.getNombre().compareTo(o2.getNombre()));
//		lista.sort((o1, o2) -> Persona.ordenarPorNombre(o1, o2) );
		lista.sort(Persona::ordenarPorNombre);
		
		imprimir("Lista ordenada");
	}
	
	public void imprimir(String mensaje) {
		System.out.println(mensaje);
		for (Persona persona : lista) {
			System.out.println(persona);
		}
	}
}

@FunctionalInterface
interface IPersona {
	Persona crearPersona(String nombre, LocalDate fechaNacimiento);
}

@FunctionalInterface
interface IPersona2 {
	Persona crearPersona(String nombre, LocalDate fechaNacimiento, Genero genero);
	
}

