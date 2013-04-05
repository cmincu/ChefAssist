package org.camin.ws;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.camin.jpa.Recipe;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RecipesService {

	private final String URL = "http://recipemanager-mincu.rhcloud.com/rest/";
	private RestTemplate restTemplate;
	private HttpEntity<?> requestEntity;

	public RecipesService() {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAccept(Collections.singletonList(new MediaType(
				"application", "json")));
		requestEntity = new HttpEntity<Object>(requestHeaders);
		MappingJacksonHttpMessageConverter messageConverter = new MappingJacksonHttpMessageConverter();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(messageConverter);

		restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(messageConverters);
	}

	public Recipe[] getRecipes() {
		ResponseEntity<Recipe[]> responseEntity = restTemplate.exchange(URL
				+ "recipes", HttpMethod.GET, requestEntity, Recipe[].class);
		Recipe[] recipes = responseEntity.getBody();
		return recipes;
	}

	public Recipe getRecipe(int id) {
		ResponseEntity<Recipe> responseEntity = restTemplate.exchange(URL
				+ "recipe/" + id, HttpMethod.GET, requestEntity, Recipe.class);
		Recipe recipe = responseEntity.getBody();
		return recipe;
	}

}
