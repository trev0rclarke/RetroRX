package jeff.retrorx.providers;

import jeff.retrorx.models.SearchResultModel;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

public interface IRecipeProvider {
    @GET("/kitchen-manager/v1/recipes")
    Observable<SearchResultModel> getRecipesByIngredient(@Query("ingredients-any") String ingredient);
}
