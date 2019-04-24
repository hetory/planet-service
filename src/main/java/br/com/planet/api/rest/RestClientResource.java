package br.com.planet.api.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public interface RestClientResource {

	public ResponseEntity<?> get(String url,HttpHeaders headers, Class classe);
}
