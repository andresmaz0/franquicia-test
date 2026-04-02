package com.accenture.prueba_back.model;

public class TopProductosPorSucursal {
	private String nombreSucursal;
	private String nombreProducto;
	private Float maxStock;
	
	public String getNombreSucursal() {
		return nombreSucursal;
	}
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public Float getMaxStock() {
		return maxStock;
	}
	public void setMaxStock(Float maxStock) {
		this.maxStock = maxStock;
	}
}
