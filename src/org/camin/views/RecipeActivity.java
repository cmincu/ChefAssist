package org.camin.views;

import org.camin.chefassist.R;
import org.camin.util.Constants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class RecipeActivity extends Activity {

	private TextView tvRecipeName;
	private TextView tvRecipeIngredients;
	private TextView tvRecipePreparation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipe);
		
		tvRecipeName = (TextView) findViewById(R.id.tvRecipeName);
		tvRecipeIngredients = (TextView) findViewById(R.id.tvIngredients);
		tvRecipePreparation = (TextView) findViewById(R.id.tvPreparation);
		
		Intent intent = getIntent();		
		tvRecipeName.setText(intent.getStringExtra(Constants.RECIPE_NAME));
		tvRecipeIngredients.setText(intent.getStringExtra(Constants.RECIPE_INGREDIENTS));
		tvRecipePreparation.setText(intent.getStringExtra(Constants.RECIPE_PREPARATION));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recipe, menu);
		return true;
	}

}
