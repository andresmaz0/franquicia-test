package com.accenture.prueba_back.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.prueba_back.dao.IProductolDao;

@Service
public class ProductoServiceImpl implements IProductoService {
	private static final Logger log = LoggerFactory.getLogger(ProductoServiceImpl.class);
	
	@Autowired
	private IProductolDao productoDao;
	
	public String addProducto(String nombreFranquicia, String nombreSucursal, String nombreProducto, Float stock) {
		log.info("Ingresando a clase ProductoServiceImpl a metodo addProducto");
		String mensaje = null;
		
		mensaje = productoDao.agregarProducto(nombreFranquicia, nombreSucursal, nombreProducto, stock);
		
		return mensaje;
	}
	
	public String deleteProducto(String nombreFranquicia, String nombreSucursal, String nombreProducto) {
		log.info("Ingresando a clase ProductoServiceImpl a metodo deleteProducto");
		String mensaje = null;
		
		mensaje = productoDao.eliminarProducto(nombreFranquicia, nombreSucursal, nombreProducto);
		
		return mensaje;
	}
	
	public String updateStockProducto(String nombreFranquicia, String nombreSucursal, String nombreProducto, Float stock) {
		log.info("Ingresando a clase ProductoServiceImpl a metodo updateStockProducto");
		String mensaje = null;
		
		mensaje = productoDao.actualizarStock(nombreFranquicia, nombreSucursal, nombreProducto, stock);
		
		return mensaje;
	}
}
