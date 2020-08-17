package com.mitocode.javaweb.semana03._5_streams;

public class Producto {

	
	String descripcion;
	Integer cantidad;
	Double precio;
	
	public Producto(String descripcion, String cantidad, String precio) {
		this.descripcion = descripcion;
		this.cantidad = Integer.valueOf(cantidad);
		this.precio = Double.valueOf(precio);
	}
	
	public Producto(String[] campos) {
		this.descripcion = campos[0];
		this.cantidad = Integer.valueOf(campos[1]);
		this.precio = Double.valueOf(campos[2]);
	}

	@Override
	public String toString() {
		return "Producto [descripcion=" + descripcion + ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}
	
	
}
