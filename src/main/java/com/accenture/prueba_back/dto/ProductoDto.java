package com.accenture.prueba_back.dto;

public class ProductoDto {
	private String nombreProducto;
	private Float cantidadStock;
	private String nombreSucursal;
	private String nombreFranquicia;
	
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
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
	public String getNombreFranquicia() {
		return nombreFranquicia;
	}
	public void setNombreFranquicia(String nombreFranquicia) {
		this.nombreFranquicia = nombreFranquicia;
	}
}
