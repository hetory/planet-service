package br.com.planet.endpoint;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.planet.convert.PlanetConverter;
import br.com.planet.dto.PlanetDto;
import br.com.planet.dto.SwapiDto;
import br.com.planet.entity.PlanetEntity;
import br.com.planet.service.PlanetService;

@RestController
@RequestMapping("/v1")
public class PlanetEndpoint {

	@Autowired
	private PlanetService planetService;

	public PlanetEndpoint(PlanetService planetService) {
		this.planetService = planetService;
	}

    @PostMapping("/planet")
    public ResponseEntity<PlanetDto>save(@Valid @RequestBody PlanetDto planetDto) {
	   
	   PlanetEntity client = planetService.save(planetDto);
	   
	   return new ResponseEntity<PlanetDto>(PlanetConverter.entityToDto(client), HttpStatus.CREATED);
    }
	
    @GetMapping("/planets")
    public ResponseEntity<List<PlanetDto>> findAll() {
    	
    	List<PlanetDto> listPlanet = planetService.findAll();

    	return new ResponseEntity<List<PlanetDto>>(listPlanet, HttpStatus.OK);
    }
     
    @GetMapping("/planets/star-wars")
    public ResponseEntity<SwapiDto> findAllPlanetsStarWars() {
    	
        SwapiDto swap = planetService.findAllPlanetsStarWars();

    	return new ResponseEntity<SwapiDto>(swap, HttpStatus.OK);
    }
    
    @GetMapping("/planet/name/{name}")
    public ResponseEntity<PlanetDto> findByName(@PathVariable("name") String name) {
    	
    	PlanetDto planetDto = planetService.findByName(name);
    	
    	if(planetDto== null){
    		return new ResponseEntity<PlanetDto>(HttpStatus.NOT_FOUND);
    	}

    	return new ResponseEntity<PlanetDto>(planetDto, HttpStatus.OK);
    }
    
    @GetMapping("/planet/{id}")    
    public ResponseEntity<PlanetDto> findById(@PathVariable("id") Long id) {
    	
    	PlanetDto planetDto = planetService.findById(id);
    	
    	if(planetDto== null){
    		return new ResponseEntity<PlanetDto>(HttpStatus.NOT_FOUND);
    	}
    		
    	return new ResponseEntity<PlanetDto>(planetDto, HttpStatus.OK);
    }

    @DeleteMapping("/planet/{id}")
    public ResponseEntity<PlanetDto>deteleById(@PathVariable("id") Long id) {
    	
    	PlanetDto planetDto = planetService.findById(id);

       if(planetDto != null){
    	    planetService.deleteById(id);   
    	    return new ResponseEntity(HttpStatus.OK);
       } else {
    	   return new ResponseEntity(HttpStatus.NOT_FOUND);
       }
    }
}