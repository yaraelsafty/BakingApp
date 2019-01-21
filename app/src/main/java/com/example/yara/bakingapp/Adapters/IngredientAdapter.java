package com.example.yara.bakingapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yara.bakingapp.Data.Ingredient;
import com.example.yara.bakingapp.Data.Response;
import com.example.yara.bakingapp.Data.Step;
import com.example.yara.bakingapp.R;

import java.util.List;

/**
 * Created by Yara on 21-Jan-19.
 */

public class IngredientAdapter  extends RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder>{
    String TAG= RecipeAdapter.class.getSimpleName();
    private Context context;
    private List<Ingredient> ingredientList;

    public IngredientAdapter(Context context, List<Ingredient> ingredientList) {
        this.context = context;
        this.ingredientList = ingredientList;
    }

    @Override
    public IngredientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ingredient_row, parent, false);
        return new IngredientAdapter.IngredientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IngredientViewHolder holder, int position) {
        final Ingredient ingredient=ingredientList.get(position);
        holder.tv_ingredient.setText(ingredient.getQuantity()+" "+ingredient.getMeasure()+" "+ingredient.getIngredient());
    }

    @Override
    public int getItemCount() {
        return ingredientList.size();
    }

    public class IngredientViewHolder extends RecyclerView.ViewHolder {

        TextView tv_ingredient;

        public IngredientViewHolder(View itemView) {
            super(itemView);

            tv_ingredient=itemView.findViewById(R.id.tv_ingredient);
        }
    }
}
