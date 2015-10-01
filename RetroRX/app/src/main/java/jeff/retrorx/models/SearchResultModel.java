package jeff.retrorx.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SearchResultModel {
    @SerializedName("results")
    ArrayList<RecipeModel> searchResults;

    public ArrayList<RecipeModel> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(ArrayList<RecipeModel> searchResults) {
        this.searchResults = searchResults;
    }
}
