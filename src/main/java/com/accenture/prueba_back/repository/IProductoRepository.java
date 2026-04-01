package com.accenture.prueba_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.prueba_back.Entity.ProductoEntity;

public interface IProductoRepository extends JpaRepository<ProductoEntity, Integer>{

}
