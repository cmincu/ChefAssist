package org.camin.views;

import org.camin.chefassist.R;
import org.camin.jpa.Recipe;
import org.camin.util.Constants;
import org.camin.util.Utils;
import org.camin.ws.RecipesService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class RecipesActivity extends Activity {

	private ListView lvRecipes;
	private RecipesService service;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipes);

        lvRecipes = (ListView) findViewById(R.id.lvRecipes);
        service = new RecipesService(this, lvRecipes);
		loadRecipesOnView();

		lvRecipes.setClickable(true);
		lvRecipes.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> adapter, View view,
					int position, long id) {
				Recipe recipe = (Recipe) adapter.getItemAtPosition(position);
				Intent intent = new Intent(view.getContext(),
						RecipeActivity.class);
				intent.putExtra(Constants.RECIPE_NAME, recipe.getRecipeName());
				intent.putExtra(Constants.RECIPE_INGREDIENTS,
						recipe.getIngredients());
				intent.putExtra(Constants.RECIPE_PREPARATION,
						recipe.getPreparation());

				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recipes, menu);
		return true;
	}

	public void loadRecipesOnView() {
		if (Utils.isOnline(this)) {
            service.execute();
			return;
		}
		Utils.showSimpleMessage(this, "No connection", "No Internet connection");
	}

}
