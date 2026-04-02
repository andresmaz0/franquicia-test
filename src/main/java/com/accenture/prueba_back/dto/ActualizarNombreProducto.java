package com.accenture.prueba_back.dto;

public class ActualizarNombreProducto {
	private String nombreFranquicia;
	private String nombreSucursal;
	private String nombreActual;
	private String nuevoNombre;
	
	public String getNombreActual() {
		return nombreActual;
	}
	public void setNombreActual(String nombreActual) {
		this.nombreActual = nombreActual;
	}
	public String getNuevoNombre() {
		return nuevoNombre;
	}
	public void setNuevoNombre(String nuevoNombre) {
		this.nuevoNombre = nuevoNombre;
	}
	public String getNombreFranquicia() {
		return nombreFranquicia;
	}
	public void setNombreFranquicia(String nombreFranquicia) {
		this.nombreFranquicia = nombreFranquicia;
	}
	public String getNombreSucursal() {
		return nombreSucursal;
	}
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}
}
