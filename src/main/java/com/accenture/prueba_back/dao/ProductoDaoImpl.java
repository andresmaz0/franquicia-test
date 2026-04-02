package com.accenture.prueba_back.dao;

import java.math.BigDecimal;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.prueba_back.Entity.ProductoEntity;
import com.accenture.prueba_back.Entity.SucursalEntity;
import com.accenture.prueba_back.repository.IProductoRepository;

@Repository
public class ProductoDaoImpl implements IProductolDao{
	private static final Logger log = LoggerFactory.getLogger(ProductoDaoImpl.class);
	
	@Autowired
	private ISucursalDao sucursalDao;
	
	@Autowired
	private IProductoRepository productoRepository;
	
	public String agregarProducto(String nombreFranquicia, String nombreSucursal, String nombreProducto, Float stock) {
		log.info("Ingresando a ProductoDaoImpl metodo agregarProducto");
		Optional<ProductoEntity> optional = null;
		SucursalEntity sucursalEntity = null;
		
		sucursalEntity = sucursalDao.verificarExistenciaSucursal(nombreFranquicia, nombreSucursal);
		
		if(sucursalEntity != null) {
			optional = productoRepository.findByNombreAndSucursalId(nombreProducto, sucursalEntity.getId());
			
			if(optional.isPresent()) {
				log.info("Ya existe un producto con ese nombre: {} en la sucursal {}", nombreProducto, nombreSucursal);
				return "Ya existe un producto con ese nombre:" + nombreProducto +" de la sucursal " + nombreSucursal;
			}
			ProductoEntity entity = new ProductoEntity();
			entity.setNombre(nombreProducto);
			entity.setStock(new BigDecimal(stock));
			entity.setSucursal(sucursalEntity);
			
			entity = productoRepository.save(entity);
			if(entity.getId() != null) {
				log.info("Se guardo un nuevo producto con id {}", entity.getId());
				return "Se guardo un nuevo producto con id " +  entity.getId();
			}else {
				return "no se pudo guardar el producto";
			}
		}else {
			return "No hay una sucursal con el nombre " + nombreSucursal + "con el producto: " + nombreProducto;
		}
	}
	
	public String eliminarProducto(String nombreFranquicia, String nombreSucursal, String nombreProducto) {
		log.info("Ingresando a ProductoDaoImpl metodo eliminarProducto");
		Optional<ProductoEntity> optional = null;
		SucursalEntity sucursalEntity = null;
		
		sucursalEntity = sucursalDao.verificarExistenciaSucursal(nombreFranquicia, nombreSucursal);
		
		if(sucursalEntity != null) {
			optional = productoRepository.findByNombreAndSucursalId(nombreProducto, sucursalEntity.getId());
			
			if(optional.isPresent()) {
				productoRepository.delete(optional.get());
				log.info("Se borro existosamente el producto con ese nombre: {} de la sucursal {}", nombreProducto, nombreSucursal);
				return "Se borro existosamente el producto con ese nombre:" + nombreProducto +" de la sucursal " + nombreSucursal;
			}else {
				log.info("El producto con ese nombre: {} en la sucursal {} no existe", nombreProducto, nombreSucursal);
				return "El producto con ese nombre: "+ nombreProducto + "en la sucursal "+ nombreSucursal + "no existe";
			}
		}
		return "No hay una sucursal con el nombre " + nombreSucursal + "con el producto: " + nombreProducto;
	}
	
	public String actualizarStock(String nombreFranquicia, String nombreSucursal, String nombreProducto, Float stock) {
		log.info("Ingresando a ProductoDaoImpl metodo agregarProducto");
		Optional<ProductoEntity> optional = null;
		SucursalEntity sucursalEntity = null;
		ProductoEntity productoEntity = null;
		
		sucursalEntity = sucursalDao.verificarExistenciaSucursal(nombreFranquicia, nombreSucursal);
		
		if(sucursalEntity != null) {
			optional = productoRepository.findByNombreAndSucursalId(nombreProducto, sucursalEntity.getId());
			
			if(optional.isPresent()) {
				productoEntity = optional.get();
				productoEntity.setStock(new BigDecimal(stock));
				productoEntity = productoRepository.save(productoEntity);
				if(productoEntity.getId() != null) {
					log.info("Se actualizo Stock en producto con id {}", productoEntity.getId());
					return "Se actualizo Stock en producto con id " +  productoEntity.getId();
				}else {
					return "No se pudo actualizar el Stock en el producto ingresado";
				}
			}
		}
		return "No hay una sucursal con el nombre " + nombreSucursal + "con el producto: " + nombreProducto;
	}
}
