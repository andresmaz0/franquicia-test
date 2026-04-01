package com.accenture.prueba_back.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "SUCURSAL")
public class SucursalEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@ManyToOne
    @JoinColumn(name = "FRANQUICIA_ID")
    private FranquiciaEntity franquicia;
	
	@OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
    private List<ProductoEntity> productos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public FranquiciaEntity getFranquicia() {
		return franquicia;
	}

	public void setFranquicia(FranquiciaEntity franquicia) {
		this.franquicia = franquicia;
	}

	public List<ProductoEntity> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoEntity> productos) {
		this.productos = productos;
	}
}
