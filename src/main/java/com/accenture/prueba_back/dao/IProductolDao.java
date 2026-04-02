package com.accenture.prueba_back.dao;

public interface IProductolDao {
	String agregarProducto(String nombreFranquicia, String nombreSucursal, String nombreProducto, Float stock);
	String eliminarProducto(String nombreFranquicia, String nombreSucursal, String nombreProducto);
}
