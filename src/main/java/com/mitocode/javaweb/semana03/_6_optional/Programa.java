package com.mitocode.javaweb.semana03._6_optional;

import java.util.Optional;

public class Programa {

	public static void main(String[] args) {
		Programa programa = new Programa();
//		programa.optionalBasic();
		programa.othersMethods();
	}
	
	private void othersMethods() {
		Optional<String> curso = Optional.of("Java Web");
		Optional<String> empty = Optional.empty();
		
		System.out.println(curso.orElse("Valor Default Curso"));
		System.out.println(empty.orElse("Valor Default Empty"));
		
		System.out.println(curso.orElseGet(() -> "Valor funcional default Curso"));
		System.out.println(empty.orElseGet(() -> "Valor funcional default Empty"));
	}

	public void optionalBasic() {
		Optional<String> curso = Optional.of("Java Web");
		
		System.out.println("Optional: " + curso);
		System.out.println("Optional.get(): " + curso.get());
		System.out.println("Optional.empty: " + Optional.empty());
		
		String nombre = "Java Web";
		String nombre2 = null;
		
		System.out.println("Optional.ofNullable no vacio:" + Optional.ofNullable(nombre));
		System.out.println("Optional.ofNullable vacio:" + Optional.ofNullable(nombre2));
		
		// Exception  java.lang.NullPointerException
//		System.out.println("Optional.of nulo:" + Optional.of(nombre2));
		
		System.out.println("================");
		Optional<String> nombreNull = Optional.ofNullable(nombre2);
//		String nombre3 = nombreNull.get();
		if(nombreNull.isPresent()) {
			System.out.println("Optional con valor");
		} else {
			System.out.println("Optional sin valor");
		}
		nombreNull.ifPresent(parametro -> System.out.println("Valor válido"));
		
		System.out.println("get de Optional.ofNullable(null): " + nombreNull);
	}
}
