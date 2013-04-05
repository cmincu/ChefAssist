package org.camin.jpa;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Recipe implements Serializable {

	private Integer id;
	private String recipeName;
	private String ingredients;
	private String preparation;
	private int cookTime;
	private String categoryId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getPreparation() {
		return preparation;
	}

	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}

	public int getCookTime() {
		return cookTime;
	}

	public void setCookTime(int cookTime) {
		this.cookTime = cookTime;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String toString() {
		return this.getId() + "/" + this.getRecipeName() + "/"
				+ this.getIngredients() + "/" + this.getPreparation();

	}

}
