package org.camin.ws;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import org.camin.jpa.Recipe;
import org.camin.views.RecipesAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RecipesService extends AsyncTask<Void, Void, Recipe[]>
{

	private final String RestURL = "http://recipemanager-mincu.rhcloud.com/rest/";
	private RestTemplate restTemplate;
    private Activity activity;
    private ListView lvRecipes;

    public RecipesService(Activity activity, ListView lvRecipes)
    {
        this.activity = activity;
        this.lvRecipes = lvRecipes;
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

    }

    @Override protected Recipe[] doInBackground(Void... voids)
    {
        try {
            ResponseEntity<Recipe[]> responseEntity = restTemplate.getForEntity(this.RestURL + "recipes", Recipe[].class);
            Recipe[] recipes = responseEntity.getBody();
            return recipes;
        } catch (Exception e) {
            Log.e("RecipesService", e.getMessage(), e);
        }

        return null;
    }

    protected void onPostExecute(Recipe[] recipes){
        RecipesAdapter recAdapter = new RecipesAdapter(this.activity, recipes);
        this.lvRecipes.setAdapter(recAdapter);
    }

    /*
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
*/
}
