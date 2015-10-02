package jeff.retrorx.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jeff.retrorx.R;
import jeff.retrorx.models.RecipeModel;
import jeff.retrorx.models.SearchResultModel;

public class RecipeListAdapter extends ArrayAdapter<RecipeModel> {
    public RecipeListAdapter(Context context, ArrayList<RecipeModel> recipes) {
        super(context, 0, recipes);
    }

    public RecipeListAdapter(Context context, int resource, List<RecipeModel> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.recipe_item, null);
        }

        RecipeModel recipe = getItem(position);

        if (recipe != null) {
            TextView nameText = (TextView) v.findViewById(R.id.nameText);
            TextView cuisineText = (TextView) v.findViewById(R.id.cuisineText);

            if (nameText != null) {
                nameText.setText(recipe.getRecipeName());
            }

            if (cuisineText != null) {
                cuisineText.setText(recipe.getCuisine());
            }
        }

        return v;
    }
}
