package com.accenture.prueba_back.dao;

import com.accenture.prueba_back.Entity.FranquiciaEntity;

public interface IFranquiciaDao {
	 String agregarFranquicia(String nombre);
	 FranquiciaEntity verificarExisteFranquicia(String nombre);
}
