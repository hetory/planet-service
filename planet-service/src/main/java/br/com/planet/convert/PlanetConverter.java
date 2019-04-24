package br.com.planet.convert;

import java.util.ArrayList;
import java.util.List;

import br.com.planet.dto.PlanetDto;
import br.com.planet.entity.PlanetEntity;

public class PlanetConverter {
	
	public static PlanetEntity dtoToEntity(PlanetDto planetDto){
		
		PlanetEntity planetEntity = new PlanetEntity();
		planetEntity.setClimate(planetDto.getClimate());
		planetEntity.setTerrain(planetDto.getTerrain());
		planetEntity.setName(planetDto.getName());
		planetEntity.setQuantity(planetDto.getQuantity());
		
		return planetEntity;
	}
	
    public static PlanetDto entityToDto(PlanetEntity planetEntity){
		
		if (planetEntity != null) {

			PlanetDto planetDto = new PlanetDto();

			planetDto.setClimate(planetEntity.getClimate());
			planetDto.setTerrain(planetEntity.getTerrain());
			planetDto.setName(planetEntity.getName());
			planetDto.setQuantity(planetEntity.getQuantity());
			
			return planetDto;

		}

		return null;
	}
    
    
   public static List<PlanetDto> listEntityToListDto(List<PlanetEntity> listPlanetEntity){
	   
	   List<PlanetDto> listPlanetDto = new ArrayList<>();
	   
	   listPlanetEntity.forEach(planetEntity ->{
		   
		    PlanetDto planetDto = new PlanetDto();
	    	planetDto.setClimate(planetEntity.getClimate());
	    	planetDto.setTerrain(planetEntity.getTerrain());
	    	planetDto.setName(planetEntity.getName());
	    	planetDto.setQuantity(planetEntity.getQuantity());
	    	
	    	listPlanetDto.add(planetDto);
		   
	   });
		
	   return listPlanetDto;
	}
}