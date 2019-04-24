package br.com.planet.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlanetEntity implements Serializable{

	private static final long serialVersionUID = 9165902477233200293L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="CLIMATE")
	private String climate;
	
	@Column(name="TERRAIN")
	private String terrain;
	
	@Column(name="QUANTITY")
	private Integer quantity;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}


	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanetEntity planetEntity = (PlanetEntity) o;
        return Objects.equals(name, planetEntity.name) &&
                Objects.equals(climate, planetEntity.climate) &&
                Objects.equals(terrain, planetEntity.terrain) &&
                Objects.equals(quantity, planetEntity.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, climate,terrain);
    }
    
	@Override
	public String toString() {
		return "PlanetEntity [id=" + id + ", name=" + name + ", climate=" + climate + ", terrain=" + terrain
				+ ", quantity=" + quantity + "]";
	}
}