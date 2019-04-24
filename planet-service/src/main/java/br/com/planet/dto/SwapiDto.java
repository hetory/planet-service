package br.com.planet.dto;

import java.util.List;
import java.util.Objects;

public class SwapiDto {
	
	private List<PlanetApiStarWarsDto> results;

	public List<PlanetApiStarWarsDto> getResults() {
		return results;
	}

	public void setResults(List<PlanetApiStarWarsDto> results) {
		this.results = results;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SwapiDto swapiDto = (SwapiDto) o;
        return Objects.equals(results, swapiDto.results) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
