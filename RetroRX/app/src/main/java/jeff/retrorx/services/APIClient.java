package jeff.retrorx.services;

import com.google.gson.Gson;

import jeff.retrorx.AppDefines;
import jeff.retrorx.providers.IRecipeProvider;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

public class APIClient {
    private static IRecipeProvider recipeProvider;

    public static IRecipeProvider getRecipeProvider(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppDefines.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        recipeProvider = retrofit.create(IRecipeProvider.class);

        return recipeProvider;
    }
}
