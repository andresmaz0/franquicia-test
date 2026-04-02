package com.accenture.prueba_back.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accenture.prueba_back.Entity.ProductoEntity;

public interface IProductoRepository extends JpaRepository<ProductoEntity, Integer>{

	@Query("SELECT p FROM ProductoEntity p WHERE p.nombre = :nombre AND p.sucursal.id = :sucursalId")
	Optional<ProductoEntity> findByNombreAndSucursalId(
		    @Param("nombre") String nombre,
		    @Param("sucursalId") Integer sucursalId
		);
	
	@Query("SELECT p FROM ProductoEntity p WHERE p.nombre = :nombre AND p.sucursal.nombre = :nombreSucursal")
	Optional<ProductoEntity> encontrarNombreAndNombreSucursal(
			@Param("nombre") String nombre,
			@Param("nombreSucursal") String nombreSucursal
			);
	
	@Query("SELECT p FROM ProductoEntity p " +
		       "JOIN p.sucursal s " +
		       "JOIN s.franquicia f " +
		       "WHERE f.nombre = :nombreFranquicia " +
		       "AND p.stock = (SELECT MAX(p2.stock) FROM ProductoEntity p2 WHERE p2.sucursal = s)")
	List<ProductoEntity> encontrarTopProductosPorSucursal(@Param("nombreFranquicia") String nombreFranquicia);
}
