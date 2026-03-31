package com.accenture.prueba_back.dto;

import java.util.List;

public class FranquiciaDto {
	private String nombre;
	private List<SucursalDto> listaSucursales;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<SucursalDto> getListaSucursales() {
		return listaSucursales;
	}
	public void setListaSucursales(List<SucursalDto> listaSucursales) {
		this.listaSucursales = listaSucursales;
	}
}
