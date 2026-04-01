package com.accenture.prueba_back.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.accenture.prueba_back.Entity.ProductoEntity;

public interface IProductoRepository extends JpaRepository<ProductoEntity, Integer>{

	@Query("SELECT p FROM ProductoEntity p WHERE p.nombre = :nombre AND p.sucursal.id = :sucursalId")
	Optional<ProductoEntity> findByNombreAndSucursalId(
		    @Param("nombre") String nombre,
		    @Param("sucursalId") Integer sucursalId
		);
}
