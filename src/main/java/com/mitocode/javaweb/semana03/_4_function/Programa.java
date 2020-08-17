package com.mitocode.javaweb.semana03._4_function;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

import org.apache.commons.codec.digest.DigestUtils;

public class Programa {

	public static void main(String[] args) {
		String curso = "Java Web Developer1";
		Function<String, Integer> funcionGetTamanio = cadena -> cadena.length();

		Integer tamanio = funcionGetTamanio.apply(curso);
		System.out.println(tamanio);
		Function<Integer, Boolean> funcionEsPar = numero -> numero % 2 == 0;
		Boolean esPar = funcionGetTamanio.andThen(funcionEsPar).apply(curso);
		System.out.println(esPar);

		System.out.println("===================================");
		List<String> students = Arrays.asList("Elar", "Jorge", "Jessy", "Mauricio", "Zanier", "Jaime", "Sebastian");

		Map<String, Boolean> map = new HashMap<>();
		for (String name : students) {
			map.put(name, funcionGetTamanio.andThen(funcionEsPar).apply(name));
		}
		System.out.println(map);

		Map<String, String> mapHash = new HashMap<String, String>();
		Function<String, String> functionHash = cadena -> DigestUtils.sha256Hex(cadena);
		for (String name : students) {
			mapHash.put(name, functionHash.apply(name));
		}
		for (Entry<String, String> element : mapHash.entrySet()) {
			System.out.println(element.getKey() + ":" + element.getValue());
		}

	}
}
