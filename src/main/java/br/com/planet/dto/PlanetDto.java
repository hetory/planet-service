package br.com.planet.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PlanetDto implements Serializable {

	private static final long serialVersionUID = -4841290405110824240L;

	@NotNull(message = "name must be not null")
    private String name;

	@NotNull(message = "climate must be not null")
    private String climate;
	
	@NotNull(message = "terrain must be not null")
    private String terrain;
	
    private Integer quantity;
	
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
        PlanetDto planetDto = (PlanetDto) o;
        return Objects.equals(name, planetDto.name) &&
                Objects.equals(climate, planetDto.climate) &&
                Objects.equals(terrain, planetDto.terrain)&&
                Objects.equals(quantity, planetDto.quantity)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, climate,terrain,quantity);
    }
    
	@Override
	public String toString() {
		return "PlanetDto [name=" + name + ", climate=" + climate + ", terrain=" + terrain + ", quantity=" + quantity
				+ "]";
	}
}