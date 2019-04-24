package br.com.planet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.planet.entity.PlanetEntity;

@Repository
public interface PlanetRepository extends  JpaRepository<PlanetEntity, Long> {
	
	public PlanetEntity findByName(String name);
	
}