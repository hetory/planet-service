package br.com.planet.api.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClientResourceImpl implements RestClientResource{

	@Override
	public ResponseEntity<?> get(String url, HttpHeaders headers, Class classe) {

		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<?> exchange = restTemplate.exchange(url, HttpMethod.GET, entity,classe);

		return exchange;
	}
}
