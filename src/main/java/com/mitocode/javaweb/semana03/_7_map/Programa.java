package com.mitocode.javaweb.semana03._7_map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Programa {

	public static void main(String[] args) {
		Map<String, String> paises = new HashMap<>();
		paises.put("PE", "Peru");
		paises.put("CO", "Colombia");
		paises.put("CH", "Chile");
		paises.put("EC", "Ecuador");
		
		paises.forEach((key,value) -> System.out.println("key: " + key + " value: " + value));
		
		System.out.println("========");
		
		Map<String, String> filtrados = paises.entrySet().stream() // Stream<EntrySet<String, String>>
			.filter(entry -> entry.getValue().toLowerCase().contains("e"))
			.collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue()));
		
		filtrados.forEach((key,value) -> System.out.println("key: " + key + " value: " + value));
		
		System.out.println("========");
		paises.putIfAbsent("MX", "Mexico");
		paises.putIfAbsent("MX", "Mexico2222");
		paises.entrySet().stream().forEach(System.out::println);
		
		System.out.println("========");
		System.out.println(paises.getOrDefault("PE", "Defaul de PEE"));
		System.out.println(paises.getOrDefault("PEE", "Defaul de PEE"));
		
		
	}
}
