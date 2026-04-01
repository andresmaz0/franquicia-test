package com.accenture.prueba_back.dto;

public class ProductoDto {
	private String nombre;
	private Float cantidadStock;
	private String nombreSucursal;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Float getCantidadStock() {
		return cantidadStock;
	}
	public void setCantidadStock(Float cantidadStock) {
		this.cantidadStock = cantidadStock;
	}
	public String getNombreSucursal() {
		return nombreSucursal;
	}
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}
	
}
