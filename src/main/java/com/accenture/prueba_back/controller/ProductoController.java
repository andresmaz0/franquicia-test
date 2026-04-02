package com.accenture.prueba_back.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.prueba_back.Entity.ProductoEntity;
import com.accenture.prueba_back.dto.FranquiciaDto;
import com.accenture.prueba_back.dto.ProductoDto;
import com.accenture.prueba_back.model.TopProductosPorSucursal;
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
	
	@CrossOrigin
	@PostMapping(path = "/eliminar-producto")
	public String eliminarProducto(@RequestBody ProductoDto request) {
		log.info("Ingresando a ProductoController metodo eliminarProducto");
		request.setNombreProducto(request.getNombreProducto().toLowerCase());
		request.setNombreSucursal(request.getNombreSucursal().toLowerCase());
		request.setNombreFranquicia(request.getNombreFranquicia().toLowerCase());
		return productoService.deleteProducto(request.getNombreFranquicia(), request.getNombreSucursal(),
				request.getNombreProducto()); 
	}
	
	@CrossOrigin
	@PostMapping(path = "/actualizar-stock")
	public String actualizarStock(@RequestBody ProductoDto request) {
		log.info("Ingresando a ProductoController metodo actualizarStock");
		request.setNombreProducto(request.getNombreProducto().toLowerCase());
		request.setNombreSucursal(request.getNombreSucursal().toLowerCase());
		request.setNombreFranquicia(request.getNombreFranquicia().toLowerCase());
		return productoService.updateStockProducto(request.getNombreFranquicia(), request.getNombreSucursal(),
				request.getNombreProducto(), request.getCantidadStock()); 
	}
	
	@CrossOrigin
	@PostMapping(path = "/Top/producto-mas-stock/sucursal")
	public List<TopProductosPorSucursal> productoMasStockPorSucursal(@RequestBody FranquiciaDto request) {
		log.info("Ingresando a ProductoController metodo productoMasStockPorSucursal");
		request.setNombreFranquicia(request.getNombreFranquicia().toLowerCase());
		return productoService.findProductoConMasStockPorSucursal(request.getNombreFranquicia()); 
	}
}
