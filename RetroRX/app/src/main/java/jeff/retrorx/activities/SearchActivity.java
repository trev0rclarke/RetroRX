package jeff.retrorx.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import jeff.retrorx.R;
import jeff.retrorx.models.RecipeModel;
import jeff.retrorx.models.SearchResultModel;
import jeff.retrorx.services.APIClient;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SearchActivity extends Activity {
    private ListView searchResultsList;
    private Button searchButton;
    private EditText searchInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchResultsList = (ListView)findViewById(R.id.searchResultsList);
        searchButton = (Button)findViewById(R.id.searchButton);
        searchInput = (EditText)findViewById(R.id.searchInput);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    SearchResultModel model  = createMockData();
                    ArrayAdapter<RecipeModel> adapter = new ArrayAdapter<RecipeModel>(
                            SearchActivity.this,
                            android.R.layout.simple_list_item_1,
                            model.getSearchResults()
                    );

                    searchResultsList.setAdapter(adapter);
//                APIClient.getRecipeProvider()
//                        .getRecipesByIngredient(searchInput.getText().toString())
//                        .subscribeOn(Schedulers.newThread())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Subscriber<SearchResultModel>() {
//
//                            @Override
//                            public void onCompleted() {
//
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//                                int i = 0;
//                            }
//
//                            @Override
//                            public void onNext(SearchResultModel searchResultModel) {
//                                // have to fake some results due to lack of API availability
//                                searchResultModel = createMockData();
//
//                                // create an adapter
//                                ArrayAdapter<RecipeModel> adapter = new ArrayAdapter<RecipeModel>(
//                                        SearchActivity.this,
//                                        android.R.layout.simple_list_item_1,
//                                        searchResultModel.getSearchResults()
//                                );
//
//                                searchResultsList.setAdapter(adapter);
//                            }
//                        });
           }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private SearchResultModel createMockData(){
        SearchResultModel model = new SearchResultModel();
        model.setSearchResults(new ArrayList<RecipeModel>());

        RecipeModel rmodel1 = new RecipeModel();
        RecipeModel rmodel2 = new RecipeModel();
        RecipeModel rmodel3 = new RecipeModel();

        rmodel1.setCuisine("Italian");
        rmodel1.setRecipeName("Spaghetti");

        rmodel2.setCuisine("Iranian");
        rmodel2.setRecipeName("Kofta Kebab");

        rmodel3.setCuisine("Chinese");
        rmodel3.setRecipeName("Fried Rice");


        model.getSearchResults().add(rmodel1);
        model.getSearchResults().add(rmodel2);
        model.getSearchResults().add(rmodel3);

        return model;
    }
}
