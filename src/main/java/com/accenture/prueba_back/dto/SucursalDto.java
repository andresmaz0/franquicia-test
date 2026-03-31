package com.accenture.prueba_back.dto;

import java.util.List;

public class SucursalDto {
	private String nombre;
	private List<ProductoDto> listaProductos;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<ProductoDto> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(List<ProductoDto> listaProductos) {
		this.listaProductos = listaProductos;
	}
}
