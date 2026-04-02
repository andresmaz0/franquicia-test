package com.accenture.prueba_back.service;

import com.accenture.prueba_back.Entity.FranquiciaEntity;

public interface IFranquiciaService {
	 String addFranquicia(String nombre);
	 FranquiciaEntity verificarExisteFranquicia(String nombre);
}
