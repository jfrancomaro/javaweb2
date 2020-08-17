package com.mitocode.javaweb.semana03._5_streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.mitocode.javaweb.semana03._1_metodos_referencia.Persona;

public class Programa {

	public static void main(String[] args) {
		Programa programa = new Programa();
//		programa.introStream();
//		programa.intStream();
//		programa.arrayStream();
//		programa.mapStream();
//		programa.files();
//		programa.filesObjeto();
		programa.statistics();
	}

	private void statistics() {
		IntSummaryStatistics statistics = IntStream.of(5, 8, 1, 10, 25).summaryStatistics();
		System.out.println(statistics);
		
		DoubleSummaryStatistics statisticsDouble = DoubleStream.of(12.50, 5.99, 4.30, 8.35).summaryStatistics();
		System.out.println(statisticsDouble);
		
		Stream<String> lineas = null;
		try {
			lineas = Files.lines(Paths.get("src/main/resources/productos.txt")); // Stream<String>
			// "ABC,10,5.2".split(",") -> String[]
			List<Producto> productos = lineas.map(linea -> linea.split(",")) // Stream<String[]>
											.filter(array -> array.length == 3)	// Stream<String[]>
											.map(Producto::new) // String<Producto>
											.collect(Collectors.toList());
			
			productos.forEach(System.out::println);
			
			//Stream<Double>
			DoubleStream precios = productos.stream() // Stream<Producto>
					.mapToDouble(producto -> producto.precio); //Stream<Double> --> DoubleStream
			System.out.println(precios.summaryStatistics());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(lineas != null) {
				lineas.close();
			}
		}
		
		
	}

	private void filesObjeto() {

		Stream<String> lineas = null;
		try {
			lineas = Files.lines(Paths.get("src/main/resources/productos.txt")); // Stream<String>
			// "ABC,10,5.2".split(",") -> String[]
			List<Producto> productos = lineas.map(linea -> linea.split(",")) // Stream<String[]>
			.filter(array -> array.length == 3)	// Stream<String[]>
			.map(Producto::new) // String<Producto>
			.collect(Collectors.toList());
			
			productos.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(lineas != null) {
				lineas.close();
			}
		}
	}

	private void files() {
		Stream<String> students = null;
		try {
			students = Files.lines(Paths.get("src/main/resources/students.txt"));
			students.sorted().filter(nombre -> nombre.length() > 5).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(students != null) {
				students.close();
			}
		}
	}

	private void mapStream() {
		IntStream.range(1, 3).map(numero -> numero * numero).average().ifPresent(System.out::println);
//		1 = 1
//		2 = 4

		String[] names = { "Elar", "Jorge", "Jessy", "Mauricio", "Zanier", "Jaime", "Sebastian", "Christian", "Alan",
				"Martin", "Jahiro", "Carlos", "Jean" };
		Arrays.stream(names).map(name -> name.toUpperCase()).filter(nombre -> nombre.length() < 5)
				.forEach(System.out::println);
	}

	public void arrayStream() {
		String[] names = { "Elar", "Jorge", "Jessy", "Mauricio", "Zanier", "Jaime", "Sebastian", "Christian", "Alan",
				"Martin", "Jahiro", "Carlos", "Jean" };

		Arrays.stream(names).filter(nombre -> nombre.startsWith("J")).sorted().forEach(System.out::println);
	}

	public void intStream() {

		IntStream.range(1, 15).forEach(System.out::print);
		System.out.println("\n==");

		IntStream.range(1, 15).skip(5).forEach(System.out::println);
		System.out.println("==");

		System.out.println(IntStream.range(10, 100).sum());

	}

	public void introStream() {
		List<Persona> lista = new ArrayList<>();
		lista.add(new Persona("Jean", LocalDate.of(1990, 5, 10)));
		lista.add(new Persona("Christian", LocalDate.of(1995, 3, 20)));
		lista.add(new Persona("Martin", LocalDate.of(1990, 5, 23)));
		lista.add(new Persona("Elar", LocalDate.of(1988, 10, 31)));
		lista.add(new Persona("Jaime", LocalDate.of(1997, 7, 5)));

		// recorriendo la lista
//		for (Persona persona : lista) {
//			System.out.println(persona);
//		}
		lista.stream().forEach(persona -> System.out.println(persona));

		System.out.println("================");
		// pintar las personas menores a 30 años
		for (Persona persona : lista) {
			if (persona.getEdad() < 30) {
				System.out.println(persona);
			}
		}
		System.out.println("================ filter");
		lista.stream().filter(persona -> persona.getEdad() < 30).forEach(System.out::println);

		System.out.println("================ collect");
		// recuperando la lista modificada
		List<Persona> lista2 = lista.stream().filter(persona -> persona.getNombre().contains("J"))
				.collect(Collectors.toList());
		lista2.forEach(System.out::println);
		System.out.println(lista2);
	}
}
