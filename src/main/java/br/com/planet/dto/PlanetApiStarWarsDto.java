package br.com.planet.dto;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlanetApiStarWarsDto {
	
	private String name;
	
	@JsonProperty(value="films")
	private List<String> films;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanetApiStarWarsDto planetApiStarWarsDto = (PlanetApiStarWarsDto) o;
        return Objects.equals(name, planetApiStarWarsDto.name) &&
                Objects.equals(films, planetApiStarWarsDto.films) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, films);
    }
    
    @Override
	public String toString() {
		return "PlanetApiStarWarsDto [name=" + name + ", films=" + films + "]";
	}
}
