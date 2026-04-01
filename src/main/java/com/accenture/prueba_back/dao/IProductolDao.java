package com.accenture.prueba_back.dao;

public interface IProductolDao {
	Boolean agregarProducto(String nombreFranquicia, String nombreSucursal, String nombreProducto, Float stock);
	Boolean eliminarProducto(String nombreFranquicia, String nombreSucursal, String nombreProducto);
}
