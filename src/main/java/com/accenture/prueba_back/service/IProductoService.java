package com.accenture.prueba_back.service;

import java.util.List;

import com.accenture.prueba_back.model.TopProductosPorSucursal;

public interface IProductoService {
	String addProducto(String nombreFranquicia, String nombreSucursal, String nombreProducto, Float stock);
	String deleteProducto(String nombreFranquicia, String nombreSucursal, String nombreProducto);
	String updateStockProducto(String nombreFranquicia, String nombreSucursal, String nombreProducto, Float stock);
	List<TopProductosPorSucursal> findProductoConMasStockPorSucursal(String nombreFranquicia);
}
