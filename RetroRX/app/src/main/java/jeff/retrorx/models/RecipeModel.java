package jeff.retrorx.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RecipeModel {
    @SerializedName("name")
    private String recipeName;

    @SerializedName("cuisine")
    private String cuisine;

    @SerializedName("ingredients")
    private ArrayList<String> ingredients;

    @SerializedName("image")
    private String recipeImageUrl;

    public String getRecipeName() {
        return recipeName;
    }

    public String getCuisine() {
        return cuisine;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public String getRecipeImageUrl() {
        return recipeImageUrl;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setRecipeImageUrl(String recipeImageUrl) {
        this.recipeImageUrl = recipeImageUrl;
    }

    @Override
    public String toString(){
        return recipeName + ", " + cuisine;
    }
}
