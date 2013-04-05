package org.camin.views;

import org.camin.jpa.Recipe;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class RecipesAdapter extends BaseAdapter {

	Recipe[] items;
	Activity context;

	public RecipesAdapter(Activity context, Recipe[] items) {
		this.context = context;
		this.items = items;
	}

	public int getCount() {
		return items.length;
	}

	public Recipe getItem(int position) {
		return items[position];
	}

	public long getItemId(int position) {
		return items[position].getId();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView; // re-use an existing view, if one is available
		if (view == null) // otherwise create a new one
			view = context.getLayoutInflater().inflate(
					android.R.layout.simple_list_item_1, null);
		TextView textView = (TextView) view.findViewById(android.R.id.text1);
		textView.setText(items[position].getRecipeName());
		return view;
	}

}
