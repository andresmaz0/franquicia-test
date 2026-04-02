package com.accenture.prueba_back.dao;

import com.accenture.prueba_back.Entity.SucursalEntity;

public interface ISucursalDao {
	String agregarSucursal(String nombreFranquicia, String nombreSucursal);
	SucursalEntity verificarExistenciaSucursal(String nombreFranquicia, String nombreSucursal);
}
