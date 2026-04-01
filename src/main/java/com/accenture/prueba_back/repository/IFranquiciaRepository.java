package com.accenture.prueba_back.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.prueba_back.Entity.FranquiciaEntity;

public interface IFranquiciaRepository extends JpaRepository<FranquiciaEntity, Integer>{
	Optional<FranquiciaEntity> findByNombre(String nombre);
}
