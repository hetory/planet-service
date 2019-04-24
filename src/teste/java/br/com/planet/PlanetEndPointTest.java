package br.com.planet;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlanetEndPointTest {

	@Autowired
	private  MockMvc mockMvc;
	
	
	@Test
	public void should_return_planet_alderaan_created() throws Exception {

        JSONObject planetDto= new JSONObject()
                .put("name", "Alderaan")
                .put("climate", "temperate")
                .put("terrain", "terrain");
        
        this.mockMvc.perform(post("/v1/planet")
                .contentType(MediaType.APPLICATION_JSON)
                .content(planetDto.toString()))
                .andDo(print())
                .andExpect(jsonPath("$.name", is("Alderaan")))
                .andExpect(jsonPath("$.climate", is("temperate")))
                .andExpect(jsonPath("$.terrain", is("terrain")))
                .andExpect(jsonPath("$.quantity", is(2)))
                .andExpect(status().isCreated());
	}
	
	@Test
	public void should_return_planet_created_with_out_api_star_wars() throws Exception {

        JSONObject planetDto= new JSONObject()
                .put("name", "nnnn")
                .put("climate", "temperate")
                .put("terrain", "terrain");
        
        this.mockMvc.perform(post("/v1/planet")
                .contentType(MediaType.APPLICATION_JSON)
                .content(planetDto.toString()))
                .andDo(print())
                .andExpect(jsonPath("$.name", is("nnnn")))
                .andExpect(jsonPath("$.climate", is("temperate")))
                .andExpect(jsonPath("$.terrain", is("terrain")))
                .andExpect(jsonPath("$.quantity", is(0)))
                .andExpect(status().isCreated());
	}
	
	@Test
	public void should_return_planet_naboo_created() throws Exception {

        JSONObject planetDto= new JSONObject()
                .put("name", "naboo")
                .put("climate", "temperate")
                .put("terrain", "terrain");
        
        this.mockMvc.perform(post("/v1/planet")
                .contentType(MediaType.APPLICATION_JSON)
                .content(planetDto.toString()))
                .andDo(print())
                .andExpect(jsonPath("$.name", is("naboo")))
                .andExpect(jsonPath("$.climate", is("temperate")))
                .andExpect(jsonPath("$.terrain", is("terrain")))
                .andExpect(jsonPath("$.quantity", is(4)))
                .andExpect(status().isCreated());
	}
	
	@Test
	public void should_return_bad_request_body() throws Exception {

        JSONObject planetDto= new JSONObject()
                .put("error-field", "terra")
                .put("climate", "temperate")
                .put("terrain", "terrain");
        
        this.mockMvc.perform(post("/v1/planet")
                .contentType(MediaType.APPLICATION_JSON)
                .content(planetDto.toString()))
                .andDo(print())
                .andExpect(status().isBadRequest());
	}
	
	@Test
	public void should_return_list_planets() throws Exception {

		createPlanet("Hoth");
		
		createPlanet("Endor");
		
		this.mockMvc.perform(get("/v1/planets"))
				.andDo(print())
				.andExpect(status().is2xxSuccessful());
		
	
	}
	
	@Test
	public void should_return_planet_api_star_wars() throws Exception {
		this.mockMvc.perform(get("/v1/planets/star-wars"))
				.andDo(print()).
				andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void should_return_planet_by_name() throws Exception { 
		createPlanet("Coruscant");
		
		this.mockMvc.perform(get("/v1/planet/name/Coruscant"))
				.andDo(print())
				.andExpect(jsonPath("$.name", is("Coruscant")))
				.andExpect(jsonPath("$.climate", is("temperate")))
				.andExpect(jsonPath("$.terrain", is("terrain")))
				 .andExpect(jsonPath("$.quantity", is(4)))
				.andExpect(status().is2xxSuccessful());
		
	}

	@Test
	public void should_return_planet_by_id() throws Exception {
			
        JSONObject planetDto= new JSONObject()
                .put("name", "Kam")
                .put("climate", "temperate")
                .put("terrain", "terrain");
        
        this.mockMvc.perform(post("/v1/planet")
                .contentType(MediaType.APPLICATION_JSON)
                .content(planetDto.toString()))
                .andDo(print())
                .andExpect(jsonPath("$.name", is("Kam")))
                .andExpect(jsonPath("$.climate", is("temperate")))
                .andExpect(jsonPath("$.terrain", is("terrain")))
                .andExpect(jsonPath("$.quantity", is(0)))
                .andExpect(status().isCreated());
		
		this.mockMvc.perform(get("/v1/planet/1"))
				.andDo(print())
				.andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void should_return_not_found_by_id() throws Exception {
		this.mockMvc.perform(get("/v1/planet/11111"))
				.andDo(print()).
				andExpect(status().isNotFound());
	}
	

	
	@Test
	public void should_return_not_found_delete() throws Exception {
		this.mockMvc.perform(delete("/v1/planet/111411"))
				.andDo(print()).
				andExpect(status().isNotFound());
	}
	
	@Test
	public void should_return_bad_request_delete() throws Exception {
		this.mockMvc.perform(delete("/v1/planet/A"))
				.andDo(print()).
				andExpect(status().isBadRequest());
	}
	
	@Test
	public void should_return_ok_delete() throws Exception {

		createPlanet("nieales");
		createPlanet("caoje");

		this.mockMvc.perform(delete("/v1/planet/" + 1))
				.andDo(print()).
				andExpect(status().isOk());
	}

	private void createPlanet(String name) throws Exception {
		 JSONObject planetDto= new JSONObject()
	                .put("name",name)
	                .put("climate", "temperate")
	                .put("terrain", "terrain");
		 
	        this.mockMvc.perform(post("/v1/planet")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(planetDto.toString()))
	                .andExpect(status().isCreated());
	}
}