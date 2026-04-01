package com.accenture.prueba_back.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.accenture.prueba_back.Entity.SucursalEntity;

public interface ISucursalRepository extends JpaRepository<SucursalEntity, Integer>{
	
	@Query("SELECT s FROM SucursalEntity s WHERE s.nombre = :nombre AND s.franquicia.id = :franquiciaId")
	Optional<SucursalEntity> findByNombreAndFranquiciaId(
		    @Param("nombre") String nombre,
		    @Param("franquiciaId") Integer franquiciaId
		);
}
