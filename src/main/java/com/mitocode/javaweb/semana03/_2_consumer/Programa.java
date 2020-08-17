package com.mitocode.javaweb.semana03._2_consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Programa {

	public static void main(String[] args) {
		String[] students = { "Elar", "Jorge", "Jessy", "Mauricio", "Zanier", "Jaime", "Sebastian", "Christian", "Alan",
				"Martin", "Jahiro", "Carlos", "Jean" };

		Programa programa = new Programa();
		programa.consumer(Arrays.asList(students));
		programa.biConsumer();
		
	}
	
	public void biConsumer() {
//		BiConsumer<Integer, Integer> operacion = (x, y) -> System.out.println(x + y);
//		BiConsumer<Integer, Integer> operacion2 = (x, y) -> System.out.println(x - y);
//		BiConsumer<Integer, Integer> operacion3 = (x, y) -> System.out.println(x * y);
//		BiConsumer<Integer, Integer> operacion4 = (x, y) -> System.out.println(x / y);
//		
//		operacion.accept(8, 5);
//		operacion2.accept(8, 5);
//		operacion3.accept(8, 5);
//		operacion4.accept(8, 5);
		
		operaciones(8, 5, (x, y) -> System.out.println(x + y));
		operaciones(8, 5, (x, y) -> System.out.println(x - y));
		operaciones(8, 5, (x, y) -> System.out.println(x * y));
		operaciones(8, 5, (x, y) -> System.out.println(x / y));
	}
	
	public void operaciones(int x, int y, BiConsumer<Integer, Integer> biConsumer) {
		biConsumer.accept(x, y);
	}

	public void consumer(List<String> listaNombres) {
		Consumer<List<String>> consumerImpresion = (lista) -> {
			for (String nombre : lista) {
				System.out.println("Hola:" + nombre);
			}
		};

//		consumer.accept(listaNombres);

		System.out.println("===============");

		Consumer<List<String>> consumerModificacion = (lista) -> {
			for (int i = 0; i < lista.size(); i++) {
				lista.set(i, (i + 1) + "-" + lista.get(i));
			}
		};
//		consumerModificacion.accept(listaNombres);

		for (String nombre : listaNombres) {
			System.out.println(nombre);
		}
		
		// andThen
		consumerModificacion.andThen(consumerImpresion).accept(listaNombres);
	}
}
