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
		
		boolean procesoAcabado = productoDao.agregarProducto(nombreFranquicia, nombreSucursal, nombreProducto, stock);
		String mensaje = null;
		if(procesoAcabado) {
			mensaje = "Se agrego Efectivamente el producto: " + nombreProducto + " a la sucursal :" + nombreSucursal;
		}else {
			mensaje = "No se agrego efectivamente el producto: " + nombreProducto + " a la sucursal :" + nombreSucursal;
		}
		return mensaje;
	}
}
