package com.accenture.prueba_back.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.prueba_back.dto.ProductoDto;
import com.accenture.prueba_back.service.IProductoService;

@RestController
@RequestMapping("/v1")
public class ProductoController {
	private static final Logger log = LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private IProductoService productoService;
	
	@CrossOrigin
	@PostMapping(path = "/nuevo-producto")
	public String agregarProducto(@RequestBody ProductoDto request) {
		log.info("Ingresando a ProductoController metodo agregarProducto");
		request.setNombreProducto(request.getNombreProducto().toLowerCase());
		request.setNombreSucursal(request.getNombreSucursal().toLowerCase());
		request.setNombreFranquicia(request.getNombreFranquicia().toLowerCase());
		return productoService.addProducto(request.getNombreFranquicia(), request.getNombreSucursal(),
				request.getNombreProducto(), request.getCantidadStock()); 
	}
}
