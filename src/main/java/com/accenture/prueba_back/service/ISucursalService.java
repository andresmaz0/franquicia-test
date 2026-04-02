package com.accenture.prueba_back.service;

import com.accenture.prueba_back.Entity.SucursalEntity;

public interface ISucursalService {
	String addSucursal(String nombreFranquicia, String nombreSucursal);
	SucursalEntity verificarExistenciaSucursal(String nombreFranquicia, String nombreSucursal);
}
