package br.com.planet.service;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.planet.api.rest.RestClientResource;
import br.com.planet.convert.PlanetConverter;
import br.com.planet.dto.PlanetDto;
import br.com.planet.dto.SwapiDto;
import br.com.planet.entity.PlanetEntity;
import br.com.planet.repository.PlanetRepository;

@Service	
public class PlanetService {
    @Autowired
    private RestClientResource restClientResource;

    @Autowired
	private PlanetRepository planetRepository;
    
    private static String URL = "https://swapi.co/api/planets/";
	
	public PlanetEntity save(PlanetDto planetDto){
		
		SwapiDto dto = findAllPlanetsStarWars();
		planetDto.setQuantity(0);
		
		if (dto != null && dto.getResults()!=null) {
			dto.getResults().forEach(planet -> {
				if(planet.getName().equalsIgnoreCase(planetDto.getName().trim())){
			    	planetDto.setQuantity(planet.getFilms().size());
				}
			});
		}
          		
		return planetRepository.save(PlanetConverter.dtoToEntity(planetDto));
	}
	
	public List<PlanetDto> findAll(){
		return PlanetConverter.listEntityToListDto(planetRepository.findAll());
	}
	
	public SwapiDto findAllPlanetsStarWars(){
		
		HttpHeaders headers  = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "");

        ResponseEntity<?> exchange = restClientResource.get(URL, headers,SwapiDto.class);

		return  (SwapiDto) exchange.getBody();
	}
	
	public PlanetDto findByName(String name){
		
		try{
			return PlanetConverter.entityToDto(planetRepository.findByName(name));
		}catch (EntityNotFoundException e) {
			return null;
		}
	}
	
	public PlanetDto findById(Long id){
		try{
			return PlanetConverter.entityToDto(planetRepository.findById(id).get());
		}catch (NoSuchElementException e) {
			return null;
		}
	}
	
	public Boolean deleteById(Long id){
		try{
			planetRepository.deleteById(id);
			return true;
		}catch (IllegalArgumentException e) {
			return false;
		}
	}	
}